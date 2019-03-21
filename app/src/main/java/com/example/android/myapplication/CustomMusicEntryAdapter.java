package com.example.android.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomMusicEntryAdapter extends ArrayAdapter<CustomMusicEntry> {


    CustomMusicEntryAdapter(Context context, ArrayList<CustomMusicEntry> arrayList){
        super(context,0,arrayList);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View itemlist=convertView;
        if(itemlist==null){
            itemlist= LayoutInflater.from(getContext()).inflate(R.layout.list_song,parent,false);
        }
        CustomMusicEntry obj=getItem(position);
        TextView t=(TextView)itemlist.findViewById(R.id.song);
        t.setText(obj.getSongname());

        TextView t1=(TextView)itemlist.findViewById(R.id.singer);
        t1.setText(obj.getSinger());

        return itemlist;
    }


}
