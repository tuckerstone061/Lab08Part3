/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Part3;

/**
 *
 * @author tucker.stone061
 */

public class Bunny extends Animal {
    
    private boolean canSeeWolf = false;
    private boolean haveSeenWolf = false;
    private int distanceToWolf;
    private int directionToWolf;
    private int currentDirection;

    public Bunny(Model model, int row, int column) {
        super(model, row, column);
    }
    
    @Override
    int decideMove() {
        
        // look all around for wolf
        canSeeWolf = false;
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.WOLF) {
                canSeeWolf = haveSeenWolf = true;
                directionToWolf = i;
                if (directionToWolf == currentDirection)
                    currentDirection = Model.turn(currentDirection, 1);
                }
        }
        
        /*if (haveSeenWolf) {
            if (canMove(-directionToWolf)) {
                currentDirection = -directionToWolf;
                return currentDirection;
            }
        }
        /*
        if (haveSeenWolf) {
            if (canMove(-directionToWolf))
                return -(directionToWolf);
            else if (canMove(Model.turn(-directionToWolf, 1)))
                return Model.turn(-directionToWolf, 1);
            else if (canMove(Model.turn(-directionToWolf, -1)))
                return Model.turn(-directionToWolf, 1);
            else 
                return Model.random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
        }
        else { // wheres that wolf...
            haveSeenWolf = false;
            currentDirection = Model.random(Model.MIN_DIRECTION,
                                                Model.MAX_DIRECTION);
        }*/
        
        
        if (canMove(currentDirection))
            return currentDirection;/*
        else if (canMove(Model.turn(currentDirection, 1)))
            return Model.turn(currentDirection, 1);
        else if (canMove(Model.turn(currentDirection, -1)))
            return Model.turn(currentDirection, -1);
        else {
            currentDirection = Model.random(Model.MIN_DIRECTION,
                                            Model.MAX_DIRECTION);
            for (int i = 0; i < 8; i++) {
                if (canMove(currentDirection))
                    return currentDirection;
                else
                    currentDirection = Model.turn(currentDirection, 1);
            }
        }*/
        currentDirection*=-1;
        return currentDirection;
    }
}



