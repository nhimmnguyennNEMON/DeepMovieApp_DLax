package com.vn.nguyenvansy.deepmovieapp.itemConfigAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vn.nguyenvansy.deepmovieapp.R;
import com.vn.nguyenvansy.deepmovieapp.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

    private List<Movie> listMovie;

    public void setData(List<Movie> list) {
        this.listMovie = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = listMovie.get(position);
        if (movie == null) { return; }

        Picasso.get().load(movie.getUrlImageMovie()).into(holder.imgFilm);
        //holder.imgFilm.setImageResource(movie.getId());
        holder.textNameMovie.setText(movie.getTitle());
        Log.w("sy.nguyenvan", "MovieAdapter " + movie.getId());
    }

    @Override
    public int getItemCount() {
        if (listMovie != null) {return listMovie.size();}
        return 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFilm;
        private TextView textNameMovie;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFilm = itemView.findViewById(R.id.imgFilm);
            textNameMovie = itemView.findViewById(R.id.textNameMovie);

        }
    }

}
