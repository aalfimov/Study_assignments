package com.shpp.p2p.cs.aalfimov;

import com.shpp.cs.a.console.TextProgram;


public class SyllableCounting extends TextProgram {
    public void run() {
        /**
         * Repeatedly prompt the user for a word and print out the estimated
         * number of syllables in that word.
         */
        while (true) {
            String word = readLine("Enter a single word: ");
            println("  Syllable count: " + syllablesIn(word));
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
    private int syllablesIn(String word) {
        /**
         * For counting syllables
         */
        int counter = 0;
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};

        /**
         * Make boolean array for find vowels
         */
        boolean[] vowelsInWord = new boolean[word.length() + 1];

        /**
         * Make new string in lower case to facilitate the search
         */
        String wordLowerCase = word.toLowerCase();

        /**
         * Search for vowels
         * Count only those that do not go in a row
         */
        for (int i = 1; i < wordLowerCase.length() + 1; i++) {
            for (int j = 1; j < vowels.length + 1; j++) {
                if (wordLowerCase.charAt(i - 1) == vowels[j - 1])
                    vowelsInWord[i] = true;
            }
            if (vowelsInWord[i] && vowelsInWord[i - 1] == false)
                counter++;
        }

        /**
         * Check for last letter 'e'
         * The number of syllables can not be less than 0
         */
        if (wordLowerCase.endsWith("e"))
            counter--;
        if (counter <= 0)
            counter = 1;
        return counter;
    }
}
