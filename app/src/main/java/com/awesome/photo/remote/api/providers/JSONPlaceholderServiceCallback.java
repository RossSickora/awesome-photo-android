package com.awesome.photo.remote.api.providers;


import androidx.lifecycle.MutableLiveData;

import com.awesome.photo.remote.api.models.AlbumsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JSONPlaceholderServiceCallback implements Callback<AlbumsModel[]> {

    private MutableLiveData<AlbumsModel[]> albumsModelMutableLiveData;

    public JSONPlaceholderServiceCallback(MutableLiveData<AlbumsModel[]> albumsModelMutableLiveData){
        this.albumsModelMutableLiveData = albumsModelMutableLiveData;
    }

    @Override
    public void onResponse(Call call, Response response) {
        albumsModelMutableLiveData.setValue((AlbumsModel[])response.body());
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        //TODO implement the failure callback
    }
}
