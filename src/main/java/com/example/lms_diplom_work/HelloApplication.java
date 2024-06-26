package com.example.lms_diplom_work;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage)  {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = fxmlLoader.getRoot();
        Stage stg = new Stage();
        stg.initStyle(StageStyle.UNDECORATED);
        ;
        stg.setScene(new Scene(root));

        
        stg.showAndWait();
    }


    public static void main(String[] args) {
        launch();

    }
}