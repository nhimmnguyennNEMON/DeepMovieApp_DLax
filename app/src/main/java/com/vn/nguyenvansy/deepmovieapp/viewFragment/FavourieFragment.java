package com.vn.nguyenvansy.deepmovieapp.viewFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.vn.nguyenvansy.deepmovieapp.MainActivity;
import com.vn.nguyenvansy.deepmovieapp.R;

public class FavourieFragment extends Fragment {

    private View view;
    void bindingView() {
    }

    void bindingAction() {
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
        view =  inflater.inflate(R.layout.fragment_favourie, container, false);
        return view;
    }
}