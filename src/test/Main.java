/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.LineBorder;

/**
 * Fitness Gui Prototype. that shows a weekly calender and has space for more components
 * use of futuristic theme.
 * @author Eric Sullivan
 */
public class Main{
    
    ArrayList<JPanel> days; //Holds the week days
    JPanel weekPanel; // Container for day panels
    JPanel titleMenuPanel; // title and menu container
    JPanel south; //Empty
    JFrame frame = new JFrame();
    JPanel out;
    final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final Dimension minScreenSize = new Dimension(1000,600);
    
    
    /**
     * Inner class that build the window border and top decoration for the frame
     */

    public class DecorationPanel extends JPanel {
        public DecorationPanel() {
            setLayout(new BorderLayout());
            add(new TopPanel(frame), BorderLayout.PAGE_START); // put the top decoration onto the top of the frame
            add(new MainPanel(frame), BorderLayout.CENTER);
            setBorder(new LineBorder(Color.BLACK, 1));
        }

    }
    /**
     * Creates the GUI interface and gives the frame resizability
     */
    public void createAndShowGui() {
        ComponentResizer cr = new ComponentResizer(); // object that gives the frame resizability
        cr.setSnapSize(new Dimension(10,10)); // Edge resize space
        cr.setMaximumSize(screenSize); // largest size for the window
        cr.setMinimumSize(minScreenSize); // smallest size for the window
        cr.registerComponent(frame);
        frame.setUndecorated(true);
        frame.add(new DecorationPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main().createAndShowGui();
            }
        });
      
    }



}
