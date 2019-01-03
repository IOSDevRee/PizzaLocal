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

public class PizzaRestaurants extends AppCompatActivity {

    //------
    ProgressDialog pd;
    String url = "https://api.myjson.com/bins/10z0ry";
   // String url = "https://api.myjson.com/bins/178ity";
    //-------
    RecyclerView rev;
    BottomNavigationView btm;

    ArrayList<GetterSetter> al = new ArrayList<>();
    String small_price[] = { "400", "450", "400", "500", "600", "400", "450", "400", "500", "600", "400", "450", "400", "500"};
    String medium_price[] = { "600", "650", "700", "600", "650", "650", "700", "600", "650", "700", "600", "650", "650", "700"};
    String large_price[] = { "800", "850", "900", "950", "1000", "1200", "1000", "900", "800", "850", "900", "950", "1000", "1200"};
    String price[] = { "600", "650", "700", "600", "650", "650", "700", "600", "650", "700", "600", "650", "650", "700"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizzarestaurants);


        rev = findViewById(R.id.rev);
        //----------
        pd = new ProgressDialog(PizzaRestaurants.this);

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
                    String Pizza = jobj.getString("Pizza");
                    String size = jobj.getString("size");
                    String toppings = jobj.getString("Toppings");
                    String i_image = jobj.getString("Visit us");
                    GetterSetter g1 = new GetterSetter(Pizza, i_image, toppings, small_price[i], medium_price[i], large_price[i]);

                    al.add(g1);
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

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PizzaRestaurants.this);
            rev.setLayoutManager(layoutManager);

            MenuAdapter my = new MenuAdapter(PizzaRestaurants.this, al);

            rev.setAdapter(my);

        }
    }

}
