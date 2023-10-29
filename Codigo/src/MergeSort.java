import java.util.Random;

/**
 * This class implements the Merge Sort algorithm and measures its execution time.
 * It generates random arrays and runs the sorting algorithm 15 times,
 * reporting the time taken for each execution.
 * The code source is based on the provided code.
 */
public class MergeSort {
    static int[] values;
    static int size = 1000000;
    static int numRuns = 15; // Number of runs

    /**
     * The main method that initiates the execution of the Merge Sort algorithm.
     * It generates random arrays, runs the algorithm 15 times, and measures the execution time.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int run = 1; run <= numRuns; run++) {
            initializeArray();

            long startTime = System.currentTimeMillis();
            mergeSort(values, 0, values.length - 1);
            long endTime = System.currentTimeMillis();

            double elapsedTimeInSeconds = (endTime - startTime) / 1000.0;
            System.out.println("Execution time in run " + run + ": " + elapsedTimeInSeconds + " seconds");
        }
    }

    /**
     * Initializes the array with random values.
     */
    static void initializeArray() {
        values = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            values[i] = rand.nextInt(1000000); // Range of random values
        }
    }

    /**
     * Sorts the array using the Merge Sort algorithm.
     *
     * @param a    The array to be sorted.
     * @param low  The index of the low boundary.
     * @param high The index of the high boundary.
     */
    public static void mergeSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, high, mid);
        }
    }

    /**
     * Merges two subarrays to sort the array.
     *
     * @param a    The array to be sorted.
     * @param low  The index of the low boundary.
     * @param high The index of the high boundary.
     * @param mid  The index of the middle element.
     */
    public static void merge(int[] a, int low, int high, int mid) {
        int i, j, k;
        int[] c = new int[high - low + 1];
        i = low;
        k = 0;
        j = mid + 1;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                c[k] = a[i];
                k++;
                i++;
            } else {
                c[k] = a[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            c[k] = a[i];
            k++;
            i++;
        }
        while (j <= high) {
            c[k] = a[j];
            k++;
            j++;
        }
        for (i = 0; i < k; i++) {
            a[low + i] = c[i];
        }
    }
}

