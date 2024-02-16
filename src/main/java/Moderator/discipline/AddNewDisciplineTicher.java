package Moderator.discipline;

import Database.CommandSQL_Theme;
import Database.CommandsSQL_Discipline;
import Database.CommandsSQL_Teachers;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.List;

public class AddNewDisciplineTicher {
    public static void addDisciplineTicher(ComboBox<String> stringComboBox,String nickname) throws SQLException {
        CommandsSQL_Discipline commandsSQLDiscipline = new CommandsSQL_Discipline();
        CommandsSQL_Teachers commandsSQL_teachers = new CommandsSQL_Teachers();
        List<String> listFIO = commandsSQL_teachers.getAllNameTeachers(nickname);
        String[] list = listFIO.get(0).split(" ");
        //System.out.println(list[0] + "\n"+ list[1]);
        commandsSQLDiscipline.addNewDisciplineTeacher(stringComboBox.getValue(), list[0], list[1], nickname);
        System.out.println(stringComboBox.getValue() + list[0] + list[1] + nickname);
    }
}
