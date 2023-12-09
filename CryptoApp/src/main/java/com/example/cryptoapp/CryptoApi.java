package com.example.cryptoapp;

//important libraries
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//API URL
public class CryptoApi {
    private static final String API_BASE_URL = "https://min-api.cryptocompare.com/data/price";

    public static String getCryptoData(String cryptocurrency) throws IOException {
        String urlString = API_BASE_URL + "?fsym=" + cryptocurrency + "&tsyms=USD,JPY,EUR";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = inputReader.readLine()) != null) {
            response.append(line);
        }
        inputReader.close();

        return response.toString();
    }
}
