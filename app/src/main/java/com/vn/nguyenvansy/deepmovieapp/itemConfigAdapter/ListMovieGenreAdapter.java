package com.vn.nguyenvansy.deepmovieapp.itemConfigAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vn.nguyenvansy.deepmovieapp.R;
import com.vn.nguyenvansy.deepmovieapp.models.ListMovieGenre;
import com.vn.nguyenvansy.deepmovieapp.models.Movie;

import java.util.List;

public class ListMovieGenreAdapter extends RecyclerView.Adapter<ListMovieGenreAdapter.ListGenreViewHolder> {

    private Context context;
    private List<ListMovieGenre> listMovieGenre;

    public ListMovieGenreAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<ListMovieGenre> listMovieGenre) {
        this.listMovieGenre = listMovieGenre;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListGenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_movie, parent, false);
        return new ListGenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListGenreViewHolder holder, int position) {
        ListMovieGenre listGenre = listMovieGenre.get(position);
        if (listGenre == null) { return; }

        holder.txtMovieTitle.setText(listGenre.getGenre());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,
                RecyclerView.HORIZONTAL,
                false);
        holder.rcv_Movie.setLayoutManager(linearLayoutManager);

        MovieAdapter movieAdapter = new MovieAdapter();
        movieAdapter.setData(listGenre.getMovies());
        holder.rcv_Movie.setAdapter(movieAdapter);
        Log.w("sy.nguyenvan", "ListMovieGenreAdapter " + listGenre.getMovies().size());
    }

    @Override
    public int getItemCount() {
        if (listMovieGenre != null) {return listMovieGenre.size();}
        return 0;
    }
    public class ListGenreViewHolder extends RecyclerView.ViewHolder {

        private TextView txtMovieTitle;
        private RecyclerView rcv_Movie;
        public ListGenreViewHolder(@NonNull View itemView) {
            super(itemView);

            rcv_Movie = itemView.findViewById(R.id.rcv_Movie);
            txtMovieTitle = itemView.findViewById(R.id.txtMovieTitle);
        }
    }

}
