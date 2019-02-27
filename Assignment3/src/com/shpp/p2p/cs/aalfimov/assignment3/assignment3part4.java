package com.shpp.p2p.cs.aalfimov.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class assignment3part4 extends WindowProgram {

    public final int APPLICATION_WIDTH = 480;
    public final int APPLICATION_HEIGHT = 300;

    /**
     * Dimensions and number of bricks
     */
    private static final double BRICK_HEIGHT = 40;
    private static final double BRICK_WIDTH = 80;
    private static final double BRICKS_IN_BASE = 10;

    public void run() {
        double x = getWidth() / 2;
        double y = getHeight();

        /**
         * Make a pyramid in the center of the screen
         */
        for (double j = BRICKS_IN_BASE; j > 0; j--) {
            for (int i = 1; i < j + 1; i++) {
                drawRect(x - (i * BRICK_WIDTH) + ((j * BRICK_WIDTH) / 2), y - BRICK_HEIGHT, BRICK_WIDTH, BRICK_HEIGHT);
            }
            y = y - BRICK_HEIGHT;
        }
    }

    /**
     * The function draw the rect. Give her the coordinates, color yellow with shadow
     *
     * @param x - Horizontal coordinates
     * @param y - Vertical coordinates
     * @param w - Brick width
     * @param h - Height of brick
     */

    private void drawRect(double x, double y, double w, double h) {
        /**
         * shadow size
         */
        int shadow = 1;
        GRect rectBoard = new GRect(x, y, w, h);
        rectBoard.setFilled(true);
        add(rectBoard);
        GRect rect = new GRect(x - shadow, y - shadow, w - shadow, h - shadow);
        rect.setFillColor(Color.YELLOW);
        rect.setFilled(true);
        add(rect);
    }

}