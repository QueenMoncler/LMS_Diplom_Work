package Moderator;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ModeratorApplication{
//    @Override
//    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(ModeratorApplication.class.getResource("moderator-view.fxml"));
//        try {
//            fxmlLoader.load();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Stage stg = new Stage();
//        Parent root = fxmlLoader.getRoot();
//        stg.setScene(new Scene(root));
//        stg.showAndWait();
//    }
    public void startModerWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader(ModeratorApplication.class.getResource("moderatorWindow-view.fxml"));
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stg = new Stage();
        Parent root = fxmlLoader.getRoot();
        stg.setScene(new Scene(root));

        stg.setResizable(false);
       // stg.setMaximized(true);
        stg.showAndWait();

    }

//    public static void startup() {
//        launch();
//    }


}
