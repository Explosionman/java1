package lesson6;

public class Dog extends Animal {
    private static int dogCounter = 0;

    public Dog(String name) {
        super(name);
        dogCounter++;
    }

    public int getDogCounter() {
        return dogCounter;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Слишком далеко. " + getName() + " не пробежит " + distance + " метров.");
            return;
        }
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println("Слишком далеко. " + getName() + " не проплывёт " + distance + " метров.");
            return;
        }
        super.swim(distance);
    }
}
