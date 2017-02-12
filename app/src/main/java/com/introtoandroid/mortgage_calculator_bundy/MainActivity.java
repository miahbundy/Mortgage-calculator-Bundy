package com.introtoandroid.mortgage_calculator_bundy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.DatePicker;
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
    EditText propTax;
    EditText hiPerYear;

    DatePicker chooseDate;

    Integer hv = new Integer(0);
    Integer lt= new Integer(0);
    Integer la= new Integer(0);
    Integer ir= new Integer(0);
    Integer ha= new Integer(0);
    Double pt= new Double(0);
    Float hpy= new Float(0.0);
    int da;
    int mo;
    int ye;

    String one;
    String two;
    String three;
    String four;
    String five;
    String seven;
    String eight;
    String nine;
    String ten;
    String eleven;


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
        propTax = (EditText) findViewById(R.id.propTax);
        hiPerYear = (EditText) findViewById(R.id.hiPerYear);
        chooseDate = (DatePicker) findViewById(R.id.DatePicker01);


        one = in.getStringExtra("homeVal");
        two = in.getStringExtra("loanTerm");
        three = in.getStringExtra("loanAmt");
        four = in.getStringExtra("intRate");
        five = in.getStringExtra("hoaAmt");
        seven = in.getStringExtra("propTax");
        eight = in.getStringExtra("hiPerYear");

        nine = in.getStringExtra("day");
        ten = in.getStringExtra("month");
        eleven = in.getStringExtra("year");



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

        if(seven!=null){
        propTax.setText(seven);}

        if(eight!=null){
        hiPerYear.setText(eight);}

        if(nine!=null&&ten!=null&&eleven!=null){
            da = Integer.parseInt(nine);
            mo = Integer.parseInt(ten);
            ye = Integer.parseInt(eleven);
            chooseDate.updateDate(ye,mo,da);
        }


    }

    public void sendMessage(View view) {

        String hv1 = homeVal.getText().toString();
        String lt1 = loanTerm.getText().toString();
        String la1 = loanAmt.getText().toString();
        String ir1 = intRate.getText().toString();
        String ha1 = hoaAmt.getText().toString();
        String pt1 = propTax.getText().toString();
        String hpy1 = hiPerYear.getText().toString();

        String day = String.valueOf(chooseDate.getDayOfMonth());
        String month = String.valueOf(chooseDate.getMonth());
        String year = String.valueOf(chooseDate.getYear());

        hv = Integer.parseInt(homeVal.getText().toString());
        lt = Integer.parseInt(loanTerm.getText().toString());
        la = Integer.parseInt(loanAmt.getText().toString());
        ir = Integer.parseInt(intRate.getText().toString());
        ha = Integer.parseInt(hoaAmt.getText().toString());
        pt = Double.parseDouble(propTax.getText().toString());
        hpy = Float.parseFloat(hiPerYear.getText().toString());

        //math
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

        Integer totalNumOfPayments = lt*numOfMonths;
        String totalNumOfPaymentsTxt = totalNumOfPayments.toString();

        Integer biDoneMonth = chooseDate.getMonth();
        Integer biDoneYear = chooseDate.getYear() + (lt - (lt/10));

        Integer moDoneMonth;
        Integer moDoneYear;
        if (biDoneMonth==0){
            moDoneMonth = 11;
            moDoneYear = chooseDate.getYear() + (lt-1);
        }
        else{
            moDoneMonth = biDoneMonth-1;
            moDoneYear = chooseDate.getYear() + lt;
        }

        biDoneMonth++;
        moDoneMonth++;

        String biDoneMonthTxt = biDoneMonth.toString();
        String biDoneYearTxt = biDoneYear.toString();
        String moDoneMonthTxt = moDoneMonth.toString();
        String moDoneYearTxt = moDoneYear.toString();



        if (isMort == 1) {

            Intent mintent = new Intent(MainActivity.this, mortSum.class);

            mintent.putExtra("homeVal", hv1);
            mintent.putExtra("loanTerm", lt1);
            mintent.putExtra("loanAmt", la1);
            mintent.putExtra("intRate", ir1);
            mintent.putExtra("hoaAmt", ha1);
            mintent.putExtra("propTax", pt1);
            mintent.putExtra("hiPerYear", hpy1);

            mintent.putExtra("day", day);
            mintent.putExtra("month", month);
            mintent.putExtra("year", year);

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
            pintent.putExtra("propTax", pt1);
            pintent.putExtra("hiPerYear", hpy1);

            pintent.putExtra("day", day);
            pintent.putExtra("month", month);
            pintent.putExtra("year", year);

            pintent.putExtra("totalNumOfPayments", totalNumOfPaymentsTxt);

            pintent.putExtra("moDoneMonth", moDoneMonthTxt);
            pintent.putExtra("biDoneMonth", biDoneMonthTxt);
            pintent.putExtra("moDoneYear", moDoneYearTxt);
            pintent.putExtra("biDoneYear", biDoneYearTxt);


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
        pt = Double.parseDouble(propTax.getText().toString());
        hpy = Float.parseFloat(hiPerYear.getText().toString());
        da = chooseDate.getDayOfMonth();
        mo = chooseDate.getMonth();
        ye = chooseDate.getYear();

        outState.putInt("hv",hv);
        outState.putInt("lt",lt);
        outState.putInt("la",la);
        outState.putInt("ir",ir);
        outState.putInt("ha",ha);
        outState.putDouble("pt",pt);
        outState.putFloat("hpy",hpy);
        outState.putInt("day", da);
        outState.putInt("month", mo);
        outState.putInt("year", ye);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        hv = savedInstanceState.getInt("hv");
        lt = savedInstanceState.getInt("lt");
        la = savedInstanceState.getInt("la");
        ir = savedInstanceState.getInt("ir");
        ha = savedInstanceState.getInt("ha");
        pt = savedInstanceState.getDouble("pt");
        hpy = savedInstanceState.getFloat("hpy");
        da = savedInstanceState.getInt("day");
        mo = savedInstanceState.getInt("month");
        ye = savedInstanceState.getInt("year");


        homeVal.setText(hv.toString());
        loanTerm.setText(lt.toString());
        loanAmt.setText(la.toString());
        intRate.setText(ir.toString());
        hoaAmt.setText(ha.toString());
        propTax.setText(pt.toString());
        hiPerYear.setText(hpy.toString());
        chooseDate.updateDate(ye,mo,da);

    }



}