package com.example.lms_diplom_work;

import Database.CommandsSQL;
import Database.GetPasswordSQL;
import Moderator.ModeratorApplication;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
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
    private Label errorTextVisible;
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
        pressMouse();
        pressEnter();
    }


    @FXML
    public void pressMouse(){
        errorTextVisible.setVisible(false);
        buttonJoin.setOnAction(ActionEvent -> {
            if (CommandsSQL.searchNickname(textField_nickname.getText())) {
                System.out.println("GOOD");
                if (GetPasswordSQL.getPass(textField_nickname.getText()).equals(passwordField_password.getText())) {
                    System.out.println("Пароли совпадают");
                    Stage stg = (Stage) buttonJoin.getScene().getWindow();

                    ModeratorApplication moderatorApplication = new ModeratorApplication();

                    try {
                        moderatorApplication.setNickname(textField_nickname.getText());
                        moderatorApplication.startModerWindow();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    stg.hide();

                } else {
                    System.out.println("Пароли не совпадают");
                    errorTextVisible.setVisible(true);
                }
            } else {
                System.out.println("Логин не совпадает");
                errorTextVisible.setVisible(true);
            }

        });
    }

    @FXML
    public void pressEnter() {
        buttonJoin.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (CommandsSQL.searchNickname(textField_nickname.getText())) {
                    System.out.println("GOOD");
                    if (GetPasswordSQL.getPass(textField_nickname.getText()).equals(passwordField_password.getText())) {
                        System.out.println("Пароли совпадают");
                        Stage stg = (Stage) buttonJoin.getScene().getWindow();

                        ModeratorApplication moderatorApplication = new ModeratorApplication();
                        try {
                            moderatorApplication.setNickname(textField_nickname.getText());
                            moderatorApplication.startModerWindow();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stg.hide();
                    } else {
                        System.out.println("Пароли не совпадают");
                        errorTextVisible.setVisible(true);
                    }
                } else {
                    System.out.println("Логин не совпадает");
                    errorTextVisible.setVisible(true);
                }
            }
        });

        passwordField_password.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (CommandsSQL.searchNickname(textField_nickname.getText())) {
                    System.out.println("GOOD");
                    if (GetPasswordSQL.getPass(textField_nickname.getText()).equals(passwordField_password.getText())) {
                        System.out.println("Пароли совпадают");
                        Stage stg = (Stage) buttonJoin.getScene().getWindow();

                        ModeratorApplication moderatorApplication = new ModeratorApplication();
                        try {
                            moderatorApplication.setNickname(textField_nickname.getText());
                            moderatorApplication.startModerWindow();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stg.hide();
                    } else {
                        System.out.println("Пароли не совпадают");
                        errorTextVisible.setVisible(true);
                    }
                } else {
                    System.out.println("Логин не совпадает");
                    errorTextVisible.setVisible(true);
                }
            }
        });

        textField_nickname.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (CommandsSQL.searchNickname(textField_nickname.getText())) {
                    System.out.println("GOOD");
                    if (GetPasswordSQL.getPass(textField_nickname.getText()).equals(passwordField_password.getText())) {
                        System.out.println("Пароли совпадают");
                        Stage stg = (Stage) buttonJoin.getScene().getWindow();

                        ModeratorApplication moderatorApplication = new ModeratorApplication();
                        try {
                            moderatorApplication.setNickname(textField_nickname.getText());
                            moderatorApplication.startModerWindow();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stg.hide();
                    } else {
                        System.out.println("Пароли не совпадают");
                        errorTextVisible.setVisible(true);
                    }
                } else {
                    System.out.println("Логин не совпадает");
                    errorTextVisible.setVisible(true);
                }
            }
        });
    }

}
