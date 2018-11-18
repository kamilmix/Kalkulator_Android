package com.mucha.kamil.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    protected void onClickButton(View v){

        Button clicked = (Button) v;
        String operator = clicked.getText().toString();

        TextView wynik  = (TextView) findViewById(R.id.wynik);
        EditText A  = (EditText) findViewById(R.id.liczbaA);
        EditText B  = (EditText) findViewById(R.id.liczbaB);

        if(A.getText().toString().matches("[0-9]*")) {


           // int number1 = Integer.parseInt(A.getText().toString());
            //int number2 = Integer.parseInt(B.getText().toString());
            double number1 = Double.parseDouble(A.getText().toString());
            double number2 = Double.parseDouble(B.getText().toString());

            double sum = 0;


            if (operator.equals("+")) {
                sum = number1 + number2;
            } else if (operator.equals("-")) {
                sum = number1 - number2;
            } else if (operator.equals("*")) {
                sum = number1 * number2;
            } else if (operator.equals("/")) {
                if (number2 == 0) {

                    CharSequence text = "Nie dziel przez 0!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                    toast.show();
                } else {
                    sum = number1 / number2;
                }
            }


            wynik.setText(String.valueOf(sum));
            //wynik.setText(A.getText().toString());
        }

    }




}
