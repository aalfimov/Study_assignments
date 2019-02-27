package com.shpp.p2p.cs.aalfimov.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class assignment3part3 extends TextProgram {
    public void run() {
        /**
         * Ask the user about the number and exponent
         */
        double base = readDouble("Enter a number: ");
        int exponent = readInt("Enter a exponent: ");

        println(raiseToPower(base, exponent));
    }

    private double raiseToPower(double base, int exponent) {
        double firstValue = base;

        /**
         * if the exponent is 0, return 1
         */
        if (exponent == 0) {
            return 1;
        }

        /**
         * if the exponent is less 0, multiply the number by itself, exponent times and divide by 1
         */
        if (exponent < 0) {
            for (int i = -1; i > exponent; i--) {
                base = base * firstValue;
            }
            base = 1 / base;
            return base;

            /**
             * If the indicator is greater than 0, multiply the number by itself exponent times
             */
        } else {
            for (int i = 1; i < exponent; i++) {
                base = base * firstValue;
            }
            return base;
        }
    }
}