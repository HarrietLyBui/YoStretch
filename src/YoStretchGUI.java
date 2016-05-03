
// awt

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//swing
import javax.swing.*;


//io

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * YogaStretchGUI create and organize beginning, intermediate, and advanced yoga level buttons,
 * create timer, select randoms 4 yoga poses and display them,
 * create buttons to display yoga name and image, display yoga instruction text and image if one of these buttons are clicked
 */
public class YoStretchGUI extends JComponent implements ActionListener{



        // create new instance of slideController object
        private YoStretchController yoStretchController = new YoStretchController();
        //temporary node to get yogaPose object
        private  LinkedListNode<YogaPose> temp;

         // variable to keep time
        private Integer timeKeeper = 0;

        // textLabel JLabel displays yoga Name
        private JLabel yogaNameLabel = new JLabel("");
        private JLabel yogaInstructionLabel = new JLabel("");
        // display current time
        private JLabel timeStatusLabel = new JLabel( "Timer: " + new Integer (timeKeeper
                / 1000).toString());

        // create buttons for different yoga levels
        private JButton yogaPoseButton = new JButton("");
        private JButton beginningButton = new JButton("Beginning level");
        private JButton intermediateButton = new JButton("Intermediate level");
        private JButton advanceButton = new JButton("Advanced level");

        //panel to display random yoga pose
        private JPanel yogaPosePanel = new JPanel();

        // set font for label
        private Font font = new Font("GT Walsheim", Font.BOLD, 20);
        private Font fontYogaName = new Font("GT Walsheim", Font.PLAIN, 18); //font for yogaName
        private Font fontInstruction = new Font("GT Walsheim", Font.PLAIN, 16); //font for yogaInstruction

        //yoga instruction text
        private String yogaInstruction ="";
        //yoga image
        private ImageIcon icon;
        //JTextArea to holds yogaInstruction text
        private JTextArea yogaInstructionText = new JTextArea();
        //layout constraint
        GridBagConstraints c = new GridBagConstraints();

        private int YOGAPOSENUM = 4;


    /**
         * constructor that align texts, set color for texts and backgrounds tell
         * buttons to listen to mouseclick
         */
        public YoStretchGUI() {

            super();

            //initialize a new node
            temp = new LinkedListNode<>();

            temp = yoStretchController.linkedListAdvanced.getFirstNode();
            while (temp!=null){
                System.out.println("image path: " + temp.getData().getYogaImagePath());

               ImageIcon icon = new ImageIcon(this.getClass().getResource(temp.getData().getYogaImagePath()), "star");
                temp = temp.getNext();
            }

            //create timer
            createTimer();
            //center yoga pose images
            c.fill = GridBagConstraints.HORIZONTAL;

            //align texts in timeStatusLabel
            timeStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
            timeStatusLabel.setVerticalAlignment(SwingConstants.CENTER);

            //align instruction text from left to right
            yogaInstructionText.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            //align instruction imag from right to left
            yogaInstructionLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

            yogaInstructionText.setBackground(null); //set background
            yogaInstructionText.setLineWrap(true); //wrap texts
            yogaInstructionText.setWrapStyleWord(true); //wrap texts
            yogaInstructionText.setFont(fontInstruction); //set font


            // align texts to the center
            beginningButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            intermediateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            advanceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            yogaPoseButton.setAlignmentX(Component.CENTER_ALIGNMENT);


            //set font
            beginningButton.setFont(font);
            intermediateButton.setFont(font);
            advanceButton.setFont(font);
            timeStatusLabel.setFont(font);
            yogaNameLabel.setFont(font);
            yogaInstructionLabel.setFont(font);

            // set color
            timeStatusLabel.setForeground(new Color(255, 255, 255));
            timeStatusLabel.setBackground(new Color(1, 63, 88));
            timeStatusLabel.setOpaque(true);

            // overlap text ontop of picture
            yogaNameLabel.setHorizontalTextPosition(JLabel.CENTER);

            // set color for text
            yogaNameLabel.setForeground(new Color(204, 255, 255, 0x80));



            // add ActionListener
            beginningButton.addActionListener(this);
            intermediateButton.addActionListener(this);
            advanceButton.addActionListener(this);
            yogaPoseButton.addActionListener(this);

            //organize layout of buttons, input boxes, labels and pictures
            initPanel();

        }

