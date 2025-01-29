package additionalHomework1;

public class Fruit {
    private double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Apple extends Fruit{

    public Apple(double weight) {
        super(1);
    }
}
class Orange extends Fruit{

    public Orange(double weight) {
        super(1.5);
    }
}
