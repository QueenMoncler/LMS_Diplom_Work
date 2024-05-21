package Student;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentApplication {

    public void startStudentWindow() throws IOException {

        Parent root = FXMLLoader.load(StudentController.class.getResource("Student-View.fxml"));
        Stage stg = new Stage();
        Scene scene = new Scene(root);

        stg.setScene(scene);

        stg.setResizable(false);
        // stg.setMaximized(true);

        stg.setFullScreen(true);
        stg.showAndWait();



    }
}
