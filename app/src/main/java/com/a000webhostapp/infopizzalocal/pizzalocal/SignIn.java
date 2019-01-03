package com.a000webhostapp.infopizzalocal.pizzalocal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SignIn extends AppCompatActivity {

    EditText ed1, ed2;
    TextView tv;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        ed1 = findViewById(R.id.edloginemail);
        ed2 = findViewById(R.id.edloginpassword);
        login = findViewById(R.id.btnlogin);

        tv = findViewById(R.id.tv_register);

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://infopizzalocal.000webhostapp.com").build();
                MyConnection my = restAdapter.create(MyConnection.class);
                my.login(ed1.getText().toString(), ed2.getText().toString(), new Callback<Response>() {

                    @Override
                    public void success(Response response, Response response2) {

                            Toast.makeText(SignIn.this, " login done", Toast.LENGTH_SHORT).show();

                            Intent inten = new Intent(SignIn.this, PizzaLocalHome.class);
                            startActivity(inten);

                        try {

                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getBody().in()));
                                String data = bufferedReader.readLine();

                                JSONArray jarr = new JSONArray(data);

                                for(int i = 0; i<jarr.length(); i++){

                                    JSONObject jobj = jarr.getJSONObject(i);
                                    String username = jobj.getString("username");
                                    Toast.makeText(SignIn.this, "Welcome" + username, Toast.LENGTH_SHORT).show();
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignIn.this, SignUp.class);
                startActivity(i);
            }
        });
    }
}
