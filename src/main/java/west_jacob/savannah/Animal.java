package west_jacob.savannah;

public class Animal {
    private int health = 0;
    private String name = "";
    private String fullName = "";

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
}
