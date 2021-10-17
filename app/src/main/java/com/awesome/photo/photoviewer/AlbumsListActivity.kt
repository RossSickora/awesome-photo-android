package com.awesome.photo.photoviewer

import androidx.appcompat.app.AppCompatActivity
import com.awesome.photo.photoviewer.viewmodels.AlbumsViewerViewModel
import androidx.lifecycle.MutableLiveData
import com.awesome.photo.remote.api.models.AlbumsModel
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.awesome.photo.photoviewer.R
import androidx.lifecycle.ViewModelProviders
import com.awesome.photo.photoviewer.viewmodels.factories.AlbumsViewerViewModelFactory
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository
import com.awesome.photo.remote.api.providers.JSONPlaceHolderServiceBuilder
import com.awesome.photo.remote.api.providers.JSONPlaceholderServiceCallback
import androidx.recyclerview.widget.LinearLayoutManager
import com.awesome.photo.photoviewer.databinding.ActivityAlbumsListBinding
import com.awesome.photo.photoviewer.presenters.adapters.AlbumViewerRecyclerViewAdapter
import com.awesome.photo.photoviewer.presenters.adapters.AlbumModelToAlbumAdapter

class AlbumsListActivity : AppCompatActivity() {
    private var albumsViewerViewModel: AlbumsViewerViewModel? = null
    var albumsModelLiveData = MutableLiveData<Array<AlbumsModel>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityAlbumsListBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_albums_list)
        albumsViewerViewModel = ViewModelProviders.of(
            this,
            AlbumsViewerViewModelFactory(
                JSONPlaceholderRepository(
                    JSONPlaceHolderServiceBuilder().build(),
                    JSONPlaceholderServiceCallback(albumsModelLiveData)
                )
            )
        ).get(
            AlbumsViewerViewModel::class.java
        )
        binding.albumViewerRv.layoutManager = LinearLayoutManager(this)
        observeAlbumsLiveData(binding)
        albumsViewerViewModel!!.getAlbums()
        super.onCreate(savedInstanceState)
    }

    private fun observeAlbumsLiveData(activityAlbumViewerBinding: ActivityAlbumsListBinding) {
        albumsModelLiveData.observe(
            this,
            Observer<Array<AlbumsModel>> { albumsModels ->
                activityAlbumViewerBinding.albumViewerRv.adapter =
                    AlbumViewerRecyclerViewAdapter(AlbumModelToAlbumAdapter().adapt(albumsModels))
            })
    }
}


