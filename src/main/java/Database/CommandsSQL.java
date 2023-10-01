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




}
