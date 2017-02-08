package com.introtoandroid.mortgage_calculator_bundy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class pay_sum extends AppCompatActivity {

    TextView pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_sum);

        pay = (TextView) findViewById(R.id.textView2);
    }

    public void sendMessage(View view) {

        Intent intent = new Intent(pay_sum.this, MainActivity.class);
        startActivity(intent);

    }
}
