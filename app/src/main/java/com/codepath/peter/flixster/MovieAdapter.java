package com.codepath.peter.flixster;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.peter.flixster.databinding.ItemMovieBinding;
import com.codepath.peter.flixster.databinding.PopulaireBinding;
import com.codepath.peter.flixster.models.Movie;

import org.parceler.Parcels;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    static Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("movieAdapter", "onCreateViewHolder");
        RecyclerView.ViewHolder viewHolder;
       LayoutInflater inflater =  LayoutInflater.from(parent.getContext());

       if(viewType == 0){
           PopulaireBinding movieView = DataBindingUtil.inflate(inflater,R.layout.populaire, parent, false);
           viewHolder = new ViewHolder1(movieView);
       }
       else {
           ItemMovieBinding movieView1 = DataBindingUtil.inflate(inflater,R.layout.item_movie, parent, false);
           viewHolder = new ViewHolder2(movieView1);
       }
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d("movieAdapter", "onBindViewHolder " + position);
        Movie movie = movies.get(position);
        if (holder.getItemViewType()== 0) {
            ViewHolder1 holder1 = (ViewHolder1) holder;
            holder1.bind(movie);
        }
        else {
            ViewHolder2 holder2 = (ViewHolder2) holder;
            holder2.bind(movie);
        }

//        holder.bing(movie);

    }

    @Override
    public int getItemViewType(int position) {
        if (movies.get(position).getRating() > 7)
            return 0;
        return  1;

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {

        public ItemMovieBinding binding;

        RelativeLayout container;
        TextView tvTitle;
        TextView tvOverView;
        ImageView ivPoster;

        public ViewHolder2(@NonNull ItemMovieBinding itemView) {
            super(itemView.getRoot());
            tvTitle = itemView.tvTitle;
            tvOverView = itemView.tvOverView;
            ivPoster = itemView.ivPoster;
            container = itemView.container;

            binding = itemView;
        }

        public void bind(Movie movie) {
//            tvTitle.setText(movie.getTitle());
//            tvOverView.setText(movie.getOverview());

            binding.setUser(movie);




            //1. Register click listener on the whole row
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //2. Navigate to a new activity on tap
                    Intent i = new Intent(context, DetailActivity.class);
                    i.putExtra("movie", Parcels.wrap(movie));
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) context, ivPoster, "profile");
                    context.startActivity(i, options.toBundle());
                }
            });
        }
    }

    public static class ViewHolder1 extends RecyclerView.ViewHolder {

        RelativeLayout container;
        ImageView ivPoster;

        public PopulaireBinding binding;

        public ViewHolder1(@NonNull PopulaireBinding itemView) {
            super(itemView.getRoot());
            ivPoster = itemView.ivPoster;
            container = itemView.container;
            binding = itemView;
        }

            public void bind(Movie movie) {
                binding.setUser(movie);


                //1. Register click listener on the whole row
                container.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //2. Navigate to a new activity on tap
                        Intent i = new Intent(context, DetailActivity.class);
                        i.putExtra("movie", Parcels.wrap(movie));
                        ActivityOptionsCompat options = ActivityOptionsCompat.
                                makeSceneTransitionAnimation((Activity) context, ivPoster, "profile");
                        context.startActivity(i, options.toBundle());
                    }
                });
            }

        }
    public static class BindingAdapterUtils {
        @BindingAdapter({"lessPopulaire"})
        public static void loadImage(ImageView view, String url) {
            Glide.with(context).load(url)
                    .placeholder(R.drawable.pa)
                    .transform(new RoundedCorners(50))
                    .into(view);
        }
    }
    public static class BindingAdapterUtils1 {
        @BindingAdapter({"MorePopulaire"})
        public static void loadImage(ImageView view, String url) {
            Glide.with(context).load(url)
                    .placeholder(R.drawable.pa)
                    .transform(new RoundedCorners(50))
                    .into(view);
        }
    }

}

