/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: ModelChangeListener.java
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
package com.neeraj.game.snakeandladder.gui.framework.common;

/**
 * The listener interface for receiving modelChange events. The class that is interested in processing a modelChange
 * event implements this interface, and the object created with that class is registered with a component using the
 * component's <code>addModelChangeListener<code> method. When
 * the modelChange event occurs, that object's appropriate
 * method is invoked.
 * @author niraj_jagtap
 * @param <E> the element type
 */
public interface ModelChangeListener<E> {

    /**
     * Model change.
     * @param model the model
     */
    public void modelChange(E model);

}
