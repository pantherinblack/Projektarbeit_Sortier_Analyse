/**
 * @since 12.01.2022
 * @author Kevin Stupar
 * @version 1.0
 */
public interface SortIF {
    /**
     * Method for executing the sorting algorithm.
     * @param array to be sorted.
     */
    void sort(int[] array);

    /**
     * Method for giving back all Data, the Sorter
     * @return
     */
    Data getData();
}
