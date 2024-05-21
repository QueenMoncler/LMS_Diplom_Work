package Teacher.CheckDZAnchorPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class SetComboboxZach {
    public ObservableList<String> listCombobox = FXCollections.observableArrayList(
    );
    public ObservableList<String> getListCombobox() throws SQLException {
        listCombobox.add("Зачет");
        listCombobox.add("Незачет");

        return listCombobox;
    }
}
