package com.a000webhostapp.infopizzalocal.pizzalocal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Menu extends Activity {

    TextView choosen;
    TextView desc;
    TextView cost;
    TextView tv;

    String small;
    String medium;
    String large;
    String pizzaName;

    TextView ssmall;
    TextView mmedium;
    TextView llarge;


    TextView totaltxt;
    int total;
    Button order;
    ListView list;


    String[] web = {"AllowChatPizza Regular","AllowChatPizza Large", "BajaFresh Regular", "BajaFresh Large", "BombayAlloo Regular", "BombayAlloo Large",
            "BombayBBQ Regular", "BombayBBQ Large","TandooriMasala Regular", "TandooriMasala Large", "TandooriPaneer Regular", "TandooriPaneer Large", "Regular Frys",
            "Large Frys", "Large Pepsi"
             };

    String[] price = {
            "400","800","450","900","500","1000","400","800","450","900","500","1000","200","300","100"
    };

    //String small_price[] = { "400", "450", "400", "500", "600", "400", "450", "400", "500", "600", "400", "450", "400", "500"};
    //String medium_price[] = { "600", "650", "700", "600", "650", "650", "700", "600", "650", "700", "600", "650", "650", "700"};
    //String large_price[] = { "800", "850", "900", "950", "1000", "1200", "1000", "900", "800", "850", "900", "950", "1000", "1200"};

    Integer[] imageId = {R.drawable.allowchat, R.drawable.allowchat, R.drawable.bajafresh, R.drawable.bombayalloo, R.drawable.bombaybbq, R.drawable.chktikmasala, R.drawable.currychick, R.drawable.indianveggie,
            R.drawable.limeveggiepizza, R.drawable.tandoorimasala, R.drawable.tandooripaneer, R.drawable.tikkamasala,R.drawable.fries, R.drawable.largefries, R.drawable.pepsi
    };

    String[] quantity= {
            "0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    };

    Integer[] additem={
            R.id.additem
    };

  /*  Integer[] addmedium={
            R.id.addmedium
    };

    Integer[] addlarge={
            R.id.addlarge
    };
*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menuselected);


        tv = findViewById(R.id.tv);
        cost = findViewById(R.id.cost);
        desc = findViewById(R.id.desc);


        totaltxt=(TextView)findViewById(R.id.total);
        order=(Button)findViewById(R.id.order);

        ssmall = findViewById(R.id.small);
        mmedium = findViewById(R.id.medium);
        llarge = findViewById(R.id.large);
        desc = findViewById(R.id.desc);
        choosen = findViewById(R.id.choose);
        //-------------

//        tv.setText(getIntent().getStringExtra("tv"));
        pizzaName = getIntent().getStringExtra("tv");
        small = getIntent().getStringExtra("small");
        medium = getIntent().getStringExtra("medium");
        large = getIntent().getStringExtra("large");
    //    desc.setText(getIntent().getStringExtra("desc"));


        final String [] priceInRs = {small, medium, large};
        final String [] title = {pizzaName};

        //-----------
        CustomList adapter;
        adapter = new CustomList(Menu.this, web, price, imageId,quantity,additem);
        

        list=(ListView)findViewById(R.id.list_menu);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    final int position, long id) {
                Toast.makeText(Menu.this, "You Clicked at " +title[+ position], Toast.LENGTH_SHORT).show();

            }
        });


        totaltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=0;

                for(int i=0;i<quantity.length;i++){
                    total += (Integer.valueOf(quantity[i]) * Integer.valueOf(price[i]));

                    totaltxt.setText("TOTAL =      "+total);
                }
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),order.class);
                i.putExtra("total",total);
                startActivity(i);
            }
        });


    }



}