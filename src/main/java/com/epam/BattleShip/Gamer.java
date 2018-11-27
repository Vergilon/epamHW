package com.epam.BattleShip;

import java.util.ArrayList;
import java.util.List;

/**
 * Class extends standard player's class functionality
 */
public class Gamer extends Player {

    Gamer(String name) {
        super(name);
    }

    /**
     * Special method to convert char symbols in special integer number.
     * If symbol isn't in switch collection, game will enter data one more time.
     *
     * @param symbol is character that needs to be converted
     * @return integer number for game board
     */
    int convertChar(char symbol) {
        List<Character> correctSymbols = new ArrayList<>();
        char[] c = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        for (char s : c) {
            correctSymbols.add(s);
        }
        int convertInt = 0;
        if (correctSymbols.contains(Character.toLowerCase(symbol))) {
            switch (Character.toLowerCase(symbol)) {
                case 'a':
                    break;
                case 'b':
                    convertInt = 1;
                    break;
                case 'c':
                    convertInt = 2;
                    break;
                case 'd':
                    convertInt = 3;
                    break;
                case 'e':
                    convertInt = 4;
                    break;
                case 'f':
                    convertInt = 5;
                    break;
                case 'g':
                    convertInt = 6;
                    break;
                case 'h':
                    convertInt = 7;
                    break;
                case 'i':
                    convertInt = 8;
                    break;
                case 'j':
                    convertInt = 9;
                    break;
            }
        } else {
            convertInt = -1;
        }
        return convertInt;
    }

    /**
     * Main method for reading data from input stream.
     * Method special increment input data, because this is necessary for board.
     *
     * @param str input string
     * @return array containing two numbers
     */
    int[] readShot(String str) {
        if (str.length() == 2) {
            int c = convertChar(str.charAt(0)) + 1;
            int i = Integer.parseInt(str.substring(1)) + 1;
            return new int[]{c, i};
        } else {
            throw new IllegalArgumentException();
        }
    }
}
