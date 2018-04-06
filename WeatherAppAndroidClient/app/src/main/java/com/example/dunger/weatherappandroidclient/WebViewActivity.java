package com.example.dunger.weatherappandroidclient;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView nav_bar;

    private void initViews() {

        nav_bar = findViewById(R.id.nav_bar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        initViews();


        WebView myWebView = findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();


        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);

        myWebView.loadUrl("http://adamko-001-site1.ftempurl.com/");

        nav_bar.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        // close drawer when item is tapped


                        if(menuItem.getTitle().equals(getString(R.string.menuItem_desktop)))
                        {
                            Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                            startActivity(intent);
                        }

                        if(menuItem.getTitle().equals(getString(R.string.menuItem_mobile)))
                        {
                            //TODO Activity refreshing
                            Intent intent = new Intent(getApplicationContext(), WeatherStationsActivity.class);
                            startActivity(intent);

                        }

                        return true;
                    }
                });

    }
}
