package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.log4j.Logger;

@Getter
@Setter
@ToString
public class Order {
    private final static Logger LOGGER = Logger.getLogger(Order.class);
    private int orderNumber;
    private String customerName;

    public Order(int number, String name) {
        this.orderNumber = number;
        this.customerName = name;
        LOGGER.info("Order created");
    }
}
