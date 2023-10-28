package com.example.medicinalplantsinformation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class plant41 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant41);


        Button button = findViewById(R.id.language_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button();
            }
        });
    }
    private void button() {
        final String language_name[]={"English","ગુજરાતી" , "हिंदी"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Choose Language");
        builder.setSingleChoiceItems(language_name, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0)
                {
                    setLocale("");
                    recreate();
                }
                else if (i==1)
                {
                    setLocale("gu");
                    recreate();
                } else if (i==2) {
                    setLocale("hi");
                    recreate();
                }

            }
        });
        builder.create();
        builder.show();

    }
    private void setLocale(String s) {

        Locale locale=new Locale(s);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
    }
}