        /**
         * method to set layout for the main JPanel, add buttons and set colors
         */
        public void initPanel() {
            //set background
            this.setBackground(Color.white);
            // set new Layout
            this.setLayout(new BorderLayout());
            add(timeStatusLabel, BorderLayout.WEST);
            // add top panel to display input boxes and add time and text button
            add(levelButtons(), BorderLayout.NORTH );
            // add JPanel that has slideshow texts
            add(yogaPosePanel, BorderLayout.CENTER);
            // add timeStatusLabel to the main JPanel
            add(instruction(), BorderLayout.SOUTH);
            // set focus for the main JPanel
            setFocusable(true);

        }

    /**
     * Method to organize yoga instruction image and text
     * @return
     */
    public JPanel instruction(){
            //create new layout
            GridLayout layout = new GridLayout(1,2);
            //create new JPanel
            JPanel instructionPanel = new JPanel();
            //set gap between image and text
            layout.setVgap(30);
            layout.setHgap(30);
            //set new layout
            instructionPanel.setLayout(layout);
            //add image to panel
            instructionPanel.add(yogaInstructionLabel, c);
            //add text to panel
            instructionPanel.add(yogaInstructionText, c);


            return instructionPanel;

        }


    /**
     * Method to organize different level buttons and timers
     * @return
     */
    public JPanel levelButtons(){
            //JPanel for beginning, intermediate, and advanced button
            JPanel level = new JPanel();
            //JPanel for the level panel and timerStatusLabel
            JPanel levelButtonPanel = new JPanel();
            //set layout for levelButtonPanel
            levelButtonPanel.setLayout(new GridLayout(2,1));
            //add timeStatusLabel
            levelButtonPanel.add(timeStatusLabel);
            //add level
            levelButtonPanel.add(level);
            //set new layout
            level.setLayout(new GridLayout(1,3));
            // add top panel to display input boxes and add time and text button
            level.add(beginningButton);
            // add JPanel that has slideshow texts
            level.add(intermediateButton);
            // add timeStatusLabel to the main JPanel
            level. add(advanceButton);
            // set focus for the main JPanel
            setFocusable(true);

            return levelButtonPanel;
        }


    /**
     * Choose 4 random yoga pose from linkedlist
     * @param linkedList
     */
    public void getRandomPose(LinkedList<YogaPose> linkedList){
        //variable for random number
        int randomNumb;
        //create a new Random object
        Random randomno = new Random();
        // generate a number in the range of 0 to list size
        randomNumb = randomno.nextInt(linkedList.size());
        //avoid null pointer exception if the yoga poses picked are at the end of the linkedlist
        if (randomNumb>linkedList.size()-YOGAPOSENUM){
            randomNumb = randomNumb-YOGAPOSENUM;
        }

        System.out.println("linkedList" + linkedList.size());
        System.out.println("random" + randomNumb);

        int i = 0;
        //get the first node of the linkedlist
        temp = linkedList.getFirstNode();
        //pick the node at index randomNumb
        while (i<randomNumb) {
            temp = temp.getNext();
            i++;
        }

    }
    /**
     * create time to display texts according to the time (in seconds) user assign
     */
    public void createTimer() {
        // create new timer
        Timer timer = new Timer();
        // set timer schedule
        timer.schedule(

                // set new timer task
                new TimerTask() {

                    public void run() {
                        //update time
                        timeStatusLabel.setText( "Timer: " + new Integer (timeKeeper/1000).toString());
                        //display THE END at the end of the slide show
                        if (timeKeeper == 60000)
                            //set text annoucement for yoga
                            timeStatusLabel.setText("TIME FOR YOGA");

                        else{
                                timeKeeper += 1000;
                                //advance time
                                createTimer();

                            }

                        }

                },

                // advance time every one second
                1000);

    }



