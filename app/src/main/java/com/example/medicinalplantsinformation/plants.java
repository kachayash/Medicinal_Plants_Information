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
    public static ArrayList<ModelClass> searchlist;


    String [] plantsname =
            {"Acacia nilotica" ,
                    "Acalypha indica" ,
                    "Allium sativum",
                    "Anethum graveolens",
                    "Argyreia nervosa",
                    "Asparagus racemosus" ,
                    "Barleria Prionitis",
//                    8
                    "Cajanus Cajan",
//                    9
                    "Calotropis procera",

    //                    10
                    "Cannabis Sativa",
//                    11
                    "Capsicum Annuum",
//                    12
                    "Carica Papaya",
//                    13
                    "Celastrus Paniculata",
//                    14
                    "Centella Asiatica",
//                    15
                    "Cinnamomum Camphora",
//                    16
                    "Cinnamomum Varum",
//                    17
                    "Citrullus Colocynthis",
//                    18
                    "Citrus Limon",
//                    19
                    "Clerodendrum Phlomidis",
//                    20
                    "Cocos Nucifera",
//                    21
                    "Commiphora Wightii",
//                    22
                    "Coriandrum sativum",
//                    23
                    "Costus speciosus",
//                    24
                    "Cucumis melo ",
//                    25
                    "Curculigo orchioides",
//                    26
                    "Curcuma longa",
//                    27
                    "Datura fastuosa",
//                    28
                    "Embelia Ribes",
//                    29
                    "Feronia Limonia",
//                    30
                    "Ficus amplissima",
//                    31
                    "Foeniculum vulgare mills",
//                    32
                    "Gaultheria Fragra",
//                    33
                    "Gerwia Tenax",
//                    34
                    "Gloriosa Superba",
//                    35
                    "Gmelina arborea",
//                    36
                    "Helianthus annuus",
//                    37
                    "Hemianthus indicus",
//                    38
                    "Holarrhena pubescens",
//                    39
                    "Hydrolea Zeylanica vahl",
//                    40
//                    41
                    "Ipomoea turbinata",
//                    42
                    "Lepidium sativum",
//                    43
                    "Lycium barbarum",
//                    44
                    "Moringa oleifera ",
//                    45
                    "Musa paradisiaca",
//                    46
                    "Nicotiana tabacum",
//                    47
                    "Ocinrnm basilicum",
//                    48
                    "Pennisetum americanum",
//                    49
                    "Pergularia daemia",
//                    50
                    "Phoenix sylvestris"
            };
    String [] localname = {
            "Baval" ,
            "Dadro",
            "Lasan",
            "Suva",
            "Vardharo",
            "Vechhekato",
            "Kantashario",
//            8
            "Tuver",
//            9
            "Ankdo",
//            10
            "Bhang",
//            11
            "Marchi",
//            12
            "Papaya",
//            13
            "Malkankni",
//            14
            "Brahmi",
//            15
            "Kapur",
//            16
            "Taj",
//            17
            "Indravarna",
//            18
            "Limbu",
//            19
            "Arani",
//            20
            "Nariel",
//            21
            "Gugal",
//            22
            "Dhana",
//            23
            "Pokramul",
//            24
            "Methi",

//            25
            "Kalimusli",
//            26
            "Haldar",
//            27
            "Dhatura",
//            28
            "Vavding",
//            29
            "Kathi",
//            30
            "Pipal",
//            31
            "Variyali",
//            32
            "Himantharet",
//            33
            "Gangeti",
//            34
            "Vachhanag",
//            35
            "Shevan",
//            36
            "Suryamukhi",
//            37
            "Anantvel",
//            38
            "Indrajav",
//            39
            "Kerite",
//            40
//            41
            "Vajval",
//            42
            "Aselio",
//            43
            "Kachoro",
//            44
            "Sargavo",
//            45
            "Kel",
//            46
            "Tambaku",
//            47
            "Marvo",
//            48
            "Bajro",
//            49
            "Nagladudheli",
//            50
            "Khajuri"
    };



    int[] img = {R.drawable.acacia_nolotica ,R.drawable.acalypha_indica,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,R.drawable.p20,R.drawable.p21,R.drawable.p22,R.drawable.p23,R.drawable.p24,R.drawable.p25,R.drawable.p26,
            R.drawable.p27,
            R.drawable.p28,
            R.drawable.p29,
            R.drawable.p30,
            R.drawable.p31,
            R.drawable.p32,
            R.drawable.p33,
            R.drawable.p34,
            R.drawable.p35,
            R.drawable.p36,
            R.drawable.p37,
            R.drawable.p38,
            R.drawable.p39,
            R.drawable.p41,
            R.drawable.p42,
            R.drawable.p43,
            R.drawable.p44,
            R.drawable.p45,
            R.drawable.p46,
            R.drawable.p47,
            R.drawable.p48,
            R.drawable.p49,
            R.drawable.p50

    };




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