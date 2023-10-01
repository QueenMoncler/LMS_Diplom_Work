package Moderator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ModeratorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonHello;

    @FXML
    void initialize() {
        buttonHello.setOnAction(actionEvent -> {
            System.out.println("hello world!");

        });

    }

}
