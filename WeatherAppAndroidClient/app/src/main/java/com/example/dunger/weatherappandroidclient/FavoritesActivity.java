package com.example.dunger.weatherappandroidclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.dunger.weatherappandroidclient.Models.WeatherStation;
import com.example.dunger.weatherappandroidclient.Services.FavoritesService;
import com.example.dunger.weatherappandroidclient.UI.FavoritesListAdapter;

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
}
