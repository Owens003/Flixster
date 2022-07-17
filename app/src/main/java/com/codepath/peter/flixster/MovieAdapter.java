package com.codepath.peter.flixster;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.codepath.peter.flixster.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.viewHolder> {

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("movieAdapter", "onCreateViewHolder");
       View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new viewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Log.d("movieAdapter", "onBindViewHolder " + position);
        Movie movie = movies.get(position);

        holder.bing(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvOverView;
        ImageView ivPoster;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverView = itemView.findViewById(R.id.tvOverView);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bing(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverView.setText(movie.getOverview());
            String imageUrl;

            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                imageUrl = movie.getBackdropPath();
            }else {
                imageUrl = movie.getPosterPath();
            }

            Glide.with(context).load(imageUrl)
                    .placeholder(R.drawable.pa)
                    .into(ivPoster);

        }
    }
}
