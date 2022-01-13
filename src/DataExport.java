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
        String text = "";
        String[] dataType = {"Time(Nanoseconds)", "Writes", "Compares", "Space"};

        for (int a = 0; a < 4; a++) {
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
                        case 0 -> text += data.get((j * fileSources.length + i)).getNanoTime();
                        case 1 -> text += data.get((j * fileSources.length + i)).getCountWrite();
                        case 2 -> text += data.get((j * fileSources.length + i)).getCountCompare();
                        case 3 -> text += data.get((j * fileSources.length + i)).getStorageSpace();
                    }

                }
                text += "\n";
            }
        }
        try {
            FileWriter writer = new FileWriter(new File("").getAbsolutePath()+"\\solutions.csv");
            writer.write(text);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
