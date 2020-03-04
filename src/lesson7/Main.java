package lesson7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(50);
        Cat[] cats = new Cat[10];

        for (int i = 0; i < cats.length; i++) {
            if (i == 5) {
                plate.fillThePlate(60);
            }
            cats[i] = new Cat("Цезарь" + (i + 1), false);
            cats[i].eat(plate);
            System.out.printf("Показатель сытости у %s: %b\n", cats[i].getName(), cats[i].isSatiety());
            cats[i].isSatiety();
            plate.info();
            System.out.println();
        }
    }
}