package part1.lang.object.equals.exam;

import java.util.Objects;

public class Rectangle {

    private int weight;
    private int height;

    public Rectangle(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    // 높이와 넓이와 같아야 동등 하다
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return weight == rectangle.weight && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
            "weight=" + weight +
            ", height=" + height +
            '}';
    }



}
