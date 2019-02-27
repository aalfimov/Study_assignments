package com.shpp.p2p.cs.aalfimov.assignment7.namesurfer;

/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;

import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class NameSurferGraph extends GCanvas
        implements NameSurferConstants, ComponentListener {

    ArrayList<NameSurferEntry> list = new ArrayList<NameSurferEntry>();

    /**
     * Creates a new NameSurferGraph object that displays the data.
     */
    public NameSurferGraph() {
        addComponentListener(this);
    }

    /**
     * Clears the list of name surfer entries stored inside this class.
     */
    public void clear() {
        list.clear();
        update();
    }

    /**
     * Adds a new NameSurferEntry to the list of entries on the display.
     * Note that this method does not actually draw the graph, but
     * simply stores the entry; the graph is drawn by calling update.
     */
    public void addEntry(NameSurferEntry entry) {
        list.add(entry);
        update();
    }

    /**
     * Updates the display image by deleting all the graphical objects
     * from the canvas and then reassembling the display according to
     * the list of entries. Your application must call update after
     * calling either clear or addEntry; update is also called whenever
     * the size of the canvas changes.
     */
    public void update() {
        removeAll();
        drawBackground();
        drawGraph();
    }

    /**
     * The method draws a grid of decades
     */
    public void drawBackground() {

        double xPosition = getWidth() / NDECADES;
        double yPosition = getHeight();

        /*Draw vertical lines and label of decades*/
        for (int i = 0; i < NDECADES; ++i) {
            add(new GLine(i * xPosition, 0, i * xPosition, yPosition));
            add(new GLabel(Integer.toString(START_DECADE + (i * 10)), 2 + i * xPosition, yPosition - GRAPH_MARGIN_SIZE / 4));
        }

        /*Draw horizontal lines*/
        add(new GLine(0, yPosition - GRAPH_MARGIN_SIZE, getWidth(), getHeight() - GRAPH_MARGIN_SIZE));
        add(new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE));

    }

    /**
     * Draw graph.
     */
    private void drawGraph() {

        double rangeForY = (getHeight() - GRAPH_MARGIN_SIZE * 2) / (double) MAX_RANK;

        for (NameSurferEntry entry : list) {
            /*coordinates for line*/
            double xPosition = 0;
            double yPosition = 0;
            double xPositionEnd = 0;
            double yPositionEnd = 0;
            if (entry != null) {
                /*check y position*/
                if (entry.getRank(0) == 0) {
                    yPosition = getHeight() - GRAPH_MARGIN_SIZE;
                } else {
                    yPosition = (entry.getRank(0) * rangeForY) + GRAPH_MARGIN_SIZE;
                }
                Color color = checkColor(list.indexOf(entry));
                drawLine(xPosition, yPosition, xPositionEnd, yPositionEnd, entry, color, rangeForY);
                /*last label*/
                drawLabel(entry.getName(), entry.getRank(NDECADES - 1), xPosition, yPosition);
            }
        }

    }

    /**
     * The method draws lines relative to decades
     *
     * @param xPosition    coordinate for line
     * @param yPosition    coordinate for line
     * @param xPositionEnd coordinate for line
     * @param yPositionEnd coordinate for line
     * @param entry        index
     * @param color        color line
     * @param rangeForY    position decades
     */
    private void drawLine(double xPosition, double yPosition, double xPositionEnd, double yPositionEnd, NameSurferEntry entry, Color color, double rangeForY) {
        for (int i = 0; i < NDECADES - 1; ++i) {
            /*set x, and check y position*/
            xPositionEnd = (i + 1) * getWidth() / NDECADES;
            if (entry.getRank(i + 1) == 0) {
                yPositionEnd = getHeight() - GRAPH_MARGIN_SIZE;
            } else {
                yPositionEnd = entry.getRank(i + 1) * rangeForY + GRAPH_MARGIN_SIZE;
            }
            /*draw line, label and change start coordinates for next line*/
            GLine line = new GLine(xPosition, yPosition, xPositionEnd, yPositionEnd);
            line.setColor(color);
            add(line);
            drawLabel(entry.getName(), entry.getRank(i), xPosition, yPosition);
            xPosition = xPositionEnd;
            yPosition = yPositionEnd;
        }
    }

    /**
     * We check the index of the cycle, to establish the required color
     *
     * @param indexOf cycle index
     * @return Needed color
     */
    private Color checkColor(int indexOf) {
        if (indexOf % 4 == 0) {
            return Color.BLUE;
        } else if (indexOf % 4 == 1) {
            return Color.RED;
        } else if (indexOf % 4 == 2) {
            return Color.MAGENTA;
        } else {
            return Color.BLACK;
        }
    }

    /**
     * Draw label, and check rank = 0, for alternative label.
     *
     * @param name      entry name
     * @param rank      entry rank
     * @param xPosition x coordinate for label
     * @param yPosition y coordinate for label
     */
    private void drawLabel(String name, int rank, double xPosition, double yPosition) {
        GLabel label = new GLabel(name + " " + rank, xPosition, yPosition);
        if (rank == 0) {
            label.setLabel(name + " *");
        }
        add(label);
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentResized(ComponentEvent e) {
        update();
    }

    public void componentShown(ComponentEvent e) {
    }
}
