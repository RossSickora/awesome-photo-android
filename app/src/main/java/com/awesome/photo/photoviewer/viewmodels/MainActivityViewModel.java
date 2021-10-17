package com.awesome.photo.photoviewer.viewmodels;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import com.awesome.photo.photoviewer.AlbumsListActivity;
import com.awesome.photo.photoviewer.PhotoListViewerActivity;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;


public class MainActivityViewModel extends ViewModel {

    private JSONPlaceholderRepository albumsRepository;

    public MainActivityViewModel(JSONPlaceholderRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    public View.OnClickListener viewAlbumsClickListener(AppCompatActivity activity){
        return view -> activity.startActivity(new Intent(activity.getApplicationContext(), AlbumsListActivity.class));
    }
    //TODO need to update destination to PhotosViewerActivity when created
    public View.OnClickListener viewPhotosClickListener(AppCompatActivity activity){
        return view -> activity.startActivity(new Intent(activity.getApplicationContext(), PhotoListViewerActivity.class));
    }

}
