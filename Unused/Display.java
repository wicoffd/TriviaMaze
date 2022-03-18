package Unused;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Display extends JFrame{
    /**
     * A display method to with colors and graphics
     *
     * @author Derek Wicoff
     * @version Winter 2022 */
    // action listeners should go in the model package.
    private final int width = 1900;
    private final int height = 900;
    private final int unit  = 64;
    private Timer timer;
    private boolean running;
    private final int gameUnits = (width+height)/unit;
    private JPanel mainPanel =new JPanel();
    private Graphics2D g;
    private JFrame displayFrame = new JFrame("Sphinx Riddle Maze");
    private int[][] maze =
            {{0,1,0,0,0,0,0}, // 0  = wall  1 = open space
            {0,1,0,1,1,1,0},
            {0,1,0,1,0,1,0},
            {0,1,1,1,1,1,2}};
    private ActionListener menuActionListener;

    public Display() {
        Dimension d = new Dimension(width,height);
        displayFrame.setLayout(new BorderLayout());
        displayFrame.setPreferredSize(d);
        displayFrame.setSize(d);
        displayFrame.setBackground(Color.DARK_GRAY);
//
        running = true;
        displayFrame.setResizable(true);
        displayFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainPanelAddComponents(displayFrame);
        displayFrame.add(mainPanel, BorderLayout.NORTH);
        displayFrame.setVisible(true);

    }

    private void mainPanelAddComponents(JFrame mainPanel) {
        /** */

        JPanel displayPanel = new JPanel(); // displayPanel is being used as the display
        displayPanel.setSize(new Dimension(width,height-100)); // 100 is a temp for component height
        displayPanel.setLayout(new BorderLayout());
        //displayPanel.setBackground(Color.BLACK);
        mainPanel.paintComponents(g);
        //paintComponents(g);
        displayPanel.setVisible(false);
        //displayPanel.add(getDisplayComponents(displayPanel));
        JPanel buttonPanel = getButtonPanel();
        mainPanel.add(displayPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        JFrame newFrame = new JFrame();
        addMenuItems();
        /*//paint(g);
        newFrame.paint(g);
        newFrame.setVisible(true);
        newFrame.setSize(new Dimension (900,900));*/
        //mainPanel.paint(g);
        //newFrame.setSize(new Dimension (maze[0].length * gameUnits, maze[0].length * gameUnits));
    }

   /* private Component getDisplayComponents(JPanel panel) {
        
    }*/

    private JPanel getButtonPanel() {
        JTextField textField = new JTextField(45);
        textField.setSize(new Dimension(45,2));
        textField.setVisible(true);
        textField.setText("test");
        //textField.getText();  // used to get text from the textfield
        JButton button = new JButton();
        button.setText("Enter");
        button.setSize(15,2);
        button.addActionListener(getTextActionListener(textField));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setSize(new Dimension(width,height-50));
        buttonPanel.add(textField, BorderLayout.WEST);
        buttonPanel.add(button, BorderLayout.EAST);
        return buttonPanel;
    }

    private ActionListener getTextActionListener(JTextField textField) { // put in model
        String t = textField.getText(); // t for temp string variable
        stringInterpreter(t);
        return e -> textField.setText(""); // ActionListener e
    }

    private void stringInterpreter(String t) {
        /** Interprets the users input into the text box and sends 
         * the information to the right place*/
    }
    public static void main(String[] args) {
        Display display = new Display();
        ///display.
    }
    public void paintComponents(Graphics2D g) {
        //super.paintComponents(g);
        //super.paint(g);
        Color color;
        for (int y = 0; y < maze.length; y++) { // for length of maze
            for (int x = 0; x < maze[0].length; x++) { // for length of column
                switch (maze[y][x]) {

                    case 0:
                        color = Color.BLACK;
                        break;
                    case 1:
                        color = Color.LIGHT_GRAY;
                        break;
                    case 2:
                        color = Color.YELLOW;
                        break;
                    default:
                        color = Color.magenta;
                        // do not break
                }

                g.setColor(Color.BLACK); // outline
                g.drawRect(gameUnits * y, gameUnits * x, gameUnits, gameUnits);
                g.setColor(color);
                g.fillRect(gameUnits * y, gameUnits * x, gameUnits, gameUnits);


            }
        }
    }
    private void addMenuItems() {
        JMenu menu;
        JMenuBar menuBar;
        menuBar = new JMenuBar();
        menu = new JMenu("Options");
        JMenuItem settings, save, load, exit;
        settings = new JMenuItem("Settings");
        save = new JMenuItem("Save");
        load = new JMenuItem("Load");
        exit = new JMenuItem("Exit");
        settings.addActionListener(menuActionListener);
        save.addActionListener(menuActionListener);
        load.addActionListener(menuActionListener);
        exit.addActionListener(menuActionListener);
        //Create an override for action listener for the menu bar
        menu.add(save);
        menu.add(settings);
        menu.add(load);
        menu.add(exit);
        menuBar.add(menu);
        displayFrame.setJMenuBar(menuBar);
    }



}
