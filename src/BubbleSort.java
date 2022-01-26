/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
 * After, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted.
 * Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
 * Auxiliary Space: O(1)
 * Boundary Cases: Bubble sort takes minimum time (Order of n) when elements are already sorted.
 * Sorting In Place: Yes
 * Stable: Yes
 *
 * @author Moustafa Hawi
 * @version 0.1
 * @since 25.01.2022
 */
public class BubbleSort implements SortIF {
    private long countBits = 0;
    private long nanoTime = 0;
    private int[] a;
    private long countSwaps = 0;
    private long countCompares = 0;

    /**
     * This Method sort the Bubble sort. It is really simple, it compares the first two elements, and swaps them if the first one is smaller than the second one.
     *
     * @param array to be sorted.
     */
    @Override
    public void sort(int[] array) {
        nanoTime = -System.nanoTime();
        countBits++;
        int n = array.length;
        countCompares++;
        for (int i = 0; i < n - 1; i++) {
            countCompares++;
            countCompares++;
            for (int j = 0; j < n - i - 1; j++) {
                countCompares++;
                countCompares++;
                if (array[j] > array[j + 1]) {
                    /**
                     * swap arr[j+1] and arr[j]
                     */
                    countBits++;
                    countSwaps += 2;
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        nanoTime += System.nanoTime();
        a = array.clone();
    }

    @Override
    public Data getData() {
        Data data = new Data("BubbleSort");
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
