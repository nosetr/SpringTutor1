package com.oxaata.nosetr.app.repository;

import com.oxaata.nosetr.app.model.PhotoModel;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<PhotoModel, Integer> {

}
