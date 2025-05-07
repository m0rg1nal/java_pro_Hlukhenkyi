package org.example;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard orders = new CoffeeOrderBoard();
        orders.addOrder("Ivan");
        orders.addOrder("Dmytro");
        orders.addOrder("Tetiana");
        orders.draw();
        orders.deliver();
        orders.deliver(3);
        orders.deliver(5);
    }
}
