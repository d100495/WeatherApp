package com.example.dunger.weatherappandroidclient;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.Services.FavoritesService;
import com.example.dunger.weatherappandroidclient.UI.FavoritesListAdapter;
import com.example.dunger.weatherappandroidclient.UI.NavigationBar;

import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    static FavoritesActivity favoritesActivity;

    //View variables
    ListView favoritesListView;

    private void initViews() {
        favoritesListView = findViewById(R.id.favoritesListView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        initViews();
        favoritesActivity=this;

        //TODO static getInstance() for navigation bar
        NavigationBar navigationBar = new NavigationBar(this); //required if navigation bar exists in this activity_layout
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//required if navigation bar exists in this activity_layout

        FavoritesService favoritesService = new FavoritesService(favoritesActivity);
        favoritesService.GetFavorites();
    }

    public void SetForecastListAdapterValues(List<WeatherStation> weatherStations) {
        FavoritesListAdapter adapter = new FavoritesListAdapter(this, R.layout.adapter_view_favorites, weatherStations);
        favoritesListView.setAdapter(adapter);
    }

    public static FavoritesActivity getInstance(){
        return favoritesActivity;
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
