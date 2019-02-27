package com.shpp.p2p.cs.aalfimov.Assignment2;

import com.shpp.cs.a.console.TextProgram;

public class assignment2part1 extends TextProgram {
    /**
     * The program solves the quadratic equation
     * Variables A, B, C
     */
    public double A = 0;
    public double B = 0;
    public double C = 0;

    /**
     * Discriminant
     */
    double D;

    public void run() {

        userInput();
        findDiscriminant();
        outputResults();

    }

    /**
     * The user enters variables a, b, c
     */
    public void userInput() {
        A = readDouble("Please enter a:");
        /**
         * Make check the first element on 0
         */
        while (A == 0) {
            A = readDouble("a can not be 0 or letter, enter another number:");
        }
        B = readDouble("Please enter b:");
        C = readDouble("Please enter c:");
    }

    /**
     * Find discriminant
     */
    public void findDiscriminant() {
        D = B * B - 4 * A * C;
    }

    public void outputResults() {
        /**
         * If the discriminant is bigger than 0, we have two roots of equation
         */
        if (D > 0) {
            double x1, x2;
            x1 = (-B - Math.sqrt(D)) / (2 * A);
            x2 = (-B + Math.sqrt(D)) / (2 * A);
            println("We have two roots of equation: x1 = " + x1 + ", x2 = " + x2);
        }

        /**
         * If the discriminant is 0, we have one root in equation
         */
        else if (D == 0) {
            double x;
            x = -B / (2 * A);
            println("The equation has one root: x = " + x);
        }

        /**
         * If the discriminant is less than 0, we has no roots in equation
         */
        else {
            println("The equation has no roots.");
        }
    }
}
