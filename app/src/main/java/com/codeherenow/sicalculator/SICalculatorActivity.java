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
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SICalculatorActivity extends Activity {

	private EditText editPrincipalAmount;
	private EditText editInterestRate;
	private TextView textPeriod;
	private TextView textResult;
	private Button buttonCalculate;
	private SeekBar seekPeriod;

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

	}

}
