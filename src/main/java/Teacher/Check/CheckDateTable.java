package Teacher.Check;

public class CheckDateTable {
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getType() {
        return type;
    }

    public String getFile() {
        return file;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public String getCheck() {
        return check;
    }

    private String id;
    private String name;
    private String lastName;
    private String type;
    private String file;
    private String comment;
    private String date;
    private String check;


    public CheckDateTable(String id, String name, String lastName, String type, String file, String comment, String date, String check) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.type = type;
        this.file = file;
        this.comment = comment;
        this.date = date;
        this.check = check;
    }
}
