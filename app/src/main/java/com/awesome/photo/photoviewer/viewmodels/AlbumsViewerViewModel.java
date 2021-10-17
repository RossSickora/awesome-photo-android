package com.awesome.photo.photoviewer.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.awesome.photo.remote.api.models.AlbumsModel;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;

public class AlbumsViewerViewModel extends ViewModel {

    public MutableLiveData<AlbumsModel[]> albumsLiveData = new MutableLiveData<>();
    private JSONPlaceholderRepository albumsRepository;

    public AlbumsViewerViewModel(JSONPlaceholderRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    public void getAlbums() {
        albumsRepository.retrieve();

    }
}
