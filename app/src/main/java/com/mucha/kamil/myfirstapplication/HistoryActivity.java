package com.mucha.kamil.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.mucha.kamil.myfristapplication.MESSAGE.REPLY";

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> list;
    DbHelper db = new DbHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        readFromDatabase();
        listView = findViewById(R.id.listView);

        Intent intent = getIntent();

       // list = intent.getStringArrayListExtra(MainActivity.EXTRA_MESSAGE);

        adapter = new ArrayAdapter<>(this, R.layout.row, list);

        listView.setAdapter(adapter);
    }

    private void readFromDatabase() {
        list = db.getAllToArray();

    }

    protected void onClickBack(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putStringArrayListExtra(EXTRA_MESSAGE, list);
        //startActivity(intent);
        setResult(RESULT_OK,intent);
        finish();


    }

}
