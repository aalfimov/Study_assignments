package com.shpp.p2p.cs.aalfimov.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class assignment3part1 extends TextProgram {

    public static final int trainDays = 7;
    public static final int[] array = new int[trainDays + 1];
    public static int cardiovascularHealthDays = 0;
    public static final int cardiovascularHealthNeedDays = 5;
    public static final int cardiovascularHealthTime = 30;
    public static int bloodPressureDays = 0;
    public static final int bloodPressureNeedDays = 3;
    public static final int bloodPressureTime = 40;

    /**
     * Call calculateTrainDays() to collect user statistics.
     * Call resultOnScreen() for data analysis.
     */
    public void run() {
        calculateTrainDays();
        resultOnScreen();
    }

    /**
     * Ask the user about the number and duration of training.
     */
    public void calculateTrainDays() {

        for (int i = 1; i < trainDays + 1; i++) {
            array[i] = readInt("How many minutes did you do on day " + i + "?");
            if (array[i] >= cardiovascularHealthTime) {
                cardiovascularHealthDays++;
            }
            if (array[i] >= bloodPressureTime) {
                bloodPressureDays++;
            }
        }
    }

    /**
     * Displays two messages. Was enough cardiovascular health days and blood pressure days?
     */
    public void resultOnScreen() {

        if (cardiovascularHealthDays >= cardiovascularHealthNeedDays) {
            println("Great job! You've done enough exercise for cardiovascular health.");
        } else {
            cardiovascularHealthDays = cardiovascularHealthNeedDays - cardiovascularHealthDays;
            println("You needed to train hard for at least " + cardiovascularHealthDays + " more day(s) a week!");
        }

        if (bloodPressureDays >= bloodPressureNeedDays) {
            println("Great job! You've done enough exercise to keep a low blood pressure.");
        } else {
            bloodPressureDays = bloodPressureNeedDays - bloodPressureDays;
            println("You needed to train hard for at least " + bloodPressureDays + " more day(s) a week!");
        }
    }
}