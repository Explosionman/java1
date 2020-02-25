package lesson6;

public class Cat extends Animal {
    private static int catCounter = 0;

    public Cat(String name) {
        super(name);
        catCounter++;
    }

    public int getCatCounter() {
        return catCounter;
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Слишком далеко. " + getName() + " не пробежит " + distance + " метров.");
            return;
        }
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }
}
