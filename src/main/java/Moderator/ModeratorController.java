package Moderator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ModeratorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button homeBtn;

    @FXML
    void initialize() {
        homeBtn.setOnMouseEntered(event -> {
            homeBtn.setStyle("-fx-background-color: green");
        });
        homeBtn.setOnMouseExited(event -> homeBtn.getScene().getWindow().hide());


    }


}
