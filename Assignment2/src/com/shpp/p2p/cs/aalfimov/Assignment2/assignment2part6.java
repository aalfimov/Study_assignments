package com.shpp.p2p.cs.aalfimov.Assignment2;

import acm.graphics.GLabel;
import com.shpp.cs.a.graphics.WindowProgram;
import acm.graphics.GOval;
import java.awt.*;

public class assignment2part6 extends WindowProgram {

    /**
     * Number of the caterpillar section
     */
    private static final int CATERPILLAR_SEGMENTS = 10;

    /**
     * Diameter oval
     */
    private static final int OVAL_SIZE = 100;
    private static final int CATERPILLAR_OFFSET_X = OVAL_SIZE/2;
    private static final int CATERPILLAR_OFFSET_Y = OVAL_SIZE/3;

    public void run() {

        /**
         * Cicle for draw caterpilar
         */
        for (int i = 0; i < CATERPILLAR_SEGMENTS; i++) {
            if (i % 2 == 0) {
                drawOval(CATERPILLAR_OFFSET_X * i, OVAL_SIZE);
            } else {
                drawOval(CATERPILLAR_OFFSET_X * i, CATERPILLAR_OFFSET_Y);
            }
            if(i==CATERPILLAR_SEGMENTS-1){
                GLabel face = new GLabel("0_J0");
                face.setFont("Verdana-20");
                add(face,CATERPILLAR_OFFSET_X * i+OVAL_SIZE/2, CATERPILLAR_OFFSET_Y+OVAL_SIZE/2);
            }
        }
    }

    /**
     * The function draw the oval. Give her the coordinates and fill color
     * @param x - coordinate on the horizontal axis
     * @param y - vertical axis coordinate
     */
    private void drawOval(double x, double y) {
        GOval oval = new GOval(x, y, OVAL_SIZE, OVAL_SIZE);
        oval.setColor(Color.RED);
        oval.setFilled(true);
        oval.setFillColor(Color.GREEN);
        add(oval);
    }
}