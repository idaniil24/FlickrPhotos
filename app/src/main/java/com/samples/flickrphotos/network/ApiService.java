package com.samples.flickrphotos.network;
import com.samples.flickrphotos.network.models.PhotoList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface ApiService {
    @GET("?method=flickr.photos.getRecent&api_key=24d959e5d0072975eb57cc01a69dfb5b&format=json&nojsoncallback=1")
    Call<PhotoList> getPhotos();
}