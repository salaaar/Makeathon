package com.example.salar.makeathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final EditText email = (EditText)findViewById(R.id.signUp_email);
        final EditText password = (EditText) findViewById(R.id.signUp_password);
        Button button = (Button) findViewById(R.id.signUp_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user = new ParseUser();
                user.setUsername(email.getText().toString());
                user.setPassword(password.getText().toString());


                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null){
                            Intent intent = new Intent(SignUp.this,SignIn.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(SignUp.this, e.getMessage(),Toast.LENGTH_LONG ).show();
                        }
                    }
                });

            }

        });

    }
}
