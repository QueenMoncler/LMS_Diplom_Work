package Moderator.Theme;

import Database.CommandSQL_Theme;
import Database.CommandsSQL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class GetObservableList {

    public String getFirstName(String nickname) {
        return CommandsSQL.getFirstNameUser(nickname);
    }

    public String getLastName(String nickname) {
        return CommandsSQL.getLastNameUser(nickname);
    }

    public int getCount() throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        int count = Integer.parseInt(commandSQL_theme.getAmountAllTheme());
        return count;
    }


    public ObservableList<GetThemeTable> list = FXCollections.observableArrayList(
    );

    public ObservableList<GetThemeTable> getList() throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        for (int i = 0; i < getCount(); i++) {
            list.add(new GetThemeTable(getFirstName(commandSQL_theme.getAllNickname().get(i)),
                    getLastName(commandSQL_theme.getAllNickname().get(i)),
                    commandSQL_theme.getAllTheme().get(i)));
        }
        return list;
    }
}
