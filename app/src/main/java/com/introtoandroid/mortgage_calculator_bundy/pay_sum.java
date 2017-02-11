package com.introtoandroid.mortgage_calculator_bundy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class pay_sum extends AppCompatActivity {

    TextView pay;

    TextView test;
    TextView test2;
    TextView test3;
    TextView test4;
    TextView test5;
    TextView test7;
    TextView test8;

    String one;
    String two;
    String three;
    String four;
    String five;
    String seven;
    String eight;

    String day;
    String month;
    String year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_sum);

        pay = (TextView) findViewById(R.id.textView);

        test = (TextView) findViewById(R.id.textView3);
        test2 = (TextView) findViewById(R.id.textView6);
        test3 = (TextView) findViewById(R.id.textView8);
        test4 = (TextView) findViewById(R.id.textView10);
        test5 = (TextView) findViewById(R.id.textView12);
        test7 = (TextView) findViewById(R.id.textView16);
        test8 = (TextView) findViewById(R.id.textView18);

        Intent mintent = getIntent();
         one = mintent.getStringExtra("homeVal");
         two = mintent.getStringExtra("loanTerm");
         three = mintent.getStringExtra("loanAmt");
         four = mintent.getStringExtra("intRate");
         five = mintent.getStringExtra("hoaAmt");
         seven = mintent.getStringExtra("propTax");
         eight = mintent.getStringExtra("hiPerYear");

        day = mintent.getStringExtra("day");
        month = mintent.getStringExtra("month");
        year = mintent.getStringExtra("year");



        test.setText(one);
        test2.setText(two);
        test3.setText(three);
        test4.setText(four);
        test5.setText(five);
        test7.setText(seven);
        test8.setText(eight);
    }

    public void sendMessage(View view) {
        String hv1 = one;
        String lt1 = two;
        String la1 = three;
        String ir1 = four;
        String ha1 = five;
        String pt1 = seven;
        String hpy1 = eight;

        Intent intent2 = new Intent(pay_sum.this, MainActivity.class);

        intent2.putExtra("homeVal", hv1);
        intent2.putExtra("loanTerm", lt1);
        intent2.putExtra("loanAmt", la1);
        intent2.putExtra("intRate", ir1);
        intent2.putExtra("hoaAmt", ha1);
        intent2.putExtra("propTax", pt1);
        intent2.putExtra("hiPerYear", hpy1);

        intent2.putExtra("day", day);
        intent2.putExtra("month", month);
        intent2.putExtra("year", year);

        startActivity(intent2);

    }
}
