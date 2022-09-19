
import java.util.EventListener;

import javax.swing.*;
public class UI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(900,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JToggleButton bit15 = new JToggleButton ("15");
        JToggleButton bit14 = new JToggleButton ("14");
        JToggleButton bit13 = new JToggleButton ("13");
        JToggleButton bit12 = new JToggleButton ("12");
        JToggleButton bit11 = new JToggleButton ("11");
        JToggleButton bit10 = new JToggleButton ("10");
        JToggleButton bit9 = new JToggleButton ("9");
        JToggleButton bit8 = new JToggleButton ("8");
        JToggleButton bit7 = new JToggleButton ("7");
        JToggleButton bit6 = new JToggleButton ("6");
        JToggleButton bit5 = new JToggleButton ("5");
        JToggleButton bit4 = new JToggleButton ("4");
        JToggleButton bit3 = new JToggleButton ("3");
        JToggleButton bit2 = new JToggleButton ("2");
        JToggleButton bit1 = new JToggleButton ("1");
        JButton saveButton = new JButton ("Save");
        JTextField saveResult = new JTextField("000000000000000");
        saveResult.setEditable(false);
        
        // saveButton.addActionListener(saveResult);


        panel.add(bit15);
        panel.add(bit14);
        panel.add(bit13);
        panel.add(bit12);
        panel.add(bit11);
        panel.add(bit10);
        panel.add(bit9);
        panel.add(bit8);
        panel.add(bit7);
        panel.add(bit6);
        panel.add(bit5);
        panel.add(bit4);
        panel.add(bit3);
        panel.add(bit2);
        panel.add(bit1);
        panel.add(saveButton);
        panel.add(saveResult);
        
        frame.add(panel);
        frame.setVisible(true);  
    }
}

