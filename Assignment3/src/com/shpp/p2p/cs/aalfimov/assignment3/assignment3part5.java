package com.shpp.p2p.cs.aalfimov.assignment3;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

public class assignment3part5 extends TextProgram {
    private int bank = 0;
    private int cash = 1;
    private int counter = 0;
    private int minCashToEndGame = 20;


    public void run() {

        /**
         * Call the game, while in the bank less than $ 20
         */
        while (bank < minCashToEndGame) {
            cash = 1;
            game();
            println("This game, you earned $" + cash);
            println("Your total is $" + bank);
            counter++;
        }
        println("It took " + counter + " games to earn $20");
    }

    /**
     * The program generates a random Boolean value, adds results, if true, calls a recursion
     */
    private void game() {
        RandomGenerator rgen = RandomGenerator.getInstance();
        rgen.nextBoolean();
        if (rgen.nextBoolean() == true) {
            cash = cash + cash;
            game();
        } else {
            bank = bank + cash;
        }
    }
}