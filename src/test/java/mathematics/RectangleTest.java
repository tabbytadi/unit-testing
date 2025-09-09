package mathematics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    private Rectangle rectangle;
    private static Rectangle rectangleStatic;

    @BeforeAll
    static void initAll() {
        System.out.println("Before All!");
        rectangleStatic = new Rectangle(2, 4);
    }

    @BeforeEach
    void init() {
        rectangle = new Rectangle(3, 6);
    }

    @Test
    @Disabled
    public void area() {
        int expected = 20;
        int actual = rectangle.area();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test area with all numbers")
    public void areaTestAll() {
        assertAll(
                () -> assertEquals(18, rectangle.area()),
                () -> assertEquals(18, rectangle.area())
        );
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @EnabledOnJre(JRE.JAVA_8)
    void increasedSide1() {
        System.out.println(rectangle.increasedSide1());
    }

    //@Test
    @RepeatedTest(3)
    void increasedSide11() {
        List<Integer> expected = Arrays.asList(3, 13, 23, 33, 43, 53, 63, 73, 83, 93);
        List<Integer> actual = rectangle.increasedSide1();
        assertIterableEquals(expected, actual, "The list is not the one expected");
    }


    @Nested
    class PerimeterTest {
        @Test
        @DisplayName("Test perimeter with positive numbers")
        public void perimeterTestPositive() {
            int expected = 18;
            int actual = rectangle.perimeter();
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test perimeter with zero numbers")
        public void perimeterTestWithZero() {
            Rectangle rectangle = new Rectangle(0, 6);
            int expected = 12;
            int actual = rectangle.perimeter();
            assertEquals(expected, actual);
        }
    }

    @Test
    @DisplayName("Increasing sides")
    public void increaseSidesTest() {
        assertThrows(NegativeIncreaseValueException.class, () -> rectangle.increaseSides(1));
    }
}