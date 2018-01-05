package com.codeherenow.sicalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mauricio on 04/01/2018.
 */

public class ResultActivity extends Activity {
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        textResult = (TextView) findViewById(R.id.txt_result);

        // Try to get the information sent by the caller Activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value1 = extras.getString("Result");
            if (value1 != null) {
                Toast.makeText(this, value1, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
