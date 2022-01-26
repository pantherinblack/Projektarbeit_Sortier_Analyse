/**
 * Heap sort is a comparison-based sorting technique based on Binary Heap data structure.
 * It is similar to selection sort where we first find the minimum element and place the minimum element at the beginning.
 * We repeat the same process for the remaining elements.
 *
 * @author Moustafa Hawi
 * @version 0.1
 * @since 25.01.2022
 */
public class HeapSort implements SortIF {
    private long countBits = 0;
    private long nanoTime = 0;
    private int[] a;
    private long countSwaps = 0;
    private long countCompares = 0;

    /**
     * To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
     *
     * @param array
     * @param n
     * @param i
     */
    public void heapify(int[] array, int n, int i) {
        /**
         * Initialize largest as root
         */
        countBits++;
        int largest = i;
        /**
         * left = 2*i + 1
         */
        countBits++;
        int l = 2 * i + 1;
        /**
         * right = 2*i + 2
         */
        countBits++;
        int r = 2 * i + 2;
        /**
         *  If left child is larger than root
         */

        if (l < n && array[l] > array[largest]) {
            countSwaps++;
            largest = l;
        }
        /**
         * If right child is larger than largest so far
         */
        countCompares++;
        if (r < n && array[r] > array[largest]) {
            countSwaps++;
            largest = r;
        }
        /**
         * If largest is not root
         */
        countCompares++;
        if (largest != i) {
            countBits++;
            countSwaps += 2;
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            /**
             * Recursively heapify the affected sub-tree
             */
            heapify(array, n, largest);
        }
    }

    /**
     * Build a rerange array and execute heapify()
     * Execute
     *
     * @param array to be sorted.
     */
    @Override
    public void sort(int[] array) {
        nanoTime = -System.nanoTime();
        countBits++;
        int n = array.length;
        /**
         * Build heap (rearrange array).
         */

        countCompares++;
        for (int i = n / 2 - 1; i >= 0; i--) {
            countCompares++;
            heapify(array, n, i);
        }
        /**
         *  One by one extract an element from heap
         */
        countCompares++;
        for (int i = n - 1; i > 0; i--) {
            countCompares++;
            /**
             * Move current root to end
             */
            countBits++;
            countSwaps += 2;
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            /**
             * call max heapify on the reduced heap
             */
            heapify(array, i, 0);
        }
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
        Data data = new Data("Heap-Sort");
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
