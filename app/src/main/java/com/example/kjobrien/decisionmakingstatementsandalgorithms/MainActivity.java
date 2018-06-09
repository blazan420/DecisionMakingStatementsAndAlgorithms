package com.example.kjobrien.decisionmakingstatementsandalgorithms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtNum1 = (EditText)findViewById(R.id.edtNum1);
        final EditText edtNum2 = (EditText)findViewById(R.id.edtNum2);
        final EditText edtNum3 = (EditText)findViewById(R.id.edtNum3);
        Button btnMaximumValue = (Button)findViewById(R.id.btnMaximumValue);
        final TextView txtResult = (TextView)findViewById(R.id.txtResult);
        final Button btnSecureRandomNumbers = (Button)findViewById(R.id.btnSecureRandomNumbers);
        final TextView txtSecureRandomNumbers = (TextView)findViewById(R.id.txtSecureRandomNumbers);

        btnMaximumValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double num1 = Double.parseDouble(edtNum1.getText().toString());
                double num2 = Double.parseDouble(edtNum2.getText().toString());
                double num3 = Double.parseDouble(edtNum3.getText().toString());

                double result = getTheMaximum(num1, num2, num3);
                txtResult.setText(result + "");

            }
        });

        btnSecureRandomNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(firstTime) {
                    txtSecureRandomNumbers.setText("");
                    firstTime = false;
                }

                SecureRandom secureRandomNumber = new SecureRandom();

                String oldTextSecureNumbersValue = txtSecureRandomNumbers.getText().toString();
                if (txtSecureRandomNumbers.getText().toString().length() >=9) {
                    btnSecureRandomNumbers.setVisibility(View.INVISIBLE);
                }

                int randomSecureNumber = 1 + secureRandomNumber.nextInt(5);
                Log.i("LOG", randomSecureNumber + "");
                txtSecureRandomNumbers.setText(oldTextSecureNumbersValue + randomSecureNumber + "");

            }
        });
    }

    public double getTheMaximum(double num1, double num2, double num3) {

        double theMaximumValue = num1;
        if (num2 > theMaximumValue) {
            theMaximumValue = num2;
        }
        if (num3 > theMaximumValue) {
            theMaximumValue = num3;
        }

        return  theMaximumValue;

    }
}
