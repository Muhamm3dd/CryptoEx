package com.example.cryptoapp;

//important libraries
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ApiController {

    @FXML
    private TextField cryptoName;

    @FXML
    private TextField usdValue;

    @FXML
    private TextField jpyValue;

    @FXML
    private TextField eurValue;

    //Search method
    @FXML
    public void onInsertClick() {
        String crypto = cryptoName.getText();

        try {
            String apiResponse = CryptoApi.getCryptoData(crypto);

            // Parse the JSON response using Gson
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(apiResponse, JsonObject.class);

            // Get values from the JSON object
            double usd = jsonObject.get("USD").getAsDouble();
            double jpy = jsonObject.get("JPY").getAsDouble();
            double eur = jsonObject.get("EUR").getAsDouble();

            // Update UI fields with parsed data
            usdValue.setText(String.valueOf(usd));
            jpyValue.setText(String.valueOf(jpy));
            eurValue.setText(String.valueOf(eur));

        } catch (IOException e) {
            e.printStackTrace();
            usdValue.setText("N/A");
            jpyValue.setText("N/A");
            eurValue.setText("N/A");
        }
    }

    //Next page method
    public void onInsertClick1(ActionEvent actionEvent) {

        try{
            Stage stage = (Stage) (((Node) actionEvent.getSource())).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("crypto-search.fxml"));
            stage.getIcons().add(new Image(getClass().getResourceAsStream("bitcoin-btc-logo.png")));

            Scene scene = new Scene(fxmlLoader.load(), 600, 730);

            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
//Close method
    public void onBackButtonClick(ActionEvent actionEvent) {
        Stage stage = (Stage) (((Node) actionEvent.getSource())).getScene().getWindow();
        stage.close();
    }
}

