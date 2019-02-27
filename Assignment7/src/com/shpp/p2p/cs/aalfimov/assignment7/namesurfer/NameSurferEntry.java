package com.shpp.p2p.cs.aalfimov.assignment7.namesurfer;

/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

public class NameSurferEntry implements NameSurferConstants {

    /* Line from data base */
    private String lineData;
    /* Here is the name entered by the user */
    private String name;

    /**
     * Creates a new NameSurferEntry from a data line as it appears
     * in the data file.  Each line begins with the name, which is
     * followed by integers giving the rank of that name for each
     * decade.
     */
    public NameSurferEntry(String line) {

        lineData = line;
        name = getName();
    }

    /**
     * Returns the name associated with this entry.
     */
    public String getName() {
        String[] value = lineData.split(" ");
        return value[0];
    }

    /**
     * Returns the rank associated with an entry for a particular
     * decade.  The decade value is an integer indicating how many
     * decades have passed since the first year in the database,
     * which is given by the constant START_DECADE.  If a name does
     * not appear in a decade, the rank value is 0.
     */
    public int getRank(int decade) {
        String[] value = lineData.split(" ");
        return Integer.parseInt(value[decade + 1]);
    }

    /**
     * Returns a string that makes it easy to see the value of a
     * NameSurferEntry.
     */
    public String toString() {

        String resultString = name + " [";
        for (int i = 0; i < NDECADES; i++) {
            resultString = resultString + getRank(i) + " ";
        }
        resultString = resultString.substring(0, resultString.length() - 1) + "]";

        return resultString;
    }
}

