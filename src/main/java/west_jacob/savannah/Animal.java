package west_jacob.savannah;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Animal {
    private int health = 0;
    private String name = "";
    private String fullName = "";
    private Image icon;

    public Animal() {}

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void newDay() {}

    public String getInfo() {
        return fullName + "\nHealth: " + String.valueOf(health);
    };

    public void setIcon(String imageName){
        File file = new File("src/main/resources/images/" + imageName);
        icon = new Image(file.toURI().toString());

    }

    public Image getIcon() {
        return icon;
    }
}
