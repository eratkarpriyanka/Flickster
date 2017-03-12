package com.codepath.flickster.network;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;

import static com.codepath.flickster.StringConstants.REQUEST_URL;

public class WebServiceRequest {


    WSResponseHandler responseHandler;

    public WebServiceRequest(){

    }

    /**
     *
     * @param context to give call back
     */
    public void callService(Context context){

        responseHandler = new WSResponseHandler(context);
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(REQUEST_URL, responseHandler);
    }
}
