
/**
 * @since 13.01.2022
 * @author Moustafa Hawi
 * @version 0.1
 * This class sort a class with a quick Sort.
 */

public class QuickSort implements SortierIF{
    @Override
    public void sort(int[] array) {

    }

    /**
     *
     * @param array This is the array that we will sort.
     * @param left This are the elements that are smaller than the pivot.
     * @param right This are the elements that are bigger than the pivot.
     * That method will take the array and sort it with a pivot that is the middle index of the array. All values before
     * the pivot are smaller than the pivot and all values that comes after the array are bigger.
     */
    public void sort(int[] array, int left, int right){
        int pivot = (int) (Math.random() * (right - left) + left);

    }

    @Override
    public Data getData() {
        return null;
    }
}
