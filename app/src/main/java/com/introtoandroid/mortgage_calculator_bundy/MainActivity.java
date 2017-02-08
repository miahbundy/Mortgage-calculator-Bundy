package com.introtoandroid.mortgage_calculator_bundy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton m;
    RadioButton p;

    boolean isMort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m = (RadioButton) findViewById(R.id.radio_mort);
        p = (RadioButton) findViewById(R.id.radio_pay);
    }

    public void sendMessage(View view) {
        if (isMort) {
            Intent intent = new Intent(MainActivity.this, mortSum.class);
            startActivity(intent);
        }

        else if (!isMort) {
            Intent intent = new Intent(MainActivity.this, pay_sum.class);
            startActivity(intent);
        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        if (p.isChecked()){
            isMort=false;
        }
        else if(m.isChecked()){
            isMort=true;
        }
    }


}

