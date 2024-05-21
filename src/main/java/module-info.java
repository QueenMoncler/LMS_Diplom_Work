module com.example.lms_diplom_work {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens Moderator.Home to javafx.fxml;
    opens Moderator to javafx.fxml;
    opens com.example.lms_diplom_work to javafx.fxml;
    opens Moderator.Theme to javafx.fxml;
    opens Moderator.Student to javafx.fxml;
    opens Teacher to javafx.fxml;
    opens Teacher.Send to javafx.fxml;
    opens Teacher.Check to javafx.fxml;
    opens Student to javafx.fxml;
    opens Student.HomeTable to javafx.fxml;

    exports com.example.lms_diplom_work;
    exports Moderator;
    exports Moderator.Home;
    exports Moderator.Theme;
    exports Moderator.Student;
    exports Teacher;
    exports Teacher.Send;
    exports Teacher.Check;
    exports Student;
    exports Student.HomeTable;
}
