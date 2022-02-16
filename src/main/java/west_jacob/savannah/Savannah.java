package west_jacob.savannah;

import java.util.ArrayList;

public class Savannah {

    private int dayCount = 0;
    private int deadCount = 0;
    private int width = 3;
    private int height = 3;
    private ArrayList<Tile> animals = new ArrayList<Tile>();

    public Savannah() {
        for(int i = 0; i < width*height; i++) {
            Animal a = new None();
            animals.add(new Tile(a));
        }
    }

    public int getDayCount() {
        return dayCount;
    }

    public int getDeadCount() {
        return deadCount;
    }

    public ArrayList<Tile> getTiles() {
        return animals;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void newDay() {
        this.dayCount++;
        for( Tile tile : this.animals ) {
            tile.newDay();

            //Check if animal died & is an animal
            if(!tile.isAnimalAlive())
            {
                deadCount++;
                tile.updateAnimal(new None());
            }
        }
    }

    public void resetSavannah(int size) {
        width = size;
        height = size;
        deadCount = 0;
        dayCount = 0;
        animals.clear();

        for(int i = 0; i < width*height; i++) {
            Animal a = new None();
            animals.add(new Tile(a));
        }
    }
}
