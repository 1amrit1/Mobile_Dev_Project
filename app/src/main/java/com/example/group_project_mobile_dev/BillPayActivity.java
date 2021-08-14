package com.example.group_project_mobile_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Collections;

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

        int postn = -1;
        for(int i = 0; i < MainActivity.userList.size();i++){
            if(MainActivity2.userId == MainActivity.userList.get(i).getId()){
                postn = i;
                break;
            };
        }
       User subscriber =  MainActivity.userList.get(postn);
        String[] acc = createStringArr(subscriber.getAccNo());

        ArrayAdapter aa = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,acc );
        spinner.setAdapter(aa);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    String[] createStringArr(int[] arr){
        String[] sArr = new String[arr.length];
        for(int i = 0; i < arr.length ; i++){
            sArr[i] = String.valueOf(arr[i]);
        }
        return  sArr;
    }
}