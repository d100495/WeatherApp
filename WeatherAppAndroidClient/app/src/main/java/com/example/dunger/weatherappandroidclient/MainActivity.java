package com.example.dunger.weatherappandroidclient;

import android.app.VoiceInteractor;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    //View variables
    private Button TestButton;
    private EditText usernameEditText;
    private EditText passwordEditText;



    //HTTPConnection variables
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private static final String TAG = MainActivity.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FindViewById
        TestButton = findViewById(R.id.TestButton);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);



        TestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Method_GETAll();
                Login();
            }
        });

    }


    //Methods for HTTP connection
    private void Method_GETAll() {

                String url="http://weatherapp-001-site1.gtempurl.com/api/weatherstation/getall";

                requestQueue = Volley.newRequestQueue(MainActivity.this);

                stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG,"Response: "+ response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG,"Error: "+ error.toString());
                    }
                });
                requestQueue.add(stringRequest);

    }//GetAll


    private void Login() {

                String url = "http://weatherapp-001-site1.gtempurl.com/token";
                String accountUrl = "http://weatherapp-001-site1.gtempurl.com/api/account";

                requestQueue = Volley.newRequestQueue(MainActivity.this);

                stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG,"Response: "+ response.toString());
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


    }//Post



}
