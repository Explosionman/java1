package lesson6;

public class Main {
    public static void main(String[] args) {
        Cat catBoris = new Cat("Борис");
        Cat catMurzik = new Cat("Мурзик");
        Dog dogTaddy = new Dog("Тэдди");
        Dog dogDobi = new Dog("Доби");
        Dog dogBobby = new Dog("Бобби");

        catBoris.run(220);
        catBoris.swim(5);
        catMurzik.run(20);
        catMurzik.swim(0);

        dogTaddy.run(400);
        dogTaddy.swim(5);
        dogDobi.run(400);
        dogDobi.swim(15);
        dogBobby.run(1000);
        dogBobby.swim(6);


        System.out.println("Итого создано животных - " + dogTaddy.getAnimalCounter()  + ": из них котов - "
                + catBoris.getCatCounter() + ", собак - " + dogTaddy.getDogCounter());
    }
}
