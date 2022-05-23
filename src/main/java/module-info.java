module com.project.advancedcomputerprogrammingfinalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.apache.poi.ooxml;
    requires json.simple;
    requires log4j;

    opens com.GUI to javafx.fxml;
    exports com.GUI;
}