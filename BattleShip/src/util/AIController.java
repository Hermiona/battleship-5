/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Random;

/**
 *
 * @author truong
 */
public class AIController {

    private String difficulty;
    private Position leftFirePosition;
    private Position rightFirePostion;
    /*
     * store the grid =0: this has not been fire >0: hit target <0: miss target
     */
    private int[][] gridPosition;

    public AIController(String difficulty) {
        this.difficulty = difficulty;
        gridPosition = new int[10][10];
        for (int i = 0; i < gridPosition.length; i++) {
            for (int j = 0; j < gridPosition.length; j++) {
                gridPosition[i][j] = 0;
            }
        }

        leftFirePosition = null;
        rightFirePostion = null;
    }

    public Position getAttackPoint() {
        Random r = new Random();
        if (difficulty.equals(ApplicationConstants.DIFFICULTY_EASY)) {
            return getAttackPointEasy();
        } else {
            return getAttackPointHard();
        }

    }

    //check whether this position is fired before or not
    private int isFired(Position p) {
        int result = 0;
//        for (int i = 0; i < gridPosition.length; i++) {
//            for (int j = 0; j < gridPosition.length; j++) {
//                if (i == p.getX() && j == p.getY()) {
//                    result = gridPosition[i][j];
//                }
//            }
//        }
        result = gridPosition[p.getX()][p.getY()];
        return result;
    }

    private Position getAttackPointEasy() {
        Position p;
        do {
            Random r = new Random();
            p = new Position(r.nextInt(10), r.nextInt(10));
        } while (isFired(p) != 0);
        return p;
    }

    private Position getAttackPointHard() {
        Position firePosition = null;

        if (leftFirePosition == null && rightFirePostion == null) { //pick random position
            firePosition = getAttackPointEasy();
        } else if (leftFirePosition != null) { //continue fire to the left
            firePosition = leftFirePosition;
        } else { //continue fire to the right
            firePosition = rightFirePostion;
        }

        return firePosition;
    }

    public void setFireResult(Position p, boolean result) {
        if (result) { //HIT
            gridPosition[p.getX()][p.getY()] = 1;
            
            //this is for hard level
            if (leftFirePosition == null && rightFirePostion == null) { //first time hit
                if (p.getX() != 0) { //ensure that the value is not out of the grid
                    leftFirePosition = new Position(p.getX() - 1, p.getY()); //go to the left 1 cell
                    if (isFired(leftFirePosition) != 0) { //if this was fired before, set to null
                        leftFirePosition = null;
                    }
                }
                if (p.getX() < 9) { //ensure that the value is not out of the grid
                    rightFirePostion = new Position(p.getX() + 1, p.getY()); //go to the right 1 cell
                    if (isFired(rightFirePostion) != 0) {//if this was fired before, set to null
                        rightFirePostion = null;
                    }
                }
            } else if (leftFirePosition != null) {
                if (leftFirePosition.getX() == p.getX()) { //last time, fire to the left hit, continue go to the left
                    if (p.getX() != 0) { //ensure that the value is not out of the grid
                        leftFirePosition = new Position(p.getX() - 1, p.getY());
                        if (isFired(leftFirePosition) != 0) { //if this was fired before, set to null
                            leftFirePosition = null;
                        }
                    } else { //go to the edge of the grid, stop, just set the fire postion to null
                        leftFirePosition = null;
                    }
                }
            } else if (rightFirePostion != null) {
                if (rightFirePostion.getX() == p.getX()) { //last time, fire to the right hit, continue go to the right
                    if (p.getX() < 9) { //ensure that the value is not out of the grid
                        rightFirePostion = new Position(p.getX() + 1, p.getY());
                        if (isFired(rightFirePostion) != 0) {//if this was fired before, set to null
                            rightFirePostion = null;
                        }
                    } else { //go to the edge of the grid, stop, just set the fire postion to null
                        rightFirePostion = null;
                    }
                }
            }
        } else { //MISS
            gridPosition[p.getX()][p.getY()] = -1;

            if (leftFirePosition == null && rightFirePostion == null) { //the computer is currently randomize
                //do nothing
            } else if (leftFirePosition != null) { 
                if (leftFirePosition.getX() == p.getX()) { //firing to the left does not hit anymore, stop moving to the left, just set to null
                    leftFirePosition = null;
                }
            } else if (rightFirePostion != null) {
                if (rightFirePostion.getX() == p.getX()) { //firing to the right does not hit anymore, stop moving to the right, just set to null
                    rightFirePostion = null;
                }
            }

        }
    }
}
