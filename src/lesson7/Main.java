package lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Murzik");
        Cat cat1 = new Cat("Barsik");
        Plate plate = new Plate(100);

        cat.eat(plate);
        plate.info();
        cat1.eat(plate);
        plate.info();

        Dog dog = new Dog("Buldog");
        dog.voice(cat);
    }
}
