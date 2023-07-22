package com.oxaata.nosetr.buytosale.module.shop.src.controller;

/*
  Look tutorial by:
  https://www.youtube.com/watch?v=QuvS_VLbGko
  At last 30:34
  and
  https://www.jetbrains.com/help/idea/spring-support-tutorial.html#run-app-and-execute-requests
 */
import com.oxaata.nosetr.buytosale.module.shop.src.service.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotosController {

    private Map<Integer, Photo> db = new HashMap<>() {{
        put(1, new Photo(1, "hello.jpg"));
        put(2, new Photo(2, "hello.jpg"));
    }};
//    private List<Photo> db = List.of(new Photo(1, "hello.jpg")); // can put only one item

    /*
     * http://localhost:8888/hello?myName=Human
     */
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/photos")
    public Collection<Photo> get() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable int id){
        Photo photo = db.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable int id){
        Photo photo = db.remove(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    // "RequestBody" to become all json request
    @PostMapping("/photos/")
    public Photo create(@RequestBody Photo photo){
        Random rand = new Random();
        photo.setId(rand.nextInt());
        db.put(photo.getId(), photo);
        return photo;
    }
}
