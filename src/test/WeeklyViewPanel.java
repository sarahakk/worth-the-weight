/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Eric Sullivan
 */
public class WeeklyViewPanel extends CardLayoutComponent {

    private GregorianCalendar calendar;
    private ArrayList<DayPanel> week;
    int dom,month,daw;
    public WeeklyViewPanel(JFrame frame, MainPanel main) {
        super(frame,main);
        setBorder(new LineBorder(Color.WHITE,10));
        calendar = new GregorianCalendar();
        dom = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH)+1;
        daw = calendar.get(Calendar.DAY_OF_WEEK);
        week = new ArrayList<>();
        setBackground(Color.WHITE);
        initDays();
        setLayout(new GridLayout(1,7));
        testOnMain();
    }

    public Dimension getPrefferedSize() {
        return new Dimension(800, 1000);
    }

    private void initDays() {
        for (int i = 0; i < 7; i++) {
            week.add(new DayPanel(dom, month, daw));
            add(week.get(i));
            daw = daw % 7+1;
            
        }
        }
// Test adder
    private void testOnMain() {
        this.addCard(this,"Test");
        this.SwitchTo("Test");
    }
}
