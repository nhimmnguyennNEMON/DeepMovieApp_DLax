package com.vn.nguyenvansy.deepmovieapp.viewFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vn.nguyenvansy.deepmovieapp.R;
import com.vn.nguyenvansy.deepmovieapp.itemConfigAdapter.ListMovieGenreAdapter;
import com.vn.nguyenvansy.deepmovieapp.models.ListMovieGenre;
import com.vn.nguyenvansy.deepmovieapp.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class ContentMovieFragment extends Fragment {

    private View view;
    private RecyclerView rcv_contentViewMovie;
    private ListMovieGenreAdapter listMovieGenreAdapter;
    void bindingView() {
        rcv_contentViewMovie = view.findViewById(R.id.rcv_contentViewMovie);
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
        Log.w("sy.nguyenvan", "ContentMovieFragment " + getListMovieForGenre().size());
    }

    private List<ListMovieGenre> getListMovieForGenre() {
        List<ListMovieGenre> listMovieGenre = new ArrayList<>();

        List<Movie> listMovies = new ArrayList<>();
        listMovies.add(new Movie(R.drawable.img_1, "Movie 1", "", "", "", "", " "));
        listMovies.add(new Movie(R.drawable.img_2, "Movie 2", "", "", "", "", " "));
        listMovies.add(new Movie(R.drawable.img_3, "Movie 3", "", "", "", "", " "));
        listMovies.add(new Movie(R.drawable.img_1, "Movie 1", "", "", "", "", " "));
        listMovies.add(new Movie(R.drawable.img_2, "Movie 2", "", "", "", "", " "));
        listMovies.add(new Movie(R.drawable.img_3, "Movie 3", "", "", "", "", " "));

        listMovieGenre.add(new ListMovieGenre("Action", listMovies));
        listMovieGenre.add(new ListMovieGenre("Comedy", listMovies));
        listMovieGenre.add(new ListMovieGenre("Drama", listMovies));
        listMovieGenre.add(new ListMovieGenre("Romance", listMovies));
        listMovieGenre.add(new ListMovieGenre("Thriller", listMovies));
        listMovieGenre.add(new ListMovieGenre("Horror", listMovies));
        listMovieGenre.add(new ListMovieGenre("Fantasy", listMovies));
        listMovieGenre.add(new ListMovieGenre("Animation", listMovies));
        listMovieGenre.add(new ListMovieGenre("Documentary", listMovies));

        return listMovieGenre;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView();
        setupRecyclerView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_content_movie, container, false);
        return view;
    }
}