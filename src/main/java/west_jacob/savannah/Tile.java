package west_jacob.savannah;

import javafx.stage.Stage;

import java.beans.PropertyChangeSupport;

public class Tile {
    //This is what is being observed by tileView
    private PropertyChangeSupport subject;
    private Animal animal;

    public Tile(Animal a) {
        animal = a;
        subject = new PropertyChangeSupport(this);
    }

    public String getTileLabel() {
        return animal.getName() + ":" + animal.getHealth();
    }

    public void newDay() { //notify all function essentially
        subject.firePropertyChange("AnimalUpdate", null, this);
    }

    public void attachObserver(TileView tileView) {
        subject.addPropertyChangeListener(tileView);
    }

    public void detachObserver(TileView tileView) {
        subject.removePropertyChangeListener(tileView);
    }
}
