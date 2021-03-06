package com.example.dunger.weatherappandroidclient;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dunger.weatherappandroidclient.UI.NavigationBar;

import java.util.ArrayList;
import java.util.List;

public class OptionsActivity extends AppCompatActivity {

    //Options variables
    private static final String PREFERENCES_NAME = "APIPreferences";
    private static OptionsActivity optionsActivity;
    //UI Variables
    List<ImageView> APIs;
    ImageView imageViewOpenWeatherMap;
    ImageView imageViewApixu;
    ImageView imageViewInfomet;

    public static boolean SaveChosenAPIoptionInMemory(String API) {
        SharedPreferences.Editor editor = optionsActivity.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit();
        editor.putString("API", API);
        return editor.commit();
    }

    public static String GetChosenAPI(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        String restored_Chosen_API = prefs.getString("API", null);
        if (!(restored_Chosen_API == null)) {
            return restored_Chosen_API;
        } else {
            return activity.getResources().getString(R.string.APIoption_Apixu);
        }
    }

    private void initViews() {
        imageViewApixu = findViewById(R.id.imageViewApixu);
        imageViewOpenWeatherMap = findViewById(R.id.imageViewOpenWeatherMap);
        imageViewInfomet = findViewById(R.id.imageViewInfomet);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        initViews();

        optionsActivity = this;

        APIs = new ArrayList<>();
        APIs.add(imageViewApixu);
        APIs.add(imageViewOpenWeatherMap);
        APIs.add(imageViewInfomet);
        //Add more ImageViews here

        SetAlphaAndImageViewOnClickListeners(APIs);

        //TODO static getInstance() for navigation bar
        NavigationBar navigationBar = new NavigationBar(this); //required if navigation bar exists in this activity_layout
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//required if navigation bar exists in this activity_layout
    }

    private void SetAlphaAndImageViewOnClickListeners(final List<ImageView> imageViews) {
        for (final ImageView imageView : imageViews) {
            if (imageView.getTag().equals(GetChosenAPI(optionsActivity))) {
                imageView.setAlpha(1f);
            } else {
                imageView.setAlpha(0.3f);
            }

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (ImageView imageView : imageViews) {
                        imageView.setAlpha(0.3f);
                    }
                    SaveChosenAPIoptionInMemory(view.getTag().toString());
                    view.setAlpha(1f);
                    Toast.makeText(getApplicationContext().getApplicationContext(),
                            view.getTag().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Navigation bar
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
        switch (item.getItemId()) {
            case android.R.id.home:
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);  // OPEN DRAWER
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }//required if navigation bar exists in this activity_layout
}
