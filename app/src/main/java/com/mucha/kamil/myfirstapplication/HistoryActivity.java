package com.mucha.kamil.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listView = findViewById(R.id.listView);

        Intent intent = getIntent();
        ArrayList<String> list = intent.getStringArrayListExtra(MainActivity.EXTRA_MESSAGE);

        adapter = new ArrayAdapter<String>(this, R.layout.row, list);

        listView.setAdapter(adapter);
    }

    protected void onClickHistory(View v){
       // Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);



    }

}
