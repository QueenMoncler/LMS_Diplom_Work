package Database;

public class ConfigDataBase {

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    private static String url = "jdbc:postgresql://localhost:1625/postgres";
    private static String username = "QUEEN";
    private static String password = "2402";
}
