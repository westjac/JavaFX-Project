package west_jacob.savannah;

public class Cheetah extends Animal {

    public Cheetah() {
        setHealth(10);
        setName("C");
        setFullName("Cheetah");
    }

    @Override
    public void newDay() {
        int currentHealth = getHealth();
        setHealth(currentHealth - 1);
    }
}
