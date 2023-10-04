package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandsSQL_Teachers extends ConnectDB {

    public CommandsSQL_Teachers() throws SQLException {
    }
    public static String getAllNameTeachers(String nickname) {

        String query = "SELECT first_name, last_name from teachers where nickname = '" + nickname + "';";
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
}
