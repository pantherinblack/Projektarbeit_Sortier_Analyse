import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * Used to export data and convert into a Excel readable format.
 * For managing export, add data with the addData() Method
 * @author Kevin Stupar
 * @version 1.0
 * @since 12.01.2022
 */
public class DataExport {
    /**
     * Contains all data to be sorted and exported.
     */
    private final Vector<Data> data = new Vector<>();

    /**
     * Gets the file-sources for counting arrays and printing them into the output
     */
    String[] fileSources = new File(new File("").getAbsolutePath() + "/files").list();

    /**
     * Constructor, removes the ".dat" ending for the fileSources attribute, for better looks.
     */
    public DataExport() {
        for (int i = 0; i < fileSources.length; i++) {
            fileSources[i] = fileSources[i].replace(".dat", "");
        }
    }

    /**
     * Adds data to be used later on.
     * @param data to add to be used
     */
    public void addData(Data data) {
        this.data.add(data);
    }

    /**
     * Generates multiple Strings and exports them using the "exportFile" method.
     */
    public void generateFiletext() {
        StringBuilder completeText = new StringBuilder();
        String[] dataType = {"Time(Nanoseconds)", "Writes", "Compares", "Space", "Sorted"};

        for (int a = 0; a < 5; a++) {
            StringBuilder text= new StringBuilder();
            text.append(dataType[a]);
            for (int i=0; i< data.size()/ fileSources.length; i++) {
                text.append(",").append(data.get(i * fileSources.length).getSortType());
            }
            text.append("\n");

            for (int i = 0; i < fileSources.length; i++) {
                text.append(fileSources[i]);
                for (int j = 0; j < data.size()/fileSources.length; j++) {
                    text.append(",");
                    switch (a) {
                        case 0 -> text.append(data.get((j + i * data.size() / fileSources.length)).getNanoTime());
                        case 1 -> text.append(data.get((j + i * data.size() / fileSources.length)).getCountWrite());
                        case 2 -> text.append(data.get((j + i * data.size() / fileSources.length)).getCountCompare());
                        case 3 -> text.append(data.get((j + i * data.size() / fileSources.length)).getStorageSpace());
                        case 4 -> text.append(SortChecker.isSorted(data.get((j + i * data.size() / fileSources.length)).getArray()));
                    }

                }
                text.append("\n");
            }
            completeText.append(text);
            exportFile(text.toString(), dataType[a]+"_Solutions.csv");
        }
        exportFile(completeText.toString(), "All_Solutions.csv");
    }

    /**
     * Generates the csv file, and saves it at a preset folder.
     * @param text for use in the file
     * @param fileName for saving the csv file.
     */
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
