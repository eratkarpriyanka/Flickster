package com.codepath.flickster.models;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.codepath.flickster.StringConstants.KEY_BACKDROP_PATH;
import static com.codepath.flickster.StringConstants.KEY_BASE_POSTER_URL;
import static com.codepath.flickster.StringConstants.KEY_POSTER_PATH;
import static com.codepath.flickster.StringConstants.KEY_SYNOPSIS;
import static com.codepath.flickster.StringConstants.KEY_TITLE;

public class Movie {


    String posterPath;
    String title;
    String backdropImgPath;
    String synosis;

    public Movie(JSONObject jsonObjMovie) throws JSONException{

        this.posterPath = jsonObjMovie.getString(KEY_POSTER_PATH);
        this.backdropImgPath = jsonObjMovie.getString(KEY_BACKDROP_PATH);
        this.title = jsonObjMovie.getString(KEY_TITLE);
        this.synosis = jsonObjMovie.getString(KEY_SYNOPSIS);
    }

    public String getPosterPath() {
        return String.format(KEY_BASE_POSTER_URL+"%s",posterPath);
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropImgPath() {
        return backdropImgPath;
    }

    public void setBackdropImgPath(String backdropImgPath) {
        this.backdropImgPath = backdropImgPath;
    }

    public String getSynosis() {
        return synosis;
    }

    public void setSynosis(String synosis) {
        this.synosis = synosis;
    }

    public static ArrayList<Movie> fromJsonArray(JSONArray jsonArrMovie){

        ArrayList movieList = new ArrayList<Movie>();

        for(int i=0 ; i<jsonArrMovie.length(); i++){

            try {

                JSONObject jsonMovieObject =  jsonArrMovie.getJSONObject(i);
                Movie movie = new Movie(jsonMovieObject);
                movieList.add(movie);

            } catch (JSONException e) {
                e.printStackTrace();

                return null;
            }

        }
        return movieList;
    }
}
