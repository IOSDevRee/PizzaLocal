package com.a000webhostapp.infopizzalocal.pizzalocal;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

public class MyOkHttpClient {

    JSONArray jsonArray;
    Request request;
    Response response;
    String data;

    public JSONArray getData(String url) throws IOException, JSONException {

        OkHttpClient okHttpClient = new OkHttpClient();
        request = new Request.Builder().url(url).build();

        response = okHttpClient.newCall(request).execute();
        data = response.body().string();

        jsonArray = new JSONArray(data);

        return jsonArray;
    }
}
