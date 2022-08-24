package com.erenulas.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String WEIGHT = "WEIGHT";
    private static final String HEIGHT = "HEIGHT";
    public static final String EXTRA_MESSAGE = "com.erenulas.150114822HW1.MESSAGE";

    private double currentWeight;
    private double currentHeight;
    private EditText weightEditText;
    private EditText heightEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            currentWeight = 0.0;
            currentWeight = 0.0;
        } else {
            currentWeight = savedInstanceState.getDouble(WEIGHT);
            currentHeight = savedInstanceState.getDouble(HEIGHT);
        }

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        heightEditText = (EditText) findViewById(R.id.heightEditText);


        Button calculateButton = (Button) findViewById(R.id.calculateBMI);

    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, ResultView.class);

        String weight = weightEditText.getText().toString();
        if(!weight.isEmpty()) {
            currentWeight = Double.parseDouble(weight);
        }

        String height = heightEditText.getText().toString();
        if(!height.isEmpty()) {
            currentHeight = Double.parseDouble(height);
        }

        Double bmi = currentWeight/(currentHeight*currentHeight);
        String result = String.format("%.1f", bmi);
        intent.putExtra(EXTRA_MESSAGE, result);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putDouble(WEIGHT, currentWeight);
        outState.putDouble(HEIGHT, currentHeight);
    }

}
