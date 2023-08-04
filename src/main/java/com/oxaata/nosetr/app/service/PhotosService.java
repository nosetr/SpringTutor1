package com.oxaata.nosetr.app.service;

import com.oxaata.nosetr.app.model.PhotoModel;
import com.oxaata.nosetr.app.repository.PhotosRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

//@Component
@Service
public class PhotosService {

//    private static Map<Integer, PhotoModel> db = new HashMap<>() {{
//        put(1, new PhotoModel(1, "hello.jpg"));
//        put(2, new PhotoModel(2, "hello.jpg"));
//    }};

    private final PhotosRepository photosRepository;

    public PhotosService(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    public Iterable<PhotoModel> get() {
//        return db.values();
        return photosRepository.findAll();
    }

    public PhotoModel get(Integer id) {
//        return db.get(id);
        return photosRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
//        return db.remove(id);
        photosRepository.deleteById(id);
    }

    public PhotoModel save(String fileName, String contentType, byte[] data) {
        PhotoModel photo = new PhotoModel(); // For this was created an empty constructor
        photo.setContentType(contentType);

//        Random rand = new Random(); // To get a random number
//        photo.setId(rand.nextInt());

        photo.setFileName(fileName);
        photo.setData(data);
//        db.put(photo.getId(), photo);
        photosRepository.save(photo);
        return photo;
    }
//    private List<Photo> db = List.of(new Photo(1, "hello.jpg")); // can put only one item

}
