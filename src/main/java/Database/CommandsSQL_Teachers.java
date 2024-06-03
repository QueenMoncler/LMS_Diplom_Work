package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandsSQL_Teachers extends ConnectDB {

    public CommandsSQL_Teachers() throws SQLException {

    }

    public String getCountNeprochitano(String discipline) throws SQLException {
        String query = "select count(*) from student.task_testing_for_teacher\n" +
                "    join student.task_from_student on student.task_testing_for_teacher.task_from_student_id = student.task_from_student.id\n" +
                "    where student.task_testing_for_teacher.status = 'На проверке' AND student.task_from_student.discipline = '"+discipline+"';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getCountNeprochitano");
            throw new RuntimeException(e);
        }
        return null;
    }
    public String getCountDisciplineTeacher(String surname) throws SQLException {
        String query = " select count(*) from public.discipline_ticher where ticher_surname = '"+surname+"'";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getCountDisciplineTeacher");
            throw new RuntimeException(e);
        }
        return null;
    }
    public static List<String> getDisciplineNameSurname(String surname) throws SQLException {
        List<String> nameStaff = new ArrayList<>();
        String query = "select discipline_name from public.discipline_ticher where ticher_surname = '"+surname+"'";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);

            while (result.next()) {
                nameStaff.add(result.getString("discipline_name"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getDisciplineNameSurname");
            throw new RuntimeException(e);
        }
        return nameStaff;
    }
    public static List<String> getAllTeach() throws SQLException {
        List<String> nameStaff = new ArrayList<>();
        String query = "Select CONCAT(first_name, ' ',last_name) AS name from public.ticher";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);

            while (result.next()) {
                nameStaff.add(result.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAllTeach");
            throw new RuntimeException(e);
        }
        return nameStaff;
    }


    public static List<String> getAllNameTeachers(String nickname) throws SQLException {
        List<String> nameStaff = new ArrayList<>();
        String query = "SELECT first_name, last_name from ticher where nickname = '" + nickname + "';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            int i = 0;
            while (result.next()) {
                nameStaff.add(result.getString("first_name") + " " + result.getString("last_name"));
                i += 1;
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAllNameTeachers");
            throw new RuntimeException(e);
        }
        return nameStaff;
    }

    public String getAmountAllTeachers() throws SQLException {
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

    public String getNicknameKeyFirstName(String firstName) throws SQLException {
        String query = "select nickname from ticher where first_name = '"+firstName+"';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("nickname");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getNicknameKeyFirstName");
            throw new RuntimeException(e);
        }
        return null;
    }


    public String getNicknameKeyLastName(String lastName) throws SQLException {
        String query = "select nickname from ticher where last_name = '"+lastName+"';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("nickname");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getNicknameKeyLastName");
            throw new RuntimeException(e);
        }
        return null;
    }
    public String getDisciplineTeacher(String nickname) throws SQLException{
        String query = "select discipline_name from discipline_ticher where nickname = '"+nickname+"'";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("discipline_name");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getDisciplineTeacher");
            throw new RuntimeException(e);
        }
        return null;
    }
    public List<String> getAllDiscipline() throws SQLException{
        List<String> allDiscipline = new ArrayList<>();
        String query = "select * from discipline.discipline";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                allDiscipline.add(result.getString("discipline_name"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAllDiscipline");
            throw new RuntimeException(e);
        }
        return allDiscipline;
    }
    public List<String> getAllDisciplineGroup(String nickname) throws SQLException{
        List<String> allDiscipline = new ArrayList<>();
        String query = "select discipline_name from public.discipline_ticher where nickname = '"+nickname+"' ";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                allDiscipline.add(result.getString("discipline_name"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getAllDisciplineGroup");
            throw new RuntimeException(e);
        }
        return allDiscipline;
    }
    public List<String> getDisciplineTeacherList(String nickname) throws SQLException{
        String query = "select discipline_name from discipline_ticher where nickname = '"+nickname+"'";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("discipline_name"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getDisciplineTeacher");
            throw new RuntimeException(e);
        }
    }






}
