package com.awesome.photo.photoviewer

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.awesome.photo.photoviewer.composables.AlbumPreviewComposable
import com.awesome.photo.photoviewer.presenters.adapters.AlbumModelToAlbumAdapter
import com.awesome.photo.photoviewer.ui.theme.AwesomephotoandroidTheme
import com.awesome.photo.photoviewer.viewmodels.AlbumsViewerViewModel
import com.awesome.photo.photoviewer.viewmodels.factories.AlbumsViewerViewModelFactory
import com.awesome.photo.remote.api.models.AlbumsModel
import com.awesome.photo.remote.api.providers.JSONPlaceHolderServiceBuilder
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository
import com.awesome.photo.remote.api.providers.JSONPlaceholderServiceCallback

class PreviewAlbumsActivity : AppCompatActivity() {
    private val albumsModelLiveData = MutableLiveData<Array<AlbumsModel>>()
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val albumsViewerViewModel = createAlbumsViewerViewModel()
//
//        setContent {
//            AwesomephotoandroidTheme {
//                albumsModelLiveData.observe(this, {
//                        albumsModels ->  Greeting(albumsModels)
//                })
//            }
//        }
    }

    private fun createAlbumsViewerViewModel() = ViewModelProviders.of(
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


}

@ExperimentalFoundationApi
@Composable
fun Greeting(albumsModels: List<AlbumsModel>) {
//    var albumslist by remember{ mutableListOf<List<AlbumsModel>>()}
//    AlbumPreviewComposable().AlbumPreview(albumList = AlbumModelToAlbumAdapter().adapt(albumsModels))
}
