public class SortChecker {

    public static boolean isSorted(int[] array){
        return isSortedAsc(array) || isSortedDsc(array);
    }

    public static boolean isSortedAsc(int[] array){
        for (int i=0; i< array.length-1; i++){
            if (array[i]>array[i+1]) return false;
        }
        return true;
    }

    public static boolean isSortedDsc(int[] array){
        for (int i=0; i< array.length-1; i++){
            if (array[i]<array[i+1]) return false;
        }
        return true;
    }
}
