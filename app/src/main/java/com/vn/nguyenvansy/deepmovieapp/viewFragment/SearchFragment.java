package com.vn.nguyenvansy.deepmovieapp.viewFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.vn.nguyenvansy.deepmovieapp.R;

public class SearchFragment extends Fragment {

    private EditText txtSearch;
    private View view;
    private ImageView btnNameFilm;
    private RecyclerView rcv_contentViewMovieSearch;
    void bindingView() {
     txtSearch.findViewById(R.id.textNameFilmValue);
     btnNameFilm.findViewById(R.id.textNameFilm);
     rcv_contentViewMovieSearch = view.findViewById(R.id.rcv_contentViewMovieSearch);
    }

    void bindingAction() {
        btnNameFilm.setOnClickListener(this::onClickBtnSearch);

    }

    private void onClickBtnSearch(View view) {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingView();
        bindingAction();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
}