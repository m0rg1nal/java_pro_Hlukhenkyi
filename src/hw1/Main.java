package hw1;

public class Main {
    private static double CONV_K = 2.20462;

    public static void main(String[] args) {
        System.out.println("Converter app");
        System.out.println("Version 1.0");

        double kgs = 5;
        double lbs = 12;
        double pounds = convertKgToLbs(kgs);
        double kilos = convertLbsToKg(lbs);
        System.out.println("Result is " + pounds + " lbs.");
        System.out.println("Result is " + kilos + " kg.");
    }

    private static double convertKgToLbs(double kgs){
        return kgs * CONV_K;
    }

    private static double convertLbsToKg(double lbs){
        return lbs/CONV_K;
    }
}