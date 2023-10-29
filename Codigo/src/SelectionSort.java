import java.util.Random;

/**
 * This class implements the Selection Sort algorithm and measures its execution time.
 * It generates random arrays and runs the sorting algorithm 15 times,
 * reporting the time taken for each execution.
 * The code source is based on the course presentation.
 */
public class SelectionSort {
    static int[] values;
    static int size = 1000000;
    static int numRuns = 15; // Number of runs

    /**
     * The main method that initiates the execution of the Selection Sort algorithm.
     * It generates random arrays, runs the algorithm 15 times, and measures the execution time.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        for (int run = 1; run <= numRuns; run++) {
            initializeArray();

            long startTime = System.currentTimeMillis();
            selectSort();
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
     * Finds the index of the minimum value in the array within a specified range.
     *
     * @param start The starting index of the range.
     * @param end   The ending index of the range.
     * @return The index of the minimum value within the specified range.
     */
    static int minIndex(int start, int end) {
        int indexOfMin = start;
        for (int index = start + 1; index <= end; index++) {
            if (values[index] < values[indexOfMin]) {
                indexOfMin = index;
            }
        }
        return indexOfMin;
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

    /**
     * Sorts the array using the Selection Sort algorithm.
     */
    static void selectSort() {
        int endIndex = size - 1;
        for (int current = 0; current < endIndex; current++) {
            int minIndex = minIndex(current, endIndex);
            if (current != minIndex) {
                swap(current, minIndex);
            }
        }
    }
}

