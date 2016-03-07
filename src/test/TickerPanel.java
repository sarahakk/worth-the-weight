/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Eric Sullivan
 */
public class TickerPanel extends JPanel{
    private String label;
    private JFrame frame;
    private int scrollX;
    
    public TickerPanel(JFrame frame){
        getLabel();
        Timer timer = new Timer(20,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });timer.start();
    } 
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Arial",Font.PLAIN,20));
        g.drawString(label, 0, frame.getContentPane().getWidth()-(scrollX--));
        if(-(scrollX)>=frame.getContentPane().getWidth()){
            scrollX=0;
        }
        
    }

    private void getLabel() {
        label = ("abcdefghijklmnopqrstuvwxyz");
    }
    
    public static void main(String[] args){
        JFrame f = new JFrame("Test");
        JPanel p = new JPanel();
        p.add(new TickerPanel(f));
        f.setSize(new Dimension(200,100));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
    }
}
