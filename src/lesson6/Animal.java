package lesson6;

public abstract class Animal {
    private static int animalCounter = 0;
    private int runLimit;
    private int swimLimit;
    private double jumpLimit;
    protected String name;

    public Animal(String name, int runLimit, int swimLimit, double jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
        animalCounter++;
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }

    public void run(int value) {
        System.out.println(name + " run: " + (value <= runLimit));
    }

    public void swim(int value) {
        System.out.println(name + " swim " + (value <= swimLimit));
    }

    public void jump(double height) {
        System.out.println(name + " jump " + (height <= jumpLimit));
    }
}
