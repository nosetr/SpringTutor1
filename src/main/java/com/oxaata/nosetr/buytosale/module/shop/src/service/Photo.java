package com.oxaata.nosetr.buytosale.module.shop.src.service;

public class Photo {
    private String id;

    private String fileName;

    // raw data


    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
