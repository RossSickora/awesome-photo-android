package com.awesome.photo.photoviewer

import androidx.appcompat.app.AppCompatActivity
import com.awesome.photo.photoviewer.viewmodels.MainActivityViewModel
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.lifecycle.ViewModelProviders
import com.awesome.photo.photoviewer.viewmodels.factories.MainActivityViewModelFactory
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository
import com.awesome.photo.remote.api.providers.JSONPlaceHolderServiceBuilder
import androidx.databinding.DataBindingUtil
import com.awesome.photo.photoviewer.R
import com.awesome.photo.photoviewer.composables.GreetingComposable
import com.awesome.photo.photoviewer.databinding.ActivityMainBinding
import com.google.accompanist.appcompattheme.AppCompatTheme

class MainActivity : AppCompatActivity() {
    private var mainActivityViewModel: MainActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel = ViewModelProviders.of(
            this,
            MainActivityViewModelFactory(JSONPlaceholderRepository(JSONPlaceHolderServiceBuilder().build()))
        ).get(
            MainActivityViewModel::class.java
        )
        val viewBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding.albumsCta.setOnClickListener(
            mainActivityViewModel!!.viewAlbumsClickListener(
        this
            )
        )
        viewBinding.mainGreeting.setContent {
            AppCompatTheme {
                GreetingComposable().Greeting()
            }
        }
    }
}
