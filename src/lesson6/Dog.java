package lesson6;

public class Dog extends Animal {
    private static int dogCounter = 0;

    public Dog(String name, int runLimit, int swimLimit, double jumpLimit) {
        super(name, runLimit, swimLimit, jumpLimit);
        dogCounter++;
    }

    public int getDogCounter() {
        return dogCounter;
    }
}
