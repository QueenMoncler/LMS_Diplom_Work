package Student.DisciplineListTaskForm;

import Database.CommandSQL_Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class SetCombobox {
    public ObservableList<String> listCombobox = FXCollections.observableArrayList(
    );
    public ObservableList<String> getSendStudentList() throws SQLException {
        listCombobox.add("Домашнее задание");
        listCombobox.add("Самостоятельная работа");
        listCombobox.add("Методички");
        return listCombobox;
    }
}
