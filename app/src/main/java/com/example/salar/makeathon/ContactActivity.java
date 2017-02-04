package com.example.salar.makeathon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.util.ArrayList;


public class ContactActivity extends AppCompatActivity {
    Button add;
    EditText name,phone;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView listView =(ListView)findViewById(R.id.contact_activity_listView);
        final ArrayList<Contact> contacts = new ArrayList<>();

        add =  (Button)findViewById(R.id.activity_contact_add);
        name = (EditText) findViewById(R.id.activity_contact_name);
        phone = (EditText)findViewById(R.id.activity_contact_phone);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts.add(
                        new Contact(R.drawable.person_5,
                                name.getText().toString(),
                                phone.getText().toString()));

                ParseObject myContact= new ParseObject("Contact");
                myContact.put("name",name.getText().toString());
                myContact.put("phone",phone.getText().toString());

                myContact.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null)
                            Toast.makeText(ContactActivity.this,"Saved successfully",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


        contacts.add(new Contact(R.drawable.person_1,"Ali Ahmadi","09136588"));
        contacts.add(new Contact(R.drawable.person_2,"Ali Ahmadi","09136588"));
        contacts.add(new Contact(R.drawable.person_7,"Ali Ahmadi","09136588"));
        contacts.add(new Contact(R.drawable.person_4,"Ali Ahmadi","09136588"));
        contacts.add(new Contact(R.drawable.person_6,"Ali Ahmadi","09136588"));


        ContactAdapter adapter = new ContactAdapter(ContactActivity.this,R.layout.contact_card_layout,contacts);
        listView.setAdapter(adapter);
    }
}
