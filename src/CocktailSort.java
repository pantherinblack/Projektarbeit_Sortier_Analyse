
/**
 * This class sorts a array with a CocktailSort and returns the data. The CocktailSort is a version of BubbleSort.
 * The Bubble sort algorithm always traverses elements from left and moves the largest element to its correct position in first iteration and second largest in second iteration and so on.
 * The CocktailSort tranverses through a given array in both directions alternatively.
 * @since 25.01.2022
 * @author Moustafa Hawi
 * @version 0.1
 */

public class CocktailSort implements SortIF{
    private int countBits = 0;
    private long nanoTime = 0;
    private int[] a;
    private int countSwaps = 0;
    private int countCompares = 0;

    /**
     * This Method sorts the Array.
     * @param array
     */
    @Override
    public void sort(int[] array) {
        nanoTime = - System.nanoTime();
        boolean swapped = true;
        countBits++;
        int start = 0;
        countBits++;
        int end = array.length;

        countCompares++;
        while (swapped == true){
            countCompares++;
            /**
             * Reset the swapped flag on entering the loop, because it might be true from a previous iteration.
             */
            swapped = false;
        }
        /**
         * loop from bottom to top same as the bubble sort.
         */
        countCompares++;
        for (int i = start; i < end - 1; i++){
            countCompares++;
            countCompares++;
            if (array[i] > array[i + 1]){
                countBits++;
                countSwaps+=2;
                int temporär = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temporär;
                swapped = true;
            }
        }
        /**
         * If nothing moved, then array is sorted.
         */
        countCompares++;
        if (swapped == false) {
            return;
        }

        /**
         * Otherwise, reset the swapped flag so that it can be used in the next stage.
         */
        swapped = false;
        /**
         * Move the end point back by one, because item at the end is in its rightful spot
         */
        end = end - 1;
        /**
         * From top to bottom, doing the same comparison as in the previous stage.
         */
            countCompares++;
            for (int i = end - 1; i >= start; i--){
                countCompares++;
                countCompares++;
                if (array[i] > array[i + 1]){
                    countBits++;
                    countSwaps+=2;
                    int temporär = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temporär;
                    swapped = true;
                }
            }
            /**
             * increase the starting point, because the last stage would have moved the next smallest number to its rightful spot.
             */
            start = start + 1;
            nanoTime += System.nanoTime();
            a = array.clone();
        }

    /**
     * This Method return data.
     * @return data
     */
    @Override
    public Data getData() {
        Data data = new Data("CocktailSort");
        data.setStorageSpace(countBits*32);
        data.setNanoTime(nanoTime);
        data.setArray(a);
        data.setCountWrite(countSwaps);
        data.setCountCompare(countCompares);
        return data;
    }
}
