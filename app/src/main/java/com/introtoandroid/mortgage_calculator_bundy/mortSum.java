package com.introtoandroid.mortgage_calculator_bundy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.RadioButton;

public class mortSum extends AppCompatActivity {

    TextView morgX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mort_sum);

        morgX2 = (TextView) findViewById(R.id.textView);
        //morgX2.setText();

    }

    public void sendMessage(View view) {

        Intent intent = new Intent(mortSum.this, MainActivity.class);
        startActivity(intent);

    }




}
