import java.io.*;
import java.util.Vector;

/**
 * This class manages all data import, export, calculations and Executes them with the run() method.
 * @since 12.01.2022
 * @author Kevin Stupar
 * @version 1.3
 */
public class Manager {

    /**
     * Sores the source to all files.
     */
    private final String[] fileSources;

    /**
     * Stores sorters for later execution.
     */
    private final Vector<SortIF> sorter = new Vector<>();

    /**
     * Object used to export data.
     */
    private final DataExport dataExport = new DataExport();

    /**
     * Object used to import data.
     */
    private final DataImport dataImport = new DataImport();

    /**
     * value for showing the completion in %
     */
    private double complete=0;

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
            runSorters(array);
        }
        System.out.println("\r100.00%");
        System.out.println("Generating Solutions finished, generating files.");
        dataExport.generateFiletext();
    }

    /**
     * Runs all sort algorithms on the before given sorter objects.
     * @param array containing the array to sort.
     */
    private void runSorters(int[] array){
        for (int i=0; i< sorter.size(); i++){
            System.out.print("\r"+(Math.round(complete*100.0))/100.0+"%");
            sorter.get(i).sort(array.clone());
            complete+=100.0/sorter.size()/ fileSources.length;
            dataExport.addData(sorter.get(i).getData());
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
    public void addSorter(SortIF sort){
        sorter.add(sort);
    }

    /**
     * Main Method, runs the manager, does nothing else.
     * @param args additional arguments, but unused.
     */
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addSorter(new QuickSort());
        manager.addSorter(new CocktailSort());
        manager.run();

    }
}