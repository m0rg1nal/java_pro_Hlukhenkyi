package hw21;

public class ArrayUtils {
    @MethodInfo(name = "findMax", getType = "Integer", description = "Finds max value in array.")
    @Author(author = "Ivan Hlukhenkyi")
    public static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @MethodInfo(name = "findMin", getType = "Integer", description = "Finds min value in array.")
    @Author(author = "Ivan Hlukhenkyi")
    public static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
