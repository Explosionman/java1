package lesson7;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void eat(Plate plate) {
        System.out.println("Cat " + name + " eat...");
        plate.decreaseFood(10);
    }

    public String getName() {
        return name;
    }

    public void fear(Dog dog){
        System.out.println("Cat "+name+ " fear dog "+ dog.getName());
    }
}
