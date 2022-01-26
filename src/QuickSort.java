/**
 * Like Merge Sort, QuickSort is a Divide and Conquer algorithm.
 * It picks an element as pivot and partitions the given array around the picked pivot.
 * There are many different versions of quickSort that pick pivot in different ways.
 * This one picks the first element as pivot.
 *
 * @author Moustafa Hawi
 * @version 0.1
 * @since 13.01.2022
 */

public class QuickSort implements SortIF {
    private long countBits = 0;
    private long nanoTime = 0;
    private int[] a;
    private long countSwaps = 0;
    private long countCompares = 0;

    /**
     * This function takes first element as pivot, places
     * the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     *
     * @param array
     * @param first
     * @param last
     * @return positionleft
     */
    public int split(int[] array, int first, int last) {
        /**
         * takes first element as pivot
         */
        countBits++;
        int pivot = first;
        /*
         * Shows the first element of the list.
         * will be increased later
         */
        countBits++;
        int positionleft = first;
        /*
         * shows the last element of the list.
         * will be reduced later
         */
        countBits++;
        int positionright = last;
        countCompares++;
        while (positionleft <= positionright) {
            countCompares++;
            /*
             * As long as the elements on the left side are smaller than the pivot element
             * are, it increases the position.
             */
            countCompares++;
            while (array[positionleft] < array[pivot]) {
                positionleft++;
                countCompares++;
            }
            /*
             * As long as the elements on the right side are bigger than the pivot element
             * it reduces the position.
             */
            countCompares++;
            while (array[positionright] > array[pivot]) {
                positionright--;
                countCompares++;
            }
            /*
             * Exchange elements:
             * 1. intermediate result holds the value from the left side.
             * 2. Then the value at the position of the left side is changed to the value of the right side.
             * 3. Then the who at the position of the right side is changed to the value betweenresult.
             * 4. On the left side forwarded by one (positionleft ++)
             * 5. Go back one on the right side (positionright --)
             */
            countCompares++;
            if (positionleft <= positionright) {
                countBits++;
                countSwaps++;
                int zwischenResultat = array[positionleft];
                array[positionleft] = array[positionright];
                array[positionright] = zwischenResultat;
                positionleft++;
                positionright--;
            }
        }
        return positionleft;
    }

    /**
     * This method calls the split() method until it has sorted through the array.
     *
     * @param array
     * @param first
     * @param last
     */
    public void sort(int[] array, int first, int last) {
        /**
         * Splitting the array into the two sides. The left side becomes smaller than Pivot and the right side becomes larger than Pivot.
         */
        countBits++;
        int index = split(array, first, last);
        /*
         * This represents the left side of the pivot element.
         */
        countCompares++;
        if (first < index - 1) {
            sort(array, first, index - 1);
        }
        /*
         * This represents the right side of the pivot element.
         */
        countCompares++;
        if (index < last) {
            sort(array, index, last);
        }
    }

    /**
     * This method calls the method sort() (which is called with the parameters array : int[], first : int, last : int.
     *
     * @param array
     */
    @Override
    public void sort(int[] array) {
        nanoTime = -System.nanoTime();
        sort(array, 0, array.length - 1);
        nanoTime += System.nanoTime();
        a = array.clone();
    }

    /**
     * This method returns data
     *
     * @return data
     */
    @Override
    public Data getData() {
        Data data = new Data("QuickSort");
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
