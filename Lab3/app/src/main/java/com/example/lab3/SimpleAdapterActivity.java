package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleAdapterActivity extends AppCompatActivity {

    public ListView listView;
    String[] animalName = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    int[] animalImages = {R.drawable.cat, R.drawable.tiger, R.drawable.monkey,
            R.drawable.dog, R.drawable.cat, R.drawable.elephant};


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        listView = (ListView) findViewById(R.id.simpleListView);

        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();

        for (int i = 0; i < animalName.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", animalName[i]);
            map.put("image", animalImages[i]);
            list.add(map);

        }
        String[] from = {"name", "image"};
        int[] to = {R.id.textView, R.id.imageView};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list,
                R.layout.list_view_item, from, to);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), animalName[i], Toast.LENGTH_LONG).show();
            }
        });

    }
}
