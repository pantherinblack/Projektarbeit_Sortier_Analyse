/**
 * Like QuickSort, MergeSort is a Divide and Conquer algorithm. It devides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves.
 * The merge() function is used for merging two halves. The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.
 * @since 25.01.2022
 * @author Moustafa Hawi
 * @version 0.1
 */
public class MergeSort implements SortIF{
    private long countBits = 0;
    private long nanoTime = 0;
    private int[] a;
    private long countSwaps = 0;
    private long countCompares = 0;
    /**
     * This Method merges the array.
     * @param array
     * @param l
     * @param m
     * @param r
     */
    public void merge(int array[], int l, int m, int r){
        /**
         * Find sizes if two subarrays to be merged.
         */
        countBits++;
        int n1 = m - l + 1;
        countBits++;
        int n2 = r - m;
        /**
         * Create temp arrays.
         */
        int L[] = new int[n1];
        countBits += L.length;
        int R[] = new int[n2];
        countBits += R.length;
        /**
         * Copy data to temporary arrays.
         */
        countCompares++;
        for (int i = 0; i < n1; i++){
            countCompares++;
            countSwaps++;
            L[i] = array[l + i];
        }
        countCompares++;
        for (int j = 0; j < n2; j++){
            countCompares++;
            countSwaps++;
            R[j] = array[m + 1 + j];
        }
        /**
         * Merge the temporary arrays.
         */
        /**
         * Initial indexes of first and second subarrays
         */
        countBits++;
        countBits++;
        int i = 0, j = 0;
        /**
         * Initial index of merged subarray array
         */
        countBits++;
        int k = l;
        countCompares++;
        while (i < n1 && j < n2) {
            countCompares++;
            countCompares++;
            if (L[i] <= R[j]) {
                countSwaps++;
                array[k] = L[i];
                i++;
            }
            else {
                countSwaps++;
                array[k] = R[j];
                j++;
            }
            k++;
        }
        /**
         *  Copy remaining elements of L[] if any
         */
        countCompares++;
        while (i < n1) {
            countCompares++;
            countSwaps++;
            array[k] = L[i];
            i++;
            k++;
        }

        /**
         *  Copy remaining elements of R[] if any
         */
        countCompares++;
        while (j < n2) {
            countCompares++;
            countSwaps++;
            array[k] = R[j];
            j++;
            k++;
        }
    }

    /**
     * Main function that sorts arr[l..r] using merge()
     * @param array
     * @param l
     * @param r
     */
    public void sort (int [] array, int l, int r){
        countCompares++;
        if (l < r) {
            /**
             * Find the middle point
             */
            countBits++;
            int m =l+ (r-l)/2;

            /**
             * Sort first and second halves
             */
            sort(array, l, m);
            sort(array, m + 1, r);

            /**
             * Merge the sorted halves
             */
            merge(array, l, m, r);
        }
    }

    /**
     * Excute sort()
     * @param array to be sorted.
     */
    @Override
    public void sort(int[] array) {
        nanoTime = - System.nanoTime();
        sort(array, 0, array.length - 1);
        nanoTime += System.nanoTime();
        a = array.clone();
    }

    /**
     * Returns data
     * @return data
     */
    @Override
    public Data getData() {
        Data data = new Data("MergeSort");
        data.setStorageSpace(countBits*32);
        data.setNanoTime(nanoTime);
        data.setArray(a);
        data.setCountWrite(countSwaps);
        data.setCountCompare(countCompares);
        return data;
    }
}
