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

    private final Activity context;
    private final List<Person> personList;

    public PersonAdapter(Activity context, List<Person> personList) {
        super(context, R.layout.item_person, personList);
        this.context = context;
        this.personList = personList;
    }

    static class ViewHolder {
        ImageView imgAvatar;
        TextView txtName;
        TextView txtCity;
        TextView txtFrom;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_person, parent, false);

            holder = new ViewHolder();
            holder.imgAvatar = rowView.findViewById(R.id.imgAvatar);
            holder.txtName = rowView.findViewById(R.id.txtName);
            holder.txtCity = rowView.findViewById(R.id.txtCity);
            holder.txtFrom = rowView.findViewById(R.id.txtFrom);

            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        Person person = personList.get(position);

        holder.txtName.setText(person.getName());
        holder.txtCity.setText(person.getCity());
        holder.txtFrom.setText("from");
        holder.imgAvatar.setImageResource(R.drawable.ic_person);

        return rowView;
    }
}