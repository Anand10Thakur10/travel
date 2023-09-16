module com.example.travel {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.sql;

    opens com.example.travel to javafx.fxml;
    exports com.example.travel;
}