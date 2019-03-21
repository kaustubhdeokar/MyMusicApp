package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {


    final Map<String,String> m=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ListView listview = (ListView) findViewById(R.id.listview1);
        final ArrayList<CustomMusicEntry> arrayList = new ArrayList<>();
        arrayList.add(new CustomMusicEntry("small town girl","shankar"));
        arrayList.add(new CustomMusicEntry("beep sms","zedge"));
        arrayList.add(new CustomMusicEntry("potatoes fast","ehsaan"));
        arrayList.add(new CustomMusicEntry("message tone","loy"));

        CustomMusicEntryAdapter adapter = new CustomMusicEntryAdapter(this, arrayList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(Main2Activity.this, "clicked" + " " + arrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        }
        );

    }

}
