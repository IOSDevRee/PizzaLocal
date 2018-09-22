package com.a000webhostapp.infopizzalocal.pizzalocal;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class PizzaLocalHome extends AppCompatActivity {

    RecyclerView rev;
    BottomNavigationView btm;
    String title[] = {"AllowChatPizza","BajaFresh", "BombayAlloo",
            "BombayBBQ","ChkTikMasala", "CurryChick",
            "DesiCombo", "IndianVeggie", "LimeVeggiePizza",
            "TandooriMasala", "TandooriPaneer", "TikkaMasala",
            "VegTikkaMasala", "currypizza"};
    int img[] = {R.mipmap.allowchat, R.mipmap.bajafresh, R.mipmap.bombayalloo, R.mipmap.bombaybbq, R.mipmap.chktikmasala, R.mipmap.currychick, R.mipmap.desicombo, R.mipmap.indianveggie,
            R.mipmap.limeveggiepizza, R.mipmap.tandoorimasala, R.mipmap.tandooripaneer, R.mipmap.tikkamasala,R.mipmap.vegtikkamasala, R.mipmap.currypizza
    };

    String desc[] = { "Red Sauce, Mozzarella Cheese, Mint, Red Onions, Aloo Chaat, Garlic, Ginger, Chilli, Chilantro",
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

    };

    String small_price[] = { "400", "450", "400", "500", "600", "400", "450", "400", "500", "600", "400", "450", "400", "500"};
    String medium_price[] = { "600", "650", "700", "600", "650", "650", "700", "600", "650", "700", "600", "650", "650", "700"};
    String large_price[] = { "800", "850", "900", "950", "1000", "1200", "1000", "900", "800", "850", "900", "950", "1000", "1200"};

    ArrayList<GetterSetter> al = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizzalocalhome);

        rev = findViewById(R.id.rev);
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

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PizzaLocalHome.this);
        rev.setLayoutManager(layoutManager);

        for(int i=0; i<img.length; i++){

            GetterSetter g1 = new GetterSetter(title[i], img[i], desc[i], small_price[i], medium_price[i], large_price[i]);
            al.add(g1);

            MyAdapter my = new MyAdapter(PizzaLocalHome.this, al);

            rev.setAdapter(my);

        }


    }
}
