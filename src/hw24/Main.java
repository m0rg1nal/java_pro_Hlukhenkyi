package hw24;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println(logger1.equals(logger2));
        logger1.log("Hello");
        logger2.log("Bye");
    }
}
