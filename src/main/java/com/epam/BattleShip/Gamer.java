package com.epam.BattleShip;

import java.util.ArrayList;
import java.util.List;

public class Gamer {

    private Board board;
    private int point;
    private String name;

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    String mes;

    Gamer(String name) {
        setBoard(new Board());
        setName(name);
        setPoint(20);
    }

    private void preShot(char letter, int number) {
        int x = convertChar(letter) + 1;
        int y = number + 1;
        shot(x, y);
    }

    private void shot(int litera, int number) {

        if (!isDamage(litera, number)) {
            mes = "Miss";
            System.out.println(mes);
            getBoard().getNinjaBoard()[litera][number] = 'O';
        }
        if (isDamage(litera, number)) {
            getBoard().degradableShip(litera, (number));
            if (getBoard().getInsideBoard()[litera][number] != 0) {
                getBoard().getNinjaBoard()[litera][number] = '✖';
                point--;
                mes = "Damage";
                System.out.println(mes);
            } else {
                getBoard().getNinjaBoard()[litera][number] = '❎';
                point--;
                mes = "Kill";
                System.out.println(mes);
            }
        }
    }

    boolean isDamage(int x, int y) {
        return getBoard().getInsideBoard()[x][y] != 0 && !isRepeat(x, y);
    }

    boolean isKill(int x, int y) {
        return mes.equals("Kill") && !isRepeat(x, y);
    }

    private boolean isRepeat(int a, int b) {
        return (getBoard().getNinjaBoard()[a][b] == 'O' || getBoard().getNinjaBoard()[a][b] == '✖' || getBoard().getNinjaBoard()[a][b] == '❎');
    }

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

    void readShot(String str) {
        if (str.length() == 2) {
            char c = str.charAt(0);
            int i = Integer.parseInt(str.substring(1));
            preShot(c, i);
        }
    }

    boolean isWin() {
        if (getPoint() == 0) {
            System.out.println("Player " + name + " win!");
        }
        return getPoint() == 0;
    }
}
