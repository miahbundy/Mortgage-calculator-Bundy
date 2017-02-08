package com.introtoandroid.mortgage_calculator_bundy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    CheckBox mortSum;
    CheckBox paySum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mortSum = (CheckBox) findViewById(R.id.mortSum);
        paySum = (CheckBox) findViewById(R.id.paySum);
    }

    public void sendMessage(View view) {
        if (mortSum.isChecked()) {
            Intent intent = new Intent(MainActivity.this, mortSum.class);
            startActivity(intent);
        }

        else if (paySum.isChecked()) {
            Intent intent = new Intent(MainActivity.this, pay_sum.class);
            startActivity(intent);
        }
    }
}

