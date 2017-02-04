package com.example.salar.makeathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SplashScreen extends AppCompatActivity {
    Button signUp;
    Button signIn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        signIn=(Button)findViewById(R.id.activity_splash_sign_in);
        signUp=(Button)findViewById(R.id.activity_splash_sign_up);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this,ContactActivity.class);
                startActivity(intent);
            }
        });
    }

}
