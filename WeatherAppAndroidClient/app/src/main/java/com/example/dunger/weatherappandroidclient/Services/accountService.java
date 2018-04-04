package com.example.dunger.weatherappandroidclient.Services;

import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dunger.weatherappandroidclient.MainActivity;
import com.example.dunger.weatherappandroidclient.Models.Token;
import com.example.dunger.weatherappandroidclient.WeatherStationsActivity;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dunger on 2018-04-03.
 */


public class accountService {


/*    //HTTPConnection variables
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private static final String TAG = MainActivity.class.getName();

    static Token token;

    private void Login() {

        String url = "http://weatherapp-001-site1.gtempurl.com/token";
        //String accountUrl = "http://weatherapp-001-site1.gtempurl.com/api/account";

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG,"Response: "+ response.toString());

                Token t = new Gson().fromJson(response.toString(),Token.class);

                Log.i(TAG,"JSON Obj: "+
                        "\naccess_token: "+t.getAccess_token() +
                        "\nToken_type: "+t.getToken_type() +
                        "\nExpires_in: "+t.getExpires_in()+"\n\n");

                Intent intent = new Intent(this, WeatherStationsActivity.class);

                intent.putExtra("token", response.toString());
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"Error: "+ error.toString());
            }
        })

        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("grant_type", "password");
                params.put("username", usernameEditText.getText().toString());
                params.put("password", passwordEditText.getText().toString());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }//Post*/
}
