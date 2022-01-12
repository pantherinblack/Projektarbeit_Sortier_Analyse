import java.io.*;
import java.util.Vector;

public class Manager {
    public String[] fileSources = new File(new File("").getAbsolutePath()+"/files").list();
    private final SortierIF[] sorter = {};
    private final Vector<Data> data = new Vector<>();

    public Manager() {
        for (int i=0; i<fileSources.length; i++){
            fileSources[i] = new File("").getAbsolutePath()+"\\files\\"+fileSources[i];
            int[] array = {};
            try {
                array = convertVectorToArray(readFile(fileSources[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            runSorters(array);
        }
    }

    public void runSorters(int[] array){
        for (SortierIF sort : sorter){
            sort.sort(array);
            data.add(sort.getData());
        }
    }

    public Vector<Integer> readFile(String fileSource) throws IOException {
        Vector<Integer> vector = new Vector<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileSource));
        vector.add(Integer.parseInt(reader.readLine()));
        return vector;
    }

    public int[] convertVectorToArray(Vector<Integer> vector){
        int[] array = new int[vector.size()];
        for (int i=0; i<array.length; i++){
            array[i] = vector.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
    }
}