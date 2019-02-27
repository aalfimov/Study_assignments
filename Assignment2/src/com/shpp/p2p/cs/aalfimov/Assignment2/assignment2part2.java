package com.shpp.p2p.cs.aalfimov.Assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class assignment2part2 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;
    public static final double SIZE_CIRCLE = 100;
    public static final double SHIFT_RECT = SIZE_CIRCLE / 2;

    /**
     * The program draws a graphic illusion,
     * black circles around the edges of the screen and white on the center.
     */
    public void run() {

        /**
         * Size of circle
         */
        double x = getWidth() - SIZE_CIRCLE;
        double y = getHeight() - SIZE_CIRCLE;

        /**
         * Drawing the first circle
         */
        drawCircle(0, 0);

        /**
         * Drawing the second circle
         */
        drawCircle(x, 0);

        /**
         * Drawing the third circle
         */
        drawCircle(x, y);

        /**
         * Drawing the fourth circle
         */
        drawCircle(0, y);

        /**
         * Drawing the square. Fill the white color
         */
        drawRect(x, y);
    }

    /**
     * The function draws circles. The input takes coordinates, where to draw.
     * The size of a circle is given by constants SIZE_CIRCLE, SIZE_CIRCLE.
     *
     * @param x - coordinate on the horizontal axis
     * @param y - vertical axis coordinate
     */
    public void drawCircle(double x, double y) {
        GOval firstCircle = new GOval(x, y, SIZE_CIRCLE, SIZE_CIRCLE);
        firstCircle.setFilled(true);
        add(firstCircle);
    }

    /**
     * The function draws rectangle.Edges coincide with the centers of the circles
     *
     * @param x - coordinate on the horizontal axis
     * @param y - vertical axis coordinate
     */
    public void drawRect(double x, double y) {
        GRect square = new GRect(SHIFT_RECT, SHIFT_RECT, x, y);
        square.setFilled(true);
        square.setColor(Color.WHITE);
        add(square);
    }
}
