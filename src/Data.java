/**
 * This Class is used to store Data to int-sort-algorithms and the sorted array.
 * For Sorting purposes, you are able to Sort not by Sorter-name, but by an int value, witch is defined by the sortType algorithms
 * @author Kevin Stupar
 * @version 1.0
 * @since 12.01.2022
 */
public class Data {
    /**
     * Conversion array, for the Sort type.
     * value of the SortType defines the index of this string array.
     */
    private static final String[] converter = {"Quicksort first", "Quicksort random", "Shakersort", "BinaryTreesort", "Insertionsort", "Mergesort"};

    /**
     * Attribute storing the number of writes the sort-algorithm needed to sort the array.
     */
    private int countWrite;

    /**
     * Attribute storing the sort type, defined in the constructor, defines the sorting-algorithm used.
     */
    private String  sortType;

    /**
     * Attribute storing the value of heap space needed to sort the array in bytes.
     */
    private int storageSpace;

    /**
     * Attribute storing the number of compares used to sort the array.
     */
    private long countCompare;

    /**
     * Attribute storing the time used to sort the array in nanoseconds
     */
    private long nanoTime;

    /**
     * int-array storing sorted values.
     */
    private int[] array;

    /**
     * Constructor creating an object and defines the algorithm used to sort the array.
     * @param sortType defines the algorithm used to sort the array.
     */
    public Data(String  sortType) {
        this.sortType = sortType;
    }

    /**
     * Gives back the sort-type (String). Attention: if the sort-type isn't set, you might get an exception.
     * @return sortType, int
     */
    public String  getSortType() {
        return sortType;
    }

    /**
     * Sets the sort-type for later use.
     * @param sortType sorttype to be set for later use.
     */
    public void setSortType(String  sortType) {
        this.sortType = sortType;
    }

    /**
     * Gives the number of writes needed to sort the array. Attention: If writes aren't set, you might get an exception
     * @return count of writes.
     */
    public int getCountWrite() {
        return countWrite;
    }

    /**
     * Sets the count of how many writes has been needed to sort the array.
     * @param countWrite number of writes.
     */
    public void setCountWrite(int countWrite) {
        this.countWrite = countWrite;
    }

    /**
     * Gives the number of compares used to sort the array. Attention: If compares aren't set, you might get an exception
     * @return number of compares.
     */
    public long getCountCompare() {
        return countCompare;
    }

    /**
     * sets the number of counts used to sort the array for later uses.
     * @param countCompare number of compares.
     */
    public void setCountCompare(long countCompare) {
        this.countCompare = countCompare;
    }

    /**
     * Gives the time used to sort the array in nanoseconds. Attention: If time isn't set, you might get an exception
     * @return sorting-time in nanoseconds
     */
    public long getNanoTime() {
        return nanoTime;
    }

    /**
     * Sets the time used to sort the array in nanoseconds.
     * @param nanoTime nanoseconds for array-sorting
     */
    public void setNanoTime(long nanoTime) {
        this.nanoTime = nanoTime;
    }

    /**
     * Gives the calculated storage space in bytes the algorithm used to sort the array. Attention: If storage isn't set, you might get an exception
     * @return needed storage-space in bytes.
     */
    public int getStorageSpace() {
        return storageSpace;
    }

    /**
     * Sets te needed storage space to sort the array in bytes.
     * @param storageSpace needed space in bytes to sort the array.
     */
    public void setStorageSpace(int storageSpace) {
        this.storageSpace = storageSpace;
    }

    /**
     * Gives back the sorted int-array. Attention: If array isn't set, you might get an exception
     * @return int-array.
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Sets the sorted int-array
     * @param array int-array
     */
    public void setArray(int[] array) {
        this.array = array;
    }

}
