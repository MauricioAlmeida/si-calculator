/*
 * Copyright (C) 2013 Code Here Now - A subsidiary of Mobs & Geeks
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file 
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */
package com.codeherenow.sicalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SICalculatorActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

	private EditText editPrincipalAmount;
	private EditText editInterestRate;
	private TextView textPeriod;
	private TextView textResult;
	private Button buttonCalculate;
	private SeekBar seekPeriod;
	private Button buttonResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sicalculator);

		editPrincipalAmount = (EditText) findViewById(R.id.edt_principal_amount);
		editInterestRate = (EditText) findViewById(R.id.edt_interest_rate);
		textPeriod = (TextView) findViewById(R.id.seek_period_text);
		textResult = (TextView) findViewById(R.id.txt_result);
		buttonCalculate = (Button) findViewById(R.id.button_calculate);
		seekPeriod = (SeekBar) findViewById(R.id.seek_period);
		buttonResult = (Button) findViewById(R.id.button_result);

		seekPeriod.setMax(9);
		buttonCalculate.setOnClickListener(this);
		seekPeriod.setOnSeekBarChangeListener(this);
		buttonResult.setOnClickListener(this);

	}

	@Override
	public void onClick(View view) {
		if (view == buttonCalculate) {
			Toast.makeText(this, "Clicou no botão Calculate", Toast.LENGTH_SHORT).show();
			String sPrincipalAmount = editPrincipalAmount.getText().toString();
			String sInterestRate = editInterestRate.getText().toString();
			double dPrincipalAmount = Double.parseDouble(sPrincipalAmount);
			double dInterestRate = Double.parseDouble(sInterestRate);
			int period = seekPeriod.getProgress() + 1;
			double finalAmount = dPrincipalAmount * (dInterestRate / 100) * period;

			textResult.setText("The interest for $" + String.format("%.2f", dPrincipalAmount) + " at a rate of " + String.format("%.2f", dInterestRate) + "% for " + String.format("%d", period) + " year(s) is $" + String.format("%.2f", finalAmount));

		} else if (view == buttonResult) {
			Intent i = new Intent(SICalculatorActivity.this, ResultActivity.class);
			i.putExtra("Result", textResult.getText().toString());
			startActivity(i);
		}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
		int value = i + 1;
		textPeriod.setText(String.format("%d", value) + " Year(s)");
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {

	}
}
