package com.awesome.photo.photoviewer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.awesome.photo.photoviewer.databinding.ActivityMainBinding;
import com.awesome.photo.photoviewer.viewmodels.MainActivityViewModel;
import com.awesome.photo.photoviewer.viewmodels.factories.MainActivityViewModelFactory;
import com.awesome.photo.remote.api.providers.JSONPlaceHolderServiceBuilder;
import com.awesome.photo.remote.api.providers.JSONPlaceholderRepository;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityViewModel = ViewModelProviders.of(this, new MainActivityViewModelFactory(new JSONPlaceholderRepository(new JSONPlaceHolderServiceBuilder().build()))).get(MainActivityViewModel.class);
        ActivityMainBinding viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //for some reason my binding isn't regenerating.
        findViewById(R.id.albums_cta).setOnClickListener(mainActivityViewModel.viewAlbumsClickListener(this));


    }
}
