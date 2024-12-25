package hw2;

import java.util.Scanner;

public class Main {
    private static final double CONV_DIST = 1.609344;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter distance you want to convert(with miles or km): ");
        String input = scanner.nextLine();
        String dist = input.split(" ")[0];
        String unit = input.split(" ")[1].toLowerCase();
        double distance = Double.parseDouble(dist);
        double result = 0;

        if (unit.equals("miles")){
            result = convertMilesToKm(distance);
            unit = "km";
        }
        System.out.println("Result: " + result+ " " + unit);
    }

    private static double convertMilesToKm(double miles){
        return miles * CONV_DIST;
    }
}
