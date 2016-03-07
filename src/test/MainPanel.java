/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.awt.*;
import javax.swing.*;

/**
 * This is where all the view component are contained (EX: login page or WeeklyViewPanel)
 * Anything add must be a CardLayoutComponent Object.
 * 
 * @author Eric Sullivan
 */
public class MainPanel extends JPanel{
    private CardLayout layout; 
    private JFrame frame;
    /**
     * Initializes this JPanel and add the Card Layout
     * Card Layout also the JPanel to switch from JPanel to JPanel easily
     * @param frame 
     */
    public MainPanel(JFrame frame){
        this.frame=frame;
        layout = new CardLayout();
        setLayout(layout);
        setPreferredSize(new Dimension(1000,800));
        testInit();
    }
    /**
     * override of JPanel's getLayout to make it return the
     * proper Manager type. (To eliminate Casting later)
     * @return CardLayout
     */
    @Override
    public CardLayout getLayout(){
        return layout;
    }
    /**
     * TODO
     * this method should add the first component that the users will see when starting
     * the program normally the Login JPanel
     */
    public void init(){
        //Add Login page to add layout
    }
    public void testInit(){
        new WeeklyViewPanel(frame,this);
    }

}
