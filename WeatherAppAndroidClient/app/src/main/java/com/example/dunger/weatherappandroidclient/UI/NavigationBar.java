package com.example.dunger.weatherappandroidclient.UI;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.example.dunger.weatherappandroidclient.R;
import com.example.dunger.weatherappandroidclient.WeatherStationsActivity;
import com.example.dunger.weatherappandroidclient.WebViewActivity;

/**
 * Created by Dunger on 2018-04-08.
 */

public class NavigationBar {

    Activity activity;

    //View variables
    DrawerLayout drawerLayout;
    NavigationView nav_bar;

    public NavigationBar(Activity activity) {
        this.activity = activity;
        initViews();
        SetItemClickListeners();
    }

    private void initViews() {
        nav_bar = activity.findViewById(R.id.nav_bar);
        drawerLayout = activity.findViewById(R.id.drawer_layout);
    }

    private void SetItemClickListeners(){
        nav_bar.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        if(menuItem.getTitle().equals(activity.getString(R.string.menuItem_desktop)))
                        {
                            Intent intent = new Intent(activity.getApplicationContext(), WebViewActivity.class);
                            activity.startActivity(intent);
                        }

                        if(menuItem.getTitle().equals(activity.getString(R.string.menuItem_mobile)))
                        {
                            //TODO Activity refreshing should not be possible
                            Intent intent = new Intent(activity.getApplicationContext(), WeatherStationsActivity.class);
                            activity.startActivity(intent);
                        }

                        return true;
                    }
                });
    }


}
