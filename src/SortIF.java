/**
 * Sorter Interface, used to ensure that each sorting algorithm is able to sort and can return data.
 * @author Kevin Stupar
 * @version 1.0
 * @since 12.01.2022
 */
public interface SortIF {
    /**
     * Method for executing the sorting algorithm.
     *
     * @param array to be sorted.
     */
    void sort(int[] array);

    /**
     * Method for giving back all Data, the Sorter
     *
     * @return
     */
    Data getData();
}
