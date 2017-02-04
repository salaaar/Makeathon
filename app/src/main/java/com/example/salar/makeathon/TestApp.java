package com.example.salar.makeathon;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pnikosis.materialishprogress.ProgressWheel;

public class TestApp extends AppCompatActivity {
    Button login;
    EditText email,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        login = (Button) findViewById(R.id.test_activity_button);
        email = (EditText) findViewById(R.id.test_activity_email);
        password = (EditText) findViewById(R.id.test_activity_password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(TestApp.this);
                dialog.setTitle("Alert");
                dialog.setMessage("Are you sure that you want to login?");
                dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(email.getText().toString().equals("makeathon@gmail.com")
                                && password.getText().toString().equals("123456")){

                            Intent intent = new Intent(TestApp.this,SplashScreen.class);
                            startActivity(intent);
                            Toast.makeText(TestApp.this,"You logged is successfully",Toast.LENGTH_LONG).show();;
                        }
                    }
                });
                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(TestApp.this,"No selected",Toast.LENGTH_LONG).show();
                    }
                });

                dialog.show();
                ProgressDialog dialog1 = new ProgressDialog(TestApp.this);
                dialog1.dismiss();
            }
        });
    }
}
