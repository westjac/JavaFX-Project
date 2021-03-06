package west_jacob.savannah;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.beans.PropertyChangeSupport;

public class Tile {
    //This is what is being observed by tileView
    private PropertyChangeSupport subject;
    private static int id = 100;
    private Animal animal;

    public Tile(Animal a) {
        id++;
        animal = a;
        subject = new PropertyChangeSupport(this);
    }

    public void updateAnimal(Animal a) {
        animal = a;
        subject.firePropertyChange("AnimalUpdate", null, this); //GRADING: TRIGGER
    }

    public String getTileLabel() {
        return animal.getName() + ":" + animal.getHealth();
    }

    public void newDay() { //notify all function essentially
        animal.newDay();
        subject.firePropertyChange("AnimalUpdate", null, this); //GRADING: TRIGGER
    }

    public boolean isAnimalAlive() {
        if(animal.getHealth() == 0 && animal.getName() != "N")
            return false;
        else
            return true;
    }

    public String getAnimalInfo() {
        return animal.getInfo();
    }

    public Image getAnimalIcon() {
        return animal.getIcon();
    }

    public void attachObserver(TileView tileView) {
        subject.addPropertyChangeListener(tileView); //GRADING: SUBJECT
    }
}
