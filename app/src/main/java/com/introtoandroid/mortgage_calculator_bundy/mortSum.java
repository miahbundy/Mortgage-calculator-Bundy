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
        one = mintent.getStringExtra("homeVal");
         two = mintent.getStringExtra("loanTerm");
         three = mintent.getStringExtra("loanAmt");
         four = mintent.getStringExtra("intRate");
         five = mintent.getStringExtra("hoaAmt");
        // six = mintent.getStringExtra("startDate");
         seven = mintent.getStringExtra("propTax");
         eight = mintent.getStringExtra("hiPerYear");



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

        String hv1 = one;
        String lt1 = two;
        String la1 = three;
        String ir1 = four;
        String ha1 = five;
        //String sd1 = six;
        String pt1 = seven;
        String hpy1 = eight;

        Intent intent = new Intent(mortSum.this, MainActivity.class);

        intent.putExtra("homeVal", hv1);
        intent.putExtra("loanTerm", lt1);
        intent.putExtra("loanAmt", la1);
        intent.putExtra("intRate", ir1);
        intent.putExtra("hoaAmt", ha1);
        //pintent.putExtra("loanTerm", sd1);
        intent.putExtra("propTax", pt1);
        intent.putExtra("hiPerYear", hpy1);

        startActivity(intent);

    }




}
