package com.example.dunger.weatherappandroidclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dunger.weatherappandroidclient.Services.accountService;

public class MainActivity extends AppCompatActivity {


    //View variables
    private Button LoginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accountService accService = new accountService(MainActivity.this);
                accService.Login();
            }
        });

    }

    private void initViews() {
        LoginButton = findViewById(R.id.LoginButton);
    }

}
