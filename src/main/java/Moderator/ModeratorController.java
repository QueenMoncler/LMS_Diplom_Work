package Moderator;

import Database.CommandSQL_Student;
import Database.CommandSQL_Theme;
import Database.CommandsSQL;
import Database.CommandsSQL_Teachers;
import DialogWindow.DialogWindow;
import Moderator.Home.TeacherCards;
import Moderator.Theme.AddNewTheme;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    private Label amountTaskKnyazevCards;

    @FXML
    private Label amountTaskPivtoratskayaCards;

    @FXML
    private Label amountTaskVornikovaCards;

    @FXML
    private Label amountTaskZhilinaCards;

    @FXML
    private Label amountTeacher;

    @FXML
    private Label amountTheme;

    @FXML
    private Label amountThemeKnyazevCards;

    @FXML
    private Label amountThemePivtoratskayaCards;

    @FXML
    private Label amountThemeVornikovaCards;

    @FXML
    private Label amountThemeZhilinaCards;

    @FXML
    private AnchorPane anchorPaneCardsWindow;

    @FXML
    private AnchorPane anchorPaneOProgWindow;

    @FXML
    private AnchorPane anchorPaneRightFull;

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
    private Button homeBtn;

    @FXML
    private AnchorPane knyazevCards;

    @FXML
    private Circle knyazevCircleImageview;

    @FXML
    private Label nameUserModerator;

    @FXML
    private Button oProgrammBtn;

    @FXML
    private AnchorPane pivtoratskayaCards;

    @FXML
    private Circle pivtoratskayaCircleImageview;

    @FXML
    private RadioButton radioBtnMen;

    @FXML
    private RadioButton radioBtnWomen;

    @FXML
    private Button studentsBtn;

    @FXML
    private Button taskBtn;

    @FXML
    private Button teacherAddBtn;

    @FXML
    private Button teacherBtn;

    @FXML
    private Button themeBtn;

    @FXML
    private Button themeBtnAddTheme;

    @FXML
    private CheckBox themeCheckKnyazev;

    @FXML
    private CheckBox themeCheckPivtoratskaya;

    @FXML
    private CheckBox themeCheckVornikova;

    @FXML
    private CheckBox themeCheckZhilina;

    @FXML
    private Circle themeCircleKnyazev;

    @FXML
    private Circle themeCirclePivtoratskaya;

    @FXML
    private Circle themeCircleVornikova;

    @FXML
    private Circle themeCircleZhilina;

    @FXML
    private TextField themeTextFieldNameTheme;

    @FXML
    private AnchorPane vornikovaCards;

    @FXML
    private Circle vornikovaCircleImageview;

    @FXML
    private AnchorPane zhilinaCards;

    @FXML
    private Circle zhilinaCircleImageview;


    private static String nicknameUser = new ModeratorApplication().getNickname();
    DialogWindow dialogWindow = new DialogWindow();


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


    static TeacherCards teacherCards = new TeacherCards(nicknameUser);
    public static Image img = teacherCards.getTeacherStaff().get(0);
    public static void setImageCircle(Circle circle)  {

        if(img.getUrl().equals(teacherCards.getTeacherStaff().get(0))){
            img = teacherCards.getTeacherStaff().get(1);
            circle.setFill(new ImagePattern(img));
        } else if (img.getUrl().equals(teacherCards.getTeacherStaff().get(1))) {
            img = teacherCards.getTeacherStaff().get(2);
            circle.setFill(new ImagePattern(img));
        } else {
            img = teacherCards.getTeacherStaff().get(0);
            circle.setFill(new ImagePattern(img));
        }


    }

    public void setImageCircleTeacher() {
        zhilinaCircleImageview.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(0)));
        knyazevCircleImageview.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(1)));
        pivtoratskayaCircleImageview.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(2)));
        vornikovaCircleImageview.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(3)));

        themeCircleZhilina.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(0)));
        themeCircleKnyazev.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(1)));
        themeCirclePivtoratskaya.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(2)));
        themeCircleVornikova.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(3)));
    }

    public void themeBtnAddNewThemeAction() throws SQLException {
        themeBtnAddTheme.setOnAction(ActionEvent -> {
            try {
                if (themeCheckZhilina.isSelected())
                    AddNewTheme.addTheme(themeTextFieldNameTheme, "lecturer");
                if (themeCheckKnyazev.isSelected())
                    AddNewTheme.addTheme(themeTextFieldNameTheme, "knyazev");
                if (themeCheckPivtoratskaya.isSelected())
                    AddNewTheme.addTheme(themeTextFieldNameTheme, "pivtoratskaya");
                if (themeCheckVornikova.isSelected())
                    AddNewTheme.addTheme(themeTextFieldNameTheme, "vornikova");

                if (!themeCheckZhilina.isSelected() &
                        !themeCheckKnyazev.isSelected() &
                        !themeCheckPivtoratskaya.isSelected() &
                        !themeCheckVornikova.isSelected()) {
                    dialogWindow.falseAddTheme();
                }
                else{
                    initializeAmountMenu();
                    dialogWindow.tryAddTheme();
                    initializeCardsThemeTeacher();
                };

            } catch (SQLException e) {
                dialogWindow.falseAddTheme();
                throw new RuntimeException(e);
            }
        });

    }

    public void teacherCardSwitch(){
        arrowSwitchBtn.setOnAction(ActionEvent -> {
            if (zhilinaCards.isVisible()) {
                zhilinaCards.setVisible(false);
                knyazevCards.setVisible(true);

            } else if (knyazevCards.isVisible()) {
                knyazevCards.setVisible(false);
                pivtoratskayaCards.setVisible(true);

            } else if (pivtoratskayaCards.isVisible()) {
                pivtoratskayaCards.setVisible(false);
                vornikovaCards.setVisible(true);
            }
            else if (vornikovaCards.isVisible()) {
                zhilinaCards.setVisible(true);
                vornikovaCards.setVisible(false);
            }
        });

    }
    public void initializeCardsThemeTeacher() throws SQLException {
        amountThemeZhilinaCards.setText(TeacherCards.getThemeAmount("lecturer"));
        amountThemeKnyazevCards.setText(TeacherCards.getThemeAmount("knyazev"));
        amountThemePivtoratskayaCards.setText(TeacherCards.getThemeAmount("pivtoratskaya"));
        amountThemeVornikovaCards.setText(TeacherCards.getThemeAmount("vornikova"));
    }
    public void initializeCardsTaskTeacher()throws SQLException{
        amountTaskZhilinaCards.setText(TeacherCards.getTaskAmount("lecturer"));
        amountTaskKnyazevCards.setText(TeacherCards.getTaskAmount("knyazev"));
        amountTaskPivtoratskayaCards.setText(TeacherCards.getTaskAmount("pivtoratskaya"));
        amountTaskVornikovaCards.setText(TeacherCards.getTaskAmount("vornikova"));
    }

    public void initializeAmountMenu() throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        CommandsSQL_Teachers commandsSQL_teachers = new CommandsSQL_Teachers();
        CommandSQL_Student commandSQLStudent = new CommandSQL_Student();

        amountTeacher.setText(commandsSQL_teachers.getAmountAllTeachers());
        nameUserModerator.setText(setNameUserModerator(nicknameUser));
        amountTheme.setText(commandSQL_theme.getAmountAllTheme());
        amountStudent.setText(commandSQLStudent.getAmountAllStudent());
    }


    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        setImageCircleTeacher();

        teacherCardSwitch();
        try {
            initializeAmountMenu();
            initializeCardsThemeTeacher();
            initializeCardsTaskTeacher();
            themeBtnAddNewThemeAction();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        homeBtn.setOnAction(ActionEvent -> {
//            anchorPaneHomeWindow.setVisible(true);
//            anchorPaneHomeWindow.setMouseTransparent(true);
//            anchorPaneTeacherWindow.setVisible(false);
//            anchorPaneThemeWindow.setVisible(false);
//            anchorPaneTaskWindow.setVisible(false);
//            anchorPaneStudentWindow.setVisible(false);
//            anchorPaneOProgWindow.setVisible(false);
//            anchorPaneRightFull.setVisible(true);
            //anchorPaneSwitch1.setVisible(false);
//            anchorPaneSwitch.setVisible(true);
//            anchorPaneTeacherWindow.setVisible(false);
//            anchorPaneHomeWindow.setVisible(true);


        });
        teacherBtn.setOnAction(ActionEvent -> {

            //anchorPaneSwitch1.setVisible(true);
            anchorPaneSwitch.setVisible(true);
            anchorPaneTeacherWindow.setVisible(true);
            anchorPaneCardsWindow.setVisible(true);
            //anchorPaneHomeWindow.setVisible(false);
//            anchorPaneHomeWindow.setVisible(false);
//            anchorPaneTeacherWindow.setVisible(true);
            anchorPaneThemeWindow.setVisible(false);
//            anchorPaneTaskWindow.setVisible(false);
//            anchorPaneStudentWindow.setVisible(false);
//            anchorPaneOProgWindow.setVisible(false);
//            anchorPaneRightFull.setVisible(false);
        });
        themeBtn.setOnAction(ActionEvent -> {
//            anchorPaneHomeWindow.setVisible(false);
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(true);
//            anchorPaneTaskWindow.setVisible(false);
//            anchorPaneStudentWindow.setVisible(false);
//            anchorPaneOProgWindow.setVisible(false);
        });
        taskBtn.setOnAction(ActionEvent -> {
//            anchorPaneHomeWindow.setVisible(false);
//            anchorPaneTeacherWindow.setVisible(false);
//            anchorPaneThemeWindow.setVisible(false);
//            anchorPaneTaskWindow.setVisible(true);
//            anchorPaneStudentWindow.setVisible(false);
//            anchorPaneOProgWindow.setVisible(false);
        });
        studentsBtn.setOnAction(ActionEvent -> {
//            anchorPaneHomeWindow.setVisible(false);
//            anchorPaneTeacherWindow.setVisible(false);
//            anchorPaneThemeWindow.setVisible(false);
//            anchorPaneTaskWindow.setVisible(false);
//            anchorPaneStudentWindow.setVisible(true);
//            anchorPaneOProgWindow.setVisible(false);
        });
        oProgrammBtn.setOnAction(ActionEvent -> {
//            anchorPaneHomeWindow.setVisible(false);
//            anchorPaneTeacherWindow.setVisible(false);
//            anchorPaneThemeWindow.setVisible(false);
//            anchorPaneTaskWindow.setVisible(false);
//            anchorPaneStudentWindow.setVisible(false);
//            anchorPaneOProgWindow.setVisible(true);
            Runtime rt = Runtime.getRuntime();
            String url = "https://github.com/QueenMoncler/LMS_Diplom_Work";
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
