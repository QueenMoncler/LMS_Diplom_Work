package Student.HomeTable;

public class TableHome {

    public String getId() {
        return id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public String getTypeTask() {
        return typeTask;
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

    public String getStatus() {
        return status;
    }

    private String id;
    private String discipline;
    private String typeTask;
    private String file;
    private String comment;
    private String date;
    private String status;



    public TableHome(String id, String discipline, String typeTask, String file, String comment, String date, String status) {
        this.id = id;
        this.discipline = discipline;
        this.typeTask = typeTask;
        this.file = file;
        this.comment = comment;
        this.date = date;
        this.status = status;
    }
}
