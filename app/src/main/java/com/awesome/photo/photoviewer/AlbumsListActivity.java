package com.awesome.photo.photoviewer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.awesome.photo.photoviewer.databinding.ActivityAlbumsListBinding;
import com.awesome.photo.photoviewer.presenters.adapters.AlbumModelToAlbumAdapter;
import com.awesome.photo.photoviewer.presenters.adapters.AlbumViewerRecyclerViewAdapter;
import com.awesome.photo.photoviewer.viewmodels.AlbumsViewerViewModel;
import com.awesome.photo.photoviewer.viewmodels.factories.AlbumsViewerViewModelFactory;
import com.awesome.photo.remote.api.models.AlbumsModel;
import com.awesome.photo.remote.api.providers.JSONPlaceHolderServiceBuilder;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;
import com.awesome.photo.remote.api.providers.JSONPlaceholderServiceCallback;

public class AlbumsListActivity extends AppCompatActivity {

    private AlbumsViewerViewModel albumsViewerViewModel;
    public MutableLiveData<AlbumsModel[]> albumsModelLiveData = new MutableLiveData<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityAlbumsListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_albums_list);
        albumsViewerViewModel = ViewModelProviders.of(this, new AlbumsViewerViewModelFactory(new JSONPlaceholderRepository(new JSONPlaceHolderServiceBuilder().build(), new JSONPlaceholderServiceCallback(albumsModelLiveData)))).get(AlbumsViewerViewModel.class);
        binding.albumViewerRv.setLayoutManager(new LinearLayoutManager(this));

        observeAlbumsLiveData(binding);
        albumsViewerViewModel.getAlbums();
        super.onCreate(savedInstanceState);
    }

    private void observeAlbumsLiveData(ActivityAlbumsListBinding activityAlbumViewerBinding) {
        albumsModelLiveData.observe(this, new Observer<AlbumsModel[]>() {
            @Override
            public void onChanged(@Nullable AlbumsModel[] albumsModels) {
                activityAlbumViewerBinding.albumViewerRv.setAdapter(new AlbumViewerRecyclerViewAdapter(new AlbumModelToAlbumAdapter().adapt(albumsModels)));
            }
        });
    }
}
