package com.example.quintin.myfianancer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quintin.myfianancer.Objects.Calculator;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class MainActivity extends AppCompatActivity {
    private SlidrInterface slidr;
    private Button one, two, three, four, five, six, seven, eight, nine, zero;
    private Button plus, subtract, divide, multiply, square;
    private Button ac, percent, dot, delete, equal;
    private String currentDisplayedInput = "";
    private String inputToBeParsed = "";
    private TextView outputResult;
    private Calculator mCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);

        setupButtons();
        setButtonRegister();
        slidr = Slidr.attach(this);
    }

    private void setButtonRegister() {
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "0";
                inputToBeParsed += "0";
                outputResult.setText(currentDisplayedInput);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "1";
                inputToBeParsed += "1";
                outputResult.setText(currentDisplayedInput);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "2";
                inputToBeParsed += "2";
                outputResult.setText(currentDisplayedInput);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "3";
                inputToBeParsed += "3";
                outputResult.setText(currentDisplayedInput);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "4";
                inputToBeParsed += "4";
                outputResult.setText(currentDisplayedInput);
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "5";
                inputToBeParsed += "5";
                outputResult.setText(currentDisplayedInput);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "6";
                inputToBeParsed += "6";
                outputResult.setText(currentDisplayedInput);
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "7";
                inputToBeParsed += "7";
                outputResult.setText(currentDisplayedInput);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "8";
                inputToBeParsed += "8";
                outputResult.setText(currentDisplayedInput);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "9";
                inputToBeParsed += "9";
                outputResult.setText(currentDisplayedInput);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "+";
                inputToBeParsed += "+";
                outputResult.setText(currentDisplayedInput);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += ".";
                inputToBeParsed += ".";
                outputResult.setText(currentDisplayedInput);
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "-";
                inputToBeParsed += "-";
                outputResult.setText(currentDisplayedInput);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "/";
                inputToBeParsed += "/";
                outputResult.setText(currentDisplayedInput);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "*";
                inputToBeParsed += "*";
                outputResult.setText(currentDisplayedInput);
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput += "%";
                inputToBeParsed += "5";
                outputResult.setText(currentDisplayedInput);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentDisplayedInput.length() != 0) {
                    currentDisplayedInput = currentDisplayedInput.substring(0, currentDisplayedInput.length() - 1);
                    inputToBeParsed = inputToBeParsed.substring(0, inputToBeParsed.length() - 1);
                    outputResult.setText(currentDisplayedInput);
                } else {
                    currentDisplayedInput = "";
                    inputToBeParsed = "";
                    outputResult.setText(currentDisplayedInput);
                }
            }
        });
        delete.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                currentDisplayedInput = "";
                inputToBeParsed = "";
                outputResult.setText(currentDisplayedInput);
                return true;
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FinanceActivity.class);
                startActivity(intent);
                finish();
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String enteredInput = outputResult.getText().toString();
                // call a function that will return the result of the calculate.
                String resultObject = mCalculator.getResult(currentDisplayedInput, inputToBeParsed);
                outputResult.setText(removeTrailingZero(resultObject));
                String temp = outputResult.getText().toString().replace("\n", "");
//                Toast.makeText(MainActivity.this, outputResult.getText().toString(), Toast.LENGTH_SHORT).show();
                inputToBeParsed = temp;
                currentDisplayedInput = temp;
                outputResult.setText(currentDisplayedInput);
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultObject = mCalculator.getResult(currentDisplayedInput, inputToBeParsed);
                outputResult.setText(removeTrailingZero(resultObject));
                String temp = outputResult.getText().toString().replace("\n", "");
                outputResult.setText(currentDisplayedInput);
            }
        });
        square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDisplayedInput = "";
                inputToBeParsed = "";
                outputResult.setText(currentDisplayedInput);
            }
        });
    }

    private void setupButtons() {
        outputResult = (TextView)findViewById(R.id.display);
        outputResult.setText("");
        mCalculator = new Calculator();
        one = (Button)findViewById(R.id.one);
        two = (Button)findViewById(R.id.two);
        three = (Button)findViewById(R.id.three);
        four = (Button)findViewById(R.id.four);
        five = (Button)findViewById(R.id.five);
        six = (Button)findViewById(R.id.six);
        seven = (Button)findViewById(R.id.seven);
        eight = (Button)findViewById(R.id.eight);
        nine = (Button)findViewById(R.id.nine);
        zero = (Button)findViewById(R.id.zero);
        plus = (Button)findViewById(R.id.plus);
        subtract = (Button)findViewById(R.id.minus);
        divide = (Button)findViewById(R.id.divide);
        multiply = (Button)findViewById(R.id.multiply);
        square = (Button)findViewById(R.id.square);
        ac = (Button)findViewById(R.id.ac);
        percent = (Button)findViewById(R.id.percent);
        dot = (Button)findViewById(R.id.dot);
        delete = (Button)findViewById(R.id.delete);
        equal = (Button)findViewById(R.id.equal);

    }


    private String removeTrailingZero(String formattingInput){
        if(!formattingInput.contains(".")){
            return formattingInput;
        }
        int dotPosition = formattingInput.indexOf(".");
        String newValue = formattingInput.substring(dotPosition, formattingInput.length());
        if(newValue.equals(".0")){
            return formattingInput.substring(0, dotPosition);
        }
        return formattingInput;
    }
//    public void unlock() {
//        slidr.unlock();
//    }


}
