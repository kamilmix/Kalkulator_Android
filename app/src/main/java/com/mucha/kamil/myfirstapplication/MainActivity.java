package com.mucha.kamil.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.math3.analysis.function.Exp;
import org.apache.commons.math3.complex.Complex;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.mucha.kamil.myfristapplication.MESSAGE";
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button plus;
    TextView wynik;


    String result;
    ArrayList<String> list = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    private void init() {
      /*  button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9); */
        wynik = (TextView) findViewById(R.id.wynik);
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





            //int ab =
            wynik.setText(result);
       // DoubleEvaluator engine = new DoubleEvaluator(true);

    }

    protected void onClickEqual(View v){

        Expression e = new ExpressionBuilder(result).build();
        double eWynik= e.evaluate();

        wynik.setText(Double.toString(eWynik));
        list.add(result + " = " + eWynik);
        result="";
    }

    protected void onClickHistory(View v){
        Intent intent = new Intent(this, HistoryActivity.class);
        intent.putStringArrayListExtra(EXTRA_MESSAGE, list);
        startActivity(intent);


    }




}
