package Moderator.Task;

import Database.CommandSQL_Task;
import Database.CommandsSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.List;

public class TaskList {


    public ObservableList<String> listComboBox = FXCollections.observableArrayList(
    );
    public ObservableList<String> listListView = FXCollections.observableArrayList(
    );

    public ObservableList<String> getListComboBox() throws SQLException {
        CommandsSQL commandsSQL = new CommandsSQL();
        for(String s : commandsSQL.lastNameAllTeacher()){
            listComboBox.add(s);
        }
        return listComboBox;
    }

    public ObservableList<String> getListListView(String nickname) throws SQLException {
        CommandSQL_Task commandSQLTask = new CommandSQL_Task();
        for(String s : commandSQLTask.getTaskTeacher(nickname)){
            listListView.add(s);
        }
        return listListView;
    }

}
