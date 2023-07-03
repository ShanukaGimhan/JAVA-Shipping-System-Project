module com.ship.ship {
    requires javafx.controls;
    requires javafx.fxml;
    requires bcrypt;
    requires gluonfx.maven.plugin;
    requires com.gluonhq.substrate;
    requires charm;
    requires java.sql;
    requires com.google.common;


    opens manage.ship to javafx.fxml;
    exports manage.ship;
    exports manage.ship.controllers;
    opens manage.ship.controllers to javafx.fxml;
}