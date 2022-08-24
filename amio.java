package com.erenulas.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class ResultView extends AppCompatActivity {

    private TextView resultValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.erenulas.bmicalculator.R.layout.activity_result_view);

        resultValueTextView = (TextView) findViewById(com.erenulas.bmicalculator.R.id.resultValueTextView);

        Intent intent = getIntent();
        String result = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        resultValueTextView.setText(result);

    }
}
