package west_jacob.savannah;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

import static west_jacob.savannah.Layout.animalDropdown;
import static west_jacob.savannah.Layout.toggleGroup;

public class Controller {
    private Savannah model;
    private Layout layout;
    private SavannahView view;

    public Controller(Savannah m, Layout l) {
        model = m;
        layout = l;
        view = layout.getView();
    }

    //Listener for when a tile is pressed in the Savannah
    public static class TileListener implements EventHandler<ActionEvent> {
        private Tile tile;

        public TileListener(Tile t) {
            tile = t;
        }
        @Override
        public void handle(ActionEvent actionEvent) {
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            String toggleGroupValue = selectedRadioButton.getText();

            if(toggleGroupValue == "Add") {
                //Choose what animal is added
                if(animalDropdown.getSelectionModel().getSelectedItem() == "Cheetah")
                    tile.updateAnimal(new Cheetah());
                else if(animalDropdown.getSelectionModel().getSelectedItem() == "Zebra")
                    tile.updateAnimal(new Zebra());
                else
                    tile.updateAnimal(new None());
            } else if(toggleGroupValue == "View") {
                //TODO
            }

        }
    }

}
