package com.example.salar.makeathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignIn extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        final EditText email = (EditText)findViewById(R.id.signIn_email);
        final EditText password = (EditText) findViewById(R.id.signIn_password);
        Button button = (Button) findViewById(R.id.signIn_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(email.getText().toString(),
                        password.getText().toString(), new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if(e == null){
                                    if(user !=null){
                                        startActivity(new Intent(SignIn.this,ContactActivity.class));
                                    }
                                }else{
                                    Log.d("ERROR",e.getMessage());
                                }
                            }
                        });
            }

        });
    }
}
