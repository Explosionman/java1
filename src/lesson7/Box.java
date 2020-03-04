package lesson7;

public class Box {
    int size;
    String color;

    public Box(int size, String color) {
        this.size = size;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Box{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(!obj.getClass().equals(Box.class)){
           return false;
        }
        Box another = (Box) obj;

        return this.size == another.size && this.color.equalsIgnoreCase(another.color);
    }

    @Override
    public int hashCode() {
        return 31 * size + color.toUpperCase().hashCode();
    }
}
