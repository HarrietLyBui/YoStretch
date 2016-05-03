import javax.swing.*;

/**
 * YogaStretchApplication creates JFrame to display and start the program
 */
public class YoStretchApplication {

    /**
     *main method
     */
    public static void main(String[] args) {

        JFrame yoStretchGUI = new JFrame("YoStretch Application"); //create a window frame
        yoStretchGUI.add( new YoStretchGUI());  //instantiate RosterProgramGUI
        yoStretchGUI.setSize(1200,800);  //set size for the window frame
        yoStretchGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close window
        yoStretchGUI.setResizable(false); //set fixed size for the window frame
        yoStretchGUI.setVisible(true); //make window visible

    }
}

