package com.example.medicinalplantsinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

public class profile extends AppCompatActivity {

    SharedPreferences sp;
    SQLiteDatabase db;
    EditText n,e,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sp=getSharedPreferences(commanclass.PREF,MODE_PRIVATE);
        n=findViewById(R.id.name_enter_p);
        e=findViewById(R.id.email_enter_p);
        p=findViewById(R.id.phone_enter_p);

        db =openOrCreateDatabase("PLANTS" , MODE_PRIVATE,null);
        String table = "CREATE TABLE IF NOT EXISTS  USERDATA (USERID INTEGER PRIMARY KEY AUTOINCREMENT  ,  NAME VARCHAR(20) , PHONE VARCHAR (10) , EMAIL VARCHAR(30) , PASSWORD VARCHAR(8))";
        db.execSQL(table);


        n.setText(sp.getString(commanclass.NAME,""));
        e.setText(sp.getString(commanclass.EMAIL,""));
        p.setText(sp.getString(commanclass.CONTACT,""));
    }
}