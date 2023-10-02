package com.example.medicinalplantsinformation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class plants extends AppCompatActivity {


    Context context;

    SearchView searchView;

    RecyclerView recyclerView;

    ArrayList<ModelClass> arrayList = new ArrayList<>();
    ArrayList<ModelClass> searchlist;


    String [] plantsname = {"Acacia nilotica" , "Acalypha indica"};
    String [] localname = {"Baval" ,"Dadro"};



    int[] img = {R.drawable.acacia_nolotica ,R.drawable.acalypha_indica};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plants);

        context=this;

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search_view);

        //data add arraylist
        for (int i = 0 ; i < plantsname.length;i++){

            //set data in array list

            ModelClass modelClass= new ModelClass();
            modelClass.setPlantsname(plantsname[i]);
            modelClass.setLocalname(localname[i]);
            modelClass.setImg(img[i]);

            //add data in array
            arrayList.add(modelClass);
        }


        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        PlantAdpater adpater = new PlantAdpater(plants.this , arrayList);
        recyclerView.setAdapter(adpater);

        searchView.setIconified(false);
        searchView.clearFocus();

        //searchview
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchlist =    new ArrayList<>();
                if(query.length()>0) {

                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getPlantsname().toUpperCase().contains(query.toUpperCase()) || arrayList.get(i).getLocalname().toUpperCase().contains(query.toUpperCase())) {
                            ModelClass modelClass = new ModelClass();
                            modelClass.setPlantsname(arrayList.get(i).getPlantsname());
                            modelClass.setLocalname(arrayList.get(i).getLocalname());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchlist.add(modelClass);

                        }

                    }
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    PlantAdpater adpater = new PlantAdpater(plants.this , searchlist);
                    recyclerView.setAdapter(adpater);
                }
                else {

                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());

                    PlantAdpater adpater = new PlantAdpater(plants.this , arrayList);
                    recyclerView.setAdapter(adpater);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                searchlist =    new ArrayList<>();
                if(s.length()>0) {

                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).getPlantsname().toUpperCase().contains(s.toUpperCase()) || arrayList.get(i).getLocalname().toUpperCase().contains(s.toUpperCase())) {
                            ModelClass modelClass = new ModelClass();
                            modelClass.setPlantsname(arrayList.get(i).getPlantsname());
                            modelClass.setLocalname(arrayList.get(i).getLocalname());
                            modelClass.setImg(arrayList.get(i).getImg());
                            searchlist.add(modelClass);

                        }

                    }
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    PlantAdpater adpater = new PlantAdpater(plants.this , searchlist);
                    recyclerView.setAdapter(adpater);
                }
                else {

                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());

                    PlantAdpater adpater = new PlantAdpater(plants.this , arrayList);
                    recyclerView.setAdapter(adpater);
                }
                return false;
            }
        });



    }
}