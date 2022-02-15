module west_jacob.savannah {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens west_jacob.savannah to javafx.fxml;
    exports west_jacob.savannah;
}