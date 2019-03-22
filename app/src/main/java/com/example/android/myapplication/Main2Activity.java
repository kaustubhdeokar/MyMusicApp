package com.example.android.myapplication;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


    Button pause,play,stop;
    String thesong;
    MediaPlayer mediaPlayer;
    int pausepos;
    int pos;
    final Map<String,String> m=new HashMap<>();
    final int[] resID = {R.raw.alumadoluma,R.raw.towngirl,R.raw.potatoesfast, R.raw.jogimahi,R.raw.khudajaane,R.raw.aslihiphop,R.raw.azadi,R.raw.kaambhari};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pause=(Button)findViewById(R.id.pause);
        play=(Button)findViewById(R.id.play);
        stop=(Button)findViewById(R.id.stop);

        ListView listview = (ListView) findViewById(R.id.listview1);
        final ArrayList<CustomMusicEntry> arrayList = new ArrayList<>();

        arrayList.add(new CustomMusicEntry("Aluma Doluma","Anirudh Ravichander"));
        arrayList.add(new CustomMusicEntry("Small Town Girl","Shankar"));
        arrayList.add(new CustomMusicEntry("Potatoes Fast","Ehsaan"));
        arrayList.add(new CustomMusicEntry("Jogi Mahi","Mohit chauhan"));
        arrayList.add(new CustomMusicEntry("Khuda Jaane","Atif aslam"));
        arrayList.add(new CustomMusicEntry("Asli Hip Hop","Ranveer Singh"));
        arrayList.add(new CustomMusicEntry("Azadi","Divine"));
        arrayList.add(new CustomMusicEntry("Kaam Bhari","Kaam Bhari"));


        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);


        CustomMusicEntryAdapter adapter = new CustomMusicEntryAdapter(this, arrayList);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(Main2Activity.this, "clicked" + " " + arrayList.get(position).songname, Toast.LENGTH_SHORT).show();
            pos=position;
            somefun(Main2Activity.this,arrayList,position);
            }
        });




    }

    public void somefun(Main2Activity v, ArrayList<CustomMusicEntry>a, int position) {


                    if(mediaPlayer==null){
                        String rep=a.get(pos).songname;
                        mediaPlayer=MediaPlayer.create(getApplicationContext(),  resID[pos]);
                    }
                    if(!mediaPlayer.isPlaying()){
                        mediaPlayer.seekTo(pausepos);
                        mediaPlayer.start();
                    }

                    if(mediaPlayer!=null) {
                        mediaPlayer.pause();
                        pausepos=mediaPlayer.getCurrentPosition();
                    }

                    if(mediaPlayer!=null) {
                        mediaPlayer.stop();
                        mediaPlayer=null;
                    }

            }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                if(mediaPlayer==null){

                    mediaPlayer=MediaPlayer.create(getApplicationContext(), resID[pos]);

                }
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(pausepos);
                    mediaPlayer.start();
                }

                break;
            case R.id.pause:
                if(mediaPlayer!=null) {
                    mediaPlayer.pause();
                    pausepos=mediaPlayer.getCurrentPosition();
                }
                break;
            case R.id.stop:
                if(mediaPlayer!=null) {
                    mediaPlayer.stop();
                    mediaPlayer=null;
                }
                break;

        }
    }
}
