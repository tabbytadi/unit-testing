package company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {
    private String name;
    private List<Double> incomeList;

    public Company(String name) {
        this.name = name;
        this.incomeList = new ArrayList<>();
    }

    public double totalIncomeValue() {
        return this.incomeList.stream().reduce(Double::sum).orElse(0.);
    }


    public boolean enoughIncome(double minIncome) {
        return this.totalIncomeValue() >= minIncome;
    }
}
