module com.example.cryptoapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.cryptoapp to javafx.fxml;
    exports com.example.cryptoapp;
}