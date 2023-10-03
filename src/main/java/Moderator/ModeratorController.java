package Moderator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ModeratorController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label amountStudent;

    @FXML
    private Label amountTask;

    @FXML
    private Label amountTheme;

    @FXML
    private Label amountTeacher;

    @FXML
    private AnchorPane anchorPaneHomeWindow;

    @FXML
    private AnchorPane anchorPaneOProgWindow;

    @FXML
    private AnchorPane anchorPaneSwitch;

    @FXML
    private AnchorPane anchorPaneTaskWindow;

    @FXML
    private AnchorPane anchorPaneTeacherWindow;

    @FXML
    private AnchorPane anchorPaneThemeWindow;
    @FXML
    private AnchorPane anchorPaneStudentWindow;

    @FXML
    private Button homeBtn;

    @FXML
    private Button oProgrammBtn;

    @FXML
    private Button studentsBtn;

    @FXML
    private Button taskBtn;

    @FXML
    private Button themeBtn;

    @FXML
    private Button teacherBtn;


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        homeBtn.setOnAction(ActionEvent -> {
            anchorPaneHomeWindow.setVisible(true);
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
            anchorPaneOProgWindow.setVisible(false);

        });
        teacherBtn.setOnAction(ActionEvent -> {
            anchorPaneHomeWindow.setVisible(false);
            anchorPaneTeacherWindow.setVisible(true);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
            anchorPaneOProgWindow.setVisible(false);
        });
        themeBtn.setOnAction(ActionEvent -> {
            anchorPaneHomeWindow.setVisible(false);
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(true);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
            anchorPaneOProgWindow.setVisible(false);
        });
        taskBtn.setOnAction(ActionEvent -> {
            anchorPaneHomeWindow.setVisible(false);
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(true);
            anchorPaneStudentWindow.setVisible(false);
            anchorPaneOProgWindow.setVisible(false);
        });
        studentsBtn.setOnAction(ActionEvent -> {
            anchorPaneHomeWindow.setVisible(false);
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(true);
            anchorPaneOProgWindow.setVisible(false);
        });
        oProgrammBtn.setOnAction(ActionEvent -> {
            anchorPaneHomeWindow.setVisible(false);
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
            anchorPaneOProgWindow.setVisible(true);
        });
    }


}
