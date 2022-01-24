
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
             * 3.
             */
            if (positionleft <= positionright){
                int zwischenResultat = array[positionleft];
                array[positionleft] = array[positionright];
                array[positionright] = zwischenResultat;
                positionleft++;
                positionright--;
            }
        }
        return 0;
    }
    @Override
    public void sort(int[] array) {

    }

    @Override
    public Data getData() {
        return null;
    }
}
