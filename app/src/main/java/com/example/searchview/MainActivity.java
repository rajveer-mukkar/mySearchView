package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SearchView search_view;
    ListView list_view;

    ArrayList<String> list;
    ArrayAdapter<String>adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<String>();
        search_view = findViewById(R.id.search_view);
        list_view = findViewById(R.id.mylist);


        list.add("Clothing");
        list.add("Footwear");
        list.add("Books");
        list.add("Makeup");
        list.add("Food");


        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        list_view.setAdapter(adapter);


        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
