
/**
 * Diese Klasse sortiert ein Array nach einem beliebigem Index der am Anfang
 * initialisiert wird.
 * @since 25.01.2022
 * @author Moustafa Hawi
 * @version 0.1
 */

public class CocktailSort implements SortIF{

    @Override
    public void sort(int[] array) {
        boolean swapped = true;
        int start = 0;
        int end = array.length;

        while (swapped == true){
            /**
             * Reset the swapped flag on entering the loop, because it might be true from a previous iteration.
             */
            swapped = false;
        }
        /**
         * loop from bottom to top same as the bubble sort.
         */
        for (int i = start; i < end - 1; i++){
            if (array[i] > array[i + 1]){
                int temporär = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temporär;
                swapped = true;
            }
        }
        /**
         * If nothing moved, then array is sorted.
         */
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
            for (int i = end - 1; i >= start; i--){
                if (array[i] > array[i + 1]){
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
        }


    @Override
    public Data getData() {
        return null;
    }
}
