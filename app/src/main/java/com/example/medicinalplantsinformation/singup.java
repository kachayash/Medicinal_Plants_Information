package com.example.medicinalplantsinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class singup extends AppCompatActivity {

    EditText name,phone,email,password;
    Button sing;
    LinearLayout next;
    SQLiteDatabase db;
    SharedPreferences sp;
    String emailp="[a-zA-Z0-9.-]+@[a-z]+\\.+[a-z]+";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        name=findViewById(R.id.name_enter);
        phone=findViewById(R.id.phone_enter);
        email =findViewById(R.id.email_enter);
        password = findViewById(R.id.password_enter);

        sing = findViewById(R.id.singup);
        next=findViewById(R.id.loginnow);


        db =openOrCreateDatabase("PLANTS" , MODE_PRIVATE,null);
        String table = "CREATE TABLE IF NOT EXISTS  USERDATA (USERID INTEGER PRIMARY KEY AUTOINCREMENT  ,  NAME VARCHAR(20) , PHONE VARCHAR (10) , EMAIL VARCHAR(30) , PASSWORD VARCHAR(8))";
        db.execSQL(table);

        // CHECK VALIDATION;

        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().trim().equals("")) {
                    name.setError("Enter Name");
                }
                //contact
                else if (phone.getText().toString().trim().equals("")) {
                    phone.setError("Enter Phone Number");
                }
                //email
                else if (email.getText().toString().trim().equals("")) {
                    email.setError("Enter Email ID");
                } else if (!email.getText().toString().trim().matches(emailp)) {
                    email.setError(emailp);
                }

                else if (password.getText().toString().trim().equals("")) {
                    password.setError("Enter Password");

                }else
                {
                    String selectq ="SELECT * FROM USERDATA WHERE PHONE='"+phone.getText().toString()+"' AND EMAIL='"+email.getText().toString()+"'";

                    Cursor cursor=db.rawQuery(selectq,null);
                    if (cursor.getCount()>0){
                        new commanmethod(singup.this ,"Email ID, Contact Number Alredy Registered" );
                    }
                    else{
                        String insert = "INSERT INTO USERDATA VALUES(NULL,'"+name.getText().toString()+"' , '"+phone.getText().toString()+"' , '"+email.getText().toString()+"' , '"+password.getText().toString()+"' )";
                        db.execSQL(insert);
                        System.out.println("Signup Successfully");
                        new commanmethod(singup.this, "Signup Successfully");
                        new commanmethod(singup.this, MainActivity.class);
                    }
                }

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new commanmethod(singup.this , MainActivity.class);

            }
        });


    }
}