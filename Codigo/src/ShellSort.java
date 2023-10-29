import java.util.Random;

/**
 * This class implements the Shell Sort algorithm and measures its execution time.
 * It generates random arrays and runs the sorting algorithm 15 times,
 * reporting the time taken for each execution.
 * The code source is based on the provided code.
 */
public class ShellSort {
    static Comparable[] values;
    static int size = 1000000;
    static int numRuns = 15; // Number of runs

    /**
     * The main method that initiates the execution of the Shell Sort algorithm.
     * It generates random arrays, runs the algorithm 15 times, and measures the execution time.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int run = 1; run <= numRuns; run++) {
            initializeArray();

            long startTime = System.currentTimeMillis();
            sort(values);
            long endTime = System.currentTimeMillis();

            double elapsedTimeInSeconds = (endTime - startTime) / 1000.0;
            System.out.println("Execution time in run " + run + ": " + elapsedTimeInSeconds + " seconds");
        }
    }

    /**
     * Initializes the array with random values.
     */
    static void initializeArray() {
        values = new Comparable[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            values[i] = rand.nextInt(1000000); // Range of random values
        }
    }

    /**
     * Sorts the array using the Shell Sort algorithm.
     *
     * @param a The array to be sorted.
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        // 3x+1 increment sequence: 1, 4, 13, 40, 121, 364, 1093,
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j].compareTo(a[j - h]) < 0; j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    /**
     * Swaps two elements in the array.
     *
     * @param a The array.
     * @param i The index of the first element.
     * @param j The index of the second element.
     */
    public static void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

