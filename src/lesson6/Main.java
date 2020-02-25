package lesson6;

public class Main {
    public static void main(String[] args) {
        //Создаём экземпляры классов Cat и Dog
        Cat catBoris = new Cat("Борис");
        Cat catMurzik = new Cat("Мурзик");
        Dog dogTaddy = new Dog("Тэдди");
        Dog dogDobi = new Dog("Доби");
        Dog dogBobby = new Dog("Бобби");

        //Применяем метода к созданным экземплярам класса Cat
        catBoris.run(220);
        catBoris.swim(5);
        catMurzik.run(20);
        catMurzik.swim(0);

        //Применяем метода к созданным экземплярам класса Dog
        dogTaddy.run(400);
        dogTaddy.swim(5);
        dogDobi.run(400);
        dogDobi.swim(15);
        dogBobby.run(1000);
        dogBobby.swim(6);

        System.out.println("Итого создано животных - " + dogTaddy.getAnimalCounter() + ": из них котов - "
                + catBoris.getCatCounter() + ", собак - " + dogTaddy.getDogCounter());
    }
}
