/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: InterfaceView.java
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
package com.neeraj.game.snakeandladder.gui.framework.view;

/**
 * The Interface InterfaceView.
 * @author niraj_jagtap
 * @param <E> the element type
 */
public interface InterfaceView<E> {

    /**
     * Pre build.
     */
    public void preBuild();

    /**
     * Builds the.
     */
    public void build();

    /**
     * Post build.
     */
    public void postBuild();

    /**
     * Close action.
     */
    public void closeAction();

    /**
     * Model state.
     * @return the e
     */
    public E modelState();

    /**
     * Model change.
     * @param model the model
     */
    public void modelChange(E model);
}
