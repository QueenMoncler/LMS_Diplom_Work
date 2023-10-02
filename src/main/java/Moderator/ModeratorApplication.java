package Moderator;


import com.example.lms_diplom_work.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ModeratorApplication {
//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(ModeratorApplication.class.getResource("moderatorWindow-view.fxml"));
//        Stage stg = new Stage();
//        Scene scene = new Scene(root);
//
//        stg.setScene(scene);
//
//        stg.setResizable(false);
//       // stg.setMaximized(true);
//        stg.showAndWait();
//    }
    public void startModerWindow() throws IOException {

        Parent root = FXMLLoader.load(ModeratorApplication.class.getResource("moderatorWindow-view.fxml"));
        Stage stg = new Stage();
        Scene scene = new Scene(root);

        stg.setScene(scene);

        stg.setResizable(false);
       // stg.setMaximized(true);
        stg.showAndWait();


    }

//    public static void startup() {
//        launch();
//    }


}
