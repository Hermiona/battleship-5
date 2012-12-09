/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;

/**
 *
 * @author truong
 */
public class ShipSelectButton extends JButton{
    private int shipType;

    public ShipSelectButton(int shipType, String displayText) {
        super(displayText);
        this.shipType = shipType;
    }

    public int getShipType() {
        return shipType;
    }

    public void setShipType(int shipType) {
        this.shipType = shipType;
    }
}
