/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author truong
 * display all the ship and the select button for selecting in a grid
 */
public class ShipSelectionPanel extends JPanel{

    private ShipLabel[] lblShip; //display the image of the ship
    private ShipSelectButton[] btnShip; //display the select button right next to the ship image
    private ImageIcon backgroundImage;

    public ShipSelectButton[] getBtnShip() {
        return btnShip;
    }
    
    public ShipSelectionPanel() {
        
        //init the panel
        this.setLayout(new GridLayout(5, 2));
        
        //init the label and the button and add to the panel
        lblShip = new ShipLabel[5];
        btnShip = new ShipSelectButton[5];
        for (int i = 0; i < lblShip.length; i++) {
            if(i==0){
                lblShip[i] = new ShipLabel(i+1);
                btnShip[i] = new ShipSelectButton(i+1, "Select Ship: "+(i+2)+" - Size: 1x" + (i+2));
            } else {
            lblShip[i] = new ShipLabel(i);
            btnShip[i] = new ShipSelectButton(i, "Select Ship: "+(i+1)+" - Size: 1x" + (i+1));
            }
            this.add(lblShip[i]);
            this.add(btnShip[i]);
        }
        
    }
}
