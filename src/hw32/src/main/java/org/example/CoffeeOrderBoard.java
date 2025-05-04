package org.example;



import lombok.Getter;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CoffeeOrderBoard{
    private final static Logger LOGGER = Logger.getLogger(CoffeeOrderBoard.class);
    private List<Order> orders;
    private int nextOrderNumber;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
        nextOrderNumber = 1;
        LOGGER.info("CoffeOrderBoard created");
    }

    public void addOrder(String customerName){
        try {
            Order order = new Order(nextOrderNumber++, customerName);
            orders.add(order);
            LOGGER.info("Order added");
        }
        catch (Exception e){
            LOGGER.error("Error while adding order for " + customerName, e);
        }

    }

    public Order deliver() {
        try {
            if (orders.isEmpty()) {
                LOGGER.warn("Attempted to deliver order, but the queue is empty.");
                return null;
            }
            Order first = orders.remove(0);
            LOGGER.info("Delivered first order: " + first);
            return first;
        } catch (Exception e) {
            LOGGER.error("Error while delivering the first order", e);
            return null;
        }
    }

    public Order deliver(int orderNumber){
        try{
            for(Order order : orders){
                if (order.getOrderNumber() == orderNumber){
                    orders.remove(order);
                    LOGGER.info("Order " + order + " delivered.");
                    return order;
                }
            }
            LOGGER.warn("Order with number : " + orderNumber + " hasn't been found.");
            return null;
        }
        catch (Exception e){
            LOGGER.error("Error while delivering order with number " +orderNumber, e);
            return null;
        }
    }

    public void draw() {
        try {
            LOGGER.info("Drawing orders.");
            for (Order order : orders) {
                System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
            }
        }
        catch (Exception e){
            LOGGER.error("Error while drawing the order queue", e);
        }

    }

}
