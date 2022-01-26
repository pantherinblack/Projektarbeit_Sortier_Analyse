/**
 * Used to sort an array by a specific algorithm
 * This Selection sort is nearly a Bubblesort, with the difference, that it searches for the lowest value in the array and places ist at the beginning
 *  The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
 *  from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.
 * 1) The subarray which is already sorted.
 * 2) Remaining subarray which is unsorted.
 * In every iteration of selection sort, the minimum element (considering ascending order)
 * from the unsorted subarray is picked and moved to the sorted subarray.
 * @author Kevin Stupar, Moustafa Hawi
 * @version 1.0
 * @since 19.01.2022
 */
public class SelectionSort implements SortIF {

    /**
     * Array to be worked on.
     */
    private int[] array;

    /**
     * counter counting the number of compares the algorithm needs.
     */
    private long compares = 0;

    /**
     * counter counting to number of writes executed by algorithm.
     */
    private long writes = 0;

    /**
     * counter counting int variables.
     */
    private long space = 0;

    /**
     * used to store the time in nanoseconds needed for sorting.
     */
    private long time = 0;

    /**
     * can be executed to start the sorting algorithm.
     *
     * @param array to be sorted.
     */
    public void sort(int[] array) {
        this.array = array;
        space += array.length;
        time = -System.nanoTime();
        selectionSort();
        time += System.nanoTime();
    }

    /**
     * Stores all data in a Data object and returns it.
     *
     * @return data object containing information
     */
    @Override
    public Data getData() {
        Data data = new Data("Selection-Sort");
        data.setArray(array);
        data.setCountCompare(compares);
        data.setCountWrite(writes);
        data.setStorageSpace(space * 32);
        data.setNanoTime(time);
        return data;
    }

    /**
     * Runs the sorting algorithm itself.
     */
    private void selectionSort() {
        space++;

        compares++;
        for (int i = 0; i < array.length; i++) {
            compares++;
            int min = i;
            space++;
            space++;

            compares++;
            for (int j = i; j < array.length; j++) {
                compares++;
                if (array[min] > array[j]) min = j;
                compares++;
            }
            int cache = array[i];
            array[i] = array[min];
            array[min] = cache;
            writes += 2;
            space++;
        }
    }
}