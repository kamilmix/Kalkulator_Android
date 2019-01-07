package com.mucha.kamil.myfirstapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.mucha.kamil.myfristapplication.MESSAGE";

  
    private TextView resultView;
    private String result;

    private ArrayList<String> historyList = new ArrayList<>();
    private DbHelper database = new DbHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        database.close();
    }

    private void init() {
        resultView = findViewById(R.id.wynik);

        result = "";

    }

    protected void onClickButton(View v){

        Button clicked = (Button) v;

        String operator = clicked.getText().toString();

            if(operator.equals("C")) {
                result = "";
            }
            else{
                result += operator;
            }

            resultView.setText(result);
    }

    protected void onClickPoint(View v){
        if(result != "") {
            result += ".";
            resultView.setText(result);
        }
    }


    protected void onClickEqual(View v){
        if(result != "") {

           try{
            Expression e = new ExpressionBuilder(result).build();
            double calculated = e.evaluate();
               resultView.setText(formatDoubleToString(calculated));
               historyList.add(result + " = " + calculated);

               database.addValue(result + " = " + calculated);

               result = "";
           }
            catch(Exception e){
                Toasty.error(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT, true).show();
            }
        }
    }

    protected void onClickHistory(View v){
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putStringArrayListExtra(EXTRA_MESSAGE, historyList);

        startActivity(intent);
    }
    protected void onClickBack(View v){
        result = deleteLastChar(result);
        resultView.setText(result);
    }

    private String deleteLastChar(String string) {
        if (string != null) {
            if(string.length() > 0){
                string = string.substring(0, string.length() - 1);
            }
        }
        return string;
    }


    private String formatDoubleToString(double d){
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
}
