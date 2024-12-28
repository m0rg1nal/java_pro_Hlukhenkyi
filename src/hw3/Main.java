package hw3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("TempConverter App");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature you want to convert(with c or f): ");
        String input = scanner.nextLine();

        String temp = input.split(" ")[0];
        String unit = input.split(" ")[1].toLowerCase();
        double temperature = Double.parseDouble(temp);
        double result = 0;
        System.out.println(convertFtoC(temperature));
    }
    private static double convertFtoC(double temp){
        return (temp - 32) / 1.8;
    }
}
