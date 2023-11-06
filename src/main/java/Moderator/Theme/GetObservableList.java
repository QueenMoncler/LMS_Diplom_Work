package Moderator.Theme;

import Database.CommandSQL_Theme;
import Database.CommandsSQL;
import Database.CommandsSQL_Teachers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.Arrays;
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
    public int getCountTeacher(String nickname) throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        int count = Integer.parseInt(commandSQL_theme.getAmountThemeTeacher(nickname));
        return count;
    }


    public ObservableList<GetThemeTable> list = FXCollections.observableArrayList(
    );
    public ObservableList<GetThemeTable> listTableThemeTeacher = FXCollections.observableArrayList(
    );
    public ObservableList<String> listTeacher = FXCollections.observableArrayList(
    );

    public ObservableList<GetThemeTable> getList() throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        for (int i = 0; i < getCountAllTeacher(); i++) {
            list.add(new GetThemeTable(getFirstName(commandSQL_theme.getAllNickname().get(i)),
                    getLastName(commandSQL_theme.getAllNickname().get(i)),
                    commandSQL_theme.getAllTheme().get(i)));
        }
        return list;
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
    public ObservableList<String> getListTeacher(String nickname) throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        for(String s:commandSQL_theme.getTeacherTheme(nickname)){
            listTeacher.add(s);
        }
        return listTeacher;
    }
}
