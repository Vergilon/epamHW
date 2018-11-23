package com.epam.BattleShip;

import java.util.Scanner;

public class Game {

    private static Computer firstGamer;
    private static Computer secondGamer;

    private static void stepPlayer(Computer g) {
        boolean flag = true;
        while (flag && !g.isWin()) {
            Scanner in = new Scanner(System.in);
            System.out.println("Player: " + g.getName());
            g.getBoard().showNinjaBoard();
            System.out.println("Attack in: ");
            String s = in.nextLine();
            g.readShot(s);
            int c = g.convertChar(s.charAt(0));
            int i = Integer.parseInt(s.substring(1));
            if (!(g.isDamage(c, i) || g.isKill(c, i))) {
                flag = false;
            }
        }
    }

    private static void stepComp(Computer g) {
        boolean flag = true;
        while (flag && !g.isWin()) {
            System.out.println("Player: " + g.getName());
            g.getBoard().showNinjaBoard();
            System.out.println("Attack in: ");
            g.autoShot();
            System.out.println(g.getX() + " " + g.getY());
            int c = g.getX();
            int i = g.getY();
            if (!(g.isDamage(c, i) || g.isKill(c, i))) {
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        int h = 4;

        System.out.println("Battle Ship");
        Scanner in = new Scanner(System.in);
        System.out.print("Give names first player: ");
        firstGamer = new Computer(in.nextLine());
        System.out.println(" ");
        System.out.print("Give names second player: ");
        secondGamer = new Computer(in.nextLine());
        System.out.println(" ");
        System.out.println("Second player is computer: y/n");
        if (in.nextLine().equals("n")) {
            while (!firstGamer.isWin() && !secondGamer.isWin()) {
                if (h % 2 == 0) {
                    stepPlayer(firstGamer);
                    h++;
                } else {
                    stepPlayer(secondGamer);
                    h++;
                }
            }
            System.out.println(" ");
        } else {
            while (!firstGamer.isWin() && !secondGamer.isWin()) {
                if (h % 2 == 0) {
                    stepPlayer(firstGamer);
                    h++;
                } else {
                    stepComp(secondGamer);
                    h++;
                }
            }
            System.out.println(" ");
        }


    }
}
