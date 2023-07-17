package com.vn.nguyenvansy.deepmovieapp.utils;

import com.vn.nguyenvansy.deepmovieapp.models.Movie;

import java.util.List;

public interface DataCallBack {
    void onDataLoaded(List<Movie> movies);
}
