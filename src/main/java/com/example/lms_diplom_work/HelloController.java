package com.example.lms_diplom_work;

import Database.CommandsSQL;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        //CommandsSQL.selectAll("employee");
          welcomeText.setText("Welcome to JavaFX Application!");
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    return;
//                }
//            }
//        }).start();

        }
}