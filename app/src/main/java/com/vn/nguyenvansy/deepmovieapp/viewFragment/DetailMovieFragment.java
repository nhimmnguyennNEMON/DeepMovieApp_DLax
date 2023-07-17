package com.vn.nguyenvansy.deepmovieapp.viewFragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

public class DetailMovieFragment extends Fragment {

    private View view;
    private ExoPlayer player;
    private StyledPlayerView playerView;
    void bindingView() {
        playerView = view.findViewById(R.id.player_view);
    }

    void bindingAction() {

    }

    void setupRecyclerView() {

    }

    void setupViewPlayMovie(String videoUrl) {
        player = new ExoPlayer.Builder(getActivity()).build();
        playerView.setPlayer(player);
        MediaItem mediaItem = MediaItem.fromUri(videoUrl);
        player.setMediaItem(mediaItem);
        player.prepare();
        player.setPlayWhenReady(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView();
        bindingAction();
        setupViewPlayMovie("https://rr2---sn-42u-i5oey.googlevideo.com/videoplayback?expire=1689629060&ei=JF21ZMrwDrmFsfIP-7abkAQ&ip=102.129.232.231&id=o-AIEgrFuvVthxWOM-UkE6N1gV5EbOYZnayJZJAZJ_Cvmr&itag=18&source=youtube&requiressl=yes&spc=Ul2Sq0pWF7MNa2_W6BNkXEWSiZQdPvuHPM21svXVVA&vprv=1&svpuc=1&mime=video%2Fmp4&ns=rV69eJu3L6W6Ep165dqpQu0O&gir=yes&clen=21473866&ratebypass=yes&dur=263.407&lmt=1689292769033676&fexp=24007246,24350018,51000024&beids=24350018&c=WEB&txp=4538434&n=YWHsRRlt2ONKnw&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Cns%2Cgir%2Cclen%2Cratebypass%2Cdur%2Clmt&sig=AOq0QJ8wRQIhAMQWQqxipFU83G05uznWOtlrM-tfgdp4LJ8_Dc-IpKDGAiBjhkwZLEE31q7K2LwGOmCFNXjVzd9BBmYhapNrQnSOAA%3D%3D&redirect_counter=1&rm=sn-q4fez67z&req_id=faff97f51f62a3ee&cms_redirect=yes&cmsv=e&ipbypass=yes&mh=wF&mip=1.53.223.232&mm=31&mn=sn-42u-i5oey&ms=au&mt=1689606682&mv=u&mvi=2&pl=23&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AG3C_xAwRgIhAOj7hTM3jB0c_54x0amGd-wOa0gR7cM6i4k7nyGQY9HgAiEAqoLOU2_aNVNFy4eqd-vxpwjRkSh_BCwuiv0YY6Mmu3M%3D");
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