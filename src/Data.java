public class Data {
    //Add static variables for other sort algorithms.
    public static final int QUICKSORT_FIRST = 0;
    public static final int QUICKSORT_RANDOM = 1;
    public static final int SHAKERSORT = 2;
    public static final int BINARYTREESORT = 3;
    public static final int INSERTIONSORT = 4;
    public static final int MERGESORT = 5;
    private static final String[] converter = {"QUICKSORT_FIRST", "QUICKSORT_RANDOM", "SHAKERSORT", "BINARYTREESORT", "INSERTIONSORT", "MERGESORT"};

    private int sortType;
    private int countWrite;
    private int countCompare;
    private long nanoTime;
    private int storageSpace;
    private int[] array;

    public static String getType(int sortType){
        return converter[sortType];
    }

    public Data(int sortType) {
        this.sortType = sortType;
    }

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }


    public int getCountWrite() {
        return countWrite;
    }

    public void setCountWrite(int countWrite) {
        this.countWrite = countWrite;
    }

    public int getCountCompare() {
        return countCompare;
    }

    public void setCountCompare(int countCompare) {
        this.countCompare = countCompare;
    }

    public long getNanoTime() {
        return nanoTime;
    }

    public void setNanoTime(long nanoTime) {
        this.nanoTime = nanoTime;
    }

    public int getStorageSpace() {
        return storageSpace;
    }

    public void setStorageSpace(int storageSpace) {
        this.storageSpace = storageSpace;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

}
