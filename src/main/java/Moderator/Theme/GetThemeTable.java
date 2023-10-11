package Moderator.Theme;

public class GetThemeTable {

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getThemeName() {
        return themeName;
    }

    private String firstName;
    private String lastName;
    private String themeName;

    public GetThemeTable(String firstName, String lastName, String themeName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.themeName = themeName;
    }



}
