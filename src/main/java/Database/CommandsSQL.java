package Database;

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


}
