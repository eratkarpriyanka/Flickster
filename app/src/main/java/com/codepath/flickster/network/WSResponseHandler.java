package com.codepath.flickster.network;

import android.content.Context;
import android.util.Log;

import com.codepath.flickster.StringConstants;
import com.codepath.flickster.models.Movie;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class WSResponseHandler extends JsonHttpResponseHandler {

    private static final String TAG = WSResponseHandler.class.getSimpleName();

    private Context context;
    IWSResponseListener iWsResponseListener;


    public WSResponseHandler(Context context){

        this.context = context;
        iWsResponseListener = (IWSResponseListener) context;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {

        JSONArray jsonMovieResults=null;

        try {
            jsonMovieResults = response.getJSONArray(StringConstants.KEY_RESULTS);
            ArrayList<Movie> movieList = null;
            if(jsonMovieResults != null) {
               movieList = Movie.fromJsonArray(jsonMovieResults);
            }
            Log.d(TAG,"Response : success "+response);
            iWsResponseListener.onWSSuccess(movieList);

        } catch (JSONException e) {

            Log.d(TAG,"Response : failure parsing json "+e);
           //  e.printStackTrace();
            /* failure parsing json */
            iWsResponseListener.onWSFailure(null);
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
        super.onFailure(statusCode, headers, responseString, throwable);

        Log.d(TAG,"Response : failure "+responseString);
        iWsResponseListener.onWSFailure(null);
    }
}
