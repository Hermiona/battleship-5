/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ShipCellList;
import util.AIController;
import util.ApplicationConstants;
import util.Position;
import util.SharedObject;

/**
 *
 * @author truong
 */
public class ComputerPlayer implements Runnable{

    private SharedObject turn;
    private AIController aiController;
    private ShipCellList shipCellList;
    private String difficulty;
    
    public ComputerPlayer(SharedObject turn, ShipCellList shipCellList, String difficulty) {
        this.turn = turn;
        this.shipCellList = shipCellList;
        this.difficulty = difficulty;
        aiController = new AIController(this.difficulty);
    }
    
    @Override
    public void run() {
        System.out.println("Thread started");
        while(!shipCellList.isGameEnd()){
            Random r = new Random();
            //System.out.println("thread");
            if(!turn.getCurrentTurn().equals(ApplicationConstants.PLAYER_HUMAN)){
                System.out.println("computer");
//                try {
//                    Thread.sleep(500);
                    Position firePoint = aiController.getAttackPoint();
                    boolean fireResult = shipCellList.computerFireHuman(firePoint);
                    aiController.setFireResult(firePoint, fireResult);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(ComputerPlayer.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        }
        System.out.println("End");
    }
    
}
