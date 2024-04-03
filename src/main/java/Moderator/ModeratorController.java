package Moderator;

import Config.TeacherName;
import Database.CommandSQL_Student;
import Database.CommandSQL_Theme;
import Database.CommandsSQL;
import Database.CommandsSQL_Teachers;
import DialogWindow.DialogWindow;
import Moderator.Home.TeacherCards;
import Moderator.Home.ToggleRadioButton;
import Moderator.Student.StudentTable;
import Moderator.Task.SelectList;
import Moderator.Task.SetFiles;
import Moderator.Task.TaskList;
import Moderator.Theme.AddNewTheme;
import Moderator.Theme.GetObservableList;
import Moderator.Theme.GetThemeTable;
import Moderator.discipline.AddNewDisciplineTicher;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
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
    private Label amountTaskKhaustovaCards;

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
    private Label amountThemeKhaustovaCards;

    @FXML
    private Label amountThemeKnyazevCards;

    @FXML
    private Label amountThemePivtoratskayaCards;

    @FXML
    private Label amountThemeVornikovaCards;

    @FXML
    private Label amountThemeZhilinaCards;

    @FXML
    private Label disciplineNameKhaustova;

    @FXML
    private Label disciplineNamePivtoratskaya;

    @FXML
    private Label disciplineNameVornikova;

    @FXML
    private Label disciplineNameZhilina;

    @FXML
    private Label disciplineNameknyazev;

    @FXML
    private Label labelKhaustovaDisciplineCards;

    @FXML
    private Label labelPivtoratskayaDisciplineCards;

    @FXML
    private Label labelVornikovaDisciplineCards;

    @FXML
    private Label labelZhilinaDisciplineCards;

    @FXML
    private Label labelknyazevDisciplineCards;

    @FXML
    private Label nameUserModerator;
    @FXML
    private Label taskLabel;
    @FXML
    private Label taskLabelFile;

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
    private AnchorPane anchorPaneHometWindow;

    @FXML
    private Pane paneClickDiscipline;

    @FXML
    private Pane paneClickTask;

    @FXML
    private Pane paneClickTeacher;
    @FXML
    private AnchorPane knyazevCards;
    @FXML
    private AnchorPane khaustovaCards;
    @FXML
    private AnchorPane pivtoratskayaCards;
    @FXML
    private AnchorPane vornikovaCards;
    @FXML
    private AnchorPane zhilinaCards;

    @FXML
    private TextField teacherPaneAddTextFieldEmail;

    @FXML
    private TextField teacherPaneAddTextFieldName;

    @FXML
    private TextField teacherPaneAddTextFieldNickname;

    @FXML
    private TextField teacherPaneAddTextFieldPassword;

    @FXML
    private TextField teacherPaneAddTextFieldPasswordEmail;

    @FXML
    private TextField teacherPaneAddTextFieldSurname;


    @FXML
    private FontAwesomeIconView arrowSwitch;

    @FXML
    private Button arrowSwitchBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button buttonSubmitTask;



    @FXML
    private Circle khaustovaCircleImageview;
    @FXML
    private Circle knyazevCircleImageview;
    @FXML
    private Circle pivtoratskayaCircleImageview;
    @FXML
    private Circle themeCircleKhaustova;

    @FXML
    private Circle themeCircleKnyazev;

    @FXML
    private Circle themeCirclePivtoratskaya;

    @FXML
    private Circle themeCircleVornikova;

    @FXML
    private Circle themeCircleZhilina;
    @FXML
    private Circle vornikovaCircleImageview;

    @FXML
    private Circle zhilinaCircleImageview;

    @FXML
    private CheckBox themeCheckKhaustova;

    @FXML
    private CheckBox themeCheckKnyazev;

    @FXML
    private CheckBox themeCheckPivtoratskaya;

    @FXML
    private CheckBox themeCheckVornikova;

    @FXML
    private CheckBox themeCheckZhilina;



    @FXML
    private Button oProgrammBtn;


    @FXML
    private RadioButton radioBtnMen;

    @FXML
    private RadioButton radioBtnWomen;

    @FXML
    private RadioButton radioDZ;

    @FXML
    private RadioButton radioMetodichki;

    @FXML
    private RadioButton radioSamostoyalki;

    @FXML
    private Button studentsBtn;

    @FXML
    private Button taskBtn;

    @FXML
    private ComboBox<String> taskComboBoxTeacher;

    @FXML
    private ComboBox<String>  discipline_combobox;



    @FXML
    private ListView<String> taskListView;

    @FXML
    private Button buttonOpenFileTask;

    @FXML
    private Button teacherAddBtn;

    @FXML
    private Button teacherBtn;

    @FXML
    private Button themeBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button themeBtnAddTheme;

    @FXML
    private Button buttonClickDiscipline;

    @FXML
    private Button buttonClickTask;

    @FXML
    private Button buttonClickTeacher;

    @FXML
    private ComboBox<String> themeComboBoxTeacher;

    @FXML
    private ComboBox<String> studentGroup;

    @FXML
    private TextField themeTextFieldNameTheme;

    @FXML
    private TableView<StudentTable> studentTable;

    @FXML
    private TableColumn<StudentTable, String> studentTableAge;

    @FXML
    private TableColumn<StudentTable, String> studentTableEmail;

    @FXML
    private TableColumn<StudentTable, String> studentTableGender;

    @FXML
    private TableColumn<StudentTable, String> studentTableGroup;

    @FXML
    private TableColumn<StudentTable, String> studentTableID;

    @FXML
    private TableColumn<StudentTable, String> studentTableLastName;

    @FXML
    private TableColumn<StudentTable, String> studentTableName;

    @FXML
    private TableColumn<StudentTable, String> studentTableNickname;

    @FXML
    private TableView<GetThemeTable> themeTable;

    @FXML
    private TableColumn<GetThemeTable, String> themeTableLastName;

    @FXML
    private TableColumn<GetThemeTable, String> themeTableName;

    @FXML
    private TableColumn<GetThemeTable, String> themeTableTheme;


    private static String nicknameUser = new ModeratorApplication().getNickname();
    DialogWindow dialogWindow = new DialogWindow();


    public String setNameUserModerator(String nickname) {
        return CommandsSQL.nameUser(nickname);
    }

    public String setTeacherAmount() {
        return CommandsSQL.getCountId();
    }

    public String setAmountTheme() {
        return (CommandsSQL.getAmountTheme());
    }

    public String setAmountStudent() {
        return CommandsSQL.getAmountStudent();
    }


    static TeacherCards teacherCards = new TeacherCards(nicknameUser);
    public static Image img = teacherCards.getTeacherStaff().get(0);

    public static void setImageCircle(Circle circle) {

        if (img.getUrl().equals(teacherCards.getTeacherStaff().get(0))) {
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
        khaustovaCircleImageview.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(4)));

        themeCircleZhilina.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(0)));
        themeCircleKnyazev.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(1)));
        themeCirclePivtoratskaya.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(2)));
        themeCircleVornikova.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(3)));
        themeCircleKhaustova.setFill(new ImagePattern(teacherCards.getTeacherStaff().get(4)));
    }

    public void themeBtnAddNewThemeAction() throws SQLException {
        themeBtnAddTheme.setOnAction(ActionEvent -> {
            try {
                if (themeCheckZhilina.isSelected())
                    AddNewDisciplineTicher.addDisciplineTicher(discipline_combobox, TeacherName.ZHILINA);
                if (themeCheckKnyazev.isSelected())
                AddNewDisciplineTicher.addDisciplineTicher(discipline_combobox, TeacherName.KNYAZEV);
                if (themeCheckPivtoratskaya.isSelected())
                AddNewDisciplineTicher.addDisciplineTicher(discipline_combobox, TeacherName.PIVTORATSKAYA);
                if (themeCheckVornikova.isSelected())
                AddNewDisciplineTicher.addDisciplineTicher(discipline_combobox, TeacherName.VORNIKOVA);
                if (themeCheckKhaustova.isSelected())
                   AddNewDisciplineTicher.addDisciplineTicher(discipline_combobox, TeacherName.KHAUSTOVA);
                if (!themeCheckZhilina.isSelected() &
                        !themeCheckKnyazev.isSelected() &
                        !themeCheckPivtoratskaya.isSelected() &
                        !themeCheckVornikova.isSelected() &
                        !themeCheckKhaustova.isSelected()
                ) {
                    dialogWindow.falseAddTheme();
                } else {
                    initializeAmountMenu();
                    dialogWindow.tryAddTheme();
                    initializeCardsThemeTeacher();
                    initializeTable("");
                }
            } catch (SQLException e) {
                dialogWindow.falseAddTheme();
                throw new RuntimeException(e);
            }
        });

    }

    public void teacherCardSwitch() {
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
            } else if (vornikovaCards.isVisible()) {
                khaustovaCards.setVisible(true);
                vornikovaCards.setVisible(false);
            }
            else if (khaustovaCards.isVisible()){
                khaustovaCards.setVisible(false);
                zhilinaCards.setVisible(true);
            }
        });

    }

    public void initializeCardsThemeTeacher() throws SQLException {
        amountThemeZhilinaCards.setText(TeacherCards.getThemeAmount(TeacherName.ZHILINA));
        amountThemeKnyazevCards.setText(TeacherCards.getThemeAmount(TeacherName.KNYAZEV));
        amountThemePivtoratskayaCards.setText(TeacherCards.getThemeAmount(TeacherName.PIVTORATSKAYA));
        amountThemeVornikovaCards.setText(TeacherCards.getThemeAmount(TeacherName.VORNIKOVA));
        amountThemeKhaustovaCards.setText(TeacherCards.getThemeAmount(TeacherName.KHAUSTOVA));
    }

    public void initializeCardsTaskTeacher() throws SQLException {
        amountTaskZhilinaCards.setText(TeacherCards.getTaskAmount(TeacherName.ZHILINA));
        amountTaskKnyazevCards.setText(TeacherCards.getTaskAmount(TeacherName.KNYAZEV));
        amountTaskPivtoratskayaCards.setText(TeacherCards.getTaskAmount(TeacherName.PIVTORATSKAYA));
        amountTaskVornikovaCards.setText(TeacherCards.getTaskAmount(TeacherName.VORNIKOVA));
        amountTaskKhaustovaCards.setText(TeacherCards.getTaskAmount(TeacherName.KHAUSTOVA));
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


    public void initializeTable(String nickname) throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        if(nickname.isEmpty()){
            themeTableName.setCellValueFactory(new PropertyValueFactory<GetThemeTable, String>("firstName"));
            themeTableLastName.setCellValueFactory(new PropertyValueFactory<GetThemeTable, String>("lastName"));
            themeTableTheme.setCellValueFactory(new PropertyValueFactory<GetThemeTable, String>("themeName"));
            themeTable.setItems(getObservableList.getList());
        }
        else{
            themeTableName.setCellValueFactory(new PropertyValueFactory<GetThemeTable, String>("firstName"));
            themeTableLastName.setCellValueFactory(new PropertyValueFactory<GetThemeTable, String>("lastName"));
            themeTableTheme.setCellValueFactory(new PropertyValueFactory<GetThemeTable, String>("themeName"));
            themeTable.setItems(getObservableList.getListTableThemeTeacher(nickname));
        }
    }
    public void initializeTableStudent() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        studentTableID.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("id"));
        studentTableName.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("name"));
        studentTableLastName.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("lastName"));
        studentTableGroup.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("group"));
        studentTableAge.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("age"));
        studentTableGender.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("gender"));
        studentTableEmail.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("email"));
        studentTableNickname.setCellValueFactory(new PropertyValueFactory<StudentTable, String>("nickname"));
        studentTable.setItems(getObservableList.getListStudent());
    }
    public void initialDisciplineCards() throws SQLException {

        labelknyazevDisciplineCards.setText(TeacherCards.getDiscipline(TeacherName.KNYAZEV));
        labelKhaustovaDisciplineCards.setText(TeacherCards.getDiscipline(TeacherName.KHAUSTOVA));
        labelPivtoratskayaDisciplineCards.setText(TeacherCards.getDiscipline(TeacherName.PIVTORATSKAYA));
        labelVornikovaDisciplineCards.setText(TeacherCards.getDiscipline(TeacherName.VORNIKOVA));
        labelZhilinaDisciplineCards.setText(TeacherCards.getDiscipline(TeacherName.ZHILINA));
    }

    public void setTaskList() throws SQLException {
        TaskList taskList = new TaskList();
        taskComboBoxTeacher.setItems(taskList.getListComboBox());
    }
