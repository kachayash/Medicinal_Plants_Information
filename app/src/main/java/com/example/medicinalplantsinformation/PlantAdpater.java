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

                    else if (position == 1) {
                        new  commanmethod(context ,plant2.class);
                    }

                    else if (position == 2) {
                        new  commanmethod(context ,plant3.class);
                    }

                    else if (position == 3) {
                        new  commanmethod(context ,plant4.class);
                    }

                    else if (position == 4) {
                        new  commanmethod(context ,plant5.class);
                    }

                    else if (position == 5) {
                        new  commanmethod(context ,plant6.class);
                    } else if (position==6) {
                        new commanmethod(context, plant7.class);
                    }

                    else if (position == 7) {
                        new commanmethod(context, plant8.class);
                    } else if (position == 8) {
                        new commanmethod(context, plant9.class);
                    } else if (position == 9) {
                        new commanmethod(context, plant10.class);
                    } else if (position == 10) {
                        new commanmethod(context, plant11.class);
                    } else if (position == 11) {
                        new commanmethod(context, plant12.class);
                    } else if (position == 12) {
                        new commanmethod(context, plant13.class);
                    } else if (position == 13) {
                        new commanmethod(context, plant14.class);
                    } else if (position == 14) {
                        new commanmethod(context, plant15.class);
                    } else if (position == 15) {
                        new commanmethod(context, plant16.class);
                    } else if (position == 16) {
                        new commanmethod(context, plant17.class);
                    } else if (position == 17) {
                        new commanmethod(context, plant18.class);
                    } else if (position == 18) {
                        new commanmethod(context, plant19.class);
                    } else if (position == 19) {
                        new commanmethod(context, plant20.class);
                    } else if (position == 20) {
                        new commanmethod(context, plant21.class);
                    } else if (position == 21) {
                        new commanmethod(context, plant22.class);
                    } else if (position == 22) {
                        new commanmethod(context, plant23.class);
                    }else if (position == 23) {
                        new commanmethod(context, plant24.class);
                    }else if (position == 24) {
                        new commanmethod(context, plant25.class);
                    }else if (position == 25) {
                        new commanmethod(context, plant26.class);
                    }else if (position == 26) {
                        new commanmethod(context, plant27.class);
                    }else if (position == 27) {
                        new commanmethod(context, plant28.class);
                    }else if (position == 28) {
                        new commanmethod(context, plant29.class);
                    }else if (position == 29) {
                        new commanmethod(context, plant30.class);
                    }else if (position == 30) {
                        new commanmethod(context, plant31.class);
                    }else if (position == 31) {
                        new commanmethod(context, plant32.class);
                    }else if (position == 32) {
                        new commanmethod(context, plant33.class);
                    }else if (position == 33) {
                        new commanmethod(context, plant34.class);
                    }else if (position == 34) {
                        new commanmethod(context, plant35.class);
                    }else if (position == 35) {
                        new commanmethod(context, plant36.class);
                    }else if (position == 36) {
                        new commanmethod(context, plant37.class);
                    }else if (position == 37) {
                        new commanmethod(context, plant38.class);
                    }else if (position == 38) {
                        new commanmethod(context, plant39.class);
                    }


                    else if (position == 39) {
                        new commanmethod(context, plant41.class);
                    }else if (position == 40) {
                        new commanmethod(context, plant42.class);
                    }else if (position == 41) {
                        new commanmethod(context, plant43.class);
                    }else if (position == 42) {
                        new commanmethod(context, plant44.class);
                    }else if (position == 43) {
                        new commanmethod(context, plant45.class);
                    }else if (position == 44) {
                        new commanmethod(context, plant46.class);
                    }else if (position == 45) {
                        new commanmethod(context, plant47.class);
                    }else if (position == 46) {
                        new commanmethod(context, plant48.class);
                    }else if (position == 47) {
                        new commanmethod(context, plant49.class);
                    }else if (position == 48) {
                        new commanmethod(context, plant50.class);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
