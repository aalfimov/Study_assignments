package com.shpp.p2p.cs.aalfimov.Assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

public class assignment2part5 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;

    /**
     * The number of rows and columns in the grid, respectively.
     */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /**
     * The width and height of each box.
     */
    private static final double BOX_SIZE = 40;

    /**
     * The horizontal and vertical spacing between the boxes.
     */
    private static final double BOX_SPACING = 10;

    public void run() {

        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                drawRect(((i * (BOX_SIZE + BOX_SPACING)) + ((APPLICATION_WIDTH - ((BOX_SIZE + BOX_SPACING) * NUM_COLS)) / 2))
                        , (j * (BOX_SIZE + BOX_SPACING)) + ((APPLICATION_HEIGHT - ((BOX_SIZE + BOX_SPACING) * NUM_ROWS)) / 2)
                        , BOX_SIZE
                        , BOX_SIZE);
            }
        }
    }

    /**
     * The function draw the rect. Give her the coordinates and color to filled
     *
     * @param x - coordinate on the horizontal axis
     * @param y - vertical axis coordinate
     * @param w - width of rectangle
     * @param h - height of a rectangle
     */
    private void drawRect(double x, double y, double w, double h) {
        GRect rect = new GRect(x, y, w, h);
        rect.setFilled(true);
        add(rect);
    }
}


