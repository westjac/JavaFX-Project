package west_jacob.savannah;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static west_jacob.savannah.Controller.tileListener;

public class TileView extends Button implements PropertyChangeListener {
    //This is the observer in the observer pattern
    private static int id = 0;
    private int count = 0;
    private Tile tile;

    public TileView(Tile t) {
        id++;
        tile = t;
        setText(tile.getTileLabel());
        setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        tile.attachObserver(this);
        setOnAction(e -> {
            tileListener(e, tile);
        });
        setGraphic(new ImageView(tile.getAnimalIcon()));
        setContentDisplay(ContentDisplay.TOP);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) { //GRADING: OBSERVE
        tile = (Tile) evt.getNewValue();
        setText(tile.getTileLabel());
        setGraphic(new ImageView(tile.getAnimalIcon()));
    }
}
