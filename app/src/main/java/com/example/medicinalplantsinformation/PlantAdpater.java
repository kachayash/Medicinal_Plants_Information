package com.example.medicinalplantsinformation;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlantAdpater  extends  RecyclerView.Adapter<PlantAdpater.MyHolder>{

    Context context;
    ArrayList<ModelClass>arrayList;
    LayoutInflater layoutInflater;
    SharedPreferences sp;
    public PlantAdpater( Context context, ArrayList<ModelClass> arrayList) {

        this.context = context;
        this.arrayList = arrayList;
        layoutInflater=LayoutInflater.from(context);
        sp = context.getSharedPreferences(commanclass.PREF,Context.MODE_PRIVATE);

    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.card,parent,false);

        return new MyHolder(view);
    }


    public class MyHolder extends   RecyclerView.ViewHolder {


        TextView plantn , ln;
        ImageView img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            plantn = itemView.findViewById(R.id.textview_plant_name);
            ln = itemView.findViewById(R.id.local_name_plants);
            img = itemView.findViewById(R.id.image_card);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.plantn.setText(arrayList.get(position).getPlantsname());
            holder.ln.setText(arrayList.get(position).getLocalname());
            holder.img.setImageResource(arrayList.get(position).getImg());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == 0){
                        new commanmethod(context , plantone.class);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
