package com.samples.flickrphotos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.samples.flickrphotos.network.ApiHandler;
import com.samples.flickrphotos.network.ApiService;
import com.samples.flickrphotos.network.models.PhotoAdapter;
import com.samples.flickrphotos.network.models.PhotoList;
import com.samples.flickrphotos.network.models.PhotoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService service = ApiHandler.getInstance().getService();
    private GridView photoContainer;
    private List<PhotoResponse> photoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoContainer = findViewById(R.id.photolv);
        getPhotos();
    }
    private void getPhotos(){
        AsyncTask.execute(() -> {
            service.getPhotos().enqueue(new Callback<PhotoList>() {
                @Override
                public void onResponse(Call<PhotoList> call, Response<PhotoList> response) {
                    if(response.isSuccessful()){
                        photoList = response.body().getPhotoList();
                        PhotoAdapter adapter = new PhotoAdapter(getApplicationContext(), R.layout.grid_item, photoList);
                        photoContainer.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<PhotoList> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}