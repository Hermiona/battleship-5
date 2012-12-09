/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 *
 * @author truong
 * this is to display the image of ship
 */
public class ShipLabel extends JLabel{

    private int shipType;
    private BufferedImage backgroundImage;
    
    public ShipLabel(int shipType) {
        this.shipType = shipType +1;
        this.setPreferredSize(new Dimension(250, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            backgroundImage = ImageIO.read(new File("images/right"+shipType+".png"));
            g.drawImage(backgroundImage, 0, 0, this.getWidth(),this.getHeight(), null);
        } catch (IOException ex) {
            Logger.getLogger(ShipLabel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
