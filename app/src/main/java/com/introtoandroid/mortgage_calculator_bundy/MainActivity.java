package com.introtoandroid.mortgage_calculator_bundy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.EditText;
import android.content.Intent;
import java.util.Calendar;
import java.util.Date;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton m;
    RadioButton p;
    int isMort;

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
    Float hpy= new Float(0.0);

    String one;
    String two;
    String three;
    String four;
    String five;
    //String six;
    String seven;
    String eight;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent in = getIntent();


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

        one = in.getStringExtra("homeVal");
        two = in.getStringExtra("loanTerm");
        three = in.getStringExtra("loanAmt");
        four = in.getStringExtra("intRate");
        five = in.getStringExtra("hoaAmt");
        // six = mintent.getStringExtra("startDate");
        seven = in.getStringExtra("propTax");
        eight = in.getStringExtra("hiPerYear");


        if(one!=null){
        homeVal.setText(one);}

        if(two!=null){
        loanTerm.setText(two);}

        if(three!=null){
        loanAmt.setText(three);}

        if(four!=null){
        intRate.setText(four);}

        if(five!=null){
        hoaAmt.setText(five);}

        //test6.setText(six);

        if(seven!=null){
        propTax.setText(seven);}

        if(eight!=null){
        hiPerYear.setText(eight);}


    }

    public void sendMessage(View view) {

        String hv1 = homeVal.getText().toString();
        String lt1 = loanTerm.getText().toString();
        String la1 = loanAmt.getText().toString();
        String ir1 = intRate.getText().toString();
        String ha1 = hoaAmt.getText().toString();
        //String sd1 = startDate.getText().toString();
        String pt1 = propTax.getText().toString();
        String hpy1 = hiPerYear.getText().toString();

        hv = Integer.parseInt(homeVal.getText().toString());
        lt = Integer.parseInt(loanTerm.getText().toString());
        la = Integer.parseInt(loanAmt.getText().toString());
        ir = Integer.parseInt(intRate.getText().toString());
        ha = Integer.parseInt(hoaAmt.getText().toString());
        //sd = (Integer) startDate.getText();
        pt = Double.parseDouble(propTax.getText().toString());
        hpy = Float.parseFloat(hiPerYear.getText().toString());

        Integer numOfMonths = 12;

        Float hiPerMonth = hpy/numOfMonths;
        String hiPerMonthTxt = hiPerMonth.toString();

        Double monthlyTaxPaid = la*(pt/100);
        String monthlyTaxPaidTxt = monthlyTaxPaid.toString();

        Float totalHIPaid = lt*hpy;
        String totalHIPaidTxt = totalHIPaid.toString();

        Integer hoaPerYear = ha*numOfMonths;
        String hoaPerYearTxt = hoaPerYear.toString();

        Integer totalHOAPaid = hoaPerYear*lt;
        String totalHOAPaidTxt = totalHOAPaid.toString();




        if (isMort == 1) {

            Intent mintent = new Intent(MainActivity.this, mortSum.class);

            mintent.putExtra("homeVal", hv1);
            mintent.putExtra("loanTerm", lt1);
            mintent.putExtra("loanAmt", la1);
            mintent.putExtra("intRate", ir1);
            mintent.putExtra("hoaAmt", ha1);
            //mintent.putExtra("loanTerm", sd1);
            mintent.putExtra("propTax", pt1);
            mintent.putExtra("hiPerYear", hpy1);

            mintent.putExtra("hiPerMonth", hiPerMonthTxt);
            mintent.putExtra("monthlyTaxPaid", monthlyTaxPaidTxt);
            mintent.putExtra("totalHIPaid", totalHIPaidTxt);
            mintent.putExtra("hoaPerYear", hoaPerYearTxt);
            mintent.putExtra("totalHOAPaid", totalHOAPaidTxt);

            startActivity(mintent);
        }

        if (isMort == 2) {
            Intent pintent = new Intent(MainActivity.this, pay_sum.class);

            pintent.putExtra("homeVal", hv1);
            pintent.putExtra("loanTerm", lt1);
            pintent.putExtra("loanAmt", la1);
            pintent.putExtra("intRate", ir1);
            pintent.putExtra("hoaAmt", ha1);
            //pintent.putExtra("loanTerm", sd1);
            pintent.putExtra("propTax", pt1);
            pintent.putExtra("hiPerYear", hpy1);

            startActivity(pintent);
        }

        else{

        }
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        if (p.isChecked()){
            isMort=2;
        }
        else if(m.isChecked()){
            isMort=1;
        }

        else{
            isMort=3;
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
        hpy = Float.parseFloat(hiPerYear.getText().toString());


        outState.putInt("hv",hv);
        outState.putInt("lt",lt);
        outState.putInt("la",la);
        outState.putInt("ir",ir);
        outState.putInt("ha",ha);
        //outState.putInt("sd",sd);
        outState.putDouble("pt",pt);
        outState.putFloat("hpy",hpy);


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
        hpy = savedInstanceState.getFloat("hpy");


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