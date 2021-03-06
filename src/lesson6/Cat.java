package lesson6;

public class Cat extends Animal {
    private static int catCounter = 0;

    public Cat(String name, int runLimit, int swimLimit, double jumpLimit) {
        super(name, runLimit, swimLimit, jumpLimit);
        catCounter++;
    }

    public static int getCatCounter() {
        return catCounter;
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }
}
