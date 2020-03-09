package lesson7;

public class Cat {
    private String name;
    private boolean satiety;

    public Cat(String name, boolean satiety) {
        this.name = name;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        System.out.println("Кот " + name + " ест...");
        plate.decreaseFood(this,15);
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }
}
