/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 * Day Panel.
 * panel that contains the work prescription for the day and any additional info of that exersize
 * @author Eric Sullivan
 */
    public class DayPanel extends JPanel{
        private JLabel dayName, date, ex1, ex2, ex3, ex1Icon, ex2Icon, ex3Icon;
        private JPanel north, northLeft, northRight, center;
        
        /**
         * Constructor 
         * Takes the day of the month and builds a panel with the right color and labels
         * @param dom
         * @param month
         * @param dow 
         */
        public DayPanel(int dom, int month, int dow){
            setBorder(new LineBorder(Color.WHITE,1));
            setLayout(new BorderLayout());
            north = new JPanel(new GridLayout(1,2));
            
            center = new JPanel(new GridLayout(3,1));
            
            northLeft = new JPanel(new FlowLayout(FlowLayout.CENTER));
            switch(dow){ // sets the day and Color of the panel by the day of the month
                case 1:
                    setDay("Sunday",new Color(255,99,71));
                    break;
                case 2:
                    setDay("Monday",new Color(255,215,0));
                    break;
                case 3:
                    setDay("Tuesday",new Color(255,182,193));
                    break;
                case 4:
                    setDay("Wednesday",new Color(144,238,144));
                    break;
                case 5:
                    setDay("Thursday",Color.ORANGE);
                    break;
                case 6:
                    setDay("Friday",new Color(173,216,230));
                    break;
                case 7:
                    setDay("Saturday",new Color(238,130,238));
                    break;
                default:
                    dayName = new JLabel("Unday");
                    break;
            }
            //add to container
            northLeft.add(dayName);
            north.add(northLeft);
            add(north,BorderLayout.NORTH);
            add(center,BorderLayout.CENTER);
        }
        /**
         * set the labels and color of the JPanel
         * and uses decoration
         * @param name
         * @param c 
         */
            private void setDay(String name, Color c){
                
                dayName = new JLabel(name);
                dayName.setFont(new Font("Arial",Font.PLAIN,20));
                dayName.setBackground(c);
                north.setBackground(c);
                north.setBorder(new MatteBorder(0,0,2,0,Color.BLACK));
                northLeft.setBackground(c);
                center.setBackground(c);
                getPrescription(); // 
                setBackground(c);
            
            
        }
            /**
             * CURRENT: test mode
             * TODO: connects to the DB to get a users prescription
             */
        private void getPrescription() {
            for(int i=0;i<3;i++){
                Image icon = getScaledImage(new ImageIcon("run.png").getImage(),25,25);
                ex1 = new JLabel("Run",new ImageIcon(icon),JLabel.LEFT);
                ex1.setFont(new Font("Arial",Font.PLAIN,20));
                ex1.setBorder(new EmptyBorder(0,0,50,0));
                center.add(ex1);
            }
        }
        /**
         * Rescales a image to the give w (width) and h(Height)
         * @param srcImg
         * @param w
         * @param h
         * @return 
         */
        private Image getScaledImage(Image srcImg, int w, int h) {
            BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = resizedImg.createGraphics();

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(srcImg, 0, 0, w, h, null);
            g2.dispose();

            return resizedImg;
        }

    }