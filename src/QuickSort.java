import java.lang.reflect.Array;
import java.util.Random;

/**
 * Diese Klasse sortiert ein Array nach einem beliebigem Index der am Anfang
 * initialisiert wird.
 * @since 13.01.2022
 * @author Moustafa Hawi
 * @version 0.1
 */

public class QuickSort implements SortIF {
    private int countBits = 0;
    private long nanoTime = 0;
    private int[] a;
    private int countSwaps = 0;
    private int countCompares = 0;
    /**
     *
     * @param array
     * @param first
     * @param last
     * @return positionleft
     */
    public int split(int[] array, int first, int last){
        /**
         * Es wird aus dem Array ein beliebiger index genommen und in der variable pivot gespeichert.
         */
        //todo random index
        countBits++;
        int pivot = first;
        /**
         * Zeigt auf das erste Element der Liste.
         * Wird auch gegebenenfalls später inkrementiert.
         */
        countBits++;
        int positionleft = first;
        /**
         * Zeigt auf das letzte Element der Liste.
         * Wird auch gegebenenfalls später dekrementiert.
         */
        countBits++;
        int positionright = last;
        countCompares++;
        while (positionleft <= positionright){
            countCompares++;
            /**
             * Solange die Elemente auf der linken Seite kleiner als das pivot Element
             * sind, erhöht die es die Position.
             */
            countCompares++;
            while (array[positionleft] < array[pivot]){
                positionleft++;
                countCompares++;
            }
            /**
             * Solange die Elemente auf der rechten Seite grösser als das Pivot-Element
             * sind, verringet es die Position.
             */
            countCompares++;
            while (array[positionright] > array[pivot]){
                positionright--;
                countCompares++;
            }
            /**
             * Tausche Elemente:
             * 1. zwischenresultat hält den Wert von der linken Seite fest.
             * 2. Dann wird der Wert an der Position der linken Seite auf der Wert der rechten Seite geändert.
             * 3. Dann wird der wer an der Position der rechten Seite auf den Wert zwischenresultat geändert.
             * 4. Auf der linken Seite um eins weitergeleitet (positionleft ++)
             * 5. Auf der rechten Seite um eins zurückgehen (positionright --)
             */
            countCompares++;
            if (positionleft <= positionright){
                countBits++;
                countSwaps++;
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
        countBits++;
        int index = split(array, first, last);
        /**
         * Das repräsentiert die linke Seite vom Pivot-Element.
         */
        countCompares++;
        if (first < index-1){
            sort(array, first, index - 1);
        }
        /**
         * Das repräsentiert die rechte Seite vom Pivot-Element.
         */
        countCompares++;
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
        nanoTime =- System.nanoTime();
        sort(array, 0, array.length - 1);
        nanoTime -= System.nanoTime();
        a = array.clone();
    }

    @Override
    public Data getData() {
        Data data = new Data("QuickSort-random");
        data.setStorageSpace(countBits*32);
        data.setNanoTime(nanoTime);
        data.setArray(a);
        data.setCountWrite(countSwaps);
        data.setCountCompare(countCompares);
        return data;
    }
}
