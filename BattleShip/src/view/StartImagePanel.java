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
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author truong
 * just to print an image
 */
public class StartImagePanel extends JPanel{
    
    private BufferedImage backgroundImage;

    public StartImagePanel() {
        try {
            backgroundImage = ImageIO.read(new File("images/start_back.jpg"));
            this.setPreferredSize(new Dimension(backgroundImage.getWidth(), backgroundImage.getHeight()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void paint(Graphics g) {
            super.paint(g);
            g.drawImage(backgroundImage, 0, 0, null);
    }
}
