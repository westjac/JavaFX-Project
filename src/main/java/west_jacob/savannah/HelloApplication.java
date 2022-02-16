package west_jacob.savannah;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

// JAVA FX Project GUI Spring 2022
// Jacob B. West
// 02/15/2022

//        X Followed the class OOP diagram 	14
//        X Observer pattern (ignores tiers)	20
//
//
//        1.	Tier: Views and animal
//        X a. All objects (ignoring the sim area)
//        X b. Have a 9 tile sim area	5
//        X c. Able to add/remove an animal properly
//        X d. Info bar listed correctly with all three items with default values
//        X e. Tile Text correct for each for one rectangle
//        X f. Tile Text correct for each for all rectangles
//        X g. Radio buttons update properly
//        X h. Selecting a rectangle with “view” affects the animal info somehow
//        X i. Selecting a rectangle with “view” affects the animal info correctly
//
//
//        2a Tier: Advanced functionality	32
//        X a. New day button has some noticeable effect
//        X b. Animals updated properly on “new day”
//        X c. Day count in info bar is correct
//        X d. Animal removed when dead on “new day”
//        X e. Num died in info bar is correct (updates on the day the animal dies)
//        X f. Num tiles filled in info bar is correct at all times
//        X e. The animal info at least holds
//        X f. Reselecting the tile updates the animal information correctly
//
//
//        2b: Layout	48
//        X a. Location of all items in correct spot
//        X b. Layout still correct on window resize
//        X c. Resize grid at minimum resets the grid and info
//        X d. Everything still working that is listed above with resize
//
//
//        Final Tier: Extensions 30
//        1) 3a (10pts) hotkeys: n -> new day; 3 -> 3x3 grid; 5 -> 5x5 grid; 8 -> 8x8 grid
//        2) 2b (10pts) button images: Shows image of animal or just a savannah if there is no animal
//        3) 2c (10pts) Shows the animal image when viewing the detailed info
//
//
//        The grade you compute is the starting point for course staff, who reserve the right to change the grade if they
//        disagree with your assessment and to deduct points for other issues they may encounter, such as errors in the
//        submission process, naming issues, etc.

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new Layout(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}