package west_jacob.savannah;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

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
            tile.updateAnimal(new Cheetah());
        }
    }

}
