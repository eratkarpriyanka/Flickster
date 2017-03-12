package com.codepath.flickster.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.codepath.flickster.R;
import com.codepath.flickster.adapter.MovieListArrayAdapter;
import com.codepath.flickster.models.Movie;
import com.codepath.flickster.network.IWSResponseListener;
import com.codepath.flickster.network.WebServiceRequest;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class MovieActivity extends Activity implements IWSResponseListener{


    private WebServiceRequest wsRequest;
    private ArrayList movieList=null;
    private ListView listView;
    private MovieListArrayAdapter adapter;
    private TextView tvEmptyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        getMovieList();
        setViews();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * map data to views
     */
    private void setViews() {

        listView = (ListView)findViewById(R.id.lvMovies);
        movieList = new ArrayList<Movie>();
        adapter = new MovieListArrayAdapter(this,movieList);
        Log.d(TAG,"adapter not null!!"+adapter);
        View headerView = (View)getLayoutInflater().inflate(R.layout.list_header,null);
       // listView.addHeaderView(headerView);
        listView.setAdapter(adapter);
    }

    /**
     * Webservice call to get list of movies
     */
    private void getMovieList() {

        wsRequest = new WebServiceRequest();
        wsRequest.callService(this);
    }

    /**
     *
     * @param object webservice callback success response
     */
    @Override
    public void onWSSuccess(Object object) {

        movieList = (ArrayList)object;
        adapter.clear();
        adapter.addAll(movieList);
        adapter.notifyDataSetChanged();
    }

    /**
     *
     * @param object webservice callback failure response
     */
    @Override
    public void onWSFailure(Object object) {
    }
}
