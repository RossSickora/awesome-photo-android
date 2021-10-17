package com.awesome.photo.photoviewer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.awesome.photo.photoviewer.databinding.ActivityPhotoListViewerBinding;
import com.awesome.photo.photoviewer.fragments.PhotoFragment;
import com.awesome.photo.photoviewer.presenters.Album;

public class PhotoListViewerActivity extends AppCompatActivity {
    private Album album;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        album = (Album)getIntent().getSerializableExtra(Constants.ALBUM);
        ActivityPhotoListViewerBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_photo_list_viewer);
        mPager = binding.viewPager;
        mPagerAdapter = new PhotoAlbumPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        super.onCreate(savedInstanceState);
    }

    private class PhotoAlbumPagerAdapter extends FragmentStatePagerAdapter {

        public PhotoAlbumPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return  PhotoFragment.getInstance(album.getPhotos().get(i));
        }

        @Override
        public int getCount() {
            return album.getPhotos().size();
        }
    }
}
