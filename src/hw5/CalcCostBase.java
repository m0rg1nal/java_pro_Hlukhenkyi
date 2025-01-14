package hw5;

// Клас розрахунку базової вартості товару
// ЗАВДАННЯ: Виправити код класу.
public class CalcCostBase {
    public double calcCost(Product product) {
        return product.getQuota() * product.getPrice();
    }
}
