package com.example.sqlitetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBO {

    public static final String TAG ="DBO" ;
    private final DBHelper helper;
    private SQLiteDatabase db;

    public DBO(Context context) {
        helper = new DBHelper(context);
        helper.getWritableDatabase();
    }


    public void insert(String TABLE_NAME, ContentValues values){
        db = helper.getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public void delete(String TABLE_NAME,String column_name,String[] column_values){
        String whereClause = column_name + "=?" ;
        db =helper.getWritableDatabase();
        db.delete(TABLE_NAME,whereClause,column_values);
        db.close();

    }

    public void queryALL(String TABLE_NAME){
        db = helper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null,null,null);
        int tbc_length = cursor.getColumnCount();
        while(cursor.moveToNext()){

            for(int i = 0; i<tbc_length; i++){
                String data = cursor.getString(i);
                Log.i(TAG,"data:"+data);
            }
        }
        cursor.close();
        db.close();
    }
    public void update(String TABLE_NAME,ContentValues updatevalues,String column_name,String[] column_values){
        SQLiteDatabase db = helper.getWritableDatabase();
        String whereClause = column_name + "=?" ;
        db.update(TABLE_NAME,updatevalues,whereClause,column_values);


        db.close();
    }

}
