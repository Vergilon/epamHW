package com.epam.lesson3;

/**
 * Char matrix for creating strings according to determined rules
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class CharMatrix {
    private char[][] charMatrix;

    public char[][] getCharMatrix() {
        return charMatrix;
    }

    public void setCharMatrix(char[][] charMatrix) {
        this.charMatrix = charMatrix;
    }

    /**
     * Defualt test constructor
     */
    public CharMatrix() {
        charMatrix = new char[][]{
                {'+', '*', '0', '*', '+'},
                {'*', '0', '*', '0', '*'},
                {'0', '*', '0', '*', '0'},
                {'*', '0', '*', '0', '*'},
                {'-', '*', '0', '*', '-'}
        };
    }

    /**
     * User constructor
     *
     * @param newMatrix set charMatrix
     */
    public CharMatrix(char[][] newMatrix) {
        charMatrix = newMatrix;
    }


    /**
     * Check number parity
     * Method is private, because it work only in method this class
     *
     * @param m number which is checked
     * @return boolean result
     */
    private boolean isEven(int m) {
        return m % 2 == 0;
    }

    /**
     * 12.270
     * Create string from edge chars
     *
     * @return string according to the rules
     */
    public String getEdgeString() {
        StringBuilder sb = new StringBuilder();
        int widthMatrix = charMatrix[0].length - 1;
        int heightMatrix = charMatrix.length - 1;
        sb.append(charMatrix[0][0]);
        sb.append(charMatrix[0][widthMatrix]);
        sb.append(charMatrix[heightMatrix][0]);
        sb.append(charMatrix[heightMatrix][widthMatrix]);
        return new String(sb);
    }

    /**
     * 12.271
     * Create string from cut out row matrix
     *
     * @param rowNumber determinate row
     * @param startChar determinate start char index
     * @param endChar   determinate last char index
     * @return string according to the rules
     */
    public String getLimitString(int rowNumber, int startChar, int endChar) {
        return new String(String.copyValueOf(charMatrix[rowNumber], startChar, endChar - startChar));
    }

    /**
     * 12.272
     * Create string from char in chequer-wise
     *
     * @param isRow set output methods matrix processing
     * @return string according to the rules
     */
    public String getCheckerString(boolean isRow) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charMatrix.length; i++) {
            for (int j = 0; j < charMatrix[0].length; j++) {
                if (isRow && isEven(i + j)) {
                    sb.append(charMatrix[i][j]);
                } else if (!isRow && isEven(i + j)) {
                    sb.append(charMatrix[j][i]);
                }
            }
        }
        return new String(sb);
    }

    /**
     * 12.273
     * Create string from even matrix char.
     * Creation takes place in row from left to right
     *
     * @return string according to the rules
     */
    public String[] getStringOfRowEvenChar() {
        String[] x = new String[charMatrix.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charMatrix.length; i++) {
            for (int j = 0; j < charMatrix.length; j++) {
                if (isEven(j)) {
                    sb.append(charMatrix[i][j]);
                }
            }
            x[i] = new String(sb);
            sb.setLength(0);
        }
        return x;
    }

    /**
     * 12.274
     * Create string from uneven matrix char.
     * Creation takes place in columns from top to bottom
     *
     * @return string according to the rules
     */
    public String[] getStringOfColumnUnevenChar() {
        String[] x = new String[charMatrix.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charMatrix.length; i++) {
            for (int j = 0; j < charMatrix.length; j++) {
                if (!isEven(j)) {
                    sb.append(charMatrix[j][i]);
                }
            }
            x[i] = new String(sb);
            sb.setLength(0);
        }
        return x;
    }
}
