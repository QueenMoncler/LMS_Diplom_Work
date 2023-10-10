package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandsSQL_Teachers extends ConnectDB {

    public CommandsSQL_Teachers() throws SQLException {

    }
    public static String[] getAllNameTeachers(String nickname)throws SQLException {
        String[] nameStaff = null;
        String query = "SELECT first_name, last_name from teachers where nickname = '" + nickname + "';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            int i = 0;
            while (result.next()) {
                nameStaff[i] = result.getString("first_name") + " " + result.getString("last_name");
                i+=1;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAllNameTeachers");
            throw new RuntimeException(e);
        }
        return nameStaff;
    }

    public  String getAmountAllTeachers()throws SQLException {
        String query = "SELECT count(id) from ticher;";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAmountAllTeachers");
            throw new RuntimeException(e);
        }
        return null;
    }


}
