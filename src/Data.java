public class Data {
    private static final int QUICKSORT_FIRST = 0;
    private static final int QUICKSORT_RANDOM = 1;
    private static final int SHAKERSORT = 2;
    private static final int BINARYTREESORT = 3;
    private static final int INSERTIONSORT = 4;
    private static final int MERGESORT = 5;
    private int sortType;
    private int countWrite;
    private int countCompare;
    private long nanoTime;
    private int storageSpace;
    private int[] array;

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
