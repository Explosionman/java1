package lesson6;

public abstract class Animal {
    private static int animalCounter = 0;
    protected int runLimit;
    protected int swimLimit;
    protected int jumpLimit;
    protected String name;

    public Animal(String name, int runLimit, int swimLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
        animalCounter++;
    }

    public int getAnimalCounter() {
        return animalCounter;
    }

    public void run(int value) {
        System.out.println(name + " run: " + (value <= runLimit));
    }

    public void swim(int value) {
        System.out.println(name + " swim " + (value <= swimLimit));
    }

    public void jump(int value) {
        System.out.println(name + " jump " + (value <= swimLimit));
    }
}
