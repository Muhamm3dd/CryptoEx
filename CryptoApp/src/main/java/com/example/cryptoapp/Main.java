package com.example.cryptoapp;

//important libraries
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    //FXML loader to launch application
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("crypto-list.fxml"));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("bitcoin-btc-logo.png")));
        primaryStage.setTitle("Crypto App");
        primaryStage.setScene(new Scene(root, 600, 730));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}