package hw25;

public class PlaneFactory extends TransportFactory{
    @Override
    Transport createTransport() {
        return new Plane();
    }
}
