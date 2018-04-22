package com.example.dunger.weatherappandroidclient;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.dunger.weatherappandroidclient.Models.WeatherHistory;
import com.example.dunger.weatherappandroidclient.Services.HistoryService;
import com.example.dunger.weatherappandroidclient.UI.FavoritesListAdapter;
import com.example.dunger.weatherappandroidclient.UI.HistoryListAdapter;
import com.example.dunger.weatherappandroidclient.UI.NavigationBar;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    static HistoryActivity historyActivity;

    //View variables
    ListView historyListView;

    private void initViews(){
        historyListView=findViewById(R.id.historyListView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initViews();
        historyActivity=this;

        //TODO static getInstance() for navigation bar
        NavigationBar navigationBar = new NavigationBar(this); //required if navigation bar exists in this activity_layout
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//required if navigation bar exists in this activity_layout

        HistoryService historyService = new HistoryService(historyActivity);
        historyService.GetHistory();
    }

    public static HistoryActivity getInstance() {
        return historyActivity;
    }

    public void SetHistoryListAdapterValues(List<WeatherHistory> weatherHistory) {
        HistoryListAdapter adapter = new HistoryListAdapter(this, R.layout.adapter_view_history, weatherHistory);
        historyListView.setAdapter(adapter);
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
