import java.io.*;
import java.util.Vector;

/**
 * @since 12.01.2022
 * @author Kevin Stupar
 * @version 0.3
 */
public class Manager {
    public final String[] fileSources;
    private final Vector<SortierIF> sorter = new Vector<>();
    private final DataExport dataExport = new DataExport();
    private final DataImport dataImport = new DataImport();

    /**
     * Creation of a manager object and editing of paths for data input.
     */
    public Manager() {
        fileSources = dataImport.getFileSources();

    }

    /**
     * Runs the calculation of the program, executes every sort algorithm on every dataset
     */
    public void run(){
        for (String fileSource : fileSources) {
            int[] array = {};
            try {
                array = convertVectorToArray(dataImport.readFile(fileSource));
            } catch (IOException e) {
                e.printStackTrace();
            }
            runSorters(array.clone());
        }
        dataExport.generateFiletext();
    }

    /**
     * Runs all sort algorithms on the before given sorter objects.
     * @param array containing the array to sort.
     */
    private void runSorters(int[] array){
        for (SortierIF sort : sorter){
            sort.sort(array);
            dataExport.addData(sort.getData());
        }
    }

    /**
     * Converts incoming integer Vector and converts it to a conventional int array.
     * @param vector Vector to be converted to int array.
     * @return array of int values, contained by the given integer vector.
     */
    private int[] convertVectorToArray(Vector<Integer> vector){
        int[] array = new int[vector.size()];
        for (int i=0; i<array.length; i++){
            array[i] = vector.get(i);
        }
        return array;
    }

    /**
     * Add method for the sort algorithms, later used to sort arrays.
     * @param sort algorithm to add to be used to calculate.
     */
    public void addSorter(SortierIF sort){
        sorter.add(sort);
    }

    /**
     * Main Method, runs the manager, does else nothing.
     * @param args additional arguments, but unused
     */
    public static void main(String[] args) {
        Manager manager = new Manager();
        //Add sorter algorithms
        //manager.addSorter(sorter);
        manager.run();
    }
}