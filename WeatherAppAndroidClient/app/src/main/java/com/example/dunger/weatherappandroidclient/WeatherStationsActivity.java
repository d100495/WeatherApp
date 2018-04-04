package com.example.dunger.weatherappandroidclient;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.dunger.weatherappandroidclient.Models.Token;
import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.Volley.RequestQueueSingleton;
import com.google.gson.Gson;

import junit.framework.Test;

import java.util.HashMap;
import java.util.Map;

import static com.example.dunger.weatherappandroidclient.MainActivity.token;

public class WeatherStationsActivity extends AppCompatActivity {


    //Variables for GSON
    WeatherStation[] stations;

    //UI variables
    Button TestButton;
    TextView TestTextView;
    ListView listView1;

    //HTTPConnection variables
    private StringRequest stringRequest;
    private static final String TAG = WeatherStationsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_stations);

        initViews();
//        getIntentInfo();

        GetWeatherStations();


        //TODO Debug info
        TestTextView.setMovementMethod(new ScrollingMovementMethod());

        TestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TestTextView.append(
                        "\nJSON Obj: "+
                                "\naccess_token: "+token.getAccess_token() +
                                "\n\nToken_type: "+token.getToken_type() +
                                "\n\nExpires_in: "+token.getExpires_in());
            }
        });


    }//onCreate


    private void GetWeatherStations() {

        String url="http://weatherapp-001-site1.gtempurl.com/api/weatherstation/getall";


        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //TODO Debug info
                Log.i("===============================================","===============================================");
                Log.i(TAG,"\n\nToken: "+ token.toString());
                Log.i(TAG,"\n\nResponse: "+ response.toString());
                Log.i(TAG,"\n\nApplicationContext: "+ getApplicationContext().toString());
                Log.i(TAG,"\n\nBaseContext: "+ getBaseContext().toString());
                Log.i(TAG,"\n\nWeatherStationsActivity.this: "+ WeatherStationsActivity.this);
                Log.i(TAG,"\n\nthis: "+ this);

                stations = new Gson().fromJson(response.toString(), WeatherStation[].class);
                PopulateWeatherStationsListView();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"CONNECTION Error: "+ error.toString());
            }
        })

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("Authorization", token.getToken_type().toString()+" "+token.getAccess_token().toString());
                return params;
            }
        };
        RequestQueueSingleton.getInstance(this).addToRequestQueue(stringRequest);
    }//GetAll

    private void initViews(){
        TestButton=findViewById(R.id.TestButton2);
        TestTextView = findViewById(R.id.TestTextView2);
        listView1 =  findViewById(R.id.listView1);
    }

   /* private void getIntentInfo(){
        //Getting token from intent
        Intent intent = getIntent();
        String t = intent.getExtras().getString("token");
        token = new Gson().fromJson(t.toString(),Token.class);
    }*/


    private void PopulateWeatherStationsListView() {
        if(stations!=null)
        {
            //TODO Debug info
            for (WeatherStation x: stations) {
                TestTextView.append("\n"+x.wholeString() + "\n");
            }

            ArrayAdapter<WeatherStation> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stations);
            listView1.setAdapter(adapter);
        }
        else
        {
            Log.i(TAG,"\n\nStations==NULL");
        }

    }



}
