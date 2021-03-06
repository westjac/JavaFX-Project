package west_jacob.savannah;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import java.util.ArrayList;

public class SavannahView extends GridPane {

    private Savannah model;
    private GridPane btnPane;
    private ArrayList<TileView> tileViews = new ArrayList<TileView>();

    public SavannahView() {
        btnPane = new GridPane();
        btnPane.setAlignment(Pos.CENTER);
        }

    public GridPane drawLayout() {
        btnPane.getChildren().clear();
        btnPane.getRowConstraints().clear();
        btnPane.getColumnConstraints().clear();
        btnPane.setAlignment(Pos.CENTER);

        ArrayList<Tile> tiles = model.getTiles();
        for (int i = 0; i < model.getHeight(); i++) {
            for (int j = 0; j < model.getWidth(); j++) {
                btnPane.add(new TileView(tiles.get(i * model.getHeight() + j)), j, i);
            }
            RowConstraints row = new RowConstraints();
            ColumnConstraints col = new ColumnConstraints();
            row.setVgrow(Priority.ALWAYS);
            col.setHgrow(Priority.ALWAYS);
            btnPane.getRowConstraints().add(row);
            btnPane.getColumnConstraints().add(col);
        }

        return btnPane;
    }

    public void setModel(Savannah m) {
        model = m;
    }
}
