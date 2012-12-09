/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author truong
 */
public class ScreenDisplay {
    
    
    public static Point getDisplayLocation(JFrame frame){
        Point displayPoint;
        int x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2 - frame.getWidth()/2);
        int y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2 - frame.getHeight()/2);
        displayPoint = new Point(x, y);
        return displayPoint;
    }
}
