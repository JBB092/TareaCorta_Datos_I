import java.util.Random;

/**
 * This class implements the Quick Sort algorithm and measures its execution time.
 * It generates random arrays and runs the sorting algorithm 15 times,
 * reporting the time taken for each execution.
 * The code source is based on the provided code.
 */
public class QuickSort {
    private int[] numbers;
    private int number;
    static int size = 1000000;
    static int numRuns = 15; // Number of runs

    /**
     * The main method that initiates the execution of the Quick Sort algorithm.
     * It generates random arrays, runs the algorithm 15 times, and measures the execution time.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int run = 1; run <= numRuns; run++) {
            int[] values = initializeArray();

            long startTime = System.currentTimeMillis();
            quickSort(values);
            long endTime = System.currentTimeMillis();

            double elapsedTimeInSeconds = (endTime - startTime) / 1000.0;
            System.out.println("Execution time in run " + run + ": " + elapsedTimeInSeconds + " seconds");
        }
    }

    /**
     * Initializes and returns an array with random values.
     *
     * @return An array with random values.
     */
    static int[] initializeArray() {
        int[] values = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            values[i] = rand.nextInt(1000000); // Range of random values
        }
        return values;
    }

    /**
     * Sorts the array using the Quick Sort algorithm.
     *
     * @param values The array to be sorted.
     */
    public static void quickSort(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        int[] arr = values;
        int length = values.length;
        quicksort(arr, 0, length - 1);
    }

    /**
     * Recursively sorts a subarray using the Quick Sort algorithm.
     *
     * @param arr   The array to be sorted.
     * @param low   The index of the low boundary.
     * @param high  The index of the high boundary.
     */
    private static void quicksort(int[] arr, int low, int high) {
        int i = low, j = high;
        int pivot = arr[low + (high - low) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quicksort(arr, low, j);
        }
        if (i < high) {
            quicksort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param arr The array in which elements are swapped.
     * @param i   The index of the first element.
     * @param j   The index of the second element.
     */
    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}