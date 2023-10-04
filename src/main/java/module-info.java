module com.example.lms_diplom_work {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;

    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens Moderator.Home to javafx.fxml;
    opens Moderator to javafx.fxml;
    opens com.example.lms_diplom_work to javafx.fxml;
    exports com.example.lms_diplom_work;
    exports Moderator;
    exports Moderator.Home;
}
