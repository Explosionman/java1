package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info(){
        System.out.println("Осталось еды: "+ food);
    }

    public void decreaseFood(Cat cat, int amount){
        if (amount > food) {
            System.out.println(cat.getName() + " не тронул еду, т.к. в тарелке для него слишком мало");
            return;
        }
        food -= amount;
        cat.setSatiety(true);
    }

    public void fillThePlate(int amount) {
        food += amount;
        System.out.println("Еда в тарелке пополнена. Остаток: " + food);
    }
}
