package com.codepath.flickster.network;

public interface IWSResponseListener {

    public void onWSSuccess(Object object);
    public void onWSFailure(Object object);
}
