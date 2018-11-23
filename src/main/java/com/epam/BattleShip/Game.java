package com.epam.BattleShip;

import java.util.Scanner;

public class Game {

    private static Gamer firstGamer;
    private static Gamer secondGamer;

    public static void main(String[] args) {
        System.out.println("Battle Ship");
        Scanner in = new Scanner(System.in);
        System.out.print("Give names first player: ");
        firstGamer = new Gamer(in.nextLine());
        System.out.println(" ");
        System.out.print("Give names second player: ");
        secondGamer = new Gamer(in.nextLine());
        System.out.println(" ");
        int h = 4;

        while (!firstGamer.isWin() && !secondGamer.isWin()) {
            if (h % 2 == 0) {
                boolean flag = true;
                while (flag && !firstGamer.isWin()) {
                    System.out.println("Player: " + firstGamer.getName());
                    firstGamer.getBoard().showNinjaBoard();
                    System.out.println("Attack in: ");
                    String s = in.nextLine();
                    firstGamer.readShot(s);
                    int c = firstGamer.convertChar(s.charAt(0));
                    int i = Integer.parseInt(s.substring(1));
                    System.out.println(!firstGamer.isDamage(c, i));
                    System.out.println(!firstGamer.isKill(c, i));
                    if (!(firstGamer.isDamage(c, i) || firstGamer.isKill(c, i))) {
                        flag = false;
                    }
                }
                h++;
            } else {
                boolean flag = true;
                while (flag && !secondGamer.isWin()) {
                    System.out.println("Player: " + secondGamer.getName());
                    secondGamer.getBoard().showNinjaBoard();
                    System.out.println("Attack in: ");
                    String s = in.nextLine();
                    secondGamer.readShot(s);
                    int c = secondGamer.convertChar(s.charAt(0));
                    int i = Integer.parseInt(s.substring(1));
                    System.out.println(!secondGamer.isDamage(c, i));
                    System.out.println(!secondGamer.isKill(c, i));
                    if (!(secondGamer.isDamage(c, i) || secondGamer.isKill(c, i))) {
                        flag = false;
                    }
                }
                h++;
            }
        }
        System.out.println(" ");
    }
}
