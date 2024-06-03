package Student;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.CommandSQL_Student;
import Moderator.ModeratorController;
import Moderator.Task.SelectList;
import Moderator.Task.SetFiles;
import Moderator.Theme.GetObservableList;
import Student.DisciplineListTaskForm.SetCombobox;
import Student.DisciplineListTaskForm.SetList;
import Student.HomeTable.SetTextTable;
import Student.HomeTable.TableHome;
import Teacher.Check.CheckDateTable;
import Teacher.OpenDesktop;
import User.User;
import com.example.lms_diplom_work.HelloApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class StudentController {

    @FXML
    private Label amountStudent;

    @FXML
    private Label amountTask;

    @FXML
    private Label amountTeacher;

    @FXML
    private Label amountTheme;

    @FXML
    private AnchorPane anchorPaneHomeForm;

    @FXML
    private AnchorPane anchorPaneMaterialForm;

    @FXML
    private AnchorPane anchorPaneRightFull;

    @FXML
    private AnchorPane anchorPaneSwitch;

    @FXML
    private AnchorPane anchorPaneTaskForm;

    @FXML
    private AnchorPane anchorPaneHomeForm2;

    @FXML
    private Button exitBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Label answerGoodComment;

    @FXML
    private Label answerGoodLabel;

    @FXML
    private Label answerGoodtextboxAssessment;

    @FXML
    private TextArea answerGoodtextboxComment;


    @FXML
    private TableView<TableHome> homeTable;

    @FXML
    private TableColumn<TableHome, String> homeTableID;
    @FXML
    private TableColumn<TableHome, String> homeTableComment;

    @FXML
    private TableColumn<TableHome, String> homeTableDate;

    @FXML
    private TableColumn<TableHome, String> homeTableDiscipline;

    @FXML
    private TableColumn<TableHome, String> homeTableFile;

    @FXML
    private TableColumn<TableHome, String> homeTableStatus;

    @FXML
    private TableColumn<TableHome, String> homeTableTypeTask;

    @FXML
    private Button materialBtn;

    @FXML
    private ComboBox<String> materialDisciplineCombobox;

    @FXML
    private ListView<String> materialList;

    @FXML
    private Button materialOpenBtn;

    @FXML
    private Label materialSelectList;

    @FXML
    private Label nameUserStudent;
    @FXML
    private Label labelT;

    @FXML
    private Button oProgrammBtn;

    @FXML
    private Button taskBtn;

    @FXML
    private Button taskInsertTaskBtn;

    @FXML
    private ListView<String> taskListDiscipline;

    @FXML
    private ListView<String> taskListTask;

    @FXML
    private Button taskOpenTaskBtn;

    @FXML
    private TextField taskSelectTask;
    @FXML
    private Label taskSelectTaskLabel;

    @FXML
    private ComboBox<String> taskTypeCombobox;

    @FXML
    private Button answerBack;

    @FXML
    private Button smenitButton;

    @FXML
    private TextArea answerCommentStudent;

    @FXML
    private TextArea answerCommentTeacher;

    @FXML
    private Label answerDTypeTaskTeacher;

    @FXML
    private Label answerDateTeacher;

    @FXML
    private Label answerDisciplineTeacher;

    @FXML
    private Label answerFileStudent;
    @FXML
    private Label answerIDTeacher;

    @FXML
    private Button answerOpenFile;

    @FXML
    private Button answerSubmit;
    @FXML
    private Button homeReBtn;



    public void setTaskTypeCombobox() throws SQLException {
        SetCombobox setCombobox = new SetCombobox();
        taskTypeCombobox.setItems(setCombobox.getSendStudentList());
    }

    public void setName() throws SQLException {
        CommandSQL_Student commandSQLStudent = new CommandSQL_Student();
        nameUserStudent.setText(commandSQLStudent.getNameStudent(User.getUserNickname()) + " " +commandSQLStudent.getLastNameStudent(User.getUserNickname()));
    }
    public void setTableHome() throws SQLException {
        SetTextTable setTextTable = new SetTextTable();
        setTextTable.initializeTableHome(homeTable, homeTableID, homeTableDiscipline, homeTableTypeTask, homeTableFile, homeTableComment,homeTableDate,homeTableStatus);
    }
    public void setTaskListDiscipline() throws SQLException {
        SetList setList = new SetList();
        taskListDiscipline.setItems(setList.getSendStudentList());
    }
    public void setMaterialList() throws SQLException {
        SetList setList = new SetList();
        taskListTask.setItems(setList.getListMaterial(taskListDiscipline.getSelectionModel().getSelectedItem(), taskTypeCombobox.getValue()));
    }
    public void setMaterialListMetodichki() throws SQLException {
        SetList setList = new SetList();
        taskListTask.setItems(setList.getListMaterialMetodichki(taskListDiscipline.getSelectionModel().getSelectedItem()));
    }

    public void alertForCheck(String id, String name, String lastName){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Перейти в окно ответа на задание ("+ name +" "+lastName+")?", ButtonType.YES, ButtonType.CANCEL);
        alert.setTitle("Диалоговое окно");
//        alert.setHeaderText(null);
//        alert.setContentText("Информация успешно добавлена");
        alert.showAndWait();
        if(alert.getResult() == ButtonType.YES){


        }
        else{

        }
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
    void initialize() throws SQLException {
        setName();
        setTableHome();
        setTaskListDiscipline();
        setTaskTypeCombobox();
        new SelectList(taskListTask, taskSelectTaskLabel);

        taskTypeCombobox.setOnAction(ActionEvent->{
            if(taskTypeCombobox.getValue().equals("Методички")){
                try {
                    setMaterialListMetodichki();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else{
                try {
                    setMaterialList();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        taskOpenTaskBtn.setOnAction(ActionEvent->{
            OpenDesktop openDesktop = new OpenDesktop();
            openDesktop.openFile(taskListDiscipline.getSelectionModel().getSelectedItem(), taskTypeCombobox.getValue(), taskSelectTaskLabel.getText());
        });



        TableView.TableViewSelectionModel<TableHome> selectionModel = homeTable.getSelectionModel();

        selectionModel.selectedItemProperty().addListener(new ChangeListener<TableHome>(){

            @Override
            public void changed(ObservableValue<? extends TableHome> observableValue, TableHome checkDateTable, TableHome t1) {
                if (t1.getStatus().equals("Не отвечено")){
                    try {
                        CommandSQL_Student commandSQLStudent = new CommandSQL_Student();
                        commandSQLStudent.updateStatusStudentFromTeacher(t1.getId());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    setAnswerPaneSelectTable(t1);
                }
                else if(t1.getStatus().equals("На оценке")){
                    setAnswerPaneSelectTable(t1);
                }
                else if(t1.getStatus().equals("Просмотрено")){
                    setAnswerPaneSelectTable(t1);
                }
                else if(t1.getStatus().equals("Зачет")){
                    try {
                        CommandSQL_Student commandSQLStudent = new CommandSQL_Student();
                        setAnswerPaneSelectTable(t1);
                        answerGoodLabel.setVisible(true);
                        answerGoodComment.setVisible(true);
                        answerGoodtextboxAssessment.setVisible(true);
                        answerGoodtextboxComment.setVisible(true);
                        answerGoodtextboxAssessment.setText(commandSQLStudent.getAnswerAssessment(answerIDTeacher.getText()));
                        answerGoodtextboxComment.setText(commandSQLStudent.getAnswerCommentAssessment(answerIDTeacher.getText()));
                        answerFileStudent.setText(commandSQLStudent.getAnswerMaterial(answerIDTeacher.getText()));
                        answerCommentStudent.setText(commandSQLStudent.getAnswerComment(answerIDTeacher.getText()));
                        answerSubmit.setVisible(false);
                        answerCommentStudent.setEditable(false);
                        answerOpenFile.setOnAction(ActionEvent ->{
                            OpenDesktop openDesktop = new OpenDesktop();
                            openDesktop.openFileDZ(answerDisciplineTeacher.getText(), answerFileStudent.getText());
                        });
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(t1.getStatus().equals("Незачет")){
                    try {
                        CommandSQL_Student commandSQLStudent = new CommandSQL_Student();
                        setAnswerPaneSelectTable(t1);
                        answerGoodLabel.setVisible(true);
                        answerGoodComment.setVisible(true);
                        answerGoodtextboxAssessment.setVisible(true);
                        answerGoodtextboxComment.setVisible(true);
                        answerGoodtextboxAssessment.setText(commandSQLStudent.getAnswerAssessment(answerIDTeacher.getText()));
                        answerGoodtextboxComment.setText(commandSQLStudent.getAnswerCommentAssessment(answerIDTeacher.getText()));
                        answerFileStudent.setText(commandSQLStudent.getAnswerMaterial(answerIDTeacher.getText()));
                        answerCommentStudent.setText(commandSQLStudent.getAnswerComment(answerIDTeacher.getText()));

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                }
            }

        });
        answerBack.setOnAction(ActionEvent->{
            homeBtn.setDisable(false);
            taskBtn.setDisable(false);
            anchorPaneHomeForm2.setVisible(false);
            anchorPaneHomeForm.setVisible(true);
        });


        homeBtn.setOnAction(ActionEvent->{
            anchorPaneHomeForm.setVisible(true);
            anchorPaneTaskForm.setVisible(false);
            anchorPaneMaterialForm.setVisible(false);
        });
        taskBtn.setOnAction(ActionEvent->{
            anchorPaneHomeForm.setVisible(false);
            anchorPaneTaskForm.setVisible(true);
            anchorPaneMaterialForm.setVisible(false);
        });
        materialBtn.setOnAction(ActionEvent->{
            anchorPaneHomeForm.setVisible(false);
            anchorPaneTaskForm.setVisible(false);
            anchorPaneMaterialForm.setVisible(true);
        });
        oProgrammBtn.setOnAction(ActionEvent -> {
            Runtime rt = Runtime.getRuntime();
            try {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + ModeratorController.getUrlGitHubRepo());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        exitBtn.setOnAction(actionEvent -> {
            Stage stage = (Stage) exitBtn.getScene().getWindow();
            stage.close();
        });


        answerOpenFile.setOnAction(ActionEvent->{
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
            answerFileStudent.setText(fileMain.getName());

        });
        answerSubmit.setOnAction(ActionEvent->{

            try {
                SetFiles setFiles = new SetFiles();
                setFiles.setFilesOnProverka(answerDisciplineTeacher.getText(), fileMain);
                CommandSQL_Student commandSQLStudent = new CommandSQL_Student();
                commandSQLStudent.setAnswerStudentFromTeacher(answerIDTeacher.getText(), answerFileStudent.getText(),answerCommentStudent.getText());
                commandSQLStudent.updateStatusAnswerStudentFromTeacher(answerIDTeacher.getText());
                goodAlert();
//                answerFileStudent.setText("");
//                answerCommentStudent.setText("");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });

        homeReBtn.setOnAction(ActionEvent->{
            try {
                setTableHome();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        smenitButton.setOnAction(ActionEvent->{
            openSceneLogin();
            Stage stage = (Stage) smenitButton.getScene().getWindow();
            stage.hide();
        });
    }
    public void openSceneLogin(){
        Parent root2;
        try {
            root2 = FXMLLoader.load(HelloApplication.class.getResource("hello-view.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stg2 = new Stage();
        Scene scene = new Scene(root2);

        stg2.setScene(scene);
        stg2.show();

    }
    public void setAnswerPaneSelectTable(TableHome t1){
        answerIDTeacher.setText(t1.getId());
        answerCommentTeacher.setText(t1.getComment());
        answerDateTeacher.setText(t1.getDate());
        answerDisciplineTeacher.setText(t1.getDiscipline());
        answerDTypeTaskTeacher.setText(t1.getTypeTask());
        homeBtn.setDisable(true);
        taskBtn.setDisable(true);
        anchorPaneHomeForm.setVisible(false);
        anchorPaneHomeForm2.setVisible(true);
    }


}
