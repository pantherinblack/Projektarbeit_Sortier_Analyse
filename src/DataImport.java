import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class DataImport {
    public String[] getFileSources(){
        String[] fileSources = new File(new File("").getAbsolutePath()+"/files").list();
        for (int i=0; i<fileSources.length; i++){
            fileSources[i] = new File("").getAbsolutePath()+"\\files\\"+fileSources[i];
        }
        return fileSources;
    }

    /**
     * Reads File, sores all int values in a vector and returns it.
     * @param fileSource Path to file to read int values from
     * @return vector, containing an array
     * @throws IOException
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
