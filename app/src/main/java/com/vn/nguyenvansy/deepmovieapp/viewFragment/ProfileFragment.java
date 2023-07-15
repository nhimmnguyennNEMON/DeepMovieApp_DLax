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
import com.vn.nguyenvansy.deepmovieapp.viewActivity.Login;


public class ProfileFragment extends Fragment {

    private View view;
    private Button btnLogout;
    void bindingView() {
        btnLogout = view.findViewById(R.id.btnLogout);
    }

    void bindingAction() {
        btnLogout.setOnClickListener(this::onClickBtnLogout);
    }

    private void onClickBtnLogout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getContext(), Login.class);
        startActivity(intent);
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
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }
}