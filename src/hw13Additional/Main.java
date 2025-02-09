package hw13Additional;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String[] menu = new String[]{"cappuccino", "beer", "vodka tonic", "mojito", "martini", "margarita"};
        Bar bar = new Bar("Jack", "John");

        try (ExecutorService bartenders = Executors.newFixedThreadPool(2)){
            for (int i = 0; i <= 30; i++){
                bar.acceptOrder(new Client(menu[new Random().nextInt(menu.length)]));
            }
            bar.close();
        }
    }
}
