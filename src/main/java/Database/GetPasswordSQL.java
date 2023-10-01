package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetPasswordSQL extends ConnectDB {
    public GetPasswordSQL() throws SQLException {
    }
    public static String getPass(String nickname) {
        String query = "select password from allconfig where nickname = '"+nickname+"';";
        try(Statement statement = connection.createStatement())  {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("password");
            }


        } catch (SQLException e) {
            System.out.println("Ошибка в getPass");
            throw new RuntimeException(e);
        }
        return null;
    }
}
