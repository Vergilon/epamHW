package com.epam.BattleShip;

public class EasyDifficult implements DifficultStrategy {

    /**
     * Special method for AI easy difficult. Shot in random cells.
     *
     * @param computer object of class Computer
     * @return boolean value depending on whether shooting
     * is allowed on this step again.
     */
    @Override
    public boolean shot(Computer computer) {
        computer.setX(computer.getBoard().getRandomNumberInRange(1, 11));
        computer.setY(computer.getBoard().getRandomNumberInRange(1, 11));

        int[] a = new int[]{computer.getX(), computer.getY()};
        if (!computer.isRepeat(computer.getX(), computer.getY())) {
            computer.shot(a);
            if (!computer.isMiss(computer.getX(), computer.getY())) {
                shot(computer);
                return false;
            }
            return false;
        } else {
            return true;
        }
    }
}
