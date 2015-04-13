package com.deemo.AccoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by 小默 on 2015/4/10.
 */
public class DetailActivity extends Activity {

    private TextView textInfo;
    private MySQLiteOpenHelper dbHelper;
    private int [] date=new int[7];
    private ArcChartView arcChartView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_deail);

        textInfo= (TextView) findViewById(R.id.textInfo);
        arcChartView= (ArcChartView) findViewById(R.id.arcChartView);

        dbHelper = new MySQLiteOpenHelper(this);

        //salary,extraMoney,dailyEat,treat,cigarettesAndWine,owrUse,gift,house,utilities,carFare,texiFare,learnUse,dailyUse
        List<Map<String, Object>> currentList = dbHelper.selectList(
                "select * from accout", null);
        int count=currentList.size()-1;

        date[0]=Integer.parseInt(currentList.get(count).get("salary").toString());
        date[1]=Integer.parseInt(currentList.get(count).get("extraMoney").toString());
        date[2]=Integer.parseInt(currentList.get(count).get("dailyEat").toString())+Integer.parseInt(currentList.get(0).get("treat").toString())+Integer.parseInt(currentList.get(0).get("cigarettesAndWine").toString());
        date[3]=Integer.parseInt(currentList.get(count).get("owrUse").toString())+Integer.parseInt(currentList.get(0).get("gift").toString());
        date[4]=Integer.parseInt(currentList.get(count).get("house").toString())+Integer.parseInt(currentList.get(0).get("utilities").toString());
        date[5]=Integer.parseInt(currentList.get(count).get("carFare").toString())+Integer.parseInt(currentList.get(0).get("texiFare").toString());
        date[6]=Integer.parseInt(currentList.get(count).get("learnUse").toString())+Integer.parseInt(currentList.get(0).get("dailyUse").toString());


        String info=currentList.toString();
        //textInfo.setText(count+info);
        //textInfo.setText(date[0]+"  "+date[1]+"  "+date[2]+"  "+date[3]+"  "+date[4]+"  "+date[5]+"  "+date[6]);
        arcChartView.setData(date);



    }
}