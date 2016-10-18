package com.example.yaoli.mock;

import android.app.Application;

import com.byoutline.mockserver.AndroidStubServer;
import com.byoutline.mockserver.NetworkType;

//import com.byoutline.androidstubserver.AndroidStubServer;

/**
 * Created by yao.li on 2016/3/17.
 */
public class MockApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidStubServer.start(this, NetworkType.UMTS);
    }
}
