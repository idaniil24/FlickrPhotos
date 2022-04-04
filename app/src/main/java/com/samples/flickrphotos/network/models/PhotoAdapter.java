package com.samples.flickrphotos.network.models;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.samples.flickrphotos.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotoAdapter extends ArrayAdapter<PhotoResponse> {

    private List<PhotoResponse> photoList;
    private int layoutId;

    public PhotoAdapter(@NonNull Context context, int resource, @NonNull List<PhotoResponse> objects) {
        super(context, resource, objects);
        photoList = objects;
        layoutId = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(layoutId, null);
        }

        TextView photoText = v.findViewById(R.id.photoText);

        PhotoResponse item = photoList.get(position);

        photoText.setText(item.getTitle());
        return v;
    }
    @Override
    public int getCount() {
        return photoList.size();
    }

}
