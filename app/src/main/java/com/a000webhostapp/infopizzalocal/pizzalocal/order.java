package com.a000webhostapp.infopizzalocal.pizzalocal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class order extends AppCompatActivity {


    TextView urtotal;
    EditText address;
    Button pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        urtotal=(TextView)findViewById(R.id.urtotal);
        int b;
        b=0;
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            b=extras.getInt("total");
        }

        urtotal.setText("Rs."+b);

        address=(EditText)findViewById(R.id.address);
        pay=(Button)findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(address.getText()==null){
                    Toast.makeText(order.this, "Please fill the Address!",
                            Toast.LENGTH_LONG).show();
                }
                Toast.makeText(order.this, "Payment portal not active!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
