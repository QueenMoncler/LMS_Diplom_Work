package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandSQL_Task extends ConnectDB {
    public CommandSQL_Task() throws SQLException {
    }

    public List<String> getTaskTeacher(String nickname)throws SQLException {
        String query = "select task_name from task_ticher where nickname = '"+nickname+"';";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("task_name"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getTaskTeacher");
            throw new RuntimeException(e);
        }
        return list;
    }



}
