package Database;

import java.sql.*;

public class ConnectDB {
    ConfigDataBase configDataBase;

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

    public static void testQuery(String query) {
        try (Connection connection = DriverManager
                .getConnection(ConfigDataBase.getUrl(),
                        ConfigDataBase.getUsername(),
                        ConfigDataBase.getPassword())) {
            Statement statement = connection.createStatement();
            ResultSet result;
            result = statement.executeQuery(query);
            System.out.println("ID | FIRST_NAME | LAST_NAME | EMAIL");
            while (result.next()) {
                String id = result.getString("id");
                String firstName = result.getString("first_name");
                String lastname = result.getString("last_name");
                String email = result.getString("email");
                System.out.println(id + " | " + firstName + " | " + lastname + " | " + email);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка в TestQuery");
            throw new RuntimeException(e);
        }
    }

    public static void prost(String query) {
        String url = "jdbc:postgresql://localhost:1625/postgres";
        String username = "QUEEN";
        String password = "2402";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement stat = connection.createStatement();
            ResultSet result;
            result = stat.executeQuery(query);
            System.out.println("ID | FIRST_NAME | LAST_NAME | EMAIL");
            while (result.next()) {
                String id = result.getString("id");
                String firstName = result.getString("first_name");
                String lastname = result.getString("last_name");
                String email = result.getString("email");
                System.out.println(id + " | " + firstName + " | " + lastname + " | " + email);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }


}
