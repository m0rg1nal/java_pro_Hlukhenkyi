package hw19;


import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {
    public static void main(String[] args) {
        int[] mergeArray = new Random().ints(10, 0,100).toArray();
        int[] binArray = {12, 324, 1, 3, 5};
        System.out.println("Starting array for merge sort: " + Arrays.toString(mergeArray));
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        System.out.println("Sorted array" + Arrays.toString(mergeArray));


        System.out.println("\nStarting array for binary search: " + Arrays.toString(binArray));
        int result = binarySearch(binArray, 5);
        System.out.println("Target has id: " + result);

    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Рекурсивно сортуємо ліву і праву половини
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Зливаємо відсортовані половини
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
