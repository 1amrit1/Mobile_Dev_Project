package com.example.group_project_mobile_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class BillPayActivity extends AppCompatActivity {

    Spinner spinner;
    EditText extAmount;
    Button btnPay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_pay);

        spinner = findViewById(R.id.spinner);
        extAmount = findViewById(R.id.extAmount);
        btnPay = findViewById(R.id.btnPay);


    }
}