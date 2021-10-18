package com.awesome.photo.photoviewer.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.awesome.photo.photoviewer.presenters.Album
import com.squareup.picasso.Picasso

class AlbumPreviewComposable {
    @ExperimentalFoundationApi
    @Composable
    fun AlbumPreview(albumList: Collection<Album>) {
        LazyVerticalGrid(cells = GridCells.Fixed(4)){
            items(albumList.toList()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Image(
                        painter = rememberImagePainter(it.photos[0].thumbnailUrl),
                        contentDescription = it.photos[0].title,
                        modifier = Modifier.size(64.dp)
                    )
                }
            }
        }
    }
}