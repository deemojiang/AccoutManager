package com.deemo.AccoutManager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 小默 on 2015/4/10.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private final static String DBNAME="accout.db";
    private final static int VESION=1;
    private SQLiteDatabase db=null;


    public MySQLiteOpenHelper(Context context ) {
        super(context,DBNAME,null,VESION);
        db=getReadableDatabase();
    }


    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS accout(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT ,month, salary,extraMoney," +
                "dailyEat,treat,cigarettesAndWine,owrUse,gift,house,utilities,carFare,texiFare,learnUse,dailyUse)");
    }

    //版本更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion>oldVersion){
            db.execSQL("DROP TABLE IF EXISTS accout");
            onCreate(db);
        }
    }

    //定义查询方法
    public Cursor selectCursor(String sql, String[] selectionArgs) {
        return db.rawQuery(sql, selectionArgs);
    }

    public List<Map<String, Object>> selectList(String sql, String[] selectionArgs) {
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        return cursorToList(cursor);
    }

    //返回选搜索到的条数
    public int selectCount(String sql, String[] selectionArgs) {
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        int count = cursor.getCount();
        if (cursor != null) {
            cursor.close();
        }
        return count;
    }

    //操作数据库，增，删，改
    public boolean execData(String sql, Object[] bindArgs) {
        try {
            db.execSQL(sql, bindArgs);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //将查询得到的cursor对象转换为list数组
    public List<Map<String, Object>> cursorToList(Cursor cursor) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        String[] arrColumnName = cursor.getColumnNames();

        //没将游标移动到首项，默认移动到第一项的上一项（-1项）
        while (cursor.moveToNext()) {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < arrColumnName.length; i++) {
                map.put(arrColumnName[i], cursor.getString(i));
            }
            list.add(map);
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }



}
