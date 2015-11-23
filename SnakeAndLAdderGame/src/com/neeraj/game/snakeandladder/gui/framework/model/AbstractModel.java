/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: AbstractModel.java
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
package com.neeraj.game.snakeandladder.gui.framework.model;

import com.neeraj.game.snakeandladder.gui.framework.view.InterfaceView;

/**
 * The Class AbstractModel.
 * @param <E> the element type
 */
public abstract class AbstractModel<E> {

    /** The view. */
    public InterfaceView<AbstractModel<E>> view;

    /** The property change. */
    public E propertyChange;

    /**
     * Gets the property change.
     * @return the property change
     */
    public E getPropertyChange() {
        return propertyChange;
    }

    /**
     * fire model change to take change in view.
     * @param propertyChange the property change
     */
    public void fireModelChange(E propertyChange) {
        this.propertyChange = propertyChange;
        view.modelChange(this);
    }

    /**
     * Gets the view.
     * @return the view
     */
    public InterfaceView getView() {
        return view;
    }

    /**
     * Sets the view.
     * @param view the view to set
     */
    public void setView(InterfaceView view) {
        this.view = view;
    }

}
