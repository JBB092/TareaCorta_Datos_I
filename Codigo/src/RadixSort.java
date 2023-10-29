import java.util.Random;

/**
 * This class implements the Radix Sort algorithm and measures its execution time.
 * It generates random arrays and runs the sorting algorithm 15 times,
 * reporting the time taken for each execution.
 * The code source is based on the provided code.
 */
public class RadixSort {
    static int size = 1000000;
    static int numRuns = 15; // Number of runs

    /**
     * The main method that initiates the execution of the Radix Sort algorithm.
     * It generates random arrays, runs the algorithm 15 times, and measures the execution time.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int run = 1; run <= numRuns; run++) {
            int[] values = initializeArray();

            long startTime = System.currentTimeMillis();
            radixSort(values);
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
     * Sorts the array using the Radix Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public static void radixSort(int[] arr) {
        int n = arr.length;
        int m = getMax(arr, n);

        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    /**
     * Helper method to find the maximum value in the array.
     *
     * @param arr The array in which the maximum value is found.
     * @param n   The number of elements in the array.
     * @return The maximum value in the array.
     */
    public static int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Performs counting sort for a specific digit (exp) of the elements in the array.
     *
     * @param arr The array to be sorted.
     * @param n   The number of elements in the array.
     * @param exp The current digit number.
     */
    public static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}

