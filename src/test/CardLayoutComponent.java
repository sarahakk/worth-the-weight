/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.awt.*;
import javax.swing.*;

/**
 * abstract class that give the card layout of the main panel to the components
 * that are added to it. So the components can add new components to the main panel
 * and switch the view to any component in the card layout list.
 * 
 * @author Eric Sullivan
 */
public abstract class CardLayoutComponent extends JPanel {

    JFrame frame;
    MainPanel main;
    
    public CardLayoutComponent(JFrame frame,MainPanel main){
        this.frame = frame;
        this.main = main;
    }
    // recreate the frame if a new component is added that is not in the CardLayout.
    public void reFrame(){
        frame.revalidate();
        frame.pack();
    }
    /*
    The Methods for controlling the CardLayout in the MainPanel object.
    */
    // <editor-fold defaultstate="collapsed" desc="Layout Code"> 
    /**
     * Changes view of main to a indicated n.
     * @param n 
     */
    public void SwitchTo(String n){
        main.getLayout().show(main, n);
    }
    /**
     * Changes view to the next component in the CardLayout list.
     */
    public void next(){
        main.getLayout().next(main);
    }
    /**
     * Changes view to the previous component in the CardLayout list.
     */
    public void prev(){
        main.getLayout().previous(main);
    }
    /**
     * Adds a new Component c to the CardLayout with name n.
     * @param c
     * @param n 
     */
    public void addCard(Component c , String n){
        main.add(c,n);
    }
    /**
     * Removes the Component c for the CardLayout list.
     * @param c 
     */
    public void RemoveCard(Component c){
        main.remove(c);
    }
    /**
     * Changes view to the first component in the CardLayout.
     */
    public void first(){
        main.getLayout().first(main);
    }
    /**
     * Changes view to the last component in the CardLayout.
     */
    public void last(){
        main.getLayout().last(main);
    }
    // </editor-fold>
    /**
     * Returns the JFrame. (might not be used)
     * @return JFrame
     */
    public JFrame getFrame(){
        return frame;
    }
    /**
     * Returns the MainPanel. (might not be used)
     * @return 
     */
    public JPanel getMain(){
        return this;
    }
}
