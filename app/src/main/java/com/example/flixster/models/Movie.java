package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.List;

import java.util.ArrayList;

@Parcel
public class Movie {
    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;

    // empty constructor needed by the Parceler library
    public Movie(){

    }

    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJSONArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;

    }

    public String getPosterPath() {
//        System.out.println(String.format("https://image.tmdb.org/t/p/w342/%s", posterPath));
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

//    public void setPosterPath(String posterPath) {
//        this.posterPath = posterPath;
//    }

    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getOverview() {
        return overview;
    }

//    public void setOverview(String overview) {
//        this.overview = overview;
//    }


    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}
