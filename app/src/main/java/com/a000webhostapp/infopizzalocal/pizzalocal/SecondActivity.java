package com.a000webhostapp.infopizzalocal.pizzalocal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class SecondActivity extends AppCompatActivity {

    private RadioGroup rg;

    TextView choosen;
    TextView desc;
    TextView small;
    TextView medium;
    TextView large;
    TextView tv;
    Button add;
    BottomNavigationView btm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        addListenerOnButton();

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

        tv = findViewById(R.id.tv);
        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);
        large = findViewById(R.id.large);
        desc = findViewById(R.id.desc);
        choosen = findViewById(R.id.choose);


        tv.setText(getIntent().getStringExtra("tv"));
        small.setText(getIntent().getStringExtra("small"));
        medium.setText(getIntent().getStringExtra("medium"));
        large.setText(getIntent().getStringExtra("large"));
        desc.setText(getIntent().getStringExtra("desc"));

        add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Menu.class);
                intent.putExtra("small",getIntent().getStringExtra("small") );
                intent.putExtra("medium",getIntent().getStringExtra("medium") );
                intent.putExtra("large", getIntent().getStringExtra("large"));
                intent.putExtra("desc", getIntent().getStringExtra("desc"));
                intent.putExtra("tv", getIntent().getStringExtra("tv"));

                startActivity(intent);
            }
        });


    }

    public void addListenerOnButton() {

        rg = (RadioGroup) findViewById(R.id.radio);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){

                    case R.id.small:
                        Toast.makeText(SecondActivity.this,
                                small.getText(), Toast.LENGTH_SHORT).show();

                        choosen.setText("Small Pizza Rs: " +(CharSequence) small.getText());

                        break;

                    case R.id.medium:
                        Toast.makeText(SecondActivity.this,
                                medium.getText(), Toast.LENGTH_SHORT).show();

                        choosen.setText("Medium Pizza Rs: " +(CharSequence) medium.getText());
                        break;

                    case R.id.large:
                        Toast.makeText(SecondActivity.this,
                                large.getText(), Toast.LENGTH_SHORT).show();

                        choosen.setText("Large Pizza Rs: " +(CharSequence) large.getText());
                        break;
                }
            }
        });


    }

}
