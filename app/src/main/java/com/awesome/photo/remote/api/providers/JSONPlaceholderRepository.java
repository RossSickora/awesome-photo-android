package com.awesome.photo.remote.api.providers;

import androidx.lifecycle.MutableLiveData;

import com.awesome.photo.remote.api.models.AlbumsModel;

import retrofit2.Callback;


public class JSONPlaceholderRepository {

    JSONPlaceholderService service;
    private Callback<AlbumsModel[]> callback;


    public JSONPlaceholderRepository(JSONPlaceholderService service){
        this.service = service;
        this.callback =  new JSONPlaceholderServiceCallback(new MutableLiveData<AlbumsModel[]>());

    }

    public JSONPlaceholderRepository(JSONPlaceholderService service, Callback<AlbumsModel[]> callback){
        this.service = service;
        this.callback = callback;
    }

    public void retrieve(){
        service.getAlbums().enqueue(callback);
    }

    public void retrieve(int id){
        service.getAlbum(id).enqueue(callback);
    }
}
