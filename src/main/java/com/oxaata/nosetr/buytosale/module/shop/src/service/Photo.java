package com.oxaata.nosetr.buytosale.module.shop.src.service;

public class Photo {
    private int id;

    private String fileName;

    // raw data


    public Photo(int id, String fileName) {
//        this.id = id;
//        this.fileName = fileName;
        setId(id);
        setFileName(fileName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
