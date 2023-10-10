package Moderator.Theme;

import Database.CommandSQL_Theme;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class AddNewTheme {
    public static void addTheme(TextField nameTheme, String nickname) throws SQLException {
       CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
       commandSQL_theme.addNewThemeTeacher(nickname, nameTheme.getText());



    }
}
