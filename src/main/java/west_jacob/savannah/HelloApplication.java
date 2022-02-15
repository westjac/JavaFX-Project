package west_jacob.savannah;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

//Button when clicked displays some text in the window

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Layout layout = new Layout(stage);
        layout.show();

    }

    public static void main(String[] args) {
        launch();
    }
}