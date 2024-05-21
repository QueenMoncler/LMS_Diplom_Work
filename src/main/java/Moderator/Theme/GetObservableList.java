package Moderator.Theme;

import Database.*;
import Moderator.Student.StudentTable;
import Teacher.Check.CheckDateTable;
import Teacher.Send.FileLib;
import User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class GetObservableList {

    public String getFirstName(String nickname) {
        return CommandsSQL.getFirstNameUser(nickname);
    }

    public String getLastName(String nickname) {
        return CommandsSQL.getLastNameUser(nickname);
    }

    public int getCountAllTeacher() throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        int count = Integer.parseInt(commandSQL_theme.getAmountAllTheme());
        return count;
    }
    public int getCountDisciplineTeacher() throws SQLException {
        CommandsSQL_Discipline commandsSQLDiscipline = new CommandsSQL_Discipline();
        int count = Integer.parseInt(commandsSQLDiscipline.getCountDisciplineTicher());
        return count;
    }
    public int getCountStudent() throws SQLException {
        CommandsSQL_Student commandsSQLStudent = new CommandsSQL_Student();
        int count = Integer.parseInt(commandsSQLStudent.getCountStudent());
        return count;
    }
    public int getCountCheck(String discipline) throws SQLException {
        CommandSQL_TeacherCHECK commandSQLTeacherCHECK = new CommandSQL_TeacherCHECK();
        int count = Integer.parseInt(commandSQLTeacherCHECK.getCountCheck(discipline));
        return count;
    }
    public int getCountTeacher(String nickname) throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        int count = Integer.parseInt(commandSQL_theme.getAmountThemeTeacher(nickname));
        return count;
    }



    public ObservableList<GetThemeTable> list = FXCollections.observableArrayList(
    );
    public ObservableList<StudentTable> listStudent = FXCollections.observableArrayList(
    );
    public ObservableList<CheckDateTable> listCheck = FXCollections.observableArrayList(
    );


    public ObservableList<GetThemeTable> listTableThemeTeacher = FXCollections.observableArrayList(
    );
    public ObservableList<String> listTeacher = FXCollections.observableArrayList(
    );
    public ObservableList<String> listGroupStudent = FXCollections.observableArrayList(
    );
    public ObservableList<String> listSendDisciplineTeacher = FXCollections.observableArrayList(
    );
    public ObservableList<String> listDiscipline = FXCollections.observableArrayList(
    );
    public ObservableList<String> listDisciplineGroup = FXCollections.observableArrayList(
    );
    public ObservableList<String> sendListStudent = FXCollections.observableArrayList(
    );
    public ObservableList<String> sendListMaterial = FXCollections.observableArrayList(
    );
