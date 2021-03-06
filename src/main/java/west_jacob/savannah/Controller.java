package west_jacob.savannah;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static west_jacob.savannah.Layout.*;

public class Controller {
    public Savannah model;
    private Layout layout;
    private SavannahView view;

    public Controller(Savannah m, Layout l) {
        model = m;
        layout = l;
        view = layout.getView();

        //Handle the press of the "New Day" button
        newDayBtn.addEventFilter(ActionEvent.ACTION, new NewDayHandler());
        resizeThree.setOnAction(e -> { resizeHandler(e, 3); });
        resizeFive.setOnAction(e -> { resizeHandler(e, 5); });
        resizeEight.setOnAction(e -> { resizeHandler(e, 8); });
    }

    //Listener for when a tile is pressed in the Savannah
    public static void tileListener(ActionEvent evt, Tile t) {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        String toggleGroupValue = selectedRadioButton.getText();

        if(toggleGroupValue == "Add") {
            filledCount++;
            filled.setText("Filled: " + String.valueOf(filledCount));

            //Choose what animal is added
            if(animalDropdown.getSelectionModel().getSelectedItem() == "Cheetah")
                t.updateAnimal(new Cheetah());
            else if(animalDropdown.getSelectionModel().getSelectedItem() == "Zebra")
                t.updateAnimal(new Zebra());
            else
                t.updateAnimal(new None());
        } else if(toggleGroupValue == "View") {
            animalInfo.setText(t.getAnimalInfo());
            infoImage.setImage(t.getAnimalIcon());
        }
    }

    //Handler for when the new day button is pressed
    public class NewDayHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            model.newDay();
            layout.update();
        }
    }

    //Handler for the resize buttons
    public void resizeHandler(ActionEvent evt, int size) {
        model.resetSavannah(size);
        view.setModel(model);

        filledCount = 0;
        filled.setText("Filled: " + String.valueOf(filledCount));
        day.setText("Day: 0");
        died.setText("Died: 0");

        view.drawLayout();
    }

    public void addHotkeys(Scene scene) {
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
               if( ke.getCode() == KeyCode.N ) { //New Day
                   model.newDay();
                   layout.update();
               }
               else if( ke.getCode() == KeyCode.NUMPAD3 ) {
                    resizeHandler(null, 3);
                }
               else if( ke.getCode() == KeyCode.NUMPAD5 ) {
                   resizeHandler(null, 5);
               }
               else if( ke.getCode() == KeyCode.NUMPAD8 ) {
                   resizeHandler(null, 8);
               }

            }
        });
    }
}
