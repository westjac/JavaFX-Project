package west_jacob.savannah;

public class Zebra extends Animal {

    public Zebra() {
        setHealth(8);
        setName("Z");
    }

    @Override
    public void newDay() {
        int currentHealth = getHealth();
        setHealth(currentHealth - 2);
    }
}
