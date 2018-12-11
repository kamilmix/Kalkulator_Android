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

  
    TextView resultView;
    String result;
    ArrayList<String> list = new ArrayList<>();
    DbHelper db = new DbHelper(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }



    private void init() {
        resultView = (TextView) findViewById(R.id.wynik);
        result="";

    }

    protected void onClickButton(View v){

        Button clicked = (Button) v;
        String operator = clicked.getText().toString();

            if (operator.equals("+")) {
                result += "+" ;
            } else if (operator.equals("-")) {
                result += "-" ;
            } else if (operator.equals("*")) {
                result += "*" ;
            } else if (operator.equals("/")) {
                result += "/" ;
            } else if(operator.equals("0")) {
                result += "0" ;
            } else if(operator.equals("1")) {
                result += "1" ;
            } else if(operator.equals("2")) {
                result += "2" ;
            } else if(operator.equals("3")) {
                result += "3" ;
            } else if(operator.equals("4")) {
                result += "4" ;
            } else if(operator.equals("5")) {
                result += "5" ;
            } else if(operator.equals("6")) {
                result += "6" ;
            } else if(operator.equals("7")) {
                result += "7" ;
            } else if(operator.equals("8")) {
                result += "8" ;
            } else if(operator.equals("9")) {
                result += "9";
            }else if(operator.equals("C")) {
                result = "";
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
               resultView.setText(Double.toString(calculated));
               list.add(result + " = " + calculated);


                db.addValue(result + " = " + calculated);



               result = "";
           }
            catch(Exception e){

                Toasty.error(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT, true).show();


            }



        }
    }

    protected void onClickHistory(View v){
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putStringArrayListExtra(EXTRA_MESSAGE, list);




        startActivity(intent);
    }
    protected void onClickBack(View v){
        result = deleteLastChar(result);
        resultView.setText(result);

    }

    private String deleteLastChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }



}
