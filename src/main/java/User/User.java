package User;

public class User {
    public static String getUserNickname() {
        return userNickname;
    }

    public static void setUserNickname(String userNickname) {
        User.userNickname = userNickname;
    }

    private static String userNickname;

}
