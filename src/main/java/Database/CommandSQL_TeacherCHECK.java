package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandSQL_TeacherCHECK extends ConnectDB{
    public CommandSQL_TeacherCHECK() throws SQLException {
    }
    public List<String> getIdCheckTable(String discipline)throws SQLException {
        String query = "select student.task_testing_for_teacher.id from student.task_testing_for_teacher \n" +
                "join student.task_from_student on student.task_testing_for_teacher.task_from_student_id = student.task_from_student.id\n" +
                "where student.task_from_student.discipline = '"+discipline+"' and student.task_testing_for_teacher.status = 'На проверке';";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("id"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getIdCheckTable");
            throw new RuntimeException(e);
        }

    }
    public List<String> getNameCheckTable(String discipline)throws SQLException {
        String query = "select student.task_from_student.name_student from student.task_testing_for_teacher \n" +
                "join student.task_from_student on student.task_testing_for_teacher.task_from_student_id = student.task_from_student.id\n" +
                "where student.task_from_student.discipline = '"+discipline+"' and student.task_testing_for_teacher.status = 'На проверке';";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("name_student"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getNameCheckTable");
            throw new RuntimeException(e);
        }

    }
    public List<String> getLastNameCheckTable(String discipline)throws SQLException {
        String query = "select student.task_from_student.lastname_student from student.task_testing_for_teacher \n" +
                "join student.task_from_student on student.task_testing_for_teacher.task_from_student_id = student.task_from_student.id\n" +
                "where student.task_from_student.discipline = '"+discipline+"' and student.task_testing_for_teacher.status = 'На проверке';";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("lastname_student"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getLastNameCheckTable");
            throw new RuntimeException(e);
        }
    }
    public List<String> getTypeCheckTable(String discipline)throws SQLException {
        String query = "select student.task_from_student.type_task from student.task_testing_for_teacher \n" +
                "join student.task_from_student on student.task_testing_for_teacher.task_from_student_id = student.task_from_student.id\n" +
                "where student.task_from_student.discipline = '"+discipline+"' and student.task_testing_for_teacher.status = 'На проверке';";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("type_task"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getTypeCheckTable");
            throw new RuntimeException(e);
        }
    }
    public List<String> getMaterialCheckTable(String discipline)throws SQLException {
        String query = "select student.task_testing_for_teacher.material from student.task_testing_for_teacher \n" +
                "join student.task_from_student on student.task_testing_for_teacher.task_from_student_id = student.task_from_student.id\n" +
                "where student.task_from_student.discipline = '"+discipline+"' and student.task_testing_for_teacher.status = 'На проверке';";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("material"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getMaterialCheckTable");
            throw new RuntimeException(e);
        }
    }
    public List<String> getCommentCheckTable(String discipline)throws SQLException {
        String query = "select student.task_testing_for_teacher.comment from student.task_testing_for_teacher \n" +
                "join student.task_from_student on student.task_testing_for_teacher.task_from_student_id = student.task_from_student.id\n" +
                "where student.task_from_student.discipline = '"+discipline+"' and student.task_testing_for_teacher.status = 'На проверке';";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("comment"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getCommentCheckTable");
            throw new RuntimeException(e);
        }
    }
    public List<String> getDateTimeCheckTable(String discipline)throws SQLException {
        String query = "select student.task_testing_for_teacher.datetime from student.task_testing_for_teacher \n" +
                "join student.task_from_student on student.task_testing_for_teacher.task_from_student_id = student.task_from_student.id\n" +
                "where student.task_from_student.discipline = '"+discipline+"' and student.task_testing_for_teacher.status = 'На проверке';";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("datetime"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getDateTimeCheckTable");
            throw new RuntimeException(e);
        }
    }

    public String getCountCheck(String dicipline){
        String query = "select count(*) from student.task_testing_for_teacher \n" +
                "join student.task_from_student on student.task_testing_for_teacher.task_from_student_id = student.task_from_student.id\n" +
                "where student.task_from_student.discipline = '"+dicipline+"' and student.task_testing_for_teacher.status = 'На проверке';";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("count");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в getCountCheck");
            throw new RuntimeException(e);
        }
        return null;
    }

    public String updateTaskTestingForTeacher(String id, String assessment, String comment)throws SQLException{
        String query = "update student.task_testing_for_teacher " +
                "set assessment = '"+assessment+"', " +
                "comment_assessment = '"+comment+"', " +
                "date_assessment = NOW() " +
                "where id = "+id+"; ";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            return "Успешно";
        }
    }
    public String getTaskFromStudentId(String id){
        String query = "select task_from_student_id from student.task_testing_for_teacher where id = "+id+"";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return String.valueOf(result.getInt("task_from_student_id"));
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в getTaskFromStudentId");
            throw new RuntimeException(e);
        }
        return null;
    }
    public String updateTaskFromStudent(String id, String assessment)throws SQLException{
        String query = "update student.task_from_student set status = '"+assessment+"' where id = "+id+"'";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            return "Успешно";
        }
    }
}
