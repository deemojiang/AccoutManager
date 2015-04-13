package com.deemo.AccoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private EditText salary;
    private EditText extraMoney;

    private EditText dailyEat;
    private EditText treat;
    private EditText cigarettesAndWine;

    private EditText owrUse;
    private EditText gift;

    private EditText house;
    private EditText utilities;

    private EditText carFare;
    private EditText texiFare;

    private EditText learnUse;
    private EditText dailyUse;

    private  MySQLiteOpenHelper dbHelper;





    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();

        dbHelper = new MySQLiteOpenHelper(this);




    }
    public void button(View view){

        String sa=salary.getText().toString();
        String ex=extraMoney.getText().toString();

        String dae=dailyEat.getText().toString();
        String tr=treat.getText().toString();
        String cw=cigarettesAndWine.getText().toString();

        String ow=owrUse.getText().toString();
        String gi=gift.getText().toString();

        String ho=house.getText().toString();
        String ut=utilities.getText().toString();

        String cf=carFare.getText().toString();
        String tf=texiFare.getText().toString();

        String lu=learnUse.getText().toString();
        String du=dailyUse.getText().toString();

        String insertSql = "insert into accout (salary,extraMoney,dailyEat,treat,cigarettesAndWine," +
                "owrUse,gift,house,utilities,carFare,texiFare,learnUse,dailyUse) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        boolean flag = dbHelper.execData(insertSql, new Object[] {
                sa,ex,dae,tr,cw,ow,gi,ho,ut,cf,tf,lu,du });

        Intent intent=new Intent(this,DetailActivity.class);
        startActivity(intent);



    }

    private void init() {
        salary= (EditText) findViewById(R.id.salary);
        extraMoney= (EditText) findViewById(R.id.extraMoney);

        dailyEat= (EditText) findViewById(R.id.dailyEat);
        treat= (EditText) findViewById(R.id.treat);
        cigarettesAndWine= (EditText) findViewById(R.id.cigarettesAndWine);

        owrUse= (EditText) findViewById(R.id.owrUse);
        gift= (EditText) findViewById(R.id.gift);

        house= (EditText) findViewById(R.id.house);
        utilities= (EditText) findViewById(R.id.utilities);

        carFare= (EditText) findViewById(R.id.carFare);
        texiFare= (EditText) findViewById(R.id.texiFare);

        learnUse= (EditText) findViewById(R.id.learnUse);
        dailyUse= (EditText) findViewById(R.id.dailyUse);
    }
}
