package com.samples.flickrphotos.network.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class PhotoList {
    @SerializedName("photos.photo")
    private List<PhotoResponse> photoList;

    public List<PhotoResponse> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<PhotoResponse> photoList) {
        this.photoList = photoList;
    }
}
