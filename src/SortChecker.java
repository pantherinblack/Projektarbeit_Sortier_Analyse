/**
 * Used to check, if the Array is sorted, multiple methods are available.
 *  * @since 12.01.2022
 *  * @author Kevin Stupar
 *  * @version 1.0
 */
public class SortChecker {

    /**
     * Checks if the array is sorted ascending oder descending.
     * @param array to be checked
     * @return boolean, if sorted true, if unsorted false
     */
    public static boolean isSorted(int[] array){
        return isSortedAsc(array) || isSortedDsc(array);
    }

    /**
     * Checks if the array is sorted ascending
     * @param array to be checked
     * @return boolean, if sorted ascending true, else false
     */
    public static boolean isSortedAsc(int[] array){
        for (int i=0; i< array.length-1; i++){
            if (array[i]>array[i+1]) return false;
        }
        return true;
    }

    /**
     * Checks if the array is sorted descending
     * @param array to be checked
     * @return boolean, if sorted descending true, else false
     */
    public static boolean isSortedDsc(int[] array){
        for (int i=0; i< array.length-1; i++){
            if (array[i]<array[i+1]) return false;
        }
        return true;
    }
}
