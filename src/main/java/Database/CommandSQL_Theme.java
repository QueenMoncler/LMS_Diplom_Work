package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandSQL_Theme extends ConnectDB {

    public CommandSQL_Theme() throws SQLException {

    }

    public  String getAmountAllTheme()throws SQLException {
        String query = "SELECT count(id) from theme_ticher;";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAmountAllTheme");
            throw new RuntimeException(e);
        }
        return null;
    }

    public  String getAmountThemeTeacher(String nickname)throws SQLException {
        String query = "SELECT count(id) from theme_ticher where nickname = '"+nickname+"';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAmountThemeTeacher");
            throw new RuntimeException(e);
        }
        return null;
    }

    public  String getAmountTaskTeacher(String nickname)throws SQLException{
        String query = "SELECT count(id) from task_ticher where nickname = '"+nickname+"';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAmountTaskTeacher");
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<String> getAllTheme()throws SQLException{
        String query = "SELECT theme from theme_ticher;";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
               list.add(result.getString("theme"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getAmountTaskTeacher");
            throw new RuntimeException(e);
        }
    }
    public List<String> getTeacherTheme(String nickname)throws SQLException{
        String query = "SELECT theme from theme_ticher where nickname = '"+nickname+"';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("theme"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getAmountTaskTeacher");
            throw new RuntimeException(e);
        }
    }
    public List<String> getAllNickname()throws SQLException{
        String query = "SELECT nickname from theme_ticher;";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("nickname"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getAllNickname");
            throw new RuntimeException(e);
        }
    }


    public String addNewThemeTeacher(String nickname, String themeName)throws SQLException{
        String query = "INSERT INTO theme_ticher(nickname, theme) VALUES('"+nickname+"', '"+themeName+"')";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.executeUpdate();
                addNewTheme(themeName);
                return "Тема добавлена успешно";
        }
    }

    public String addNewTheme(String themeName)throws SQLException{
        String query = "INSERT INTO theme(name) VALUES('"+themeName+"')";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            return "Тема добавлена успешно";
        }
    }





}
