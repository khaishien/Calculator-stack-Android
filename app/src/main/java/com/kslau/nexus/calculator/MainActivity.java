package com.kslau.nexus.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Stack;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final static private String TAG = "MainActivity";

    private TextView currentTV;
    private TextView bufferTV;

    private ScrollView topScrollView;
    private ScrollView bottomScrollView;

    private Button nineButton;
    private Button eightButton;
    private Button sevenButton;
    private Button sixButton;
    private Button fiveButton;
    private Button fourButton;
    private Button threeButton;
    private Button twoButton;
    private Button oneButton;
    private Button zeroButton;
    private Button dotButton;

    private Button plusButton;
    private Button minusButton;
    private Button timesButton;
    private Button divideButton;
    private Button equalButton;

    private Button clearButton;
    private Button removeButton;

    //data
    String currentText = "";
    String bufferText = "";
    boolean isPreviousDigit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindUI();


    }

    private void bindUI() {

        topScrollView = (ScrollView) findViewById(R.id.top_scroll_view);
        bottomScrollView = (ScrollView) findViewById(R.id.bottom_scroll_view);


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
        zeroButton = (Button) findViewById(R.id.zero_tv);
        zeroButton.setOnClickListener(this);
        dotButton = (Button) findViewById(R.id.dot_tv);
        dotButton.setOnClickListener(this);

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
        String lastString;
        char lastChar;
        switch (v.getId()) {
            case R.id.nine_tv:
                currentText = currentText.concat("9");
                isPreviousDigit = true;
                updateCurrentText();
                break;
            case R.id.eight_tv:
                currentText = currentText.concat("8");
                isPreviousDigit = true;
                updateCurrentText();
                break;
            case R.id.seven_tv:
                currentText = currentText.concat("7");
                isPreviousDigit = true;
                updateCurrentText();
                break;
            case R.id.six_tv:
                currentText = currentText.concat("6");
                isPreviousDigit = true;
                updateCurrentText();
                break;
            case R.id.five_tv:
                currentText = currentText.concat("5");
                isPreviousDigit = true;
                updateCurrentText();
                break;
            case R.id.four_tv:
                currentText = currentText.concat("4");
                isPreviousDigit = true;
                updateCurrentText();
                break;
            case R.id.three_tv:
                currentText = currentText.concat("3");
                isPreviousDigit = true;
                updateCurrentText();
                break;
            case R.id.two_tv:
                currentText = currentText.concat("2");
                isPreviousDigit = true;
                updateCurrentText();
                break;
            case R.id.one_tv:
                currentText = currentText.concat("1");
                isPreviousDigit = true;
                updateCurrentText();
                break;
            case R.id.zero_tv:
                if (currentText != "") {
                    currentText = currentText.concat("0");
                    isPreviousDigit = true;
                }
                updateCurrentText();
                break;
            case R.id.dot_tv:
                if (currentText == "")
                    currentText = currentText.concat("0");
                currentText = currentText.concat(".");
                updateCurrentText();
                break;

            //functions
            case R.id.plus_tv:
                if (currentText == "") {
                    currentText = bufferText;
                }

                if (isPreviousDigit) {
                    currentText = currentText.concat("+");
                    isPreviousDigit = false;
                    updateCurrentText();
                }
                break;
            case R.id.minus_tv:
                if (currentText == "") {
                    currentText = bufferText;
                }

                if (isPreviousDigit) {
                    currentText = currentText.concat("-");
                    isPreviousDigit = false;
                    updateCurrentText();
                }
                break;
            case R.id.times_tv:
                if (currentText == "") {
                    currentText = bufferText;
                }

                if (isPreviousDigit) {
                    currentText = currentText.concat("*");
                    isPreviousDigit = false;
                    updateCurrentText();
                }
                break;
            case R.id.divide_tv:
                if (currentText == "") {
                    currentText = bufferText;
                }

                if (isPreviousDigit) {
                    currentText = currentText.concat("/");
                    isPreviousDigit = false;
                    updateCurrentText();
                }
                break;
            case R.id.equal_tv:
                if (currentText != "") {
                    lastString = currentText.substring(currentText.length() - 1, currentText.length());
                    lastChar = lastString.charAt(0);
                    if (Character.isDigit(lastChar))
                        getTotal();

                } else {
                    currentText = bufferText;
                    updateCurrentText();

                    if (currentText == "")
                        currentTV.setText("0");
                }
                break;
            //remove button
            case R.id.clear_tv:
                currentText = "";
                bufferText = "";
                currentTV.setText("0");
                bufferTV.setText("");
                isPreviousDigit = false;
                break;
            case R.id.remove_tv:
                if (currentText != "") {
                    lastString = currentText.substring(currentText.length() - 1, currentText.length());
                    lastChar = lastString.charAt(0);
                    Log.d(TAG, "last:" + lastChar);
                    currentText = currentText.substring(0, currentText.length() - 1);

                    if (Character.isDigit(lastChar)) {
                        isPreviousDigit = true;
                    } else {
                        isPreviousDigit = false;
                    }
                    updateCurrentText();
                }
                break;
            default:
                Log.d(TAG, "unknown click view");
                break;
        }

        topScrollView.fullScroll(View.FOCUS_DOWN);
        bottomScrollView.fullScroll(View.FOCUS_DOWN);
    }


    private void updateCurrentText() {
        Log.d(TAG, currentText);
        currentTV.setText(currentText);
        bufferTV.setText(bufferText);
    }

    private void getTotal() {
        bufferTV.setText(currentText);

        DecimalFormat format = new DecimalFormat("###,###,###,###.##############");
        currentText = String.valueOf(format.format(infix(currentText)));
        currentTV.setText(currentText);
        bufferText = currentText;


    }

    public double infix(String expression) {

        expression = expression.replaceAll("[\t\n ]", "") + "=";
        String operator = "*/+-=";

        //split up the operators from the values
        StringTokenizer tokenizer = new StringTokenizer(expression, operator, true);
        Stack operatorStack = new Stack();
        Stack valueStack = new Stack();

        while (tokenizer.hasMoreTokens()) {
            //add the next token to the proper stack
            String token = tokenizer.nextToken();
            if (operator.indexOf(token) < 0)
                valueStack.push(token);
            else
                operatorStack.push(token);
            //perform any pending operations
            resolve(valueStack, operatorStack);
        }
        //return the top of the value stack
        String lastOne = (String) valueStack.pop();
        return Double.parseDouble(lastOne);


    }

    public int getPriority(String op) {
        if (op.equals("*") || op.equals("/"))
            return 1;
        else if (op.equals("+") || op.equals("-"))
            return 2;
        else if (op.equals("="))
            return 3;
        else
            return Integer.MIN_VALUE;
    }

    public void resolve(Stack values, Stack operators) {

        while (operators.size() >= 2) {
            String first = (String) operators.pop();
            String second = (String) operators.pop();
            if (getPriority(first) < getPriority(second)) {
                operators.push(second);
                operators.push(first);
                return;
            } else {
                String firstValue = (String) values.pop();
                String secondValue = (String) values.pop();
                values.push(compute(secondValue, second, firstValue));
                operators.push(first);
            }
        }
    }

    public String compute(String value1, String operator, String value2) {
        //Log.d(TAG, "compute " + value1 + operator + value2);
        double d1 = Double.parseDouble(value1);
        double d2 = Double.parseDouble(value2);

        if (operator.equals("*"))
            return "" + (d1 * d2);
        else if (operator.equals("/"))
            return "" + (d1 / d2);
        else if (operator.equals("+"))
            return "" + (d1 + d2);
        else if (operator.equals("-"))
            return "" + (d1 - d2);
        else
            return null;
    }



}
