/**
 * YogaPose objects allow access and manipulation of yoga Name, corresponding instruction and image path
 */
public class YogaPose implements Comparable<YogaPose>{

    private String yogaName;
    private String yogaInstruction;
    private String yogaImagePath;

    /**
     * Constructor takes in 3 parameter and assign yogaName, yogaInstruction, and yogaImagePath
     */
    public YogaPose(String name, String instruction, String path){

        setYogaName(name);
        setYogaInstruction(instruction);
        setYogaImagePath(path);

    }

    /**
     * set yoga name
     * @param name
     */
    public void setYogaName(String name){

        this.yogaName = name;

    }

    /**
     * set yoga instruction
     * @param instruction
     */
    public void setYogaInstruction(String instruction){
        this.yogaInstruction = instruction;

    }

    /**
     * set yoga image path
     * @param path
     */
    public void setYogaImagePath(String path){

        this.yogaImagePath = path;

    }

    /**
     * get yogaName
     * @return
     */
    public String getYogaName(){
        return yogaName;

    }

    /**
     * get YogaInstruction
     * @return
     */
    public String getYogaInstruction(){
        return yogaInstruction;
    }

    /**
     * get yogaImagePath
     * @return
     */
    public String getYogaImagePath(){

        return yogaImagePath;

    }

    /**
     * Compare yogaName between different yogaPose objects
     * @param otherYogaPose
     * @return
     */

    @Override
    public int compareTo(YogaPose otherYogaPose) {
        //compare name
        int nameDiff = yogaName.compareToIgnoreCase(otherYogaPose.getYogaName());
        if(nameDiff != 0){
            return nameDiff;
        }
        //names are equals compare age
        return nameDiff;
    }

}



