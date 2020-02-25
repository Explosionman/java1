package lesson6;

public class Animal {
    private static int animalCounter = 0;
    private String name;

    public Animal(String name) {
        this.name = name;
        animalCounter++;
    }

    public Animal() {
    }

    public String getName() {
        return name;
    }

    public int getAnimalCounter() {
        return animalCounter;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " метров.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " метров.");
    }
}
