package com.oxaata.nosetr.app.controller;

/*
  Look tutorial by:
  https://www.youtube.com/watch?v=QuvS_VLbGko
  and
  https://www.jetbrains.com/help/idea/spring-support-tutorial.html#run-app-and-execute-requests
 */
import com.oxaata.nosetr.app.model.PhotoModel;
import com.oxaata.nosetr.app.service.PhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotosController {

//    private Map<Integer, PhotoModel> db = new HashMap<>() {{
//        put(1, new PhotoModel(1, "hello.jpg"));
//        put(2, new PhotoModel(2, "hello.jpg"));
//    }};
////    private List<Photo> db = List.of(new Photo(1, "hello.jpg")); // can put only one item

    @Autowired
//    private final PhotosService photosService;
    private PhotosService photosService; // without "final" because of "Autowired"

//    Comment, because it was set the "Autowired"-Annotation
//    public PhotosController(PhotosService photosService) {
//        this.photosService = photosService;
//    }

    /*
     * http://localhost:8888/hello?myName=Human
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/photos")
//    public Collection<PhotoModel> get() {
////        return db.values();
//        return photosService.get();
//    }
    public Iterable<PhotoModel> get() {
        return photosService.get();
    }

    @GetMapping("/photos/{id}")
    public PhotoModel get(@PathVariable Integer id){
//        PhotoModel photo = db.get(id);
        PhotoModel photo = photosService.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id){
//        PhotoModel photo = db.remove(id);

//        PhotoModel photo = photosService.remove(id);
//        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        photosService.remove(id);
    }

    // "RequestBody" to become all json request
    // "RequestPart" to become only one part of json (her with name "data")
    @PostMapping("/photos")
//    public Photo create(@RequestBody @Valid Photo photo){
    public PhotoModel create(@RequestPart("data") MultipartFile file) throws IOException {
//        PhotoModel photo = new PhotoModel(); // For this was created an empty constructor
//        Random rand = new Random(); // To get a random number
//        photo.setId(rand.nextInt());
//        photo.setFileName(file.getOriginalFilename());
//        photo.setData(file.getBytes());
////        db.put(photo.getId(), photo);
//        photosService.save(photo.getId(), photo);
        return photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
