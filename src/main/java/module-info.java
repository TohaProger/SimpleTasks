module com.example.program {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    opens com.example.program.Model to javafx.fxml;
    opens com.example.program to javafx.fxml;
    exports com.example.program;
    exports com.example.program.Model;
    exports com.example.program.Controllers;
    opens com.example.program.Controllers to javafx.fxml;
    exports com.example.program.DAO;
    opens com.example.program.DAO to javafx.fxml;
    exports com.example.program.Repository;
    opens com.example.program.Repository to javafx.fxml;
}