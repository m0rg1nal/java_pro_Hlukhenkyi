package hw13Additional;

public class Client implements Runnable{
    private String drink;

    public Client(String drink) {
        this.drink = drink;
    }

    public String getDrink() {
        return drink;
    }


    @Override
    public void run() {
        System.out.println("Order of 1 " + drink);
    }
}
