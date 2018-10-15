package com.epam.lesson2;

/**
 * StringTask description.
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class StringTask {
    private String stringTask;

    public String getStringTask() {
        return stringTask;
    }

    public void setStringTask(String stringTask) {
        this.stringTask = stringTask;
    }

    public StringTask(String string) {
        setStringTask(string);
    }

    /**
     * 9.13
     *
     * @return third string character
     */
    public char getThirdChar() {
        return stringTask.charAt(2);
    }

    /**
     * 9.14
     *
     * @return last string character
     */
    public char getLastChar() {
        return stringTask.charAt(stringTask.length() - 1);
    }

    /**
     * 9.15
     *
     * @param kthChar string index
     * @return x(th) string character
     */
    public char getKthChar(int kthChar) {
        return stringTask.charAt(kthChar - 1);
    }

    /**
     * 9.64
     *
     * @return same neighbouring characters count
     */
    public int getSameNeighbors() {
        int count = 0;
        for (int i = 0; i < stringTask.length() - 1; i++) {
            if (stringTask.charAt(i) == stringTask.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 9.100
     *
     * @return new string with swapped second and fifth characters
     */
    public String swapSecondAndFifth() {
        char[] characters = stringTask.toCharArray();
        char tmp = characters[1];
        characters[1] = characters[4];
        characters[4] = tmp;
        return new String(characters);
    }

    /**
     * @return reverse string
     */
    public String reverseString() {
        return new StringBuilder(stringTask).reverse().toString();
    }

}