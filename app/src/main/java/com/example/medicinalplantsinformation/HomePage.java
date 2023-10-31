package com.example.medicinalplantsinformation;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    TextView text;
    int check;
    SharedPreferences sp;

    SQLiteDatabase db;
    Toolbar toolbar;


    CardView plant , scan , search , profile;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        db=openOrCreateDatabase("PLANTS", MODE_PRIVATE,null);
        String table = "CREATE TABLE IF NOT EXISTS USERDATA (USERID INTEGER PRIMARY KEY AUTOINCREMENT  ,  NAME VARCHAR(20) , PHONE VARCHAR (10) , EMAIL VARCHAR(30) , PASSWORD VARCHAR(8))";
        db.execSQL(table);

        text=findViewById(R.id.user_text);
        sp=getSharedPreferences(commanclass.PREF,MODE_PRIVATE);

        //slidebar
        ImageSlider imageSlider =findViewById(R.id.sld);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.acacia_nolotica , ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.acalypha_indica , ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.p4 , ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.p8 , ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.p15 , ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.p17, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.p18 , ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.p19 , ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.p20 , ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.p21 , ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        // name set textview
        text.setText(sp.getString(commanclass.NAME,""));


        //tooolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //plants
        plant = findViewById(R.id.plants_info);
        plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new commanmethod(HomePage.this , "Plants Info");
                new commanmethod(HomePage.this , plants.class);

            }
        });


        //search
        search = findViewById(R.id.seasch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new commanmethod(HomePage.this , plants.class);
            }
        });


        //scan
        scan =findViewById(R.id.scan);
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scanCode();
            }
        });


        //profile

        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new commanmethod(HomePage.this,com.example.medicinalplantsinformation.profile.class);
            }
        });


    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Scan Code");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(Capture.class);
        barLauncher.launch(options);
    }
    ActivityResultLauncher<ScanOptions> barLauncher =registerForActivityResult(new ScanContract(),result -> {

        if (result.getContents() != null){

//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setTitle("Result");
//            builder.setMessage(result.getContents());
            check = Integer.parseInt(result.getContents());


//            transfer activity

            if (check == 1){
                Intent intent = new Intent(HomePage.this , plantone.class);
                startActivity(intent);
            }
            else if (check == 2) {
                    new commanmethod(HomePage.this, plant2.class);
            }

            else if (check == 3) {
                new commanmethod(HomePage.this, plant3.class);
            }

            else if (check == 4) {
                new commanmethod(HomePage.this, plant4.class);
            }

            else if (check == 5) {
                new commanmethod(HomePage.this, plant5.class);
            }

            else if (check == 6) {
                new commanmethod(HomePage.this, plant6.class);
            }

            else if (check == 7) {
                new commanmethod(HomePage.this, plant7.class);
            } else if (check == 8) {
                new commanmethod(HomePage.this, plant8.class);
            } else if (check == 9) {
                new commanmethod(HomePage.this, plant9.class);
            } else if (check == 10) {
                new commanmethod(HomePage.this, plant10.class);
            } else if (check == 11) {
                new commanmethod(HomePage.this, plant11.class);
            } else if (check == 12) {
                new commanmethod(HomePage.this, plant12.class);
            } else if (check == 13) {
                new commanmethod(HomePage.this, plant13.class);
            } else if (check == 14) {
                new commanmethod(HomePage.this, plant14.class);
            } else if (check == 15) {
                new commanmethod(HomePage.this, plant15.class);
            } else if (check == 16) {
                new commanmethod(HomePage.this, plant16.class);
            } else if (check == 17) {
                new commanmethod(HomePage.this, plant17.class);
            } else if (check == 18) {
                new commanmethod(HomePage.this, plant18.class);
            } else if (check == 19) {
                new commanmethod(HomePage.this, plant19.class);
            } else if (check == 20) {
                new commanmethod(HomePage.this, plant20.class);
            } else if (check == 21) {
                new commanmethod(HomePage.this, plant21.class);
            } else if (check == 22) {
                new commanmethod(HomePage.this, plant22.class);
            }
            else if (check == 23) {
                new commanmethod(HomePage.this, plant23.class);
            }
            else if (check == 24) {
                new commanmethod(HomePage.this, plant24.class);
            }
            else if (check == 25) {
                new commanmethod(HomePage.this, plant25.class);
            }
            else if (check == 26) {
                new commanmethod(HomePage.this, plant26.class);
            }
            else if (check == 27) {
                new commanmethod(HomePage.this, plant27.class);
            }
            else if (check == 28) {
                new commanmethod(HomePage.this, plant28.class);
            }
            else if (check == 29) {
                new commanmethod(HomePage.this, plant29.class);
            }
            else if (check == 30) {
                new commanmethod(HomePage.this, plant30.class);
            }   else if (check == 31) {
                new commanmethod(HomePage.this, plant31.class);
            }
            else if (check == 32) {
                new commanmethod(HomePage.this, plant32.class);
            }
            else if (check == 33) {
                new commanmethod(HomePage.this, plant33.class);
            }
            else if (check == 34) {
                new commanmethod(HomePage.this, plant34.class);
            }
            else if (check == 35) {
                new commanmethod(HomePage.this, plant35.class);
            }
            else if (check == 36) {
                new commanmethod(HomePage.this, plant36.class);
            }
            else if (check == 37) {
                new commanmethod(HomePage.this, plant37.class);
            }
            else if (check == 38) {
                new commanmethod(HomePage.this, plant38.class);
            }
            else if (check == 39) {
                new commanmethod(HomePage.this, plant39.class);
            }

            else if (check == 41) {
                new commanmethod(HomePage.this, plant41.class);
            }else if (check == 42) {
                new commanmethod(HomePage.this, plant42.class);
            }else if (check == 43) {
                new commanmethod(HomePage.this, plant43.class);
            }else if (check == 44) {
                new commanmethod(HomePage.this, plant44.class);
            }else if (check == 45) {
                new commanmethod(HomePage.this, plant45.class);
            }else if (check == 46) {
                new commanmethod(HomePage.this, plant46.class);
            }else if (check == 47) {
                new commanmethod(HomePage.this, plant47.class);
            }else if (check == 48) {
                new commanmethod(HomePage.this, plant48.class);
            }else if (check == 49) {
                new commanmethod(HomePage.this, plant49.class);
            }else if (check == 50) {
                new commanmethod(HomePage.this, plant50.class);
            }else if (check == 51) {
                new commanmethod(HomePage.this, plant51.class);
            }else if (check == 52) {
                new commanmethod(HomePage.this, plant52.class);
            }else if (check == 53) {
                new commanmethod(HomePage.this, plant53.class);
            }else if (check == 54) {
                new commanmethod(HomePage.this, plant54.class);
            }else if (check == 55) {
                new commanmethod(HomePage.this, plant55.class);
            }else if (check == 56) {
                new commanmethod(HomePage.this, plant56.class);
            }else if (check == 57) {
                new commanmethod(HomePage.this, plant57.class);
            }else if (check == 58) {
                new commanmethod(HomePage.this, plant58.class);
            }else if (check == 59) {
                new commanmethod(HomePage.this, plant59.class);
            }else if (check == 60) {
                new commanmethod(HomePage.this, plant60.class);
            } else if (check==61) {
                new commanmethod(HomePage.this, plant61.class);

            } else if (check==62) {
                new commanmethod(HomePage.this, plant62.class);

            }else {
                new commanmethod(HomePage.this , "Pls Scan Original Qr Code");
            }

//            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    dialogInterface.cancel();
//                }
//            }).show();
        }

    });




    //toolbar clicl event
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_item,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.about_as){
            // go to about as page
            new commanmethod(HomePage.this , aboutas.class);
            Toast.makeText(this , "About as" , Toast.LENGTH_SHORT).show();
        }else{
            // logout and data delate
            String sql = "DELETE FROM USERDATA WHERE USERID='"+sp.getString(commanclass.ID,"")+"'";
            db.execSQL(sql);
            new commanmethod(HomePage.this , MainActivity.class);
            Toast.makeText(this , "Logout" , Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}