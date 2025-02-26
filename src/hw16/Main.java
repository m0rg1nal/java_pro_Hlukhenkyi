package hw16;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main{
    public static void main(String[] args) {
        int sum = add(134, 1336);
        System.out.println(sum);

        StringManipulator upperCase = (String text) -> text.toUpperCase();
        System.out.println(upperCase.manipulate("Hello, world"));

        Function<String, Integer> function = StringListProcessor::countUpperCase;
        System.out.println(function.apply("Hello"));

        Supplier<Integer> randInt = () -> RandomNumberGenerator.generateRandomNumber(1, 100);
        System.out.println(randInt.get());
    }
    static int add(int a, int b){
        MathOperation addition = new MathOperation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        return addition.operate(a, b);
    }
}

class StringListProcessor{
    static int countUpperCase(String s){
        int counter = 0;
        for (char i : s.toCharArray()) {
            if(Character.isUpperCase(i)){
                counter++;
            }
        }
        return counter;
    }
}
