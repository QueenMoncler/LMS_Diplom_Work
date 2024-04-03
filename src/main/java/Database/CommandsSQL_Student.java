package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandsSQL_Student extends ConnectDB {

    public CommandsSQL_Student() throws SQLException {

    }
    public List<String> getAllGroup()throws SQLException {
        String query = "select distinct class from student;";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("class"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getAllGroup");
            throw new RuntimeException(e);
        }

    }

    public String getCountStudent(){
        String query = "select count(*) from student;";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в getCountStudent");
            throw new RuntimeException(e);
        }
        return null;
    }


    public List<String> getIDStudent()throws SQLException {
        String query = "SELECT id from student";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("id"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getIDStudent");
            throw new RuntimeException(e);
        }
    }
    public List<String> getFirstNameStudent()throws SQLException {
        String query = "SELECT first_name from student";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("first_name"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getFirstNameStudent");
            throw new RuntimeException(e);
        }
    }
    public List<String> getLastNameStudent()throws SQLException {
        String query = "SELECT last_name from student";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("last_name"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getLastNameStudent");
            throw new RuntimeException(e);
        }
    }
    public List<String> getGroupStudent()throws SQLException {
        String query = "SELECT class from student";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("class"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getGroupStudent");
            throw new RuntimeException(e);
        }
    }
    public List<String> getAgeStudent()throws SQLException {
        String query = "SELECT age from student";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("age"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getAgeStudent");
            throw new RuntimeException(e);
        }
    }
    public List<String> getGenderStudent()throws SQLException {
        String query = "SELECT gender from student";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("gender"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getGenderStudent");
            throw new RuntimeException(e);
        }
    }
    public List<String> getEmailStudent()throws SQLException {
        String query = "SELECT email from student";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("email"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getEmailStudent");
            throw new RuntimeException(e);
        }
    }
    public List<String> getNicknameStudent()throws SQLException {
        String query = "SELECT nickname from student";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            List<String> list = new ArrayList<>();
            while (result.next()) {
                list.add(result.getString("nickname"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getNicknameStudent");
            throw new RuntimeException(e);
        }
    }
}
