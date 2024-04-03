package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandsSQL_Discipline extends ConnectDB {

    public CommandsSQL_Discipline() throws SQLException {

    }
    public String getCountDisciplineTicher(){
        String query = "select count(*) from discipline_ticher;";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в getCountDisciplineTicher");
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<String> getNameDisciplineTeacher()throws SQLException{
        String query = "SELECT ticher_name from discipline_ticher";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("ticher_name"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getNameDisciplineTeacher");
            throw new RuntimeException(e);
        }
    }
    public List<String> getSurnameDisciplineTeacher()throws SQLException{
        String query = "SELECT ticher_surname from discipline_ticher";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("ticher_surname"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getSurnameDisciplineTeacher");
            throw new RuntimeException(e);
        }
    }
    public List<String> getDisciplineNameDisciplineTeacher()throws SQLException{
        String query = "SELECT discipline_name from discipline_ticher";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("discipline_name"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getDisciplineNameDisciplineTeacher");
            throw new RuntimeException(e);
        }
    }
    public String addNewDisciplineTeacher(String disciplineName, String ticherName, String ticherSUrname, String nickname)throws SQLException{
        String query = "INSERT INTO discipline_ticher(discipline_name, ticher_name, ticher_surname, nickname) VALUES('"+disciplineName+"','"+ticherName+"','"+ticherSUrname+"','"+nickname+"')";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            return "Дисциплина добавлена успешно";
        }

    }
}
