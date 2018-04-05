package com.example.dunger.weatherappandroidclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.Token;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static Token token;

    //View variables
    private Button LoginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;

    //HTTPConnection variables
    private StringRequest stringRequest;
    private static final String TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });

    }


    private void Login() {

        String url = "http://weatherapp-001-site1.gtempurl.com/token";
        //String accountUrl = "http://weatherapp-001-site1.gtempurl.com/api/account";

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "Response: " + response.toString());

                token = new Gson().fromJson(response.toString(), Token.class);

                //TODO Delete Debug info
                Log.i(TAG, "JSON Obj: " +
                        "\naccess_token: " + token.getAccess_token() +
                        "\nToken_type: " + token.getToken_type() +
                        "\nExpires_in: " + token.getExpires_in() + "\n\n");

                Toast.makeText(getApplicationContext(),
                        "Logged in!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), WeatherStationsActivity.class);
//                        intent.putExtra("token", response.toString());
                startActivity(intent);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //TODO Delete Debug info
                Log.i(TAG, "Error: " + error.toString());
                Toast.makeText(getApplicationContext(),
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
        RequestQueueSingleton.getInstance(this).addToRequestQueue(stringRequest);
    }//Post


    private void initViews() {
        LoginButton = findViewById(R.id.LoginButton);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }

}
