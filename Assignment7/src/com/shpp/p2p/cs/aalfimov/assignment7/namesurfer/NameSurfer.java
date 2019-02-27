package com.shpp.p2p.cs.aalfimov.assignment7.namesurfer;

/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import com.shpp.cs.a.simple.SimpleProgram;

import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends SimpleProgram implements NameSurferConstants {

    /**
     * Text input field
     */
    private JTextField FIELD;

    /**
     * The graph shown on the screen
     */
    protected NameSurferGraph GRAPH;

    /**
     * Database, this is the .txt file that we read from NAMES_DATA_FILE
     */
    protected NameSurferDataBase DATA_BASE;
    private JLabel NAME;
    private JButton graphButton;
    private JButton clearButton;

    /**
     * This method has the responsibility for reading in the data base
     * and initializing the interactors at the top of the window.
     */

    public void init() {
        NAME = new JLabel("Name: ");
        add(NAME, NORTH);

        FIELD = new JTextField(20);
        add(FIELD, NORTH);
        FIELD.addActionListener(this);

        graphButton = new JButton("Graph");
        add(graphButton, NORTH);

        clearButton = new JButton("Clear");
        add(clearButton, NORTH);

        addActionListeners();

        GRAPH = new NameSurferGraph();
        add(GRAPH);

        DATA_BASE = new NameSurferDataBase(NAMES_DATA_FILE);
    }

    /**
     * This class is responsible for detecting when the buttons are
     * clicked, so you will have to define a method to respond to
     * button actions.
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearButton) {
            GRAPH.clear();
        } else {
            String nextName = FIELD.getText().toLowerCase();
            NameSurferEntry name = DATA_BASE.findEntry(nextName);
            if (name != null) {
                GRAPH.addEntry(name);
            }
        }
    }
}
