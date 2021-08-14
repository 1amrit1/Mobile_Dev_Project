package com.example.group_project_mobile_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BillPayActivity extends AppCompatActivity {

    Spinner spinner;
    EditText extAmount;
    Button btnPay;
    CheckBox ckBoxRememberMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_pay);

        spinner = findViewById(R.id.spinner);
        extAmount = findViewById(R.id.extAmount);
        btnPay = findViewById(R.id.btnPay);
        ckBoxRememberMe = findViewById(R.id.ckBoxRememberMe);
        int postn = -1;
        for(int i = 0; i < MainActivity.userList.size();i++){
            if(MainActivity2.userId == MainActivity.userList.get(i).getId()){
                postn = i;
                break;
            };
        }

        User subscriber =  MainActivity.userList.get(postn);
        String[] acc = createStringArr(subscriber.getAccNo(),subscriber);

        int utilityPostn = -1;
        for(int i = 0; i < MainActivity.utilityList.size();i++){
            for(int j = 0; j < subscriber.getAccNo().length;j++){

                if(subscriber.getAccNo()[j] == MainActivity.utilityList.get(i).getAccNo()){
                    utilityPostn = i;
                    break;
                };

            }

        }

        Utility utObj = MainActivity.utilityList.get(utilityPostn);



        ArrayAdapter aa = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,acc );
        spinner.setAdapter(aa);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amt = Double.parseDouble(extAmount.getText().toString());

                //reduce amt from subscriber object
                double balance = subscriber.getBalance() - amt;
                subscriber.setBalance(balance);

                //reduce amt from utilites object
                double billAmt = utObj.getBillAmt()- amt;
                utObj.setBillAmt(billAmt);

                if(ckBoxRememberMe.isChecked() == true){
                    MainActivity2.savedSubsciberId = subscriber.getId();
                    String msg = "Your Payment for : $"+amt+"has been accepted! and your subscription number will be saved for further use!";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();

                }else {
                    String msg = "Your Payment for : $"+amt+"has been accepted!";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);

            }
        });


    }

    String[] createStringArr(int[] arr,User subscriber){


        ArrayList<String> sArr = new ArrayList<>();
        for(int i = 0; i < MainActivity.utilityList.size() ; i++){
            if(MainActivity.utilityList.get(i).getType() == MainActivity.utilityObj.getType()){
                for (int j = 0; j < arr.length;j++){
                    if(arr[j] == MainActivity.utilityList.get(i).getAccNo()){
                        sArr.add(String.valueOf(arr[j]));
                    }
                }
            }
//            sArr[i] = String.valueOf(arr[i]);
        }
        if(sArr.size()>0){
            String[] strArr = new String[sArr.size()];
            strArr = sArr.toArray(strArr);
            return strArr;
        }else {
            return new String[0];
        }
    }
}