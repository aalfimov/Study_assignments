package com.shpp.p2p.cs.aalfimov.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {

    /**
     * Karel draws a chessboard until he rests against a wall in the north.
     *
     * @throws Exception
     */
    public void run() throws Exception {
        while (notFacingNorth()) {
            putBeeper();
            smartMove();
            if (notFacingNorth()) {
                smartMove();
            }
        }
    }

    /**
     * Karel takes a cautious step.
     * If the wall is ahead, he makes a turn on a new line.
     *
     * @throws Exception
     */
    private void smartMove() throws Exception {
        if (frontIsClear())
            move();
        else {
            if (facingEast())
                turnToTheLeft();
            else if (facingWest())
                turnToTheRight();
        }
    }

    /**
     * If Karel rests against the eastern wall, he moves to the next line and goes in the opposite direction.
     * If the way to the north is blocked, he does not go.
     *
     * @throws Exception
     */
    private void turnToTheLeft() throws Exception {
        turnLeft();
        if (facingNorth() && frontIsClear()) {
            smartMove();
            turnLeft();
        }
    }

    /**
     * Karel turn Around
     *
     * @throws Exception
     */
    private void turnAround() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    /**
     * If Karel rests against the western wall, he moves to the next line and goes in the opposite direction.
     * If the way to the north is blocked, he does not go.
     *
     * @throws Exception
     */
    private void turnToTheRight() throws Exception {
        turnAround();
        if (facingNorth() && frontIsClear()) {
            smartMove();
            turnAround();
        }
    }
}