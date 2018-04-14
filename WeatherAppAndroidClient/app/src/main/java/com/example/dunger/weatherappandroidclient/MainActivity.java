package com.example.dunger.weatherappandroidclient;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dunger.weatherappandroidclient.Services.accountService;

public class MainActivity extends AppCompatActivity {

    //View variables
    private static Button LoginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO disabling button while logging in
                accountService accService = new accountService(MainActivity.this);
                accService.Login(usernameEditText.getText().toString(),passwordEditText.getText().toString());
            }
        });
    }

    private void initViews() {
        LoginButton = findViewById(R.id.LoginButton);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }


}
