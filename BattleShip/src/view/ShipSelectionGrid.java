/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Ship;

/**
 *
 * @author truong
 */
public class ShipSelectionGrid extends JPanel {

    private PositionLabel[][] lblPosition;
    private Ship[] ships;

    public PositionLabel[][] getLblPosition() {
        return lblPosition;
    }

    public ShipSelectionGrid() {
        //init the panel
        this.setLayout(new GridLayout(10, 10));

        //init the label
        lblPosition = new PositionLabel[10][10];
        for (int i = 0; i < lblPosition.length; i++) {
            for (int j = 0; j < lblPosition[i].length; j++) {
                lblPosition[i][j] = new PositionLabel(i, j);
                this.add(lblPosition[i][j]);
            }
        }
    }

    public void paintShips(Ship[] ships) {
        //every time the user click on the label, call this function to paint the new ship on the grid
        this.ships = ships;
        repaint();
    }

    public Ship[] getShips() {
        return ships;
    }

    public void setShips(Ship[] ships) {
        this.ships = ships;
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            //draw back ground image
            BufferedImage backgroundImage = ImageIO.read(new File("images/space.jpg"));
            g.drawImage(backgroundImage, 0, 0, null);


            //paint the ship image
            BufferedImage shipImage;
            if (ships != null) {
                for (int i = 0; i < ships.length; i++) {
                    shipImage = ImageIO.read(new File("images/right" + ships[i].getShipType() + ".png"));
                    g.drawImage(shipImage, ships[i].getStartCol() * 50, ships[i].getStartRow() * 50, ships[i].getLength() * 50, 50, null);
                    
                }
//                BufferedImage shipImage = ImageIO.read(new File("images/right" + ships[ships.length-1].getShipType() + ".png"));
//                g.drawImage(shipImage, ships[ships.length-1].getStartCol() * 50, ships[ships.length-1].getStartRow() * 50, ships[ships.length-1].getLength() * 50, 50, null);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
