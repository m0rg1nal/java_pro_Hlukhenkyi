package hw16;

import java.util.Random;

public class RandomNumberGenerator {
    static int generateRandomNumber(int min, int max){
        Random random = new Random();
        return random.nextInt(min, max);
    }
}
