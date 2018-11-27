package com.epam.BattleShip;

/**
 * This interface is necessary for realization Strategy pattern.
 * In this case, this pattern using for chosen difficult in AI computer.
 */
public interface DifficultStrategy {
    boolean shot(Computer computer);
}
