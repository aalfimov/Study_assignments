package com.shpp.p2p.cs.aalfimov.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class assignment3part2 extends TextProgram {
    /**
     * Number of hailstones
     * User enter the number
     */
    public int number = readInt("Enter a number: ");

    public void run() {
        /**
         * Make check the number on 0
         */
        while (number <= 0) {
            number = readInt("Number can not be 0 or less, enter another number:");
        }
        numberOfHailstone();
    }

    /**
     * We make the check on even or odd, using the module by 2.
     * if odd, multiply the number by 3 and add 1
     * if even, divide by 2
     */
    public void numberOfHailstone() {
        while (number != 1) {
            if (number % 2 == 1) {
                print(number + " is odd so I make 3n + 1: ");
                number = number * 3 + 1;
                println(number);
            } else {
                print(number + " is even so I take half: ");
                number = number / 2;
                println(number);
            }
        }
    }
}