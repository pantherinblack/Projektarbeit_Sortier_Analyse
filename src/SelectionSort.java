public class SelectionSort implements SortierIF{
    private int[] array;
    private long compares=0;
    private int writes=0;
    private int space=0;
    private long time=0;

    public void sort(int[] array) {
        this.array = array;
        space+=array.length;
        time = -System.nanoTime();
        selectionSort();
        time += System.nanoTime();
    }

    @Override
    public Data getData() {
        Data data = new Data("Selection-Sort");
        data.setArray(array);
        data.setCountCompare(compares);
        data.setCountWrite(writes);
        data.setStorageSpace(space*32);
        data.setNanoTime(time);
        return data;
    }

    public void selectionSort() {
        space++;
        for (int i = 0; i < array.length; i++) {
            compares++;
            int min = i;
            space++;
            space++;
            for (int j = i; j < array.length; j++) {
                compares++;
                if (array[min] > array[j]) min = j;
                compares++;
            }
            int cache = array[i];
            array[i] = array[min];
            array[min] = cache;
            writes+=3;
        }
    }
}