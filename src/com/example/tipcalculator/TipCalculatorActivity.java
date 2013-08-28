package com.example.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends Activity {
	
	public EditText etTotalAmount;
	public TextView tvTip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        etTotalAmount = (EditText) findViewById(R.id.etTotalAmount);
        tvTip = (TextView) findViewById(R.id.tvTip);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
    
    public void onTenPercent(View v) {
    	this.setTip(0.1);
    }


    public void onFifteenPercent(View v) {
    	this.setTip(0.15);
    }

 
    public void onTwentyPercent(View v) {
    	this.setTip(0.2);
    }


    private void setTip(double percent) {
    	String total = etTotalAmount.getText().toString();

    	if (total.matches("")) {
    	    Toast.makeText(this, "Please enter a total amount", Toast.LENGTH_SHORT).show();
    	    return;
    	}
 
    	double tip = percent * Double.parseDouble(total);
    	double new_total = Double.parseDouble(total) + tip;

    	DecimalFormat df = new DecimalFormat("#.##");
    	String tip_value = "Tip: $" + df.format(tip);
    	String total_value = "Total including tip: $" + df.format(new_total);

    	tvTip.setText(tip_value + "\n" + total_value);
    }
  
}
