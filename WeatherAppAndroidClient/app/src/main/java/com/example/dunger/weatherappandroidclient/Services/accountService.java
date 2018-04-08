package com.example.dunger.weatherappandroidclient.Services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.MainActivity;
import com.example.dunger.weatherappandroidclient.Models.Token;
import com.example.dunger.weatherappandroidclient.R;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.example.dunger.weatherappandroidclient.WeatherStationsActivity;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dunger on 2018-04-03.
 */

public class accountService {
    private static Activity activity;

    //Token variables
    private static Token token;
    private static final String PREFERENCES_NAME = "tokenPreferences";

    //View variables
    private EditText usernameEditText;
    private EditText passwordEditText;

    //HTTPConnection variables
    private StringRequest stringRequest;
    private static final String TAG = MainActivity.class.getSimpleName();


    public accountService(Activity activity){
        this.activity=activity;
        initViews();
    }

    private void initViews() {
        usernameEditText = activity.findViewById(R.id.usernameEditText);
        passwordEditText = activity.findViewById(R.id.passwordEditText);
    }


    public void Login() {

        String url = "http://weatherapp-001-site1.gtempurl.com/token";

        stringRequest = new StringRequest(Request.Method.POST, url
        , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                token = new Gson().fromJson(response.toString(), Token.class);
                SetToken();

                Toast.makeText(activity.getApplicationContext(),
                        "Logged in!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity.getApplicationContext(), WeatherStationsActivity.class);
                activity.startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(activity.getApplicationContext(),
                        "Error: Incorrect username or password", Toast.LENGTH_SHORT).show();
            }
        })

        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("grant_type", "password");
                params.put("username", usernameEditText.getText().toString());
                params.put("password", passwordEditText.getText().toString());
                return params;
            }
        };
        RequestQueueSingleton.getInstance(activity).addToRequestQueue(stringRequest); //adding this POST request to request queue
    }

    public static Token GetToken(){
        SharedPreferences prefs = activity.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        String restored_access_token = prefs.getString("access_token", null);
        String restored_token_type = prefs.getString("token_type",null);
        int restored_expires_in = prefs.getInt("expires_in", 0);

        token=new Token(restored_access_token,restored_token_type,restored_expires_in);
        return token;
    }

    public static boolean SetToken(){
        SharedPreferences.Editor editor = activity.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        editor.putString("access_token", token.getAccess_token());
        editor.putString("token_type",token.getToken_type());
        editor.putInt("expires_in", token.getExpires_in());
        return editor.commit();
    }
}


