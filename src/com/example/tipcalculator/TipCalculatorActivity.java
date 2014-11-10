package com.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	double percentage;
	
	EditText etInput;
	TextView tvTip;
	TextView tvCurrentPercentageLabel;
	TextView tvCurrentPercentage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		// UI
		etInput = (EditText) findViewById(R.id.etInput);
		tvTip = (TextView) findViewById(R.id.tvTips);
		tvCurrentPercentageLabel = (TextView) findViewById(R.id.tvPercentageLabel);
		tvCurrentPercentage = (TextView) findViewById(R.id.tvPercentage);

		etInput.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				calculateTip(null);
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void calculateTip(View v) {
		if (etInput.getText().toString().equals("")) {
			return;
		}

		if (v == null) {
			// do nothing
		} else {
			switch (v.getId()) {
			case R.id.btn10:
				percentage = 0.1;
				break;
			case R.id.btn15:
				percentage = 0.15;
				break;
			case R.id.btn20:
				percentage = 0.2;
				break;
			default:
				// do nothing
				break;
			}
		}

		tvCurrentPercentage.setText(String.valueOf(percentage));
		int input = Integer.parseInt(etInput.getText().toString());
		tvTip.setText(String.valueOf(Math.round(input * percentage * 100.0) / 100.0));

	}

}
