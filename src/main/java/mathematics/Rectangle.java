package mathematics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Rectangle {
    private int side1;
    private int side2;

    public Rectangle() {
    }

    public Rectangle(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) throws ArithmeticException {
        if (side2 < 0) {
            throw new ArithmeticException("The side has to be non negative number!");
        }
        this.side2 = side2;
    }

    public void increaseSides(int increase) throws NegativeIncreaseValueException {
        if (increase < 0) {
            throw new NegativeIncreaseValueException("The increase has to be non negative number!");
        }
    }

    public List<Integer> increasedSide1() {
        List increasedSide = new ArrayList();
        IntStream.range(0, 100)
                .filter(number -> number % 10 == 0)
                .forEach(number -> increasedSide.add(side1+number));
        return increasedSide;
    }

    public int perimeter() {
        return 2 * (side1 + side2);
    }

    public int area() {
        return side1 * side2;
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                '}';
    }
}
