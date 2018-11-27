package com.epam.BattleShip;

import java.util.Scanner;

/**
 * Game is the main class, which collects all the necessary elements
 * to activate the game of sea battle.
 *
 * @author Roman Moderatov
 * @version 1.0
 * @since 1.8
 */
public class Game {
    static Scanner in = new Scanner(System.in);

    /**
     * This method activate game for real player
     *
     * @param g is object class Gamer
     */
    private static void stepPlayer(Gamer g) {

        while (!g.isWin()) {
            System.out.println("Player: " + g.getName());
            g.getBoard().showNinjaBoard();
            System.out.println("Attack in: ");
            String s = in.nextLine();
            if (g.shot(g.readShot(s))) {
                stepPlayer(g);
                break;
            } else {
                break;
            }
        }
    }

    /**
     * This method activate game for computer player
     *
     * @param g is object class Computer
     */
    private static void stepComp(Computer g) {
        while (!g.isWin()) {
            System.out.println("Player: " + g.getName());
            g.getBoard().showNinjaBoard();
            System.out.println("Attack in: ");
            if (g.computerShot()) {
                stepComp(g);
                break;
            } else {
                break;
            }
        }
    }

    /**
     * Main working method.
     *
     * @param args for working in console (for example cmd)
     */
    public static void main(String[] args) {
        int h = 2;

        System.out.println("Battle Ship");
        System.out.print("Select game mode: HUMAN vs HUMAN (hh) or HUMAN vs COMPUTER (hc): ");
        String s = in.nextLine();
        if (s.equals("hh")) {
            System.out.println(" ");
            System.out.print("Name of the first player: ");
            Gamer firstPlayer = new Gamer(in.nextLine());
            System.out.print("Name of the second player: ");
            Gamer secondPlayer = new Gamer(in.nextLine());
            System.out.println(" ");
            while (!firstPlayer.isWin() && !secondPlayer.isWin()) {
                System.out.println("Step " + (h - 2));
                if (h % 2 == 0) {
                    stepPlayer(firstPlayer);
                    h++;
                } else {
                    stepPlayer(secondPlayer);
                    h++;
                }
            }
        } else if (s.equals("hc")) {
            System.out.println(" ");
            System.out.print("Name of the first player: ");
            Gamer player = new Gamer(in.nextLine());
            System.out.println(" ");
            System.out.println("Chose difficult: easy or normal?");
            DifficultStrategy dif;
            String d = in.nextLine();
            if (d.equals("easy")) {
                dif = new EasyDifficult();
            } else if (d.equals("normal")) {
                dif = new HumanDifficult();
            } else {
                throw new IllegalArgumentException();
            }
            Computer computer = new Computer("Computer", dif);
            while (!player.isWin() && !computer.isWin()) {
                if (h % 2 == 0) {
                    stepPlayer(player);
                    h++;
                } else {
                    stepComp(computer);
                    h++;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
