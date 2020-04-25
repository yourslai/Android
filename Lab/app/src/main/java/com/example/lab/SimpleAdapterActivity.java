package com.example.lab;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterActivity extends Activity {
    public ListView listView;
    String[] animalName = {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    int[] animalImages = {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,
            R.drawable.dog,R.drawable.cat,R.drawable.elephant};


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        listView = (ListView) findViewById(R.id.simpleListView);

        ArrayList<HashMap<String,Object>> arrayList = new ArrayList<>();

        for (int i=0;i<animalName.length;i++){
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("name",animalName[i]);
            hashMap.put("image",animalImages[i]);
            arrayList.add(hashMap);

        }
        String[] from={"name","image"};
        int[] to={R.id.textView,R.id.imageView};

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,arrayList,R.layout.activity_simple_adapter,from,to);
        listView.setAdapter(simpleAdapter);
    }
}
