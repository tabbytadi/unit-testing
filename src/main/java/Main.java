import company.Company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("That's it!");
        Queue<Company> companies = new PriorityQueue<>(Comparator.comparing((Company::totalIncomeValue)));
    }
}
