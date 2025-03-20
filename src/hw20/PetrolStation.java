package hw20;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class PetrolStation {
    private double amount;
    private final ExecutorService service = Executors.newFixedThreadPool(3);
    private final BlockingQueue<Car> queue = new LinkedBlockingQueue<>();

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public synchronized double getAmount() {
        return amount;
    }

    public void doRefuel(Car car, double fuelAmount) throws InterruptedException { // enter zero to fuel to full tank
        queue.put(car);
        service.submit(() -> {
            try {
                Thread.sleep(new Random().nextInt(3000, 10000));
                double fuelDifference = car.getTankCapacity() - car.getFuelAmount();
                if (fuelAmount == 0 && amount >= fuelDifference) {
                    amount -= fuelDifference;
                    car.setFuelAmount(car.getTankCapacity());
                    System.out.println("\nFueled " +car.getName() + " to full tank");
                    System.out.println("Amount of fuel now(litres): " + car.getFuelAmount());
                } else if (fuelDifference <= fuelAmount) {
                    amount -= fuelAmount;
                    car.setFuelAmount(car.getTankCapacity());
                    System.out.println("\nFueled " +car.getName() + " with " + fuelAmount);
                    System.out.println("Had to use only " + fuelDifference);
                    System.out.println("Amount of fuel now(litres): " + car.getFuelAmount());
                } else if (fuelAmount < amount){
                    amount -= fuelAmount;
                    car.setFuelAmount(car.getFuelAmount() + fuelAmount);
                    System.out.println("\nFueled " +car.getName() + " with " + fuelAmount);
                    System.out.println("Amount of fuel now(litres): " + car.getFuelAmount());
                }else{
                    System.out.println("\nNot enough fuel for " + car.getName());

                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    public void shutdown() {
        service.shutdown();
    }
}
