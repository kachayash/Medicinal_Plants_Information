package com.example.medicinalplantsinformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    SharedPreferences sp;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sp=getSharedPreferences(commanclass.PREF,MODE_PRIVATE);
        img=findViewById(R.id.img_splash);

        AlphaAnimation animation=new AlphaAnimation(0,1);
        animation.setDuration(2000);
        img.startAnimation(animation);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sp.getString(commanclass.REMEMBER,"").equalsIgnoreCase("NO")){
                    new commanmethod(SplashScreen.this, MainActivity.class);
                }else {
                    new commanmethod(SplashScreen.this,HomePage.class);
                }
            }
        },2000);
    }
}