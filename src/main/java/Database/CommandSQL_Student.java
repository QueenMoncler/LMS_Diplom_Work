package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandSQL_Student extends ConnectDB {

    public CommandSQL_Student() throws SQLException {
    }

    public String getAmountAllStudent()throws SQLException {
        String query = "SELECT count(id) from student;";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAmountAllStudent");
            throw new RuntimeException(e);
        }
        return null;
    }

}