//    public ObservableList<GetThemeTable> getList() throws SQLException {
    //        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
    //        for (int i = 0; i < getCountAllTeacher(); i++) {
    //            list.add(new GetThemeTable(getFirstName(commandSQL_theme.getAllNickname().get(i)),
    //                    getLastName(commandSQL_theme.getAllNickname().get(i)),
    //                    commandSQL_theme.getAllTheme().get(i)));
    //        }
    //        return list;

    //    }
    public ObservableList<GetThemeTable> getList() throws SQLException {
        CommandsSQL_Discipline commandsSQLDiscipline = new CommandsSQL_Discipline();
        for (int i = 0; i < getCountDisciplineTeacher(); i++) {
//
            list.add(new GetThemeTable(commandsSQLDiscipline.getNameDisciplineTeacher().get(i),
                    commandsSQLDiscipline.getSurnameDisciplineTeacher().get(i),
                    commandsSQLDiscipline.getDisciplineNameDisciplineTeacher().get(i)));
        }
        return list;
    }
    public ObservableList<StudentTable> getListStudent() throws SQLException {
        CommandsSQL_Student commandsSQLStudent = new CommandsSQL_Student();
        for (int i = 0; i < getCountStudent(); i++) {
            System.out.println(commandsSQLStudent.getFirstNameStudent().get(i));
            listStudent.add(new StudentTable(commandsSQLStudent.getIDStudent().get(i),
                    commandsSQLStudent.getFirstNameStudent().get(i),
                    commandsSQLStudent.getLastNameStudent().get(i),
                    commandsSQLStudent.getGroupStudent().get(i),
                    commandsSQLStudent.getAgeStudent().get(i),
                    commandsSQLStudent.getGenderStudent().get(i),
                    commandsSQLStudent.getEmailStudent().get(i),
                    commandsSQLStudent.getNicknameStudent().get(i)));
        }
        return listStudent;
    }
    public ObservableList<CheckDateTable> getListCheck(String discipline) throws SQLException {
        CommandSQL_TeacherCHECK commandSQLTeacherCHECK = new CommandSQL_TeacherCHECK();
        for (int i = 0; i < getCountCheck(discipline); i++) {
            //System.out.println(commandSQLTeacherCHECK.getIdCheckTable().get(i));
            listCheck.add(new CheckDateTable(commandSQLTeacherCHECK.getIdCheckTable(discipline).get(i),
                    commandSQLTeacherCHECK.getNameCheckTable(discipline).get(i),
                    commandSQLTeacherCHECK.getLastNameCheckTable(discipline).get(i),
                    commandSQLTeacherCHECK.getTypeCheckTable(discipline).get(i),
                    commandSQLTeacherCHECK.getMaterialCheckTable(discipline).get(i),
                    commandSQLTeacherCHECK.getCommentCheckTable(discipline).get(i),
                    commandSQLTeacherCHECK.getDateTimeCheckTable(discipline).get(i),
                    "Проверить"));
        }
        return listCheck;
    }

    public ObservableList<GetThemeTable> getListTableThemeTeacher(String nickname) throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        List<String> listTeacher =  CommandsSQL_Teachers.getAllNameTeachers(nickname);
        String[] listTeacherSplit = listTeacher.get(0).split(" ");
        for(int i = 0; i<getCountTeacher(nickname); i++){
            String firstName = listTeacherSplit[0];
            String lastName = listTeacherSplit[1];
            list.add(new GetThemeTable(firstName,
                                        lastName,
                    commandSQL_theme.getTeacherTheme(nickname).get(i)));
        }
        return list;
    }
    public ObservableList<String> getListAllTeacher() throws SQLException {
        CommandsSQL commandsSQL = new CommandsSQL();
        for(String s:commandsSQL.lastNameAllTeacher()){
            listTeacher.add(s);
        }
        return listTeacher;
    }
    public ObservableList<String> getStudentAllGroup() throws SQLException {
        CommandsSQL_Student commandsSQLStudent = new CommandsSQL_Student();
        for(String s:commandsSQLStudent.getAllGroup()){
            listGroupStudent.add(s);
        }
        return listGroupStudent;
    }
    public ObservableList<String> getSendStudentList(String group) throws SQLException {
        CommandsSQL_Student commandsSQLStudent = new CommandsSQL_Student();
        for(String s:commandsSQLStudent.getStudentFromGroup(group)){
            sendListStudent.add(s);
        }
        return sendListStudent;
    }
    public ObservableList<String> getSendMaterial(String discipline, String matetial) throws SQLException {
        FileLib fileLib = new FileLib();
        for(String s:fileLib.t(discipline, matetial)){
            sendListMaterial.add(s);
        }
        return sendListMaterial;
    }

    public ObservableList<String> getSendDisciplineComboBox() throws SQLException {
        CommandsSQL_Teachers commandsSQL_teachers = new CommandsSQL_Teachers();
        for(String s:commandsSQL_teachers.getDisciplineTeacherList(User.getUserNickname())){
            listSendDisciplineTeacher.add(s);
        }
        return listSendDisciplineTeacher;
    }
    public ObservableList<String> getListDiscipline() throws SQLException {
      CommandsSQL_Teachers commandsSQL_teachers = new CommandsSQL_Teachers();
        for(String s:commandsSQL_teachers.getAllDiscipline()){
            System.out.println(s);
            listDiscipline.add(s);
        }
        return listDiscipline;
    }
    public ObservableList<String> getListDisciplineGroup(String nickname) throws SQLException {
        CommandsSQL_Teachers commandsSQL_teachers = new CommandsSQL_Teachers();
        for(String s:commandsSQL_teachers.getAllDisciplineGroup(nickname)){
            listDisciplineGroup.add(s);
        }
        return listDisciplineGroup;
    }
}
