package west_jacob.savannah;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

// JAVA FX Project GUI Spring 2022
// Jacob B. West
// 02/15/2022

//  ***Project Extensions***
//  1) 3a (10pts) hotkeys: n -> new day; 3 -> 3x3 grid; 5 -> 5x5 grid; 8 -> 8x8 grid
//  2) 2b (10pts) button images: Shows image of animal or just a savannah if there is no animal
//  3) 2c (10pts) Shows the animal image when viewing the detailed info

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new Layout(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}