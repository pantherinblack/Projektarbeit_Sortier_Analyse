public class Data {
    private int countWrite;
    private int countCompare;
    private long nanoTime;
    private int storageSpace;
    private int[] array;

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
