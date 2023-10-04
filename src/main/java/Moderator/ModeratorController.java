package Moderator;

import Database.CommandsSQL;
import Moderator.Home.TeacherCards;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
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
    private Label amountTeacher;

    @FXML
    private Label amountTheme;

    @FXML
    private AnchorPane anchorPaneHomeWindow;

    @FXML
    private AnchorPane anchorPaneOProgWindow;

    @FXML
    private AnchorPane anchorPaneStudentWindow;

    @FXML
    private AnchorPane anchorPaneSwitch;

    @FXML
    private AnchorPane anchorPaneTaskWindow;

    @FXML
    private AnchorPane anchorPaneTeacherWindow;

    @FXML
    private AnchorPane anchorPaneThemeWindow;

    @FXML
    private FontAwesomeIconView arrowSwitch;

    @FXML
    private Button arrowSwitchBtn;

    @FXML
    private Label cardsAmountTask;

    @FXML
    private Label cardsAmountTheme;

    @FXML
    private Button homeBtn;

    @FXML
    private Label nameUserModerator;

    @FXML
    private Button oProgrammBtn;

    @FXML
    private Button studentsBtn;

    @FXML
    private Button taskBtn;

    @FXML
    private Button teacherBtn;

    @FXML
    private Circle testCircleImageview;

    @FXML
    private Button themeBtn;


    public String setNameUserModerator(String nickname){
        return CommandsSQL.nameUser(nickname);
    }

    public String setTeacherAmount(){
        return CommandsSQL.getCountId();
    }
    public String setAmountTheme(){
        return (CommandsSQL.getAmountTheme());
    }
    public String setAmountStudent(){
        return CommandsSQL.getAmountStudent();
    }

    private URL urlTest = getClass().getResource("/Images/teacherTest.png");
    private URL urlZhilina = getClass().getResource("/Images/zhilina.png");
    TeacherCards teacherCards = new TeacherCards();
    private Image img = new Image(teacherCards.urlTeacherZhilina.toExternalForm());
    public void setImageCircle()  {

        if(img.getUrl().equals(urlTest.getFile())){
            img = new Image(urlZhilina.toExternalForm());
        }
        else {
            img = new Image(urlTest.toExternalForm());
        }
        testCircleImageview.setFill(new ImagePattern(img));
    }


    private String nicknameUser = new ModeratorApplication().getNickname();



    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        amountTeacher.setText(setTeacherAmount());
        nameUserModerator.setText(setNameUserModerator(nicknameUser));
        amountTheme.setText(setAmountTheme());
        amountStudent.setText(setAmountStudent());


        arrowSwitchBtn.setOnAction(ActionEvent->{
            testCircleImageview.setFill(new ImagePattern(img));
        });


        homeBtn.setOnAction(ActionEvent -> {
            anchorPaneHomeWindow.setVisible(true);
            anchorPaneHomeWindow.setMouseTransparent(true);
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
