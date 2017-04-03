package com.kslau.nexus.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final static private String TAG = "MainActivity";

    private TextView currentTV;
    private TextView bufferTV;

    private Button nineButton;
    private Button eightButton;
    private Button sevenButton;
    private Button sixButton;
    private Button fiveButton;
    private Button fourButton;
    private Button threeButton;
    private Button twoButton;
    private Button oneButton;

    private Button plusButton;
    private Button minusButton;
    private Button timesButton;
    private Button divideButton;
    private Button equalButton;

    private Button clearButton;
    private Button removeButton;

    //data
    Stack operands = new Stack();
    String currentText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindUI();


    }

    private void bindUI() {
        currentTV = (TextView) findViewById(R.id.current_tv);
        bufferTV = (TextView) findViewById(R.id.buffer_tv);

        nineButton = (Button) findViewById(R.id.nine_tv);
        nineButton.setOnClickListener(this);
        eightButton = (Button) findViewById(R.id.eight_tv);
        eightButton.setOnClickListener(this);
        sevenButton = (Button) findViewById(R.id.seven_tv);
        sevenButton.setOnClickListener(this);
        sixButton = (Button) findViewById(R.id.six_tv);
        sixButton.setOnClickListener(this);
        fiveButton = (Button) findViewById(R.id.five_tv);
        fiveButton.setOnClickListener(this);
        fourButton = (Button) findViewById(R.id.four_tv);
        fourButton.setOnClickListener(this);
        threeButton = (Button) findViewById(R.id.three_tv);
        threeButton.setOnClickListener(this);
        twoButton = (Button) findViewById(R.id.two_tv);
        twoButton.setOnClickListener(this);
        oneButton = (Button) findViewById(R.id.one_tv);
        oneButton.setOnClickListener(this);

        plusButton = (Button) findViewById(R.id.plus_tv);
        plusButton.setOnClickListener(this);
        minusButton = (Button) findViewById(R.id.minus_tv);
        minusButton.setOnClickListener(this);
        timesButton = (Button) findViewById(R.id.times_tv);
        timesButton.setOnClickListener(this);
        divideButton = (Button) findViewById(R.id.divide_tv);
        divideButton.setOnClickListener(this);
        equalButton = (Button) findViewById(R.id.equal_tv);
        equalButton.setOnClickListener(this);

        clearButton = (Button) findViewById(R.id.clear_tv);
        clearButton.setOnClickListener(this);
        removeButton = (Button) findViewById(R.id.remove_tv);
        removeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nine_tv:
                currentText = currentText.concat("9");
                updateCurrentText();
                break;
            case R.id.eight_tv:
                currentText = currentText.concat("8");
                updateCurrentText();
                break;
            case R.id.seven_tv:
                currentText = currentText.concat("7");
                updateCurrentText();
                break;
            case R.id.six_tv:
                currentText = currentText.concat("6");
                updateCurrentText();
                break;
            case R.id.five_tv:
                currentText = currentText.concat("5");
                updateCurrentText();
                break;
            case R.id.four_tv:
                currentText = currentText.concat("4");
                updateCurrentText();
                break;
            case R.id.three_tv:
                currentText = currentText.concat("3");
                updateCurrentText();
                break;
            case R.id.two_tv:
                currentText = currentText.concat("2");
                updateCurrentText();
                break;
            case R.id.one_tv:
                currentText = currentText.concat("1");
                updateCurrentText();
                break;

            //functions
            case R.id.plus_tv:
                bufferCurrentText("+");
                break;
            case R.id.minus_tv:
                bufferCurrentText("-");
                break;
            case R.id.times_tv:
                bufferCurrentText("*");
                break;
            case R.id.divide_tv:
                bufferCurrentText("/");
                break;
            case R.id.equal_tv:
                computeAll();
                break;
            //remove button
            case R.id.clear_tv:
                currentText = "";
                updateCurrentText();
                break;
            case R.id.remove_tv:
                currentText = currentText.substring(0, currentText.length() - 1);
                updateCurrentText();
                break;
            default:
                Log.d(TAG, "unknown click view");
                break;
        }
    }


    private void updateCurrentText() {
        currentTV.setText(currentText);
    }

    private void bufferCurrentText(String operator) {

        operands.push(currentText);
        operands.push(operator);
        currentText = "";
        //currentTV.setText("0");

    }

    private void computeAll() {
        operands.push(currentText);
        currentText = "";

        double total = 0;

        while (operands.size() > 1) {
            double valueOne = Double.parseDouble(operands.pop().toString());
            String operator = operands.pop().toString();
            double valueTwo = Double.parseDouble(operands.pop().toString());

            Log.d(TAG, valueOne + "," + operator + "," + valueTwo);

            total = compute(valueOne, operator, valueTwo);
        }

        currentTV.setText(String.valueOf(total));

    }

    private double compute(double valueOne, String operator, double valueTwo) {

        switch (operator) {
            case "+":
                return valueOne + valueTwo;
            case "-":
                return valueOne - valueTwo;
            case "*":
                return valueOne * valueTwo;
            case "/":
                return valueOne / valueTwo;
            default:
                return 0;

        }

    }
}
