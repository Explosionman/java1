package lesson6;

public class Cat extends Animal {
    private static int catCounter = 0;

    public Cat(String name, int runLimit, int swimLimit, int jumpLimit) {
        super(name, runLimit, swimLimit, jumpLimit);
        catCounter++;
    }

    public int getCatCounter() {
        return catCounter;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
}
