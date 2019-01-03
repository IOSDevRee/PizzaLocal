package com.a000webhostapp.infopizzalocal.pizzalocal;

import android.content.Intent;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btnSignIn, btnSignUp;
    BottomNavigationView btm;
    TextView txtSogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignUp = findViewById(R.id.btnSignUp);
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

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSignIn();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity();
            }
        });
    }

    public void openActivity(){
        Intent intent = new Intent(MainActivity.this, SignUp.class);
        startActivity(intent);
    }

    public void openSignIn(){
        Intent intent = new Intent(MainActivity.this, PizzaLocalHome.class);
        startActivity(intent);
    }
}
