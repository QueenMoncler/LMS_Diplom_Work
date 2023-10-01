package com.example.lms_diplom_work;

import Database.CommandsSQL;
import Database.GetPasswordSQL;
import Moderator.ModeratorApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button sceneButton1;

    @FXML
    private Button buttonJoin;

    @FXML
    private PasswordField passwordField_password;

    @FXML
    private TextField textField_nickname;



    @FXML
    public void initialize(URL location, ResourceBundle resources) {
            buttonJoin.setOnAction(ActionEvent ->{
                if (CommandsSQL.searchNickname(textField_nickname.getText())){
                System.out.println("GOOD");
                if (GetPasswordSQL.getPass(textField_nickname.getText()).equals(passwordField_password.getText())){
                System.out.println("Пароли совпадают");
                    Stage stg = (Stage) buttonJoin.getScene().getWindow();
                    stg.close();
                    ModeratorApplication moderatorApplication = new ModeratorApplication();
                    moderatorApplication.startModerWindow();
                }
                else System.out.println("Пароли не совпадают");
            }
            else System.out.println("NE GOOD");
        });

}

}
