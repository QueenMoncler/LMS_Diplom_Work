package Moderator.Home;

import Moderator.ModeratorApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ModeratorHomeApplication {
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(ModeratorHomeApplication.class.getResource("moderatorHome-view.fxml"));
//        Stage stg = new Stage();
//        Scene scene = new Scene(root);
//
//        stg.setScene(scene);
//
//        stg.setResizable(false);
//        // stg.setMaximized(true);
//        stg.showAndWait();
//    }
//
//    public static void main(String[] args){
//        launch(args);
//    }


    public void startModerWindow() throws IOException {
        Parent root = FXMLLoader.load(ModeratorHomeApplication.class.getResource("moderatorHome-view.fxml"));
        Stage stg = new Stage();
        Scene scene = new Scene(root);

        stg.setScene(scene);

        stg.setResizable(false);
        // stg.setMaximized(true);
        stg.showAndWait();

    }

}
