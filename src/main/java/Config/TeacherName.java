package Config;

import Database.CommandsSQL_Teachers;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TeacherName {
    Map<String,String> kFirstNvNickname = new HashMap<>();
    Map<String,String> kLastNvNickname = new HashMap<>();
    public void setKFirstNvNickname() throws SQLException {
        CommandsSQL_Teachers commandsSQLTeachers = new CommandsSQL_Teachers();

    }
}
