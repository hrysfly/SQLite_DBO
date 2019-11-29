package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_CREATETABLE_USERINFO = "CREATE TABLE "+Constants.TABLENAME_CLIENT + "(user_name varchar primary key,user_password varchar not null,user_id varchar,user_real_name varchar,user_nickname varchar,user_address varchar,user_sex varchar,user_paymentcode varchar not null);";
        String sql_CREATETABLE_BOOKINFO = "CREATE TABLE "+Constants.TABLENAME_BOOK + "(book_id varchar primary key,book_name varchar,book_author varchar,book_publish varchar,book_type varchar,book_price varchar,book_total varchar,book_img_url varchar,book_describle varchar);";
        String sql_CREATETABLE_ORDERID = "CREATE TABLE "+Constants.TABLENAME_ORDERID + "(order_id varchar primary key);";
        sqLiteDatabase.execSQL(sql_CREATETABLE_USERINFO);
        sqLiteDatabase.execSQL(sql_CREATETABLE_BOOKINFO);
        sqLiteDatabase.execSQL(sql_CREATETABLE_ORDERID);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
