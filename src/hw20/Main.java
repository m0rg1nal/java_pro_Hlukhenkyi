package hw20;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PetrolStation station = new PetrolStation(500);
        Car car1 = new Car("Toyota",50, 20.5);
        Car car2 = new Car("Mazda", 100, 10);
        Car car3 = new Car("Subaru", 40, 0);
        Car car4 = new Car("Volkswagen", 50, 34.5);
        Car car5 = new Car("Volvo", 50, 23.5);
        System.out.println("Petrol station is working and has " + station.getAmount() + " l of fuel.");

        station.doRefuel(car1, 0); // 0 - full tank
        station.doRefuel(car2, 100);
        station.doRefuel(car3, 10);
        station.doRefuel(car4, 20);
        station.doRefuel(car5, 20);

        station.shutdown();
    }
}
