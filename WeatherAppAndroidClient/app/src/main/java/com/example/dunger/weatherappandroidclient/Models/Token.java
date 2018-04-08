package com.example.dunger.weatherappandroidclient.Models;

/**
 * Created by Dunger on 2018-04-03.
 */

public class Token {
    String access_token;
    String token_type;
    int expires_in;


    public Token(String access_token, String token_type, int expires_in) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

}
