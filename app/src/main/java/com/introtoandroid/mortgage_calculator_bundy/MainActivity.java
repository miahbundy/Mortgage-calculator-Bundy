package com.introtoandroid.mortgage_calculator_bundy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    RadioButton m;
    RadioButton p;
    EditText homeVal;

    boolean isMort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m = (RadioButton) findViewById(R.id.radio_mort);
        p = (RadioButton) findViewById(R.id.radio_pay);
        homeVal = (EditText) findViewById(R.id.homeVal);
    }

    public void sendMessage(View view) {
        if (isMort) {
            //Editable theString = homeVal.getText();
            Intent intent = new Intent(MainActivity.this, mortSum.class);
            //intent.putExtra("homeVal", theString);
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

