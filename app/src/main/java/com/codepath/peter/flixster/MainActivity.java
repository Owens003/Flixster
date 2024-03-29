package com.codepath.peter.flixster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.os.Bundle;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.codepath.peter.flixster.databinding.ActivityMainBinding;
import com.codepath.peter.flixster.models.Movie;
//import com.codepath.peter.flixster.MovieAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    public static final String NOW_PLAYING_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";
    public static final String TAG = "MainActivity";

   private ActivityMainBinding binding;
    List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        RecyclerView ojpMovies = binding.ojpmovie;
        movies = new ArrayList<>();

        // create the adapter
        MovieAdapter movieAdapter = new MovieAdapter(this, movies);
        // set the adapter on the recyclerView
        ojpMovies.setAdapter(movieAdapter);
        // set a Layout on the recyclerView
        ojpMovies.setLayoutManager(new LinearLayoutManager(this));

//        AsyncHttpClient client = new AsyncHttpClient();
//        client.get(NOW_PLAYING_URL, new JsonHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Headers headers, JSON json) {
//                Log.d(TAG, "onSuccess");
//                JSONObject jsonObject = json.jsonObject;
//                try{
//                    JSONArray results = jsonObject.getJSONArray("results");
//                    Log.i(TAG, "Results: " + movies.size());
//                    movies.addAll(Movie.fromJsonArray(results));
//                    movieAdapter.notifyDataSetChanged();
//                    Log.i(TAG, "Movies: " + results.toString());
//                }catch (JSONException e){
//                    Log.e(TAG,"hit json exeption", e);
//                }
//            }
//
//            @Override
//            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
//                Log.d(TAG, "onFailure");
//            }
//        });

        StringBuilder responseStrBuilder = new StringBuilder();;
        try {
            InputStream inputStream = getAssets().open("movies.txt");
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
            JSONArray results = jsonObject.getJSONArray("results");

            movies.addAll( Movie.fromJsonArray(results));
            movieAdapter.notifyDataSetChanged();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Log.i(TAG, "onCreate: " + responseStrBuilder.toString());
        }
    }
}