package com.example.android.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void go(View v){
    e=(EditText)findViewById(R.id.edittext1);
    String msg=e.getText().toString();
    Intent i=new Intent(this,Main2Activity.class);
    i.putExtra("string-value",msg);
    startActivity(i);


    }

}
