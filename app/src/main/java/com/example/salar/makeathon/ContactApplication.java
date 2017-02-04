package com.example.salar.makeathon;

import android.app.Application;

import com.parse.Parse;

public class ContactApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("sample")
                .clientKey(null)
                .server("http://makathon.hamravesh.ir/sample/parse/")
                .build()
        );
    }
}
