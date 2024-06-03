package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommandSQL_Student extends ConnectDB {

    public CommandSQL_Student() throws SQLException {
    }

    public String getNameStudent(String nickname)throws SQLException {
        String query = "select first_name from public.student where nickname = '"+nickname+"'";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("first_name");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getNameStudent");
            throw new RuntimeException(e);
        }
        return null;
    }
    public String getLastNameStudent(String nickname)throws SQLException {
        String query = "select last_name from public.student where nickname = '"+nickname+"'";
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("last_name");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в getLastNameStudent");
            throw new RuntimeException(e);
        }
        return null;
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

    public String getCountCheck(String name, String lastName){
        String query = "select count(*) from student.task_from_student where name_student = '"+name+"' and lastname_student = '"+lastName+"';";
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

    public List<String> getIdHomeTable(String name, String lastName)throws SQLException {
        String query = "select id from student.task_from_student where name_student = '"+name+"' and lastname_student = '"+lastName+"'";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("id"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getIdHomeTable");
            throw new RuntimeException(e);
        }

    }
    public List<String> getDisciplineHomeTable(String name, String lastName)throws SQLException {
        String query = "select discipline from student.task_from_student where name_student = '"+name+"' and lastname_student = '"+lastName+"'";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("discipline"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getDisciplineHomeTable");
            throw new RuntimeException(e);
        }

    }
    public List<String> getTypeTaskHomeTable(String name, String lastName)throws SQLException {
        String query = "select type_task from student.task_from_student where name_student = '"+name+"' and lastname_student = '"+lastName+"'";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("type_task"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getTypeTaskHomeTable");
            throw new RuntimeException(e);
        }

    }
    public List<String> getMaterialHomeTable(String name, String lastName)throws SQLException {
        String query = "select material from student.task_from_student where name_student = '"+name+"' and lastname_student = '"+lastName+"'";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("material"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getMaterialHomeTable");
            throw new RuntimeException(e);
        }

    }
    public List<String> getCommentHomeTable(String name, String lastName)throws SQLException {
        String query = "select comment from student.task_from_student where name_student = '"+name+"' and lastname_student = '"+lastName+"'";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("comment"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getCommentHomeTable");
            throw new RuntimeException(e);
        }

    }
    public List<String> getDatetimeHomeTable(String name, String lastName)throws SQLException {
        String query = "select datetime from student.task_from_student where name_student = '"+name+"' and lastname_student = '"+lastName+"'";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("datetime"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getDatetimeHomeTable");
            throw new RuntimeException(e);
        }

    }
    public List<String> getstatusHomeTable(String name, String lastName)throws SQLException {
        String query = "select status from student.task_from_student where name_student = '"+name+"' and lastname_student = '"+lastName+"'";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("status"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getstatusHomeTable");
            throw new RuntimeException(e);
        }

    }

    public List<String> getListDiscipline()throws SQLException {
        String query = "select discipline_name from discipline.discipline";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("discipline_name"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getListDiscipline");
            throw new RuntimeException(e);
        }

    }

    public List<String> getListMaterial(String name, String lastName, String discipline, String typeTask)throws SQLException {
        String query = "select material from student.task_from_student where name_student = '"+name+"' and lastname_student = '"+lastName+"' and discipline = '"+discipline+"' and type_task = '"+typeTask+"'";
        List<String> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                list.add(result.getString("material"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Ошибка в getListDiscipline");
            throw new RuntimeException(e);
        }

    }
    public String getAnswerAssessment(String id)throws SQLException {
        String query = "select assessment from student.task_testing_for_teacher where task_from_student_id = "+id+"";

        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("assessment");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в getListDiscipline");
            throw new RuntimeException(e);
        }
        return null;
    }
    public String getAnswerCommentAssessment(String id)throws SQLException {
        String query = "select comment_assessment from student.task_testing_for_teacher where task_from_student_id = "+id+"";

        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("comment_assessment");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в getListDiscipline");
            throw new RuntimeException(e);
        }
        return null;
    }
    public String getAnswerMaterial(String id)throws SQLException {
        String query = "select material from student.task_testing_for_teacher where task_from_student_id = "+id+"";

        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("material");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в getAnswerMaterial");
            throw new RuntimeException(e);
        }
        return null;
    }
    public String getAnswerComment(String id)throws SQLException {
        String query = "select comment from student.task_testing_for_teacher where task_from_student_id = "+id+"";

        try (Statement statement = connection.createStatement();) {
            ResultSet result;
            result = statement.executeQuery(query);
            while (result.next()) {
                return result.getString("comment");
            }

        } catch (SQLException e) {
            System.out.println("Ошибка в getAnswerComment");
            throw new RuntimeException(e);
        }
        return null;
    }



    public String updateStatusStudentFromTeacher(String id)throws SQLException{
        String query = "update student.task_from_student set status = 'Просмотрено' where id = "+id+";";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            return "Тема добавлена успешно";
        }
    }

    public String setAnswerStudentFromTeacher(String id, String material, String comment)throws SQLException{
        String query = "insert into student.task_testing_for_teacher(task_from_student_id, material, comment) VALUES ("+id+", '"+material+"', '"+comment+"')";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            return "Тема добавлена успешно";
        }
    }
    public String updateStatusAnswerStudentFromTeacher(String id)throws SQLException{
        String query = "update student.task_from_student set status = 'На оценке' where id = "+id+";";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            return "Тема добавлена успешно";
        }
    }



}
