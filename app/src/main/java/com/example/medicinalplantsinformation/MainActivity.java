package com.example.medicinalplantsinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText email , password;
    Button sing;
    LinearLayout next;

    SQLiteDatabase db;
    SharedPreferences sp;
    CheckBox remember;
    String emailp="[a-zA-Z0-9.-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next=findViewById(R.id.singup_now);
        email = findViewById(R.id.email_id);
        password = findViewById(R.id.password);
        sing=  findViewById(R.id.sing);
        remember =findViewById(R.id.checkbox);
        sp = getSharedPreferences(commanclass.PREF,MODE_PRIVATE);


        db=openOrCreateDatabase("PLANTS", MODE_PRIVATE,null);

        String table = "CREATE TABLE IF NOT EXISTS USERDATA (USERID INTEGER PRIMARY KEY AUTOINCREMENT  ,  NAME VARCHAR(20) , PHONE VARCHAR (10) , EMAIL VARCHAR(30) , PASSWORD VARCHAR(8))";
        db.execSQL(table);



        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (email.getText().toString().trim().equals("")) {
                    email.setError("Enter Email ID");
            } else if (!email.getText().toString().trim().matches(emailp)) {
                    email.setError(emailp);
            }else if (password.getText().toString().trim().equals("")) {
                    password.setError("Enter Password");
            }else{

                String select="SELECT * FROM USERDATA WHERE EMAIL='"+email.getText().toString()+"' AND PASSWORD='"+password.getText().toString()+"'";
                Cursor cursor=db.rawQuery(select,null);
                if(cursor.getCount()>0){
                    while (cursor.moveToNext()) {
                        String sUserId = cursor.getString(0);
                        String sName = cursor.getString(1);
                        String sContact = cursor.getString(2);
                        String sEmail = cursor.getString(3);
                        String sPassword = cursor.getString(4);

                        sp.edit().putString(commanclass.ID,sUserId).commit();
                        sp.edit().putString(commanclass.NAME,sName).commit();
                        sp.edit().putString(commanclass.CONTACT,sContact).commit();
                        sp.edit().putString(commanclass.EMAIL,sEmail).commit();
                        sp.edit().putString(commanclass.PASSWORD,sPassword).commit();

                        if(remember.isChecked()){
                            sp.edit().putString(commanclass.REMEMBER,"No").commit();
                        }else{
                            sp.edit().putString(commanclass.REMEMBER,"").commit();
                        }
                    }
                    new commanmethod(MainActivity.this, "Login Succesfull");
                    new commanmethod(MainActivity.this, HomePage.class);
                }else{
                    new commanmethod(MainActivity.this , "Login Unsuccesfull");
                }

            }
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new commanmethod(MainActivity.this , singup.class);
            }
        });




    }
}