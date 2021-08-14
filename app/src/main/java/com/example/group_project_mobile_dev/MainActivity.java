package com.example.group_project_mobile_dev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static Utility utilityObj;//public static variables are available globally

    public static ArrayList<Utility> listViewUtilityList ;

    public static ArrayList<Utility> utilityList ;
    public static ArrayList<User> userList ;


    ListView listViewUtilityType ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewUtilityList = new ArrayList<>();
        utilityList = new ArrayList<>();
        userList = new ArrayList<>();

        filllistViewUtilityList();
        fillUtilityList();
        fillUserData();
        System.out.println(listViewUtilityList);

        listViewUtilityType = findViewById(R.id.listViewUtilityType);

        listViewUtilityType.setAdapter(new UtilityAdapter(this,listViewUtilityList));

        listViewUtilityType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                utilityObj = listViewUtilityList.get(position);
                Intent intent = new Intent(getBaseContext(),MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    public void filllistViewUtilityList(){

        listViewUtilityList.add(new Utility(11,"Hydro",100,R.mipmap.hydro));
        listViewUtilityList.add(new Utility(21,"Mobile",90,R.mipmap.mobile));
        listViewUtilityList.add(new Utility(31,"Gas",200,R.mipmap.gas));
        listViewUtilityList.add(new Utility(41,"Water",50,R.mipmap.water));
        listViewUtilityList.add(new Utility(51,"NetFlix",70,R.mipmap.netflix));
    }


    public void fillUtilityList(){

        utilityList.add(new Utility(11,"Hydro",100,R.mipmap.hydro));
        utilityList.add(new Utility(21,"Mobile",90,R.mipmap.mobile));
        utilityList.add(new Utility(31,"Gas",200,R.mipmap.gas));
        utilityList.add(new Utility(41,"Water",50,R.mipmap.water));
        utilityList.add(new Utility(51,"NetFlix",70,R.mipmap.netflix));

        utilityList.add(new Utility(12,"Hydro",140,R.mipmap.hydro));
        utilityList.add(new Utility(22,"Mobile",70,R.mipmap.mobile));
        utilityList.add(new Utility(32,"Gas",50,R.mipmap.gas));
        utilityList.add(new Utility(42,"Water",10,R.mipmap.water));
        utilityList.add(new Utility(52,"NetFlix",70,R.mipmap.netflix));

        utilityList.add(new Utility(13,"Hydro",200,R.mipmap.hydro));
        utilityList.add(new Utility(23,"Mobile",80,R.mipmap.mobile));
        utilityList.add(new Utility(33,"Gas",400,R.mipmap.gas));
        utilityList.add(new Utility(43,"Water",100,R.mipmap.water));
        utilityList.add(new Utility(53,"NetFlix",70,R.mipmap.netflix));



    }

    public void fillUserData(){

        userList.add(new User(21,"James", 1000,new int[]{11,21,31,41,51}));
        userList.add(new User(22,"Thames", 2000,new int[]{12,22,32,42,52}));
        userList.add(new User(23,"Names", 3000,new int[]{13,23,33,43,53}));


    }

}