package com.example.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {

    private Activity context;
    private List<Person> personList;

    public PersonAdapter(Activity context, List<Person> personList) {
        super(context, R.layout.item_person, personList);
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_person, null, true);

        ImageView imgAvatar = rowView.findViewById(R.id.imgAvatar);
        TextView txtName = rowView.findViewById(R.id.txtName);
        TextView txtCity = rowView.findViewById(R.id.txtCity);

        Person person = personList.get(position);

        txtName.setText(person.getName());
        txtCity.setText(person.getCity());
        imgAvatar.setImageResource(R.drawable.ic_person);

        return rowView;
    }
}