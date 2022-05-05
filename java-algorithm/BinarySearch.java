import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random gen = new Random();
    private static final BinarySearch search = new BinarySearch();

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

    private static int inputValue() {
        System.out.println("Enter the value to search: ");
        int v = validInt();
        return v;
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

    int binarySearch(int[] arr, int val, int left, int right)   {
        if (left > right)   {
            return -1;
        }

        int mid = (left - right) / 2;

        if (arr[mid] == val) {
            return mid;
        }

        else if (arr[mid] > val) {
            return binarySearch(arr, val, left, mid - 1);
        }

        else    {
            return binarySearch(arr, val, mid + 1, right);
        }
    }
    
    public static void main(String[] args) {
        int n = inputSize();
        int v = inputValue();
        int[] arr = inputArray(n);

        search.bubbleSort(arr);

        System.out.print("Sorted array: ");
        search.display(arr);

        int foundIndex = search.binarySearch(arr, v, 0, n - 1);
        System.out.println("\nFound " + v + " at index: " + foundIndex);
    }
}
