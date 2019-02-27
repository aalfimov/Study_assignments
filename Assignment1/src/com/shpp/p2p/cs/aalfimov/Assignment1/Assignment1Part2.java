package com.shpp.p2p.cs.aalfimov.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {

    /**
     * Karel build Stone Mason
     *
     * @throws Exception
     */
    public void run() throws Exception {
        while (frontIsClear()) {
            buildColumn();
            turnLeft();
            safeMove();
        }
        buildColumn();

    }

    /**
     * Build a column until we hit the wall
     *
     * @throws Exception
     */

    private void buildColumn() throws Exception {
        turnLeft();
        while (frontIsClear()) {
            buildBlock();
            move();
        }
        buildBlock();
        turnAround();
        walkToBarrier();
    }

    /**
     * Karel checks for the presence of a beeper
     *
     * @throws Exception
     */

    private void buildBlock() throws Exception {
        if (noBeepersPresent()) {
            putBeeper();
        }
    }

    /**
     * Karel checks the front, before move
     *
     * @throws Exception
     */

    private void safeMove() throws Exception {
        if (frontIsClear()) {
            walk();
        }
    }

    /**
     * Karel makes four steps
     *
     * @throws Exception
     */
    private void walk() throws Exception {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

    /**
     * Karel turn Around
     *
     * @throws Exception
     */
    private void turnAround() throws Exception {
        for (int i = 0; i < 2; i++) {
            turnLeft();
        }
    }

    /**
     * Karel goes until he meets the wall
     *
     * @throws Exception
     */
    private void walkToBarrier() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }
}
