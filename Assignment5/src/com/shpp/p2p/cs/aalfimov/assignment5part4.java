
package com.shpp.p2p.cs.aalfimov;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class assignment5part4 extends TextProgram {
    /**
     * Path to csv file
     */
    private static final String FILE = "assets/file.csv";

    private static final int columnIndex = 1;
    /**
     * Separators :)
     */
    private static final String SEPARATOR = ",||(\"&&!,)";

    /**
     * Program to parsing csv format file.
     */
    public void run() {
        ArrayList<String> parsingCSV = extractColumn(FILE, columnIndex);
        println(parsingCSV);
    }

    /**
     * The method separates the string with commas and returns in the form ArrayList
     *
     * @param line - string to separate
     * @return ArrayList with margins
     */
    private ArrayList<String> fieldsIn(String line) {
        ArrayList<String> margins = new ArrayList<>();
        String[] margin = line.split(SEPARATOR);
        for (int i = 0; i < margin.length; i++) {
            margins.add(margin[i]);
        }
        return margins;
    }

    /**
     * The method reads the strings and passes them to the method fieldsIn() for division into fields.
     * After that, we call the method makeResultString() to generate the result on the screen
     *
     * @param filename    The path to the file
     * @param columnIndex Required column index
     * @return ArrayList with results
     */
    private ArrayList<String> extractColumn(String filename, int columnIndex) {
        ArrayList<ArrayList<String>> array = new ArrayList<>();

        try (BufferedReader readFile = new BufferedReader(new FileReader(filename))) {
            String line;
            while (true) {
                line = readFile.readLine();
                if (line == null) {
                    break;
                }
                ArrayList<String> margins = fieldsIn(line);
                array.add(margins);
            }
        } catch (IOException ex) {
            return null;
        }
        return makeResultString(array, columnIndex);
    }

    /**
     * The method creates a string of results that it pulls from the read file Arrey
     *
     * @param array       with all strings
     * @param columnIndex index that user need
     * @return results string
     */
    private ArrayList<String> makeResultString(ArrayList<ArrayList<String>> array, int columnIndex) {
        ArrayList<String> results = new ArrayList<>();
        for (ArrayList<String> margin : array) {
            results.add(margin.get(columnIndex));
        }
        return results;
    }
}