//    public void actionTaskList(ComboBox<String> comboBox) throws SQLException {
//        CommandsSQL_Teachers commandsSQLTeachers = new CommandsSQL_Teachers();
//        String nickname = commandsSQLTeachers.getNicknameKeyLastName(comboBox.getValue());
//        TaskList taskList = new TaskList();
//        taskListView.setItems(taskList.getListListView(commandsSQLTeachers.getNicknameKeyLastName(comboBox.getValue())));
//    }
    public void actionTaskList() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        taskListView.setItems(getObservableList.getListDiscipline());
    }
    public void setThemeComboBoxTeacher() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        themeComboBoxTeacher.setItems(getObservableList.getListAllTeacher());
    }
    public void setStudentComboBox() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        studentGroup.setItems(getObservableList.getStudentAllGroup());
    }
    public void actionThemeComboBoxTeacher(ComboBox<String> comboBox) throws SQLException {
        CommandsSQL_Teachers commandsSQLTeachers = new CommandsSQL_Teachers();
        String nickname = commandsSQLTeachers.getNicknameKeyLastName(comboBox.getValue());
        if(!nickname.isEmpty()) initializeTable(nickname);
    }
    public void initialDisciplineCombobox() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        discipline_combobox.setItems(getObservableList.getListDiscipline());
    }
    public void goodAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Диалоговое окно");
        alert.setHeaderText(null);
        alert.setContentText("Информация успешно добавлена");
        alert.showAndWait();
    }

    private FileChooser fileChooser = new FileChooser();
    private File fileMain;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        new SelectList(taskListView, taskLabel);
        setImageCircleTeacher();
        teacherCardSwitch();
        try {
            setStudentComboBox();
            actionTaskList();
            initialDisciplineCombobox();
            initialDisciplineCards();
            setThemeComboBoxTeacher();
            setTaskList();
            initializeTable("");
            initializeAmountMenu();
            initializeCardsThemeTeacher();
            initializeCardsTaskTeacher();
            themeBtnAddNewThemeAction();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        themeComboBoxTeacher.setOnAction(ActionEvent->{
            try {
                actionThemeComboBoxTeacher(themeComboBoxTeacher);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        studentGroup.setOnAction(ActionEvent->{
            try{
                initializeTableStudent();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        buttonOpenFileTask.setOnAction(ActionEvent -> {
            fileChooser.setInitialDirectory(new File("C://Users//Public//Desktop"));
            fileChooser.setTitle("Select file");
            //FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("select...", "*.txt","*.pdf","*.docx","*.doc","*.pptx");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Все файлы", "*.*"),
                    new FileChooser.ExtensionFilter("txt", "*.txt"),
                    new FileChooser.ExtensionFilter("пдф", "*.pdf"),
                    new FileChooser.ExtensionFilter("ворд", "*.docx"),
                    new FileChooser.ExtensionFilter("презентация", "*.pptx")
            );
            File file = fileChooser.showOpenDialog(new Stage());
            fileMain = file;
            taskLabelFile.setText(fileMain.getName());
        });

        buttonSubmitTask.setOnAction(ActionEvent->{
            if(!(taskLabel.getText().equals(""))
            && (radioDZ.isSelected() ||
                    radioSamostoyalki.isSelected() ||
                    radioMetodichki.isSelected())
            && !(taskLabelFile.equals(""))){
                SetFiles setFiles = new SetFiles();
                ToggleRadioButton toggleRadioButton = new ToggleRadioButton();
                setFiles.setFilesDirect(taskLabel.getText(), fileMain,
                        toggleRadioButton.t(radioDZ, radioSamostoyalki, radioMetodichki));
                taskLabel.setText("");
                taskLabelFile.setText("");
                radioDZ.setSelected(false);
                radioMetodichki.setSelected(false);
                radioSamostoyalki.setSelected(false);
                goodAlert();
            }
            else System.out.println("BAD!");
        });

        buttonClickDiscipline.setOnAction(ActionEvent ->{
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(true);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
        });
        buttonClickTeacher.setOnAction(ActionEvent ->{
            anchorPaneSwitch.setVisible(true);
            anchorPaneTeacherWindow.setVisible(true);
            anchorPaneCardsWindow.setVisible(true);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
        });
        buttonClickTask.setOnAction(ActionEvent ->{
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(true);
            anchorPaneStudentWindow.setVisible(false);
        });

        homeBtn.setOnAction(ActionEvent -> {
            anchorPaneHometWindow.setVisible(true);
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
        });
        teacherBtn.setOnAction(ActionEvent -> {
            anchorPaneSwitch.setVisible(true);
            anchorPaneTeacherWindow.setVisible(true);
            anchorPaneCardsWindow.setVisible(true);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
        });
        themeBtn.setOnAction(ActionEvent -> {
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(true);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
        });
        taskBtn.setOnAction(ActionEvent -> {
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(true);
            anchorPaneStudentWindow.setVisible(false);
        });
        studentsBtn.setOnAction(ActionEvent -> {
            anchorPaneStudentWindow.setVisible(true);
            anchorPaneTeacherWindow.setVisible(false);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneThemeWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
        });
        oProgrammBtn.setOnAction(ActionEvent -> {
            Runtime rt = Runtime.getRuntime();
            String url = "https://github.com/QueenMoncler/LMS_Diplom_Work";
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        exitBtn.setOnAction(actionEvent -> {
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();
        });

        //new ToggleRadioButton(radioBtnMen, radioBtnWomen);
        ToggleRadioButton toggleRadioButton = new ToggleRadioButton();
        toggleRadioButton.toggleRadioGender(radioBtnMen, radioBtnWomen);
        toggleRadioButton.toggleRadioDiscipline(radioDZ, radioSamostoyalki, radioMetodichki);
    }



}
