package com.samples.flickrphotos.network.models;

import com.google.gson.annotations.SerializedName;

public class PhotoResponse {
    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
