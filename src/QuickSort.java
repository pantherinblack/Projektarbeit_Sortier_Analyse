import java.lang.reflect.Array;

/**
 * Diese Klasse sortiert ein Array nach einem beliebigem Index der am Anfang
 * initialisiert wird.
 * @since 13.01.2022
 * @author Moustafa Hawi
 * @version 0.1
 */

public class QuickSort implements SortierIF{
    /**
     *
     * @param array
     * @param first
     * @param last
     * @return
     */
    public int split(int[] array, int first, int last){
        /**
         * Es wird aus dem Array ein beliebiger index genommen und in der variable pivot gespeichert.
         */
        //todo random index
        int pivot = array[(first + last)/2];
        /**
         * Zeigt auf das erste Element der Liste.
         * Wird auch gegebenenfalls später inkrementiert.
         */
        int positionleft = first;
        /**
         * Zeigt auf das letzte Element der Liste.
         * Wird auch gegebenenfalls später dekrementiert.
         */
        int positionright = last;

        while (positionleft <= positionright){
            /**
             * Solange die Elemente auf der linken Seite kleiner als das pivot Element
             * sind, erhöht die es die Position.
             */
            while (array[positionleft] < pivot){
                positionleft++;
            }
            /**
             * Solange die Elemente auf der rechten Seite grösser als das Pivot-Element
             * sind, verringet es die Position.
             */
            while (array[positionright] > pivot){
                positionright--;
            }
            /**
             * Tausche Elemente:
             * 1. zwischenresultat hält den Wert von der linken Seite fest.
             * 2. Dann wird der Wert an der Position der linken Seite auf der Wert der rechten Seite geändert.
             * 3. Dann wird der wer an der Position der rechten Seite auf den Wert zwischenresultat geändert.
             * 4. Auf der linken Seite um eins weitergeleitet (positionleft ++)
             * 5. Auf der rechten Seite um eins zurückgehen (positionright --)
             */
            if (positionleft <= positionright){
                int zwischenResultat = array[positionleft];
                array[positionleft] = array[positionright];
                array[positionright] = zwischenResultat;
                positionleft++;
                positionright--;
            }
        }
        return positionleft;
    }

    /**
     * Diese Methode ruft die Methode split() so lange auf bis es das Array durchsortiert hat.
     * @param array
     * @param first
     * @param last
     */
    public void sort(int[] array, int first, int last){
        /**
         * Aufteilung des Arrays in die zwei Seiten. Die linke Seit wird kleiner als Pivot und rechte Seite grösser als Pivot.
         */
        int index = split(array, first, last);
        /**
         * Das repräsentiert die linke Seite vom Pivot-Element.
         */
        if (first < index - 1){
            sort(array, first, index - 1);
        }
        /**
         * Das repräsentiert die rechte Seite vom Pivot-Element.
         */
        if (index < last){
            sort(array, index, last);
        }
    }
    /**
     *  Diese Methode ruft die Methode sort() (die mit den Parametern array : int[], first : int, last : int.
     * @param array
     */
    @Override
    public void sort(int[] array) {

    }

    @Override
    public Data getData() {
        //todo: return data
        return null;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int [] beispielArray = {6,23,534,12,4,1,65,3};
        for (int i = 0; i < beispielArray.length; i++){
            System.out.println(beispielArray[i]);
        }
        q.sort(beispielArray, 0, beispielArray.length);
        System.out.println("-------------------------");
        for (int i = 0; i < beispielArray.length; i++){
            System.out.println(beispielArray[i]);
        }
    }
}
