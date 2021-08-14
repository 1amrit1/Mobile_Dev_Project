package com.example.group_project_mobile_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText subscriptionNum;
    Button btnSubNum;
    public static int userId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        subscriptionNum = findViewById(R.id.extSubsNum);
        btnSubNum = findViewById(R.id.btnSubNum);

        btnSubNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int subNum = Integer.parseInt(subscriptionNum.getText().toString());
                int postn = -1;
                for(int i = 0; i < MainActivity.userList.size();i++){
                    if(subNum == MainActivity.userList.get(i).getId()){
                        postn = i;
                        break;
                    };
                }
                if(postn == -1){
                    Toast.makeText(getApplicationContext(),"Wrong Subscription Number",Toast.LENGTH_SHORT).show();
                }else {
                    userId = subNum;
                    Intent intent = new Intent(getBaseContext(),BillPayActivity.class);
                    startActivity(intent);
                }


            }
        });


    }
}