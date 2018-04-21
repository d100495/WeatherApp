package com.example.dunger.weatherappandroidclient.UI;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.example.dunger.weatherappandroidclient.MapsActivity;
import com.example.dunger.weatherappandroidclient.OptionsActivity;
import com.example.dunger.weatherappandroidclient.R;
import com.example.dunger.weatherappandroidclient.WebViewActivity;

/**
 * Created by Dunger on 2018-04-08.
 */

public class NavigationBar {

    Activity activity;

    //View variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    public NavigationBar(Activity activity) {
        this.activity = activity;
        initViews();
        SetListeners();
    }

    private void initViews() {
        navigationView = activity.findViewById(R.id.nav_bar);
        drawerLayout = activity.findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(activity,drawerLayout,R.string.navbar_open,R.string.navbar_close);
    }

    private void SetListeners(){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        drawerLayout.closeDrawers();

                        if(actionBarDrawerToggle.onOptionsItemSelected(menuItem))
                        {
                            return true;
                        }
                        if(menuItem.getItemId()==R.id.nav_desktop)
                        {
                            if(!(activity.getClass()==WebViewActivity.class)) {
                                Intent intent = new Intent(activity.getApplicationContext(), WebViewActivity.class);
                                activity.startActivity(intent);
                            }
                        }
                        if(menuItem.getItemId()==R.id.nav_mobile)
                        {
                            if(!(activity.getClass()==MapsActivity.class)) {
                                Intent intent = new Intent(activity.getApplicationContext(), MapsActivity.class);
                                activity.startActivity(intent);
                            }
                        }
                        if(menuItem.getItemId()==R.id.nav_options)
                        {
                            if(!(activity.getClass()==OptionsActivity.class)) {
                                Intent intent = new Intent(activity.getApplicationContext(), OptionsActivity.class);
                                activity.startActivity(intent);
                            }

                        }
                        else {
                            drawerLayout.openDrawer(GravityCompat.START);  // OPEN DRAWER
                        }
                        return true;
                    }
                });

        actionBarDrawerToggle.syncState();

    }



}
