package com.example.lms_diplom_work;

import Database.ConnectDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //String query = "CREATE table test(id BIGSERIAL, first_name VARCHAR(50))";
//
        //String query = "DROP table test";

        //String query = "INSERT INTO test(first_name) VALUES('test')";
        String query = "Select * FROM employee";

        ConnectDB.testQuery(query);
        //launch();
    }
}