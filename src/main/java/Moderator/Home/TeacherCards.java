package Moderator.Home;

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
    private URL urlVornikova = getClass().getResource("/Images/vornikova.png");
    Map<Integer, Image> teacherStaff = new HashMap<>();

    public void setStaff() {
        teacherStaff.put(0, new Image(urlTeacherZhilina.toExternalForm()));
        teacherStaff.put(1, new Image(urlTeacherKnyazev.toExternalForm()));
        teacherStaff.put(2, new Image(urlVornikova.toExternalForm()));
    }



    public static String[] nameStaff;
    public static String themeAmount;
    public static String taskAmount;

    public static void setNameStaff() throws SQLException {
        CommandsSQL_Teachers commandsSQL_teachers = new CommandsSQL_Teachers();
        nameStaff = commandsSQL_teachers.getAllNameTeachers(nickname);
    }

    public static void setThemeAmount() throws SQLException {
        CommandsSQL_Teachers commandsSQL_teachers = new CommandsSQL_Teachers();
        themeAmount = commandsSQL_teachers.getAmountThemeTeacher(nickname);
    }

    public static void setTaskAmount() throws SQLException {
        CommandsSQL_Teachers commandsSQL_teachers = new CommandsSQL_Teachers();
        taskAmount = commandsSQL_teachers.getAmountTaskTeacher(nickname);
    }


    public Map<Integer, Image> getTeacherStaff() {
        setStaff();
        return teacherStaff;
    }

    public static String[] getNameStaff() throws SQLException {
        setNameStaff();
        return nameStaff;
    }

    public static String getThemeAmount() throws SQLException {
        setThemeAmount();
        return themeAmount;
    }

    public static String getTaskAmount() throws SQLException{
        setTaskAmount();
        return taskAmount;
    }




}
