package Moderator.Home;

import Database.CommandSQL_Theme;
import Database.CommandsSQL_Teachers;
import javafx.scene.image.Image;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TeacherCards {

    public static String nickname;

    public TeacherCards(String nickname) {
        this.nickname = nickname;
    }


    private URL urlTeacherZhilina = getClass().getResource("/Images/zhilina.png");
    private URL urlTeacherKnyazev = getClass().getResource("/Images/knyazev.png");
    private URL urlPivtoratskaya = getClass().getResource("/Images/vornikova.png");
    private URL urlVornikova = getClass().getResource("/Images/vornikova.png");
    Map<Integer, Image> teacherStaff = new HashMap<>();

    public void setStaff() {
        teacherStaff.put(0, new Image(urlTeacherZhilina.toExternalForm()));
        teacherStaff.put(1, new Image(urlTeacherKnyazev.toExternalForm()));
        teacherStaff.put(2, new Image(urlPivtoratskaya.toExternalForm()));
        teacherStaff.put(3, new Image(urlVornikova.toExternalForm()));
    }



    public static String[] nameStaff;
    public static String themeAmount;
    public static String taskAmount;

//    public static void setNameStaff() throws SQLException {
//        CommandsSQL_Teachers commandsSQL_teachers = new CommandsSQL_Teachers();
//        nameStaff = commandsSQL_teachers.getAllNameTeachers(nickname);
//    }
//
//    public static void setThemeAmount() throws SQLException {
//        CommandSQL_Theme commandSQLTheme = new CommandSQL_Theme();
//        themeAmount = commandSQLTheme.getAmountThemeTeacher(nickname);
//    }
//
//    public static void setTaskAmount() throws SQLException {
//        CommandSQL_Theme commandSQLTheme = new CommandSQL_Theme();
//        taskAmount = commandSQLTheme.getAmountTaskTeacher(nickname);
//    }


    public Map<Integer, Image> getTeacherStaff() {
        setStaff();
        return teacherStaff;
    }

//    public static String[] getNameStaff() throws SQLException {
//        setNameStaff();
//        return nameStaff;
//    }

    public static String getThemeAmount(String nickname) throws SQLException {
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        return commandSQL_theme.getAmountThemeTeacher(nickname);
    }

    public static String getTaskAmount(String nickname) throws SQLException{
        CommandSQL_Theme commandSQL_theme = new CommandSQL_Theme();
        return commandSQL_theme.getAmountTaskTeacher(nickname);
    }

}
