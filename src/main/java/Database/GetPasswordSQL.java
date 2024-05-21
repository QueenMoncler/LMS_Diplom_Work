package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetPasswordSQL extends ConnectDB {
    public GetPasswordSQL() throws SQLException {
    }
    public static Boolean getPass(String nickname, String password) {
        String query = "select * from public.alluser where nickname = '"+nickname+"' AND password = MD5('"+password+"');";
        try(Statement statement = connection.createStatement())  {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return true;
            }


        } catch (SQLException e) {
            System.out.println("Ошибка в getPass");
            throw new RuntimeException(e);
        }
        return false;
    }
    public static Boolean getPassTeacher(String nickname, String password) {
        String query = "select * from ticher_config_account where nickname = '"+nickname+"' AND password = '"+password+"';";
        try(Statement statement = connection.createStatement())  {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return true;
            }


        } catch (SQLException e) {
            System.out.println("Ошибка в getPass");
            throw new RuntimeException(e);
        }
        return false;
    }
}
