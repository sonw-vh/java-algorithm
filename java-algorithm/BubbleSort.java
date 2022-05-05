package bubble;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random gen = new Random();

    private static void display(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    
    private static int validInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());

                if (result > 0) {
                    return result;
                } else {
                    System.out.println("Please enter a positive integer number!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                System.out.println("Enter again: ");
            }
        }
    }

    private static int inputSize() {
        System.out.println("Enter the number of elements in array: ");
        int n = validInt();
        return n;
    }

    private static int[] inputArray(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = gen.nextInt(n) + 1;
        }
        System.out.print("Unsorted array: ");
        display(arr);
        return arr;
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                int limitSwap = arr.length - 1;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    limitSwap--;
                    if (limitSwap == 0) break;
                }
            }
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int n = inputSize();
        int[] arr = inputArray(n);
        bubbleSort(arr);
        System.out.print("Sorted array: ");
        display(arr);
    }
}
