import java.util.Random;

/**
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm.
 * It picks an element as pivot and partitions the given array around the picked pivot.
 * There are many different versions of quickSort that pick pivot in different ways.
 * This one picks a random element as a pivot.
 *
 * @author Moustafa Hawi
 * @version 0.1
 * @since 13.01.2022
 */
public class RandomizedQuickSort implements SortIF {
    private long countBits = 0;
    private long nanoTime = 0;
    private int[] a;
    private long countSwaps = 0;
    private long countCompares = 0;

    /**
     * This Function helps in calculating random numbers between low(inclusive) and high(inclusive)
     *
     * @param array
     * @param low
     * @param high
     */
    public void random(int array[], int low, int high) {
        Random rand = new Random();
        countBits += 2;
        int pivot = rand.nextInt(high - low) + low;
        int temp1 = array[pivot];
        array[pivot] = array[high];
        array[high] = temp1;
    }

    /**
     * This function takes first element as pivot, places
     * the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    public int split(int array[], int low, int high) {
        /**
         * pivot is chosen randomly
         */
        random(array, low, high);
        countBits++;
        int pivot = array[high];
        /**
         * index of smaller element
         */
        countBits++;
        int i = (low - 1);
        countCompares++;
        for (int j = low; j < high; j++) {
            countCompares++;
            /**
             * If current element is smaller than or equal to pivot
             */
            countCompares++;
            if (array[j] < pivot) {
                i++;
                /**
                 * swap arr[i] and arr[j]
                 */
                countBits++;
                countSwaps++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        /**
         * swap arr[i+1] and arr[high] (or pivot)
         */
        countBits++;
        int temp = array[i + 1];
        countSwaps += 2;
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    /**
     * The main function that implements QuickSort()
     * arr[] --> Array to be sorted,
     * low --> Starting index,
     * high --> Ending index
     *
     * @param array
     * @param low
     * @param high
     */
    public void sort(int[] array, int low, int high) {
        if (low < high) {
            countCompares++;
            /**
             *  pi is partitioning index, arr[pi] is now at right place
             */
            countBits++;
            int pi = split(array, low, high);
            /**
             * Recursively sort elements before
             * partition and after partition
             */
            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }
    }

    /**
     * This method calls the method sort() (which is called with the parameters array : int[], first : int, last : int.
     *
     * @param array to be sorted.
     */
    @Override
    public void sort(int[] array) {
        nanoTime = -System.nanoTime();
        sort(array, 0, array.length - 1);
        nanoTime += System.nanoTime();
        a = array.clone();
    }

    /**
     * This method returns data.
     *
     * @return data
     */
    @Override
    public Data getData() {
        Data data = new Data("QuickSort-random");
        data.setStorageSpace(countBits * 32);
        data.setNanoTime(nanoTime);
        data.setArray(a);
        data.setCountWrite(countSwaps);
        data.setCountCompare(countCompares);
        countBits = 0;
        countCompares = 0;
        countSwaps = 0;
        return data;
    }
}
