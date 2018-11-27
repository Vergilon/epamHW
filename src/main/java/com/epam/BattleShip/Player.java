package com.epam.BattleShip;

public class Player {

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

    /**
     * Constructor for player. Point is number that have all part of all ships.
     *
     * @param name name of player.
     */
    Player(String name) {
        setBoard(new Board());
        setName(name);
        setPoint(20);
    }

    /**
     * Standard method for shooting. If shot doesn't hit the ship,
     * this method will output the message "Miss". If shot hit the ship,
     * but not kill, this method will output the message "Damage". If shot
     * kill the ship, this method will output the message "Kill". Besides,
     * this method display changes in board that are visible to the player.
     *
     * @param array input array containing two numbers (coordinates)
     * @return boolean value depending on whether shooting is allowed
     * on this step again.
     */
    boolean shot(int[] array) {
        int x = array[0];
        int y = array[1];
        String mes = "";
        if (!isRepeat(x, y)) {
            if (isMiss(x, y)) {
                mes = "Miss";
                System.out.println(mes);
                getBoard().getNinjaBoard()[x][y] = 'O';
                return false;
            } else {
                getBoard().degradableShip(x, y);
                if (isKill(x, y)) {
                    getBoard().getNinjaBoard()[x][y] = '❎';
                    point--;
                    mes = "Kill";
                    System.out.println(mes);
                    return true;
                }
                if (isDamage(x, y)) {
                    getBoard().getNinjaBoard()[x][y] = '✖';
                    point--;
                    mes = "Damage";
                    System.out.println(mes);
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return true;
        }
    }

    /**
     * Checker for damage on the ship.
     *
     * @param x is X axis cells value
     * @param y is Y axis cells value
     * @return boolean answer
     */
    boolean isDamage(int x, int y) {
        return getBoard().getInsideBoard()[x][y] > 0;
    }

    /**
     * Checker for kill on the ship.
     *
     * @param x is X axis cells value
     * @param y is Y axis cells value
     * @return boolean answer
     */
    boolean isKill(int x, int y) {
        return getBoard().getStabilityInsideBoard()[x][y] != 0 && getBoard().getInsideBoard()[x][y] == 0;
    }

    /**
     * Checker for repeat cell.
     *
     * @param x is X axis cells value
     * @param y is Y axis cells value
     * @return boolean answer
     */
    boolean isRepeat(int x, int y) {
        return !(getBoard().getNinjaBoard()[x][y] == '.');
    }

    /**
     * Checker for miss on the ship
     *
     * @param x is X axis cells value
     * @param y is Y axis cells value
     * @return boolean answer
     */
    boolean isMiss(int x, int y) {
        return !(isDamage(x, y) || isKill(x, y));
    }

    /**
     * Checker on win
     *
     * @return boolean answer
     */
    boolean isWin() {
        if (getPoint() == 0) {
            System.out.println("Player " + name + " win!");
        }
        return getPoint() == 0;
    }
}
