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
    boolean isMort;

    EditText homeVal;
    EditText loanTerm;
    EditText loanAmt;
    EditText intRate;
    EditText hoaAmt;
    //EditText startDate;
    EditText propTax;
    EditText hiPerYear;

    Integer hv = new Integer(0);
    Integer lt= new Integer(0);
    Integer la= new Integer(0);
    Integer ir= new Integer(0);
    Integer ha= new Integer(0);
    //Date sd;
    Double pt= new Double(0);
    Integer hpy= new Integer(0);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m = (RadioButton) findViewById(R.id.radio_mort);
        p = (RadioButton) findViewById(R.id.radio_pay);

        homeVal = (EditText) findViewById(R.id.homeVal);
        loanTerm = (EditText) findViewById(R.id.loanTerm);
        loanAmt = (EditText) findViewById(R.id.loanAmt);
        intRate = (EditText) findViewById(R.id.intRate);
        hoaAmt = (EditText) findViewById(R.id.hoaAmt);
        //startDate = (EditText) findViewById(R.id.startDate);
        propTax = (EditText) findViewById(R.id.propTax);
        hiPerYear = (EditText) findViewById(R.id.hiPerYear);


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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        hv = Integer.parseInt(homeVal.getText().toString());
        lt = Integer.parseInt(loanTerm.getText().toString());
        la = Integer.parseInt(loanAmt.getText().toString());
        ir = Integer.parseInt(intRate.getText().toString());
        ha = Integer.parseInt(hoaAmt.getText().toString());
        //sd = (Integer) startDate.getText();
        pt = Double.parseDouble(propTax.getText().toString());
        hpy = Integer.parseInt(hiPerYear.getText().toString());


        outState.putInt("hv",hv);
        outState.putInt("lt",lt);
        outState.putInt("la",la);
        outState.putInt("ir",ir);
        outState.putInt("ha",ha);
        //outState.putInt("sd",sd);
        outState.putDouble("pt",pt);
        outState.putInt("hpy",hpy);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        hv = savedInstanceState.getInt("hv");
        lt = savedInstanceState.getInt("lt");
        la = savedInstanceState.getInt("la");
        ir = savedInstanceState.getInt("ir");
        ha = savedInstanceState.getInt("ha");
        //sd = savedInstanceState.getInt("sd");
        pt = savedInstanceState.getDouble("pt");
        hpy = savedInstanceState.getInt("hpy");


        homeVal.setText(hv.toString());
        loanTerm.setText(lt.toString());
        loanAmt.setText(la.toString());
        intRate.setText(ir.toString());
        hoaAmt.setText(ha.toString());
        //startDate.setText(sd.toString());
        propTax.setText(pt.toString());
        hiPerYear.setText(hpy.toString());

    }




}

