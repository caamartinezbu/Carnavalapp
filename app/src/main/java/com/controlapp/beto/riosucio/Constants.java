package com.controlapp.beto.riosucio;

/**
 * Created by JuanSe on 6/11/16.
 */
public class Constants {

    private static final String GANGS_QUERY_URL = "https://carnavaldiablo.000webhostapp.com/validate_date.php";

    public Constants(){

    }

    public static String getGangsQueryUrl() {
        return GANGS_QUERY_URL;
    }
}
