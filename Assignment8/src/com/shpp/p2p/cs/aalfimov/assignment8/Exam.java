package com.shpp.p2p.cs.aalfimov.assignment8;

import acm.graphics.GObject;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Exam extends WindowProgram {

    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 500;

    /**
     * Number of bricks per row
     */
    private static final int NBRICKS_PER_ROW = 8;
    /**
     * Number of rows of bricks
     */
    private static final int NBRICK_ROWS = 8;
    /**
     * Separation between bricks
     */
    private static final int BRICK_SEP = 2;
    /**
     * Width of a brick
     */
    private static final int BRICK_WIDTH = (APPLICATION_WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
    /**
     * Height of a brick
     */
    private static final int BRICK_HEIGHT = (APPLICATION_HEIGHT - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICK_ROWS;

    /**
     * The amount of time to pause between frames (100 fps).
     */
    private static final double PAUSE_TIME = 1000.0 / 10;
    /**
     * data array with fill color of Bricks
     */
    private GRect[][] dataObjects = new GRect[NBRICKS_PER_ROW][NBRICK_ROWS];

    private GObject selectedObject;

    public void run() {
        makeBricks();
        greenLight();
    }

    /**
     * Draw NBRICKS_PER_ROW brick per line, NBRICK_ROWS per column, and fill them.
     */
    private void makeBricks() {
        for (int line = 0; line < NBRICKS_PER_ROW; line++) {
            for (int column = 0; column < NBRICK_ROWS; column++) {
                drawBricks(line * (BRICK_WIDTH + BRICK_SEP),
                        column * (BRICK_HEIGHT + BRICK_SEP) - BRICK_SEP,
                        BRICK_WIDTH, BRICK_HEIGHT, line, column);
            }
        }
    }

    /**
     * The function draw the Brick. Give her the coordinates and color to filled
     * If its first column, fill brick in black color, otherwise in white.
     *
     * @param x      - coordinate on the horizontal axis
     * @param y      - vertical axis coordinate
     * @param w      - width of rectangle
     * @param h      - height of a rectangle
     * @param line   - line of brick
     * @param column - column of brick
     */
    private void drawBricks(int x, int y, int w, int h, int line, int column) {
        dataObjects[line][column] = new GRect(x, y, w, h);
        dataObjects[line][column].setFilled(true);
        dataObjects[line][column].setColor(Color.WHITE);
        if (column == 0) {
            dataObjects[line][column].setColor(Color.BLACK);
        }
        add(dataObjects[line][column]);
    }

    /**
     * Check clicked object, get Element selected object and call checkObject()
     *
     * @param e Mouse Event
     */
    public void mousePressed(MouseEvent e) {
        selectedObject = getElementAt(e.getX(), e.getY());
        if (selectedObject != null) {
            checkObject();
        }
    }

    /**
     * The method finds in which column the brick was pressed and another one is drawn.
     * If the column has more than 3 bricks, it paints one in green.
     */
    private void checkObject() {
        if (selectedObject.getColor() == Color.BLACK) {
            int line = (int) selectedObject.getX() % BRICK_WIDTH / 2;

            for (int i = 0; i < NBRICK_ROWS; i++) {
                if (dataObjects[line][2].getColor() == Color.BLACK) {
                    dataObjects[line][i].setColor(Color.GREEN);
                }
                if (dataObjects[line][i].getColor() == Color.BLACK || dataObjects[line][i].getColor() == Color.GREEN) {
                    continue;
                } else {
                    dataObjects[line][i].setColor(Color.BLACK);
                    break;
                }
            }
        }
    }

    /**
     * The method checks the elements of the array in the search for green brick
     * Then change color with next element (or first element of array)
     */
    private void greenLight() {
        addMouseListeners();
        while (true) {
            for (int line = 0; line < NBRICKS_PER_ROW; line++) {
                for (int column = 0; column < NBRICK_ROWS; column++) {
                    if (dataObjects[line][column].getColor() == Color.GREEN) {
                        dataObjects[line][column].setColor(Color.BLACK);
                        if (column + 1 >= NBRICK_ROWS || dataObjects[line][column + 1].getColor() == Color.WHITE) {
                            dataObjects[line][0].setColor(Color.GREEN);
                        } else {
                            dataObjects[line][column + 1].setColor(Color.GREEN);
                        }
                        break;
                    }
                }
            }
            pause(PAUSE_TIME);
        }
    }
}