package Teacher;

import Database.CommandSQL_TeacherCHECK;
import Database.CommandsSQL_Student;
import Database.CommandsSQL_Teachers;
import Moderator.Home.ToggleRadioButton;
import Moderator.ModeratorController;
import Moderator.Student.StudentTable;
import Moderator.Task.SelectList;
import Moderator.Task.SetFiles;
import Moderator.Theme.GetObservableList;
import Teacher.Check.CheckDateTable;
import Teacher.CheckDZAnchorPane.SetComboboxZach;
import Teacher.Send.FileLib;
import User.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class TeacherController implements Initializable {
    @FXML
    private Label amountStudent;



    @FXML
    private Label amountTask;

    @FXML
    private Label sendPersonalStudentLabel;
    @FXML
    private Label amountTeacher;

    @FXML
    private Label amountTheme;

    @FXML
    private AnchorPane anchorPaneHometWindow;

    @FXML
    private AnchorPane anchorPaneRightFull;

    @FXML
    private AnchorPane anchorPaneSendDZ;
    @FXML
    private AnchorPane anchorPaneGetDZ;

    @FXML
    private AnchorPane anchorPaneStudentWindow;

    @FXML
    private AnchorPane anchorPaneSwitch;

    @FXML
    private AnchorPane anchorPaneTaskWindow;

    @FXML
    private AnchorPane anchorPaneCheckDZ;

    @FXML
    private Button buttonClickDiscipline;

    @FXML
    private Button buttonClickTask;
    @FXML
    private Button checkCloseButton;


    @FXML
    private Button buttonClickTeacher;

    @FXML
    private Button buttonOpenFileTask;

    @FXML
    private Button buttonSubmitTask;

    @FXML
    private Button exitBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Label nameUserModerator;

    @FXML
    private Button oProgrammBtn;

    @FXML
    private Pane paneClickDiscipline;

    @FXML
    private Pane paneClickTask;

    @FXML
    private Pane paneClickTeacher;

    @FXML
    private RadioButton radioDZ;

    @FXML
    private RadioButton radioMetodichki;

    @FXML
    private RadioButton radioSamostoyalki;

    @FXML
    private Button sendBtn;

    @FXML
    private TextArea sendCommentTextArea;

    @FXML
    private Button sendDZBtn;

    @FXML
    private ComboBox<String> sendDisciplineComboBox;

    @FXML
    private ComboBox<String> sendGroupComboBox;

    @FXML
    private ComboBox<String> checkDiciplineCombobox;

    @FXML
    private ComboBox<String> checkGroupCombobox;

    @FXML
    private ComboBox<String> sendMaterialComboBox;

    @FXML
    private CheckBox sendPersonalCheckBox;

    @FXML
    private CheckBox sendOnlyCommentCheckBox;

    @FXML
    private RadioButton sendRadioDZ;

    @FXML
    private RadioButton sendRadioSamostoyalki;

    @FXML
    private ComboBox<String> studentGroup;


    @FXML
    private TextArea checkCommentTEacherTextField;

    @FXML
    private TextArea checkCommentTextField;

    @FXML
    private TextField checkDateTextField;

    @FXML
    private TextField checkFileTextField;

    @FXML
    private TextField checkLastNameTextField;
    @FXML
    private TextField checkIDTextField;

    @FXML
    private TextField checkNameTextField;

    @FXML
    private TextField checkTypeTextField;
    @FXML
    private Button checkOpenButton;

    @FXML
    private Button checkSendButton;


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
    private TableView<CheckDateTable> checkTable;

    @FXML
    private TableColumn<CheckDateTable, String> checkTableCHECK;

    @FXML
    private TableColumn<CheckDateTable, String> checkTableCOMMENT;

    @FXML
    private TableColumn<CheckDateTable, String> checkTableDATE;

    @FXML
    private TableColumn<CheckDateTable, String> checkTableFILE;

    @FXML
    private TableColumn<CheckDateTable, String> checkTableID;

    @FXML
    private TableColumn<CheckDateTable, String> checkTableLASTNAME;

    @FXML
    private TableColumn<CheckDateTable, String> checkTableNAME;

    @FXML
    private TableColumn<CheckDateTable, String> checkTableTYPE;


    @FXML
    private Button studentsBtn;

    @FXML
    private Button taskBtn;

    @FXML
    private ComboBox<String> taskComboBoxTeacher;
    @FXML
    private ComboBox<String> checkZachetCombobox;



    @FXML
    private ComboBox<String> taskComboBoxTheme;

    @FXML
    private Label taskLabel;

    @FXML
    private Label taskLabelFile;

    @FXML
    private ListView<String> taskListView;
    @FXML
    private ListView<String> sendStudentListView;

    @FXML
    private Button sendBtnGetDZ;

    @FXML
    private Button sendBtnOpenMaterial;
    private String disciplineTableCheckDZ = "";



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
    public void initializeTableCheckDZ(String discipline) throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        checkTableID.setCellValueFactory(new PropertyValueFactory<CheckDateTable, String>("id"));
        checkTableNAME.setCellValueFactory(new PropertyValueFactory<CheckDateTable, String>("name"));
        checkTableLASTNAME.setCellValueFactory(new PropertyValueFactory<CheckDateTable, String>("lastName"));
        checkTableTYPE.setCellValueFactory(new PropertyValueFactory<CheckDateTable, String>("type"));
        checkTableFILE.setCellValueFactory(new PropertyValueFactory<CheckDateTable, String>("file"));
        checkTableCOMMENT.setCellValueFactory(new PropertyValueFactory<CheckDateTable, String>("comment"));
        checkTableDATE.setCellValueFactory(new PropertyValueFactory<CheckDateTable, String>("date"));
        checkTableCHECK.setCellValueFactory(new PropertyValueFactory<CheckDateTable, String>("check"));
        checkTable.setItems(getObservableList.getListCheck(discipline));
    }

    public void goodAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Диалоговое окно");
        alert.setHeaderText(null);
        alert.setContentText("Информация успешно добавлена");
        alert.showAndWait();
    }
    public void alertForCheck(String id, String name, String lastName){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Проверить задание студента ("+ name +" "+lastName+")?", ButtonType.YES, ButtonType.CANCEL);
        alert.setTitle("Диалоговое окно");
//        alert.setHeaderText(null);
//        alert.setContentText("Информация успешно добавлена");
        alert.showAndWait();
        if(alert.getResult() == ButtonType.YES){
            anchorPaneGetDZ.setVisible(false);
            anchorPaneCheckDZ.setVisible(true);
            homeBtn.setDisable(true);
            taskBtn.setDisable(true);
            studentsBtn.setDisable(true);
            sendBtn.setDisable(true);
            sendBtnGetDZ.setDisable(true);

        }
        else{

        }
    }
    public void actionTaskList() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        taskListView.setItems(getObservableList.getListDisciplineGroup(User.getUserNickname()));
    }
    public void setStudentComboBox() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        studentGroup.setItems(getObservableList.getStudentAllGroup());
    }
    public void setStudentComboBoxSend() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        sendGroupComboBox.setItems(getObservableList.getStudentAllGroup());
    }
    public void disciplineComboboxSend() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        sendDisciplineComboBox.setItems(getObservableList.getSendDisciplineComboBox());
    }
    public void setStudentComboBoxGet() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        checkGroupCombobox.setItems(getObservableList.getStudentAllGroup());
    }
    public void disciplineComboboxGet() throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        checkDiciplineCombobox.setItems(getObservableList.getSendDisciplineComboBox());
    }
    public void setSendStudentListView(String group) throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        sendStudentListView.setItems(getObservableList.getSendStudentList(group));
    }
    public void setSendMaterialComboBox(String discipline, String material) throws SQLException {
        GetObservableList getObservableList = new GetObservableList();
        sendMaterialComboBox.setItems(getObservableList.getSendMaterial(discipline, material));
    }
    public boolean setAddTaskFromStudent(String group, String nameStudent, String lastNameStudent, String discipline, String typeTask, String material, String comment) throws SQLException {
        CommandsSQL_Student commandsSQLStudent = new CommandsSQL_Student();
        if(commandsSQLStudent.addTaskFromStudent(group, nameStudent, lastNameStudent, discipline, typeTask, material, comment))
            return true;
        return false;
    }

    private FileChooser fileChooser = new FileChooser();
    private File fileMain;
    private void sendBtnDefault()
    {

        sendGroupComboBox.setDisable(false);
        sendGroupComboBox.setValue(null);
        sendStudentListView.setItems(null);
        sendPersonalCheckBox.setSelected(false);
        sendPersonalStudentLabel.setDisable(true);
        sendRadioDZ.setDisable(true);
        sendRadioSamostoyalki.setDisable(true);
        sendRadioDZ.setSelected(false);
        sendRadioSamostoyalki.setSelected(false);
        //sendMaterialComboBox.setDisable(true);
        sendMaterialComboBox.setValue(null);
        sendBtnOpenMaterial.setDisable(true);
        sendCommentTextArea.setText(null);
        sendOnlyCommentCheckBox.setSelected(false);
    }

    public void setZachetComobobx() throws SQLException {
        SetComboboxZach setComboboxZach = new SetComboboxZach();
        checkZachetCombobox.setItems(setComboboxZach.getListCombobox());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        nameUserModerator.setText(User.getUserNickname());
        ToggleRadioButton toggleRadioButton = new ToggleRadioButton();
        new SelectList(taskListView, taskLabel);
        new SelectList(sendStudentListView, sendPersonalStudentLabel);



        sendOnlyCommentCheckBox.setOnAction(ActionEvent ->{

            if(sendOnlyCommentCheckBox.isSelected()){
                sendRadioDZ.setDisable(true);
                sendRadioSamostoyalki.setDisable(true);
                sendRadioDZ.setSelected(false);
                sendRadioSamostoyalki.setSelected(false);
                //sendMaterialComboBox.setDisable(true);
                sendDZBtn.setDisable(true);
                //sendMaterialComboBox.setDisable(true);
                sendBtnOpenMaterial.setDisable(true);
            }

            else {
                sendRadioDZ.setDisable(false);
                sendRadioSamostoyalki.setDisable(false);
                sendRadioDZ.setSelected(false);
                sendRadioSamostoyalki.setSelected(false);
                //sendMaterialComboBox.setDisable(false);
                sendMaterialComboBox.setValue(null);
                sendDZBtn.setDisable(false);
                //sendMaterialComboBox.setDisable(false);
                sendBtnOpenMaterial.setDisable(false);
            }
        });
        sendPersonalCheckBox.setOnAction(ActionEvent ->{
            sendPersonalStudentLabel.setDisable(!sendPersonalCheckBox.isSelected());
        });
        sendDisciplineComboBox.setOnAction(ActionEvent -> {
            sendBtnDefault();
        });
        try {
            setZachetComobobx();
            setStudentComboBoxSend();
            disciplineComboboxSend();
            setStudentComboBoxGet();
            disciplineComboboxGet();
            setStudentComboBox();
            actionTaskList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        studentGroup.setOnAction(ActionEvent->{
            try{
                initializeTableStudent();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        checkDiciplineCombobox.setOnAction(ActionEvent->{
            try {
                initializeTableCheckDZ(checkDiciplineCombobox.getValue());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        checkGroupCombobox.setOnAction(ActionEvent -> {
            checkDiciplineCombobox.setDisable(false);
        });


        sendRadioDZ.setOnAction(ActionEvent ->{
            try {
                setSendMaterialComboBox(sendDisciplineComboBox.getValue(), toggleRadioButton.radioButton(sendRadioDZ, sendRadioSamostoyalki).getText());
                sendMaterialComboBox.setValue(null);
                //sendMaterialComboBox.setDisable(false);
                sendBtnOpenMaterial.setDisable(false);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        sendRadioSamostoyalki.setOnAction(ActionEvent->{
            try {
                setSendMaterialComboBox(sendDisciplineComboBox.getValue(), toggleRadioButton.radioButton(sendRadioDZ, sendRadioSamostoyalki).getText());
                sendMaterialComboBox.setValue(null);
                //sendMaterialComboBox.setDisable(false);
                sendBtnOpenMaterial.setDisable(false);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        sendGroupComboBox.setOnAction(ActionEvent->{
            try {
                setSendStudentListView(sendGroupComboBox.getValue());
                sendRadioSamostoyalki.setDisable(false);
                sendRadioDZ.setDisable(false);
                }
             catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
        sendDZBtn.setOnAction(ActionEvent ->{
            if(!sendPersonalCheckBox.isSelected()){
            for(int i = 0; i<sendStudentListView.getItems().size(); i++){
                String[] name = sendStudentListView.getItems().get(i).split(" ");
                try {
                    setAddTaskFromStudent(sendGroupComboBox.getValue(),
                            name[0], name[1],
                            sendDisciplineComboBox.getValue(),
                            toggleRadioButton.radioButton(sendRadioDZ, sendRadioSamostoyalki).getText(),
                            sendMaterialComboBox.getValue(),
                            sendCommentTextArea.getText());

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
                sendBtnDefault();
                goodAlert();
            }
            else{
                String[] name = sendPersonalStudentLabel.getText().split(" ");
                try {
                    setAddTaskFromStudent(sendGroupComboBox.getValue(),
                            name[0], name[1],
                            sendDisciplineComboBox.getValue(),
                            toggleRadioButton.radioButton(sendRadioDZ, sendRadioSamostoyalki).getText(),
                            sendMaterialComboBox.getValue(),
                            sendCommentTextArea.getText());
                    sendBtnDefault();
                    goodAlert();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        sendMaterialComboBox.setOnAction(ActionEvent->{
            sendBtnOpenMaterial.setDisable(false);
            sendDZBtn.setDisable(false);
        });
        sendBtnOpenMaterial.setOnAction(ActionEvent->{
            OpenDesktop openDesktop = new OpenDesktop();
            openDesktop.openFile(sendDisciplineComboBox.getValue(), toggleRadioButton.radioButton(sendRadioDZ, sendRadioSamostoyalki).getText(), sendMaterialComboBox.getValue());
        });


        homeBtn.setOnAction(ActionEvent -> {
            anchorPaneHometWindow.setVisible(true);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
            anchorPaneSendDZ.setVisible(false);
            anchorPaneGetDZ.setVisible(false);

        });
        taskBtn.setOnAction(ActionEvent -> {
            anchorPaneHometWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(true);
            anchorPaneStudentWindow.setVisible(false);
            anchorPaneSendDZ.setVisible(false);
            anchorPaneGetDZ.setVisible(false);

        });
        studentsBtn.setOnAction(ActionEvent -> {
            anchorPaneStudentWindow.setVisible(true);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneSendDZ.setVisible(false);
            anchorPaneGetDZ.setVisible(false);

        });
        sendBtn.setOnAction(ActionEvent->{
            anchorPaneSendDZ.setVisible(true);
            anchorPaneStudentWindow.setVisible(false);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneGetDZ.setVisible(false);

        });
        sendBtnGetDZ.setOnAction(ActionEvent->{
            anchorPaneSendDZ.setVisible(false);
            anchorPaneStudentWindow.setVisible(false);
            anchorPaneHometWindow.setVisible(false);
            anchorPaneTaskWindow.setVisible(false);
            anchorPaneGetDZ.setVisible(true);
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
                ToggleRadioButton toggleRadioButtonn = new ToggleRadioButton();
                setFiles.setFilesDirect(taskLabel.getText(), fileMain,
                        toggleRadioButtonn.t(radioDZ, radioSamostoyalki, radioMetodichki));
                taskLabel.setText("");
                taskLabelFile.setText("");
                radioDZ.setSelected(false);
                radioMetodichki.setSelected(false);
                radioSamostoyalki.setSelected(false);
                goodAlert();
            }
            else System.out.println("BAD!");
        });
        TableView.TableViewSelectionModel<CheckDateTable> selectionModel = checkTable.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<CheckDateTable>(){

            @Override
            public void changed(ObservableValue<? extends CheckDateTable> observableValue, CheckDateTable checkDateTable, CheckDateTable t1) {
                checkIDTextField.setText(t1.getId());
                checkNameTextField.setText(t1.getName());
                checkLastNameTextField.setText(t1.getLastName());
                checkTypeTextField.setText(t1.getType());
                checkFileTextField.setText(t1.getFile());
                checkCommentTextField.setText(t1.getComment());
                checkDateTextField.setText(t1.getDate());
                alertForCheck(t1.getId(), t1.getName(), t1.getLastName());
            }


        });
        checkCloseButton.setOnAction(ActionEvent->{
            anchorPaneGetDZ.setVisible(true);
            anchorPaneCheckDZ.setVisible(false);
            homeBtn.setDisable(false);
            taskBtn.setDisable(false);
            studentsBtn.setDisable(false);
            sendBtn.setDisable(false);
            sendBtnGetDZ.setDisable(false);

        });
        checkOpenButton.setOnAction(ActionEvent->{
            OpenDesktop openDesktop = new OpenDesktop();
            openDesktop.openFileDZ(checkDiciplineCombobox.getValue(), checkFileTextField.getText());
        });

        checkSendButton.setOnAction(ActionEvent ->{
            try {
                CommandSQL_TeacherCHECK commandSQLTeacherCHECK = new CommandSQL_TeacherCHECK();
                commandSQLTeacherCHECK.updateTaskTestingForTeacher(checkIDTextField.getText(), checkZachetCombobox.getValue(), checkCommentTEacherTextField.getText());
                commandSQLTeacherCHECK.updateTaskFromStudent(commandSQLTeacherCHECK.getTaskFromStudentId(checkIDTextField.getText()), checkZachetCombobox.getValue());
                goodAlert();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });



        toggleRadioButton.toggleRadioDiscipline(radioDZ, radioSamostoyalki, radioMetodichki);
        toggleRadioButton.toggleRadioSend(sendRadioDZ, sendRadioSamostoyalki);

    }
}
