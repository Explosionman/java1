package lesson6;

public class Main {
    public static void main(String[] args) {
        //Создаём экземпляры классов Cat и Dog
        Cat catBoris = new Cat("Борис", 400, 2, 0.5);
        Cat catMurzik = new Cat("Мурзик", 150, 0, 3);
        Dog dogTaddy = new Dog("Тэдди", 500, 40, 2);
        Dog dogDobi = new Dog("Доби", 600, 15, 1);

        //Применяем методы к созданным экземплярам класса Cat
        catBoris.run(220);
        catBoris.swim(5);
        catBoris.jump(0.5);
        catMurzik.run(80);
        catMurzik.swim(2);
        catMurzik.jump(5);

        //Применяем методы к созданным экземплярам класса Dog
        dogTaddy.run(700);
        dogTaddy.swim(5);
        dogTaddy.jump(4);
        dogDobi.run(400);
        dogDobi.swim(18);
        dogDobi.jump(1);

        System.out.println("Итого создано животных - " + dogTaddy.getAnimalCounter() + ": из них котов - "
                + catBoris.getCatCounter() + ", собак - " + dogTaddy.getDogCounter());
    }
}
