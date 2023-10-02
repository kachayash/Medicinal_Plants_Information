package com.example.medicinalplantsinformation;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class commanmethod {

    commanmethod(Context context , String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    commanmethod(Context context , Class<?> nextClass){
        Intent intent = new Intent(context , nextClass);
        context.startActivity(intent);
    }


}
