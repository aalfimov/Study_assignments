package com.shpp.p2p.cs.aalfimov.Assignment1;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {

    /**
     * To find the middle of the series, Karel fills it with beepers, and then collects on the alternate sides. In the end, put beeper on the middle lines.
     *
     * @throws Exception
     */
    public void run() throws Exception {
        startCheck();
        while (beepersPresent()) {
            findLastBeeper();
        }
        putLastBeeper();
    }

    /**
     * Start check the world from 1 cell and scatter Beepers
     *
     * @throws Exception
     */
    private void startCheck() throws Exception {
        if (frontIsClear()) {
            move();
            scatterBeepers();
            turnAround();
            move();
        }
    }

    /**
     * Karel is spreading beeper
     *
     * @throws Exception
     */
    private void scatterBeepers() throws Exception {
        while (frontIsClear()) {
            putBeeper();
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
     * Karel collects beers from different sides
     *
     * @throws Exception
     */
    private void findLastBeeper() throws Exception {
        while (beepersPresent()) {
            move();
        }
        turnAround();
        move();
        pickBeeper();
        move();
    }

    /**
     * Karel put Last Beeper
     *
     * @throws Exception
     */
    private void putLastBeeper() throws Exception {
        turnAround();
        if (frontIsClear()) {
            move();
        }
        putBeeper();
    }
}
