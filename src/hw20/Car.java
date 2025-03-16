package hw20;

public class Car {
    private double tankCapacity;
    private double fuelAmount;
    private String name;

    public Car(String name,double tankCapacity, double fuelAmount) {
        this.tankCapacity = tankCapacity;
        this.fuelAmount = fuelAmount;
        this.name = name;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public String getName() {
        return name;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }
}
