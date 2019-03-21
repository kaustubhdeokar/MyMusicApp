package com.example.android.myapplication;

public class CustomMusicEntry {

    String songname;
    String singer;

    CustomMusicEntry(String songname,String singer){
        this.songname=songname;
        this.singer=singer;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
