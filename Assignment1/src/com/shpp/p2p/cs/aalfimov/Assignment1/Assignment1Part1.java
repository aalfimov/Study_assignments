package com.shpp.p2p.cs.aalfimov.Assignment1;

import com.shpp.karel.KarelTheRobot;


public class Assignment1Part1 extends KarelTheRobot {

    /**
     * Karel leaves the house to get a newspaper
     *
     * @throws Exception
     */
    public void run() throws Exception {
        followTheNewspaper();
        pickBeeper();
        returnToTheApartment();
    }

    /**
     * Karel leave the house
     *
     * @throws Exception
     */
    private void followTheNewspaper() throws Exception {
        turnRight();
        move();
        turnLeft();
        walk();
    }

    /**
     * Karel back to the house
     *
     * @throws Exception
     */
    private void returnToTheApartment() throws Exception {
        turnLeft();
        turnLeft();
        walk();
        turnRight();
        move();
        turnRight();
    }

    /**
     * Karel turns to the right
     *
     * @throws Exception
     */
    private void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {
            turnLeft();
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
}
