package Database;

import Moderator.Home.TeacherCards;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandsSQL extends ConnectDB {

    public CommandsSQL() throws SQLException {
    }

    public static void selectAll(String table) {
        String query = "SELECT * FROM %s".formatted(table);
        try(Statement statement = connection.createStatement();)  {
            ResultSet result;
            result = statement.executeQuery(query);
            System.out.println("ID | FIRST_NAME | LAST_NAME | EMAIL");
            while (result.next()) {
                System.out.println(result.getString("id") + " | "
                        + result.getString("first_name") + " | "
                        + result.getString("last_name") + " | "
                        + result.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в selectAll");
            throw new RuntimeException(e);
        }
    }

    public static void selectStr(String str, String table) {
        String query = "SELECT "+str+" FROM "+table+"";
        try(Statement statement = connection.createStatement();)  {
            ResultSet result;
            result = statement.executeQuery(query);
            System.out.println("EMAIL");
            while (result.next()) {
                System.out.println(
                        result.getString("email"));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в selectStr");
            throw new RuntimeException(e);
        }
    }
    public static boolean searchNickname(String nickname){
        String query = "SELECT nickname from allconfig where nickname = '"+ nickname +"';";
        try(Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в searchNickname");
            throw new RuntimeException(e);
        }
        return false;
    }

    public static String getCountId() {
        String query = "SELECT count(id) from ticher";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                System.out.println(result.getString("count"));
                return result.getString("count");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в getCountId");
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String nameUser(String nickname) {

        String query = "SELECT first_name, last_name from moderator where nickname = '" + nickname + "';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {

                return result.getString("first_name") + " " + result.getString("last_name");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в nameUser");
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String getLastNameUser(String nickname) {
        String query = "SELECT last_name from ticher where nickname = '" + nickname + "';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {

                return result.getString("last_name");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getLastNameUser");
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String getFirstNameUser(String nickname) {
        String query = "SELECT first_name from ticher where nickname = '" + nickname + "';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("first_name");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getFirstNameUser");
            throw new RuntimeException(e);
        }
        return null;
    }

    public static String getAmountTheme(){
        String query = "SELECT count(id) from theme";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAmountTheme");
            throw new RuntimeException(e);
        }
        return null;
    }


    public static String getAmountStudent(){
        String query = "SELECT count(id) from student";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAmountStudent");
            throw new RuntimeException(e);
        }
        return null;
    }


    public static String addTask() throws SQLException {
        String query = "INSERT INTO task(theme, task_name, task_text, task_file) " +
                        "VALUES('тест', 'тест', 'тест', ?)";
        File file = new File("TaskFile/IKT/testFileIKT.txt");
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try(FileInputStream fileInputStream = new FileInputStream(file)){
            statement.setBinaryStream(1, fileInputStream);
            statement.executeUpdate();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public static String getTask(){
        String query = "select convert_from(task_file, 'UTF8') from task where task_name = 'тест'";
        try (Statement statement = connection.createStatement()) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("convert_from");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getTask");
            throw new RuntimeException(e);
        }
        return null;
    }





}
