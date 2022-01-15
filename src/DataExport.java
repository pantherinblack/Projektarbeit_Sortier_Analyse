import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * @author Kevin Stupar
 * @version 0.1
 * Class used to Export Data ordered in a cvs file, ready to import into excel.
 * @since 12.01.2022
 */
public class DataExport {
    private final Vector<Data> data = new Vector<>();
    String[] fileSources = new File(new File("").getAbsolutePath() + "/files").list();

    public DataExport() {
        for (int i = 0; i < fileSources.length; i++) {
            fileSources[i] = fileSources[i].replace(".dat", "");
        }
    }

    public void addData(Data data) {
        this.data.add(data);
    }

    public void generateFiletext() {
        String completeText = "";
        String[] dataType = {"Time(Nanoseconds)", "Writes", "Compares", "Space", "Sorted"};

        for (int a = 0; a < 5; a++) {
            String text="";
            text += dataType[a];
            for (int i=0; i< data.size()/ fileSources.length; i++) {
                text += "," + Data.getType(data.get(i*fileSources.length).getSortType());
            }
            text += "\n";

            for (int i = 0; i < fileSources.length; i++) {
                text += fileSources[i];
                for (int j = 0; j < data.size()/fileSources.length; j++) {
                    text += ",";
                    switch (a) {
                        case 0 -> text += data.get((j + i * data.size() / fileSources.length)).getNanoTime();
                        case 1 -> text += data.get((j + i * data.size() / fileSources.length)).getCountWrite();
                        case 2 -> text += data.get((j + i * data.size() / fileSources.length)).getCountCompare();
                        case 3 -> text += data.get((j + i * data.size() / fileSources.length)).getStorageSpace();
                        case 4 -> text += SortChecker.isSorted(data.get((j + i * data.size() / fileSources.length)).getArray());
                    }

                }
                text += "\n";
            }
            completeText+=text;
            exportFile(text, dataType[a]+"_Solutions.csv");
        }
        exportFile(completeText, "All_Solutions.csv");
    }

    public void exportFile(String text, String fileName){
        try {
            FileWriter writer = new FileWriter(new File("").getAbsolutePath()+"\\solutions\\"+fileName);
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
