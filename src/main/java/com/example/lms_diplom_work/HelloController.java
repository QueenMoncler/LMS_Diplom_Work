package com.example.lms_diplom_work;

import Database.CommandsSQL;
import Database.GetPasswordSQL;
import Moderator.ModeratorApplication;
import Student.StudentApplication;
import Teacher.TeacherApplication;
import User.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane sceneReg;



    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        pressMouse();
        pressEnter();
    }

    public void openScene(String nickname){
        if(CommandsSQL.selectRole(nickname).equals("Модератор")) openSceneModerator();
        else if (CommandsSQL.selectRole(nickname).equals("Преподаватель")) openSceneTeacher();
        else if(CommandsSQL.selectRole(nickname).equals("Студент")) openSceneStudent();
    }

    public void openSceneModerator(){
        Parent root2;
        try {
            root2 = FXMLLoader.load(ModeratorApplication.class.getResource("moderatorWindow-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stg2 = new Stage();
        Scene scene = new Scene(root2);

        stg2.setScene(scene);
        stg2.show();
        stg2.setResizable(false);
        stg2.setFullScreen(true);
    }
    public void openSceneTeacher(){
        Parent root2;
        try {
            root2 = FXMLLoader.load(TeacherApplication.class.getResource("Teacher-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stg2 = new Stage();
        Scene scene = new Scene(root2);

        stg2.setScene(scene);
        stg2.show();
        stg2.setResizable(false);
        stg2.setFullScreen(true);
    }
    public void openSceneStudent(){
        Parent root3;
        try {
            root3 = FXMLLoader.load(StudentApplication.class.getResource("Student_View.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stg3 = new Stage();
        Scene scene = new Scene(root3);

        stg3.setScene(scene);
        stg3.show();
        stg3.setResizable(false);
        stg3.setFullScreen(true);
    }


    @FXML
    public void pressMouse(){
        errorTextVisible.setVisible(false);
        buttonJoin.setOnAction(ActionEvent -> {
            if (CommandsSQL.searchNickname(textField_nickname.getText())) {
                System.out.println("Login Valid");
                if (GetPasswordSQL.getPass(textField_nickname.getText(), passwordField_password.getText())) {
                    System.out.println("Password Valid");
                    User.setUserNickname(textField_nickname.getText());
                    //if(CommandsSQL.selectRole(textField_nickname.getText().equals("Модератор")))
                    Stage thisStage = (Stage) buttonJoin.getScene().getWindow();
                    //ModeratorApplication moderatorApplication = new ModeratorApplication();
                    //moderatorApplication.setNickname(textField_nickname.getText());
                    //openScene();
                    openScene(textField_nickname.getText());
                    thisStage.close();
                } else {
                    System.out.println(passwordField_password.getText().hashCode());
                    System.out.println("Password NOT Valid");
                    errorTextVisible.setVisible(true);
                }
            } else {
                System.out.println("Login NOT Valid");
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
                    if (GetPasswordSQL.getPass(textField_nickname.getText(), passwordField_password.getText())) {
                        System.out.println("Пароли совпадают");
                        User.setUserNickname(textField_nickname.getText());
                        Stage stg = (Stage) buttonJoin.getScene().getWindow();
                        //ModeratorApplication moderatorApplication = new ModeratorApplication();
                        //moderatorApplication.setNickname(textField_nickname.getText());
                        //openScene();
                        openScene(textField_nickname.getText());
                        //stg.close();

                        stg.close();
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
                    if (GetPasswordSQL.getPass(textField_nickname.getText(), passwordField_password.getText())) {
                        System.out.println("Пароли совпадают");
                        Stage stg = (Stage) buttonJoin.getScene().getWindow();
                        User.setUserNickname(textField_nickname.getText());
                        //ModeratorApplication moderatorApplication = new ModeratorApplication();
                        //moderatorApplication.setNickname(textField_nickname.getText());
                        //openScene();
                        openScene(textField_nickname.getText());
                        stg.close();

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
                    if (GetPasswordSQL.getPass(textField_nickname.getText(),
                            passwordField_password.getText())) {
                        System.out.println("Пароли совпадают");
                        Stage stg = (Stage) buttonJoin.getScene().getWindow();
                        User.setUserNickname(textField_nickname.getText());
                        //ModeratorApplication moderatorApplication = new ModeratorApplication();
                        //moderatorApplication.setNickname(textField_nickname.getText());
                        //openScene();
                        openScene(textField_nickname.getText());
                        stg.close();

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
