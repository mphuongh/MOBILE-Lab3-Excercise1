package com.example.adapter;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listViewPersons;
    ArrayList<Person> personArrayList;
    PersonAdapter personAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPersons = findViewById(R.id.listViewPersons);

        personArrayList = new ArrayList<>();
        personArrayList.add(new Person("Ngân", "Vũng Tàu"));
        personArrayList.add(new Person("Nhi", "Bến Tre"));
        personArrayList.add(new Person("Phương", "Hồ Chí Minh"));

        personAdapter = new PersonAdapter(this, personArrayList);
        listViewPersons.setAdapter(personAdapter);
    }
}