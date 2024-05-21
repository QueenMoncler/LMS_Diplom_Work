package Student.DisciplineListTaskForm;

import Database.CommandSQL_Student;
import Database.CommandsSQL_Student;
import Teacher.Send.FileLib;
import User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class SetList {
    public ObservableList<String> listDiscipline = FXCollections.observableArrayList(
    );
    public ObservableList<String> getSendStudentList() throws SQLException {
        CommandSQL_Student commandsSQLStudent = new CommandSQL_Student();
        for(String s:commandsSQLStudent.getListDiscipline()){
            listDiscipline.add(s);
        }
        return listDiscipline;
    }


    public ObservableList<String> listMaterial = FXCollections.observableArrayList(
    );
    public ObservableList<String> getListMaterial(String discipline, String typeTask) throws SQLException {
        CommandSQL_Student commandsSQLStudent = new CommandSQL_Student();
        for(String s:commandsSQLStudent.getListMaterial(commandsSQLStudent.getNameStudent(User.getUserNickname()),
                commandsSQLStudent.getLastNameStudent(User.getUserNickname()),
                discipline, typeTask)){
            listMaterial.add(s);
        }
        return listMaterial;
    }
    public ObservableList<String> getListMaterialMetodichki(String discipline) throws SQLException {
        FileLib fileLib = new FileLib();
        for(String s:fileLib.t(discipline, "Методички")){
            listMaterial.add(s);
        }
        return listMaterial;
    }

}
