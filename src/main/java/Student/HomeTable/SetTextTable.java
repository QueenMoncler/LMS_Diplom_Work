package Student.HomeTable;

import Database.CommandSQL_Student;
import Database.CommandSQL_TeacherCHECK;
import Moderator.Theme.GetObservableList;
import Teacher.Check.CheckDateTable;
import User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class SetTextTable {

    public int getCountCheck(String nickname) throws SQLException {
        CommandSQL_Student commandSQLStudent = new CommandSQL_Student();
        int count = Integer.parseInt(commandSQLStudent.getCountCheck(
                commandSQLStudent.getNameStudent(nickname), commandSQLStudent.getLastNameStudent(nickname)
        ));
        return count;
    }
    public ObservableList<TableHome> listCheck = FXCollections.observableArrayList(
    );

    public ObservableList<TableHome> getListHome() throws SQLException {
        CommandSQL_Student commandSQLStudent = new CommandSQL_Student();
        String name = commandSQLStudent.getNameStudent(User.getUserNickname());
        String lastName = commandSQLStudent.getLastNameStudent(User.getUserNickname());
        for (int i = 0; i < getCountCheck(User.getUserNickname()); i++) {
            //System.out.println(commandSQLTeacherCHECK.getIdCheckTable().get(i));
            listCheck.add(new TableHome(commandSQLStudent.getIdHomeTable(name, lastName).get(i),
                    commandSQLStudent.getDisciplineHomeTable(name, lastName).get(i),
                    commandSQLStudent.getTypeTaskHomeTable(name, lastName).get(i),
                    commandSQLStudent.getMaterialHomeTable(name, lastName).get(i),
                    commandSQLStudent.getCommentHomeTable(name, lastName).get(i),
                    commandSQLStudent.getDatetimeHomeTable(name, lastName).get(i),
                    commandSQLStudent.getstatusHomeTable(name, lastName).get(i)
                    ));
        }
        return listCheck;
    }
//public ObservableList<TableHome> getListHome() throws SQLException {
//    CommandSQL_Student commandSQLStudent = new CommandSQL_Student();
//    String name = commandSQLStudent.getNameStudent(User.getUserNickname());
//    String lastName = commandSQLStudent.getLastNameStudent(User.getUserNickname());
//    for (int i = 0; i < getCountCheck(User.getUserNickname()); i++) {
//        //System.out.println(commandSQLTeacherCHECK.getIdCheckTable().get(i));
//        listCheck.add(new TableHome("text",
//                "text",
//                "text",
//                "text",
//                "text",
//                "text",
//                "text"
//        ));
//    }
//    return listCheck;
//}


    public void initializeTableHome(TableView tableView, TableColumn id, TableColumn discipline, TableColumn typeTask, TableColumn file, TableColumn comment, TableColumn date, TableColumn status) throws SQLException {
        id.setCellValueFactory(new PropertyValueFactory<TableHome, String>("id"));
        discipline.setCellValueFactory(new PropertyValueFactory<TableHome, String>("discipline"));
        typeTask.setCellValueFactory(new PropertyValueFactory<TableHome, String>("typeTask"));
        file.setCellValueFactory(new PropertyValueFactory<TableHome, String>("file"));
        comment.setCellValueFactory(new PropertyValueFactory<TableHome, String>("comment"));
        date.setCellValueFactory(new PropertyValueFactory<TableHome, String>("date"));
        status.setCellValueFactory(new PropertyValueFactory<TableHome, String>("status"));
        tableView.setItems(getListHome());
    }
}
