package com.awesome.photo.photoviewer.presenters.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.awesome.photo.photoviewer.Constants;
import com.awesome.photo.photoviewer.PhotoListViewerActivity;
import com.awesome.photo.photoviewer.R;
import com.awesome.photo.photoviewer.presenters.Album;

import java.util.ArrayList;
import java.util.Collection;

public class AlbumViewerRecyclerViewAdapter extends RecyclerView.Adapter {

    ArrayList<Album> list = new ArrayList<>();

    public AlbumViewerRecyclerViewAdapter(Collection<Album> albums) {
        list.addAll(albums);
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
        Album current = list.get(i);

        ((AlbumViewerRecyclerViewAdapter.AlbumViewHolder) viewHolder).getAlbumTitleTextView().setText("Album " + current.getId());
        ((AlbumViewerRecyclerViewAdapter.AlbumViewHolder) viewHolder).getCardViewWrapper().setOnClickListener(getClickHandlerFor(current));
    }

    private View.OnClickListener getClickHandlerFor(Album current) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constants.ALBUM, current );
                view.getContext().startActivity(new Intent(view.getContext(), PhotoListViewerActivity.class).putExtras(bundle));
            }
        };
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {

        private TextView albumTitleTextView;
        private CardView cardViewWrapper;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            albumTitleTextView = itemView.findViewById(R.id.album_title);
            cardViewWrapper = itemView.findViewById(R.id.view_holder_parent);
        }

        public TextView getAlbumTitleTextView() {
            return albumTitleTextView;
        }

        public CardView getCardViewWrapper() {
            return cardViewWrapper;
        }
    }
}
