import java.util.Random;

/**
 * This class implements the Bubble Sort algorithm and measures its execution time.
 * It generates random arrays and runs the sorting algorithm 15 times,
 * reporting the time taken for each execution.
 * The code source is based on the course presentation.
 */
public class BubbleSort {
    static int[] values;
    static int size = 1000000;
    static int numRuns = 15; // Number of runs

    /**
     * The main method that initiates the execution of the Bubble Sort algorithm.
     * It generates random arrays, runs the algorithm 15 times, and measures the execution time.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int run = 1; run <= numRuns; run++) {
            initializeArray();

            long startTime = System.currentTimeMillis();
            bubbleSort();
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
     * Sorts the array using the Bubble Sort algorithm.
     */
    static void bubbleSort() {
        int nElements = values.length;
        for (int out = nElements - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (values[in] > values[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }
    }

    /**
     * Swaps the values at two given indices in the array.
     *
     * @param i The index of the first value.
     * @param j The index of the second value.
     */
    static void swap(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }
}
