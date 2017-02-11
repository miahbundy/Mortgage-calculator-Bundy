package com.introtoandroid.mortgage_calculator_bundy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import android.widget.RadioButton;

public class mortSum extends AppCompatActivity {

    TextView morg;

    TextView monthlyhi;
    TextView taxPerMonth;
    TextView totalHIPaidTV;
    TextView hoaPerYearTV;
    TextView totalHOAPaidTV;

    String one;
    String two;
    String three;
    String four;
    String five;
    String seven;
    String eight;

    String hiPerMonth;
    String monthlyTaxPaid;
    String totalHIPaid;
    String hoaPerYear;
    String totalHOAPaid;

    String day;
    String month;
    String year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mort_sum);

        morg = (TextView) findViewById(R.id.textView);

        monthlyhi = (TextView) findViewById(R.id.textView19);
        taxPerMonth = (TextView) findViewById(R.id.textView3);
        totalHIPaidTV = (TextView) findViewById(R.id.textView12);
        hoaPerYearTV = (TextView) findViewById(R.id.textView21);
        totalHOAPaidTV = (TextView) findViewById(R.id.textView23);

        Intent mintent = getIntent();
        one = mintent.getStringExtra("homeVal");
        two = mintent.getStringExtra("loanTerm");
        three = mintent.getStringExtra("loanAmt");
        four = mintent.getStringExtra("intRate");
        five = mintent.getStringExtra("hoaAmt");
        seven = mintent.getStringExtra("propTax");
        eight = mintent.getStringExtra("hiPerYear");

        hiPerMonth = mintent.getStringExtra("hiPerMonth");
        monthlyTaxPaid = mintent.getStringExtra("monthlyTaxPaid");
        totalHIPaid = mintent.getStringExtra("totalHIPaid");
        hoaPerYear = mintent.getStringExtra("hoaPerYear");
        totalHOAPaid =  mintent.getStringExtra("totalHOAPaid");

        day = mintent.getStringExtra("day");
        month = mintent.getStringExtra("month");
        year = mintent.getStringExtra("year");


        monthlyhi.setText(hiPerMonth);
        taxPerMonth.setText(monthlyTaxPaid);
        totalHIPaidTV.setText(totalHIPaid);
        hoaPerYearTV.setText(hoaPerYear);
        totalHOAPaidTV.setText(totalHOAPaid);



    }


    public void sendMessage(View view) {

        String hv1 = one;
        String lt1 = two;
        String la1 = three;
        String ir1 = four;
        String ha1 = five;
        String pt1 = seven;
        String hpy1 = eight;

        Intent intent = new Intent(mortSum.this, MainActivity.class);

        intent.putExtra("homeVal", hv1);
        intent.putExtra("loanTerm", lt1);
        intent.putExtra("loanAmt", la1);
        intent.putExtra("intRate", ir1);
        intent.putExtra("hoaAmt", ha1);
        intent.putExtra("propTax", pt1);
        intent.putExtra("hiPerYear", hpy1);

        intent.putExtra("day", day);
        intent.putExtra("month", month);
        intent.putExtra("year", year);

        startActivity(intent);

    }




}
