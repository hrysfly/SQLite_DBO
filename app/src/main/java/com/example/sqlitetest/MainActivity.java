package com.example.sqlitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button ;
    private Button btn_insert_to_cominfo;
    private DBO dbo;
    private Button btn_deletebook;
    private Button btn_jump;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button_test);
        btn_insert_to_cominfo = findViewById(R.id.btn_insert_com);
        btn_deletebook = findViewById(R.id.btn_deletebook);
        btn_jump = findViewById(R.id.btn_jump);
        dbo = new DBO(this);
        dbo.queryALL(Constants.TABLENAME_BOOK);
        btn_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });
        /*btn_deletebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] valuse = new String[]{
                        "2019"
                };
                dbo.delete(Constants.TABLENAME_BOOK,BOOK_columnname.BOOK_ID,valuse);
                Log.i(DBO.TAG, "delete"+BOOK_columnname.BOOK_ID+  "= "+valuse.toString());
            }
        });
        ContentValues values = new ContentValues();
        values.put(BOOK_columnname.BOOK_ID,"2019");
        values.put(BOOK_columnname.BOOK_AUTHOR,"张三");
        values.put(BOOK_columnname.BOOK_NAME,"学霸的黑科技系统");
        values.put(BOOK_columnname.BOOK_PRICE,"45");
        values.put(BOOK_columnname.BOOK_PUBLISH,"人民出版社");
        values.put(BOOK_columnname.BOOK_TYPE,"科幻");
        values.put(BOOK_columnname.BOOK_TOTAL,"20");
        dbo.insert(Constants.TABLENAME_BOOK,values);
        dbo.queryALL(Constants.TABLENAME_BOOK);*/
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values =new ContentValues();
                values.put("user_id","1001");
                values.put("user_name","张三");
                values.put("user_address","电子科技大学成都学院");
                values.put("user_password","1234567890");
                dbo.insert(Constants.TABLENAME_CLIENT,values);
                dbo.queryALL(Constants.TABLENAME_CLIENT);

            }
        });
        btn_insert_to_cominfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values =new ContentValues();
                values.put("com_id","1001");
                values.put("com_name","暖手宝");
                values.put("com_price","65元");
                values.put("com_state","有货");
                dbo.insert(Constants.TABLENAME_BOOK,values);
                dbo.queryALL(Constants.TABLENAME_BOOK);
            }
        });*/
    }
}
