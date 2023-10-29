import java.util.Random;

public class SelectionSort {
    static int[] values;
    static int size = 1000000;
    static int numRuns = 15; // Número de ejecuciones

    public static void main(String[] args) {
        for (int run = 1; run <= numRuns; run++) {
            initializeArray();

            long startTime = System.currentTimeMillis();
            selectSort();
            long endTime = System.currentTimeMillis();

            double elapsedTimeInSeconds = (endTime - startTime) / 1000.0;
            System.out.println("Tiempo de ejecución en la ejecución " + run + ": " + elapsedTimeInSeconds + " segundos");
        }
    }

    static void initializeArray() {
        values = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            values[i] = rand.nextInt(1000000); // Rango de valores aleatorios
        }
    }

    static int minIndex(int start, int end) {
        int indexOfMin = start;
        for (int index = start + 1; index <= end; index++) {
            if (values[index] < values[indexOfMin]) {
                indexOfMin = index;
            }
        }
        return indexOfMin;
    }

    static void swap(int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

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
