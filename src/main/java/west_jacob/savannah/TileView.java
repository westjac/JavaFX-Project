package west_jacob.savannah;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

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
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) { //GRADING: OBSERVE
        tile = (Tile) evt.getNewValue();
        setText(tile.getTileLabel());
    }
}
