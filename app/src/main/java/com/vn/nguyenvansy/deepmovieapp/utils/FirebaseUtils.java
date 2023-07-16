package com.vn.nguyenvansy.deepmovieapp.utils;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.vn.nguyenvansy.deepmovieapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class FirebaseUtils {
    private static FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private static FirebaseUser currentUser = mAuth.getCurrentUser();
    private static FirebaseFirestore firestore = FirebaseFirestore.getInstance();


    public static List<User> getListUserData() {
        List<User> userList = new ArrayList<>();
        CollectionReference collectionRef = firestore.collection("user");
        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        User user = document.toObject(User.class);
                        userList.add(user);
                    }
                } else {
                    Exception e = task.getException();
                }
            }
        });
        return userList;
    }

}