        /**
         * if the buttons get clicked
         */
        public void actionPerformed(ActionEvent e) {

            // i  f beginningButton button got clicked
            if (e.getSource() == beginningButton) {
                //refresh JPanel
                yogaPosePanel.removeAll();
                //get random yogaPose
                getRandomPose(yoStretchController.linkedListBeginner);
                //display poses
                displayYogaPose(yoStretchController.linkedListBeginner.getFirstNode());
                System.out.println("temp node " + temp.getData().getYogaName());


            }


            // if intermediateButton button got clicked
            if (e.getSource() == intermediateButton) {
                //refresh JPanel
                yogaPosePanel.removeAll();
                //get random yogaPose
                getRandomPose(yoStretchController.linkedListIntermediate);
                //display poses
                displayYogaPose(yoStretchController.linkedListIntermediate.getFirstNode());


            }

            // if advanceButton button got clicked
            if (e.getSource() == advanceButton) {
                //refresh JPanel
                yogaPosePanel.removeAll();
                //get random yogaPose
                getRandomPose(yoStretchController.linkedListAdvanced);
                //display poses
                displayYogaPose(yoStretchController.linkedListAdvanced.getFirstNode());


            }
        }

    /**
     * Get 5 different yoga poses, display yoga name and corresponding image to a JButton
     * If the button displaying a certain yoga pose get clicked, the instruction image and texts for that pose apprears
     * @param node
     */

    public void displayYogaPose(LinkedListNode<YogaPose> node) {
            //numb variable to count the number of yoga poses displayed
            int numb = 0;
            //if the poses is smaller than 5
            while (numb != YOGAPOSENUM) {
                //create new button
                yogaPoseButton = new JButton("<html>" + yogaInstruction.replaceAll("\\n", "<br>") + "</html>");
                //add ActionListener to that button
                yogaPoseButton.addActionListener(new ActionListener() {


                    //add actionListener to yoga pose buttons
                    public void actionPerformed(ActionEvent e) {
                        //get the name displayed on the button
                        String namePose = ((JButton) e.getSource()).getText();
                        //temporary node moving along the linkedlist
                        LinkedListNode<YogaPose> temp2 = node;

                        //get the instruction of the yoga pose and yoga image selected
                        while (temp2 != null) {
                            System.out.println("button");

                            //find the node containing the right instruction
                            if (namePose == temp2.getData().getYogaName()) {
                                //get yoga instruction
                                yogaInstruction = temp2.getData().getYogaInstruction();
                                //get image of the instruction and scale the image
                                icon = new ImageIcon(this.getClass().getResource(temp2.getData().getYogaImagePath()), "star");
                                Image image = icon.getImage(); // transform it
                                Image newimg = image.getScaledInstance(450, 450,
                                        java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                                icon = new ImageIcon(newimg); // transform it back
                                break;
                            }
                            //get the next node in the linkedlist
                            temp2 = temp2.getNext();


                        }
                        //display yoga instruction
                        yogaInstructionText.setText(yogaInstruction);
                        //display image
                        yogaInstructionLabel.setIcon(icon);



                    }
                });

                //set text
                yogaPoseButton.setText(temp.getData().getYogaName());
                //set font
                yogaPoseButton.setFont(fontYogaName);

                // create an ImageIcon variable and store the picture in the variable
                ImageIcon icon = new ImageIcon(this.getClass().getResource(temp.getData().getYogaImagePath()), "star");
                Image image = icon.getImage(); // transform it
                Image newimg = image.getScaledInstance(200, 200,
                        java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                icon = new ImageIcon(newimg); // transform it back
                yogaPoseButton.setIcon(icon);
                // to remote the spacing between the image and button's borders
                yogaPoseButton.setMargin(new Insets(0, 0, 0, 0));
                //set text position on button
                yogaPoseButton.setVerticalTextPosition(SwingConstants.BOTTOM);
                yogaPoseButton.setHorizontalTextPosition(SwingConstants.CENTER);

                //add buttons to yogaPosePanel
                yogaPosePanel.add(yogaPoseButton, c);
                yogaPosePanel.validate();
                yogaPosePanel.repaint();

                //add the next yoga pose
                numb++;
                temp = temp.getNext();


            }
        }



}
