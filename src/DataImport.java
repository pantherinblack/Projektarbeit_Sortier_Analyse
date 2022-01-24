import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Vector;

/**
 * Used for managing int arrays, able to read filenames and the array-content of files.
 * @since 12.01.2022
 * @author Kevin Stupar
 * @version 1.0
 */
public class DataImport {
    /**
     * return all file-sources, in the "files" folder of the Project.
     * @return file-sources to Arrays.
     */
    public String[] getFileSources(){
        String[] fileSources = new File(new File("").getAbsolutePath()+"/files").list();
        for (int i = 0; i< Objects.requireNonNull(fileSources).length; i++){
            fileSources[i] = new File("").getAbsolutePath()+"\\files\\"+fileSources[i];
        }
        return fileSources;
    }

    /**
     * Reads a File, converts all int values in a vector and returns it.
     * @param fileSource Path to file to read int values from
     * @return vector, containing Integers
     */
    public Vector<Integer> readFile(String fileSource) throws IOException {
        Vector<Integer> vector = new Vector<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileSource));
        String text="";
        while (text!=null){
             text = reader.readLine();
             if (text!=null){
                 vector.add(Integer.parseInt(text));
             }
        }

        return vector;

    }
}
