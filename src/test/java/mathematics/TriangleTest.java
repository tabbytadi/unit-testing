package mathematics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    public void perimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        int expected = 12;
        int actual = triangle.perimeter();
        assertEquals(expected, actual);
    }

    @Test
    public void perimeterZeroValues() {
        Triangle triangle = new Triangle();
        int expected = 1;
        int actual = triangle.perimeter();
        assertEquals(expected, actual);
    }

}