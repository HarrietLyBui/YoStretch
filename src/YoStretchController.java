import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * YoStretchController reads in 3 CSV files of three different yoga level.
 * Each file contains yoga name, instruction and image path.
 * YoStretchController creates three linked lists for yogaPose objects,
 * insert information from csv file into yogaPose object
 */
public class YoStretchController {

    //linked list to holds yogaPose object
    protected LinkedList<YogaPose> linkedListBeginner;
    protected LinkedList<YogaPose> linkedListIntermediate;
    protected LinkedList<YogaPose> linkedListAdvanced;


    /**
     * Constructor initializing linked lists and open files
     */
    public YoStretchController(){

        //initialize three linked lists for different yoga level
        linkedListBeginner = new LinkedList();
        linkedListIntermediate = new LinkedList();
        linkedListAdvanced = new LinkedList();

        //read in csv file to get yoga name, descripion and image path
        openFile("YogaDataBeginning.csv", linkedListBeginner);
        openFile("YogaDataIntermediate.csv", linkedListIntermediate);
        openFile("YogaDataAdvanced.csv", linkedListAdvanced);


    }




    /**
     * read from dictionary.txt and input the word into a List
     * generate a random word from the list as hidden word by creating random number
     */
    public void openFile(String fileName, LinkedList<YogaPose> linkedList) {

        /**
         * try read in fileName, insert yoga name, description and image path into yogaPose object, than insert them
         * into linkedlist
         */
        try {
            //csv file containing data
            //create new file
            File fileCSV = new File(fileName);
            // get the path to the file
            String fileNamePathCSV = fileCSV.getAbsolutePath();
            //reader reads csv file
            CSVReader reader = new CSVReader(new FileReader(fileNamePathCSV), ',', '"', '|');

            //lists to hold yogaName
            List<String> yogaNameList = new ArrayList<>();
            //lists to hold yogaDescription
            List<String> yogaDescriptionList = new ArrayList<>();
            //lists to hold image path
            List<String> yogaImagePath = new ArrayList<>();

            //ignore header in csv file
            String[] yogaDetail = reader.readNext();

                //read in column 0,1 and 2 in csv file
                while ((yogaDetail = reader.readNext()) != null) {
                    //add information into appropriate list
                    yogaNameList.add(yogaDetail[0]);
                    yogaDescriptionList.add(yogaDetail[1]);
                    yogaImagePath.add(yogaDetail[2]);


            }

            for (int i=0; i<yogaNameList.size(); i++) {
                //add yogaName, yogaDescription and yogaImagePath into yogaPose object
                YogaPose yogaPose = new YogaPose(yogaNameList.get(i), yogaDescriptionList.get(i), yogaImagePath.get(i));
                //insert them yogaPose object into linnkedList
                linkedList.insertFirst(yogaPose);

            }





        }
        //if file not found, print error message
            catch (IOException | SecurityException e){

                System.out.println("problem reading the file");
            }


    }



}
