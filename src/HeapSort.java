/**
 * Heap sort is a comparison-based sorting technique based on Binary Heap data structure.
 * It is similar to selection sort where we first find the minimum element and place the minimum element at the beginning.
 * We repeat the same process for the remaining elements.
 * @since 25.01.2022
 * @author Moustafa Hawi
 * @version 0.1
 */
public class HeapSort implements SortIF {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        /**
         * Build heap (rearrange array).
         */
        //
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    @Override
    public Data getData() {
        return null;
    }
}
