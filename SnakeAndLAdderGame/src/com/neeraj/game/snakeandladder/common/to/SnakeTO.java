/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: SnakeTO.java
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

import com.neeraj.game.snakeandladder.common.exception.SnakeAndLadderException;

/**
 * The Class SnakeTO.
 *
 * @author niraj_jagtap
 */
public class SnakeTO implements SnakeOrLadderObject {

    /** The start point. */
    private Integer startPoint;

    /** The end point. */
    private Integer endPoint;

    /**
     * Instantiates a new snake to.
     *
     * @param startPoint the start point
     * @param endPoint the end point
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    public SnakeTO(Integer startPoint, Integer endPoint) throws SnakeAndLadderException {
        if (startPoint > endPoint) {
            this.startPoint = startPoint - 1;
            this.endPoint = endPoint - 1;
        } else {
            throw new SnakeAndLadderException("SNAKE_1001", "Snake head should be larger than its tail");
        }
    }

    /**
     * Gets the start point.
     *
     * @return the startPoint
     */
    @Override
    public Integer getStartPoint() {
        return startPoint;
    }

    /**
     * Sets the start point.
     *
     * @param startPoint the startPoint to set
     */
    @Override
    public void setStartPoint(Integer startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * Gets the end point.
     *
     * @return the endPoint
     */
    @Override
    public Integer getEndPoint() {
        return endPoint;
    }

    /**
     * Sets the end point.
     *
     * @param endPoint the endPoint to set
     */
    @Override
    public void setEndPoint(Integer endPoint) {
        this.endPoint = endPoint;
    }

}
