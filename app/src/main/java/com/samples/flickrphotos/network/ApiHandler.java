package com.samples.flickrphotos.network;
import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import com.samples.flickrphotos.network.ApiService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHandler {
    private static ApiHandler mInstance;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://api.flickr.com/services/rest/";

    public ApiHandler(){
        //Cоздание экземпляра библиотеки для RestAPI Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient getOkHttp(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer " + "1328899")
                                .build();
                        return chain.proceed(newRequest);
                    }
                }).build();
        return client;
    }
    public static ApiHandler getInstance(){
        if(mInstance==null)
            mInstance = new ApiHandler();
        return mInstance;
    }

    public ApiService getService(){
        return retrofit.create(ApiService.class);
    }
}
