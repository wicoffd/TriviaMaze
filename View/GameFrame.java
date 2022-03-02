package View;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    JFrame frame = new JFrame("Test");
    private void displayGameFrame(){
        frame.setVisible(true);
        frame.setLayout(new GridLayout());
        frame.setSize(1080,960);
        JPanel mainPanel = new JPanel();
        JTextField text = new JTextField(45);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(text);
        //frame.add(text);
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.displayGameFrame();
    }
}
