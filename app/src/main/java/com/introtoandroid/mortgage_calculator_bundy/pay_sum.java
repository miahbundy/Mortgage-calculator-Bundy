package com.introtoandroid.mortgage_calculator_bundy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class pay_sum extends AppCompatActivity {

    TextView pay;
    TextView numPaymentsTV;
    TextView monthlyPO;
    TextView biweeklyPO;

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

    String mDM;
    String mDY;
    String bDM;
    String bDY;

    String totalNumPayments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_sum);

        pay = (TextView) findViewById(R.id.textView);
        numPaymentsTV = (TextView) findViewById(R.id.textView25);
        monthlyPO = (TextView) findViewById(R.id.textView28);
        biweeklyPO = (TextView) findViewById(R.id.textview29);

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

        totalNumPayments = mintent.getStringExtra("totalNumOfPayments");

        mDM = mintent.getStringExtra("moDoneMonth");
        mDY = mintent.getStringExtra("moDoneYear");
        bDM = mintent.getStringExtra("biDoneMonth");
        bDY = mintent.getStringExtra("biDoneYear");

        numPaymentsTV.setText(totalNumPayments);

        biweeklyPO.setText("Month number " + bDM + " of " +bDY);
        monthlyPO.setText("Month number " + mDM + " of " + mDY);


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
