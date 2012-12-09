/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


/**
 *
 * @author truong
 */
public class SharedObject {
    private String currentTurn;

    public String getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(String currentTurn) {
        this.currentTurn = currentTurn;
    }

    public SharedObject(String firstTurn) {
        this.currentTurn = firstTurn;
    }
}
