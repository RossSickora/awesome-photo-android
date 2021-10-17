package com.awesome.photo.photoviewer

import androidx.appcompat.app.AppCompatActivity
import com.awesome.photo.photoviewer.presenters.Album
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.PagerAdapter
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.awesome.photo.photoviewer.R
import com.awesome.photo.photoviewer.PhotoListViewerActivity.PhotoAlbumPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.awesome.photo.photoviewer.databinding.ActivityPhotoListViewerBinding
import com.awesome.photo.photoviewer.fragments.PhotoFragment

class PhotoListViewerActivity : AppCompatActivity() {
    private var album: Album? = null
    private var mPager: ViewPager? = null
    private var mPagerAdapter: PagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        album = intent.getSerializableExtra(Constants.ALBUM) as Album?
        val binding: ActivityPhotoListViewerBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_photo_list_viewer)
        mPager = binding.viewPager
        mPagerAdapter = PhotoAlbumPagerAdapter(supportFragmentManager)
        mPager!!.adapter = mPagerAdapter
        super.onCreate(savedInstanceState)
    }

    private inner class PhotoAlbumPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(
        fm!!
    ) {
        override fun getItem(i: Int): Fragment {
            return PhotoFragment.getInstance(album!!.photos[i])
        }

        override fun getCount(): Int {
            return album!!.photos.size
        }
    }
}