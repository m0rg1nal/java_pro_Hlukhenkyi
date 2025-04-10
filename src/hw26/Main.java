package hw26;

public class Main {
    public static void main(String[] args) {
        User user = new User("Anton");
        user.setAdress(new Adress("Ukraine", "Kyiv", "Yaroslaviv Val", "2"));
        System.out.println("User: " + user.getName());
        System.out.println("Adress: " + user.getFullAdress());

    }
}
