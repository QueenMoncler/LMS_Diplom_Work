package Database;

import java.sql.*;

public class ConnectDB {
    ConfigDataBase configDataBase;
    static Connection connection;

    static {
        try {
            connection = DriverManager
                    .getConnection(ConfigDataBase.getUrl(),
                            ConfigDataBase.getUsername(),
                            ConfigDataBase.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ConnectDB() throws SQLException {
    }

    public Connection connect() {
        System.out.println("Connecting...");
        try (Connection connection = DriverManager
                .getConnection(ConfigDataBase.getUrl(),
                        ConfigDataBase.getUsername(),
                        ConfigDataBase.getPassword())) {
            System.out.println("Connection!");
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return null;
    }





}
