package com.awesome.photo.photoviewer.fragments;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.awesome.photo.photoviewer.R;
import com.awesome.photo.photoviewer.databinding.FragmentPhotoBinding;
import com.awesome.photo.remote.api.models.AlbumsModel;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.Nullable;

public class PhotoFragment extends Fragment {

    AlbumsModel albumsModel;

    public static PhotoFragment getInstance(AlbumsModel albumsModel){
        PhotoFragment newInstance = new PhotoFragment();
        newInstance.albumsModel = albumsModel;
        return  newInstance;
    }

    public PhotoFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPhotoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo, container, false);
        binding.photoHeader.setText(albumsModel.getTitle());
        Picasso.get().load(albumsModel.getUrl()).into(binding.photoImageView);
        return binding.getRoot();
    }

    protected void setAlbumsModel(AlbumsModel albumsModel){
        this.albumsModel = albumsModel;
    }
}
