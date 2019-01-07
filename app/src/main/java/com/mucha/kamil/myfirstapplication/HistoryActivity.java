package com.mucha.kamil.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.mucha.kamil.myfristapplication.MESSAGE.REPLY";

    private ArrayList<String> historyList;
    private DbHelper database = new DbHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        readFromDatabase();
        init();
    }

    @Override
    protected void onDestroy() {
        database.close();
        super.onDestroy();
    }

    private void init() {
        ListView listViewHistory = findViewById(R.id.listView);
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(buttonBackOnClickListener);

        ArrayAdapter<String> equationAdapter = new ArrayAdapter<>(this, R.layout.row, historyList);

        listViewHistory.setAdapter(equationAdapter);
    }

    private void readFromDatabase() {
        historyList = database.getAllToArray();
    }

    private View.OnClickListener buttonBackOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            buttonBackClicked();
        }
    };

    private void buttonBackClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putStringArrayListExtra(EXTRA_MESSAGE, historyList);
        //startActivity(intent);
        setResult(RESULT_OK,intent);
        finish();
    }

}
