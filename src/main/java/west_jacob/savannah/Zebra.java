package west_jacob.savannah;

public class Zebra extends Animal {

    public Zebra() {
        setHealth(8);
        setName("Z");
        setFullName("Zebra");
        setIcon("zebra.png");
    }

    @Override
    public void newDay() {
        int currentHealth = getHealth();
        setHealth(currentHealth - 2);
    }
}
