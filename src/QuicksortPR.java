public class QuicksortPR implements SortierIF{
    private int[] array = {};
    private long time=0;
    private int writes=0;
    private int compares=0;
    private int storage=0;
    private Data data = new Data(Data.QUICKSORT_RANDOM);

    public void sort(int[] array){
        this.array = array;
        storage+=array.length;
        time= -System.nanoTime();
        quickSort(0, array.length-1);
        time+=System.nanoTime();
        data.setArray(array);
    }

    public void quickSort(int leftPos, int rightPos){
        if (leftPos<rightPos){
            compares++;
            int middlepos = split(leftPos, rightPos);
            storage+=1;
            quickSort(leftPos, middlepos-1);
            quickSort(middlepos+1, rightPos);
            writes+=3;
        }
    }

    public int split(int leftPos, int rightpos){
        int pivot = (int) (Math.random()*((double)rightpos-leftPos))+leftPos;
        //int pivot = (rightpos-leftPos)/2 + leftPos;
        storage+=3;

        while (leftPos<rightpos){
            compares++;
            if (array[rightpos]>array[leftPos]){
                compares++;
                rightpos--;
            } else {
                if (array[leftPos]<=array[pivot]){
                    compares++;
                    leftPos++;
                } else {
                    int cache = array[leftPos];
                    array[leftPos] = array[rightpos];
                    array[rightpos] = cache;
                    writes+=3;
                }
            }
        }
        int cache = array[pivot];
        array[pivot] = array[rightpos];
        array[rightpos] = cache;
        writes+=3;
        return pivot;
    }

    @Override
    public Data getData() {
        data.setStorageSpace(storage*32);
        data.setNanoTime(time);
        data.setCountWrite(writes);
        data.setCountCompare(compares);
        return data;
    }
}