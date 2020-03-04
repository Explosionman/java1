package lesson7;

public class Main {
    public static void main(String[] args) {
//        Box box1 = new Box(5, "red");
//        Box box2 = new Box(5, "Red");
//
//        if (box1.equals(box2)) {
//            System.out.println("Равны");
//        } else {
//            System.out.println("не равны");
//        }

//        String s = String.format("a %s bb %d ", "rtrt", 23) ;
//
//        String s1 = "qwerty";
//        System.out.println(s1.startsWith("qw4"));
//
//
//        System.out.println(s);

//        StringBuilder sb = new StringBuilder("Java");
////        sb.setLength(100000);
//        sb.append("1").append(" dfg \n").append(" 5 ").append(" t\" \' \\t");
//        System.out.println(sb);
//        sb.setLength(3);
//        System.out.println(sb);
//        sb.reverse();
//        System.out.println(sb);


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
