package com.vn.nguyenvansy.deepmovieapp.viewFragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.vn.nguyenvansy.deepmovieapp.R;
import com.vn.nguyenvansy.deepmovieapp.itemConfigAdapter.MovieAdapter;
import com.vn.nguyenvansy.deepmovieapp.models.Movie;

public class DetailMovieFragment extends Fragment {

    private View view;
    private ExoPlayer player;
    private StyledPlayerView playerView;

    void bindingView() {
        playerView = view.findViewById(R.id.player_view);
    }

    void bindingAction() {

    }

    void setupContentMovie() {

    }

    void setupViewPlayMovie() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            Movie movie = (Movie) bundle.getParcelable("movie");
            player = new ExoPlayer.Builder(getActivity()).build();
            playerView.setPlayer(player);
            MediaItem mediaItem = MediaItem.fromUri(movie.getUrlMovie());
            player.setMediaItem(mediaItem);
            player.prepare();
            player.setPlayWhenReady(true);
        }
    }

    public static DetailMovieFragment newInstance(Bundle bundle) {
        DetailMovieFragment fragment = new DetailMovieFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView();
        bindingAction();
        setupViewPlayMovie();
    }

    @Override
    public void onStop() {
        super.onStop();
        player.setPlayWhenReady(false);
        player.release();
        player = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_movie, container, false);
        return view;
    }
}