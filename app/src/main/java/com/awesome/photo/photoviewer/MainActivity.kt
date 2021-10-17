package com.awesome.photo.photoviewer

import androidx.appcompat.app.AppCompatActivity
import com.awesome.photo.photoviewer.viewmodels.MainActivityViewModel
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.awesome.photo.photoviewer.viewmodels.factories.MainActivityViewModelFactory
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository
import com.awesome.photo.remote.api.providers.JSONPlaceHolderServiceBuilder
import androidx.databinding.DataBindingUtil
import com.awesome.photo.photoviewer.R
import com.awesome.photo.photoviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var mainActivityViewModel: MainActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewModel = ViewModelProviders.of(
            this,
            MainActivityViewModelFactory(JSONPlaceholderRepository(JSONPlaceHolderServiceBuilder().build()))
        ).get(
            MainActivityViewModel::class.java
        )
        val viewBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding.albumsCta.setOnClickListener(
            mainActivityViewModel!!.viewAlbumsClickListener(
                this
            )
        )
    }
}