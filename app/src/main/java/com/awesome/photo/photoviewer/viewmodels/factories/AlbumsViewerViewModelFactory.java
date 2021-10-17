package com.awesome.photo.photoviewer.viewmodels.factories;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.awesome.photo.photoviewer.viewmodels.AlbumsViewerViewModel;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;

public class AlbumsViewerViewModelFactory implements ViewModelProvider.Factory {

        JSONPlaceholderRepository albumsRepository;

        public AlbumsViewerViewModelFactory(JSONPlaceholderRepository albumsRepository){
            this.albumsRepository = albumsRepository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T)new AlbumsViewerViewModel(albumsRepository);
        }
}
