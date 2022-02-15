package west_jacob.savannah;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TileView extends Button implements PropertyChangeListener {
    //This is the observer in the observer pattern
    private int id = 0;
    private int count = 0;
    private Tile tile;


    public TileView(Tile t) {
        tile = t;
        setText(tile.getTileLabel());
        setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

    }

    public void update() {
        //This is called by the tile when notifying that there is new info to display
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        tile = (Tile) evt.getNewValue();
        setText(tile.getTileLabel());
    }
}
