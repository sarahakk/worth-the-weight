/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Eric Sullivan
 */
    public class TopPanel extends JPanel { //TopPanel Start
        JPanel left, right;
        JLabel rightLabel, leftLabel;
        int pX,pY;
        JFrame frame;
        
        public TopPanel(JFrame fram){
            this.frame = fram;
            right = new JPanel();
            left = new JPanel();
            // adds flow layout so labels will be in the right places
            left.setLayout(new FlowLayout(FlowLayout.LEFT));
            right.setLayout(new FlowLayout(FlowLayout.RIGHT));
            left.setBackground(Color.WHITE);
            right.setBackground(Color.WHITE);
            // init labels
            leftLabel = new JLabel("Program Title");
            leftLabel.setFont(new Font("Arial",Font.PLAIN,20));
            rightLabel = new JLabel("X");
            rightLabel.setFont(new Font("Arial",Font.PLAIN,20));
            // Grid layout to get panels side by side
            setLayout(new GridLayout(1,2));
            // add labels to approperate containers
            left.add(leftLabel);
            right.add(rightLabel);
            // add left and right panels to TopPanel
            add(left);
            add(right);
            
            // Listener for the X label to close the program
            rightLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    System.exit(0);
                }
            });
            // listeners that allow the user to drag and move the window
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) { //On click gets the current location
                    // Get x,y and store them
                    pX = me.getX();
                    pY = me.getY();

                }

                @Override
                 public void mouseDragged(MouseEvent me) { // moves the window when the TopPanel is dragged

                    frame.setLocation(frame.getLocation().x + me.getX() - pX,
                            frame.getLocation().y + me.getY() - pY);
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() { // moves the window when the TopPanel is dragged
                @Override
                public void mouseDragged(MouseEvent me) {

                    frame.setLocation(frame.getLocation().x + me.getX() - pX,
                            frame.getLocation().y + me.getY() - pY);
                }
            });
        }
    }