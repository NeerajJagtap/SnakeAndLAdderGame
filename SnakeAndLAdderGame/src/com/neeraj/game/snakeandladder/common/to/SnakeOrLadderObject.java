/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: SnakeOrLadderObject.java
 * @developer: Niraj Jagtap
 * Java Version: 1.6.0_xx
 * date of draft:
 * last update:  Nov 23, 2015
 *
 * Copyright ? 2015,
 * Pune/Main
 * All rights, including that of the extracts pressure,
 * photomechanical reproduction (including microscopy),
 * and the evaluation of databases, or similar
 * organizations, reserved.
 *
 */
package com.neeraj.game.snakeandladder.common.to;

/**
 * The Interface SnakeOrLadderObject.
 *
 * @author niraj_jagtap
 */
public interface SnakeOrLadderObject {

    /**
     * Gets the start point.
     *
     * @return the start point
     */
    public Integer getStartPoint();

    /**
     * Sets the start point.
     *
     * @param startPoint the new start point
     */
    public void setStartPoint(Integer startPoint);

    /**
     * Gets the end point.
     *
     * @return the end point
     */
    public Integer getEndPoint();

    /**
     * Sets the end point.
     *
     * @param endPoint the new end point
     */
    public void setEndPoint(Integer endPoint);
}
