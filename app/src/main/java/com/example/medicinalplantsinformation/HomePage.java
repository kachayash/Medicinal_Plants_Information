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

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

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
                new commanmethod(HomePage.this, "Profile");
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



}