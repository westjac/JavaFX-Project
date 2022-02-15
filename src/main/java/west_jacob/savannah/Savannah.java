package west_jacob.savannah;

import java.util.ArrayList;

public class Savannah {

    private int dayCount = 0;

    public int getDayCount() {
        return dayCount;
    }

    public int getDeadCount() {
        return deadCount;
    }

    private int deadCount = 0;
    private int width = 3;
    private int height = 3;
    private ArrayList<Tile> animals = new ArrayList<Tile>();

    public ArrayList<Tile> getTiles() {
        return animals;
    }

    public Savannah() {
        for(int i = 0; i < width*height; i++) {
            Animal a = new None();
            animals.add(new Tile(a));
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void newDay() {
        this.dayCount++;
        for( Tile tile : this.animals ) {
            tile.newDay();
        }
    }
}
