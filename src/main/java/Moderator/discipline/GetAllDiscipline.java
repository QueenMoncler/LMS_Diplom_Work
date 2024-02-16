package Moderator.discipline;

import Database.ConnectDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class GetAllDiscipline extends ConnectDB {

    public GetAllDiscipline() throws SQLException{

    }
    String query = "Select * from "+"discipline"+".discipline";

//     public String getNicknameKeyLastName(String lastName) throws SQLException {
//String query = "select nickname from ticher where last_name = '"+lastName+"';";
//        try (Statement statement = connection.createStatement();) {
//            ResultSet result;
//            result = statement.executeQuery(query);
//            while (result.next()) {
//                return result.getString("nickname");
//            }
//        } catch (SQLException e) {
//            System.out.println("Ошибка в getNicknameKeyLastName");
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

}
