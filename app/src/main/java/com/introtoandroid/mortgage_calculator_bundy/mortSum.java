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


    TextView test;
    TextView test2;
    TextView test3;
    TextView test4;
    TextView test5;
    //TextView test6;
    TextView test7;
    TextView test8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mort_sum);

        morg = (TextView) findViewById(R.id.textView);

        test = (TextView) findViewById(R.id.textView3);
        test2 = (TextView) findViewById(R.id.textView6);
        test3 = (TextView) findViewById(R.id.textView8);
        test4 = (TextView) findViewById(R.id.textView10);
        test5 = (TextView) findViewById(R.id.textView12);
        //test6 = (TextView) findViewById(R.id.textView14);
        test7 = (TextView) findViewById(R.id.textView16);
        test8 = (TextView) findViewById(R.id.textView18);

        Intent mintent = getIntent();
        String one = mintent.getStringExtra("homeVal");
        String two = mintent.getStringExtra("loanTerm");
        String three = mintent.getStringExtra("loanAmt");
        String four = mintent.getStringExtra("intRate");
        String five = mintent.getStringExtra("hoaAmt");
        //String six = mintent.getStringExtra("startDate");
        String seven = mintent.getStringExtra("propTax");
        String eight = mintent.getStringExtra("hiPerYear");



        test.setText(one);
        test2.setText(two);
        test3.setText(three);
        test4.setText(four);
        test5.setText(five);
        //test6.setText(six);
        test7.setText(seven);
        test8.setText(eight);

    }

    public void sendMessage(View view) {

        Intent intent = new Intent(mortSum.this, MainActivity.class);
        startActivity(intent);

    }




}
