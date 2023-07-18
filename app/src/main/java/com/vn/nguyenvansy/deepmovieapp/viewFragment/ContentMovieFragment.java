package com.vn.nguyenvansy.deepmovieapp.viewFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.vn.nguyenvansy.deepmovieapp.R;
import com.vn.nguyenvansy.deepmovieapp.itemConfigAdapter.ListMovieGenreAdapter;
import com.vn.nguyenvansy.deepmovieapp.itemConfigAdapter.MovieAdapter;
import com.vn.nguyenvansy.deepmovieapp.models.HotPicMovie;
import com.vn.nguyenvansy.deepmovieapp.models.ListMovieGenre;
import com.vn.nguyenvansy.deepmovieapp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class ContentMovieFragment extends Fragment implements MovieAdapter.OnItemClickListener{

    private View view;
    private RecyclerView rcv_contentViewMovie;
    private ListMovieGenreAdapter listMovieGenreAdapter;
    private StyledPlayerView playerView;
    private ExoPlayer player;

    List<ListMovieGenre> listMovieGenre = new ArrayList<>();
    List<Movie> listMovies = new ArrayList<>();
    void bindingView() {
        rcv_contentViewMovie = view.findViewById(R.id.rcv_contentViewMovie);
        playerView = view.findViewById(R.id.player_view);
    }

    void bindingAction() {

    }

    void setupRecyclerView() {
        listMovieGenreAdapter = new ListMovieGenreAdapter(view.getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( view.getContext(),
                RecyclerView.VERTICAL,
                false);
        rcv_contentViewMovie.setLayoutManager(linearLayoutManager);

        listMovieGenreAdapter.setData(getListMovieForGenre());
        rcv_contentViewMovie.setAdapter(listMovieGenreAdapter);
    }

    private List<ListMovieGenre> getListMovieForGenre() {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference movieCollectionRef = db.collection("movies");

        movieCollectionRef.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                // Xử lý dữ liệu khi lấy thành công
                for (DocumentSnapshot document : queryDocumentSnapshots) {
                    // Lấy thông tin từ DocumentSnapshot và thêm vào movieList
                    Movie movie = document.toObject(Movie.class);
                    listMovies.add(movie);
                    listMovieGenre.add(new ListMovieGenre(movie.getGenre(), listMovies));
                }
                listMovieGenreAdapter.notifyDataSetChanged();
                setupViewPlayMovie();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Xử lý khi lấy dữ liệu thất bại
            }
        });

        return listMovieGenre;
    }

    void setupViewPlayMovie() {
        player = new ExoPlayer.Builder(getActivity()).build();
        playerView.setPlayer(player);
        MediaItem mediaItem = MediaItem.fromUri(listMovies.get(0).getUrlMovie());
        player.setMediaItem(mediaItem);
        player.prepare();
        player.setPlayWhenReady(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView();
        setupRecyclerView();
        MovieAdapter adapter = new MovieAdapter();
        adapter.setOnItemClickListener();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(requireContext(), "Clicked item at position: " + position, Toast.LENGTH_SHORT).show();
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
        view = inflater.inflate(R.layout.fragment_content_movie, container, false);
        return view;
    }
}