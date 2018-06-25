package com.awesome.photo.photoviewer.presenters.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.awesome.photo.photoviewer.R;
import com.awesome.photo.photoviewer.presenters.Album;

import java.util.List;

public class AlbumViewerRecyclerViewAdapter extends RecyclerView.Adapter {

    List<Album> albums;

    public AlbumViewerRecyclerViewAdapter(List<Album> albums) {
        this.albums = albums;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_album_holder, viewGroup, false);

        RecyclerView.ViewHolder holder = new AlbumViewerRecyclerViewAdapter.AlbumViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Album current = albums.get(i);

        ((AlbumViewerRecyclerViewAdapter.AlbumViewHolder) viewHolder).getAlbumTitleTextView().setText("Album " + current.getId());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {

        private TextView albumTitleTextView;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            albumTitleTextView = itemView.findViewById(R.id.album_title);
        }

        public TextView getAlbumTitleTextView() {
            return albumTitleTextView;
        }
    }
}
