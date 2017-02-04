package com.example.salar.makeathon;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {

    ArrayList<Contact> myContacts;

    public ContactAdapter(Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        myContacts = (ArrayList<Contact>) objects;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Contact contact = myContacts.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_card_layout, parent, false);

        }

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), position+ contact.getName(),Toast.LENGTH_LONG).show();;
            }
        });

        ImageView contactImage = (ImageView)convertView.findViewById(R.id.contact_card_image);
        TextView contactName = (TextView)convertView.findViewById(R.id.contact_card_name);
        TextView contactPhone = (TextView)convertView.findViewById(R.id.contact_card_phone);


        contactImage.setImageResource(contact.getImage());
        contactName.setText(contact.getName());
        contactPhone.setText(contact.getPhone());

        return convertView;

    }
}
