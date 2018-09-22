package com.a000webhostapp.infopizzalocal.pizzalocal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignUp extends AppCompatActivity {

    EditText edusername, edemail, edpassword;

    Button btnsubmit;
    TextView tvlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        edusername = findViewById(R.id.edusername);
        edemail = findViewById(R.id.edemail);
        edpassword = findViewById(R.id.edpassword);
        tvlogin = findViewById(R.id.tvlogin);

        btnsubmit = findViewById(R.id.btnsubmit);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://infopizzalocal.000webhostapp.com").build();
                MyConnection my = restAdapter.create(MyConnection.class);
                my.student_registration(edusername.getText().toString(), edemail.getText().toString(), edpassword.getText().toString(), new Callback<Response>() {
                    @Override
                    public void success(Response response, Response response2) {
                        Toast.makeText(SignUp.this, "Registration sucessfully done", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void failure(RetrofitError error) {

                        Toast.makeText(SignUp.this, "error"+error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this, SignIn.class);
                startActivity(i);
            }
        });
    }

   }