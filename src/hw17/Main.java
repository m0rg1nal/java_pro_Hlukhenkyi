package hw17;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> list = Arrays.asList(
                new Product("banana", "fruit", 20.33),
                new Product("apple", "fruit", 15.25),
                new Product("cucumber", "vegetable", 15.70),
                new Product("tomato", "vegetable", 17.99),
                new Product("milk", "dairy", 50.25),
                new Product("mozzarella", "dairy", 100.10),
                new Product("kombucha", "beverage", 70.85),
                new Product("coca-cola", "beverage", 20.50)
        );
        Map<String, Double> result = list.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
        double maxPrice = Collections.max(result.values());
        System.out.println(result);
        System.out.println(maxPrice);
    }
}
