import java.io.File;
import java.util.Vector;

/**
 * @since 12.01.2022
 * @author Kevin Stupar
 * @version 0.1
 * Class used to Export Data ordered in a cvs file, ready to import into excel.
 */
public class DataExport {
    private final Vector<Data> data = new Vector<>();
    String[] fileSources = new File(new File("").getAbsolutePath()+"/files").list();

    public DataExport() {
        for (int i=0; i< fileSources.length; i++){
            fileSources[i].replace(".dat", "");
        }
    }

    public void addData(Data data){
        this.data.add(data);
    }

    public void sortData(){
        data.sort(Data::compareTo);
    }

    public void generateFiletext(){
        String text = "";

        text+="CountCompare";
        for (String fileSource : fileSources){
            text+=","+fileSource;
        }
        text+="\n";
        for (int i=0; i<fileSources.length; i++){
            text += Data.getType(data.get((i * fileSources.length)).getSortType());
            for (int j=0; j< data.size()/ fileSources.length; j++){
                text += ","+data.get((i * fileSources.length + j)).getCountCompare();

            }
        }
    }
}
