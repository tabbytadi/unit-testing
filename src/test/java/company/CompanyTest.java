package company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    private Company company;

    @BeforeEach
    void init() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        company = Company.class.getConstructor(String.class).newInstance("Comp 1");
        List<Double> incomeList = Arrays.asList(10., 20., 30., 40., 50.);

        Field field = Company.class.getDeclaredField("incomeList");
        field.setAccessible(true);
        field.set(company, incomeList);
    }

    @Test
    void totalIncomeValue() {
        double expected = 150;
        double actual = company.totalIncomeValue();
        assertEquals(expected, actual);
    }

    @Test
    void totalIncomeValueEmptyList() {
        Company company = new Company("Test Company - No Income");
        double expected = 0;
        double actual = company.totalIncomeValue();
        assertEquals(expected, actual);
    }

    @Test
    void enoughIncome() {
        assertTrue(company.enoughIncome(100));
    }
}