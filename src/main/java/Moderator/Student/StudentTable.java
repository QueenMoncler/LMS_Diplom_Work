package Moderator.Student;

public class StudentTable {

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    private String id;
    private String name;
    private String lastName;
    private String group;
    private String age;
    private String gender;
    private String email;
    private String nickname;

    public StudentTable(String id, String name, String lastName, String group, String age, String gender, String email, String nickname) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.group = group;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.nickname = nickname;
    }
}
