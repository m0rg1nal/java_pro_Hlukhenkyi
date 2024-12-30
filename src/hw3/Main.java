package hw3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("TempConverter App");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature you want to convert(with C or F): ");
        String input = scanner.nextLine();

        String temp = input.substring(0,input.length() - 1);
        char unit = input.charAt(input.length() - 1);
        double temperature = Double.parseDouble(temp);
        double result = 0;
        switch (unit){
            case 'C':{
                result = convertCtoF(temperature);
                unit = 'F';
                break;
            }
            case 'F':{
                result = convertFtoC(temperature);
                unit = 'C';
                break;
            }
            default:
                System.out.println("You have entered wrong data.");
        }
        System.out.println("Result: " + result + unit);
    }

    private static double convertFtoC(double temp){
        return (temp - 32) / 1.8;
    }

    private static double convertCtoF(double temp){
        return temp * 1.8 + 32;
    }
}
