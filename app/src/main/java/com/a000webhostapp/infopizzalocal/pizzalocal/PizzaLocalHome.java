package com.a000webhostapp.infopizzalocal.pizzalocal;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class PizzaLocalHome extends AppCompatActivity {

//------
ProgressDialog pd;
//String url = "https://api.myjson.com/bins/10z0ry";
String url = "https://api.myjson.com/bins/178ity";
    //-------
    RecyclerView rev;
    BottomNavigationView btm;
    /*String title[] = {"AllowChatPizza","BajaFresh", "BombayAlloo",
            "BombayBBQ","ChkTikMasala", "CurryChick",
            "DesiCombo", "IndianVeggie", "LimeVeggiePizza",
            "TandooriMasala", "TandooriPaneer", "TikkaMasala",
            "VegTikkaMasala", "currypizza"};*/
    
    Integer img[] = {R.drawable.allowchat, R.drawable.bajafresh, R.drawable.bombayalloo, R.drawable.bombaybbq, R.drawable.chktikmasala, R.drawable.currychick, R.drawable.desicombo, R.drawable.indianveggie,
            R.drawable.limeveggiepizza, R.drawable.tandoorimasala, R.drawable.tandooripaneer, R.drawable.tikkamasala,R.drawable.vegtikkamasala, R.drawable.currypizza
    };

  /*  String desc[] = { "Red Sauce, Mozzarella Cheese, Mint, Red Onions, Aloo Chaat, Garlic, Ginger, Chilli, Chilantro",
                      "Garlic Sauce, Cheese, Mushrooms, Onion, pineapple, bloak olives, chopped garlic",
                      "Bombay alloo, artichokes heart, green peppers, black olives",
                      "Barbeque sauce, cilantro, mint, mixed veg, burnt onion & garlic",
                      "Tikka sauce, tikka chicken, mozzarella cheese, mushrooms, red onions, bell peppers, garlic, ginger, fresh chilantro, green chillies",
                      "curry sause, curry chicken, mozzarella cheese, red onions, garlic, ginger, jalapeno",
                      "Sauce, cheese, pepperoni, mushrooms, red onions, green peppers, italian sausage, garlic chicken, chopped garlic, ginger, jalapeno",
                      "red sauce or white sauce, mozarella cheese, mushrooms, olive, red onion, tomatoes, bell pepper, garlic, ginger, fresh chilantro, chillies",
                      "red onion, tomatoes, bell peper, fresh diced cucumber, green onion, lime, green chilli, mushrooms, black olive",
                      "tandoori sauce, jalapeno, chilli, mushromm, red onion, tomatoes, garlic, ginger",
                      "tikka sauce, cheese, mushrooms, bell pepers, red onion, tomatoes, garlic, ginger, tikka paneer, frsh chilantor",
                      "tikka sauce, tikka chicken, mushrooms, bellpepper, onion, garlick jalapenao",
                      "tikka saurce, pesto sauce, spinach ginger, garlick, oion, green chillies",
                      "curry sauce, cheese, black olive, red onion, tomaotes, chilli"

    };*/

    String small_price[] = { "400", "450", "400", "500", "600", "400", "450", "400", "500", "600", "400", "450", "400", "500"};
    String medium_price[] = { "600", "650", "700", "600", "650", "650", "700", "600", "650", "700", "600", "650", "650", "700"};
    String large_price[] = { "800", "850", "900", "950", "1000", "1200", "1000", "900", "800", "850", "900", "950", "1000", "1200"};

    ArrayList<GetterSetter> al = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizzalocalhome);


        rev = findViewById(R.id.rev);
        //----------
        pd = new ProgressDialog(PizzaLocalHome.this);

        new MyClass().execute();

        //---------
        btm = findViewById(R.id.btm);


        btm.setOnNavigationItemSelectedListener(

                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected( MenuItem item) {

                        Fragment selectedFrag = null;

                        switch(item.getItemId()){

                            case R.id.op_menu:
                                selectedFrag = new MenuFragment();
                                break;


                            case R.id.op_cart:
                                selectedFrag = new CartFragment();
                                break;

                            case R.id.op_accounts:
                                selectedFrag = new AccountsFragment();
                                break;
                        }

                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();

                        return true;
                    }
                });



        /*RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PizzaLocalHome.this);
        rev.setLayoutManager(layoutManager);

        for(int i=0; i<img.length; i++){

            GetterSetter g1 = new GetterSetter(title[i], img[i], desc[i], small_price[i], medium_price[i], large_price[i]);
            al.add(g1);

            MyAdapter my = new MyAdapter(PizzaLocalHome.this, al);

            rev.setAdapter(my);

        }*/


    }

    private class MyClass extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {


            MyOkHttpClient myConnection = new MyOkHttpClient();
            try {
                JSONArray jsonArray = myConnection.getData(url);

                for(int i = 0; i <jsonArray.length(); i++){

                    JSONObject jobj = jsonArray.getJSONObject(i);
                    String c_name = jobj.getString("zip");
                    String city = jobj.getString("city");
                    String c_id = jobj.getString("restaurant");
                    String i_image = jobj.getString("Visit us");
                   // Integer img = Integer.parseInt(image);
                             
                  //  GetterSetter g1 = new GetterSetter(c_name, img[i], c_id, small_price[i], medium_price[i], large_price[i]);
                    GetterSetter g2 = new GetterSetter(c_id, i_image, city, c_name);
                    al.add(g2);

                   /* al.add(c_name);
                    al.add(s_size);
                    al.add(c_id);
                    al.add(image);*/
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if(pd.isShowing()){
                pd.dismiss();
            }

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PizzaLocalHome.this);
            rev.setLayoutManager(layoutManager);

            MyAdapter my = new MyAdapter(PizzaLocalHome.this, al);

            rev.setAdapter(my);

           /* ArrayAdapter adapter = new ArrayAdapter(PizzaLocalHome.this, android.R.layout.simple_list_item_1, al);
            lv.setAdapter(adapter);*/
        }
    }

}
