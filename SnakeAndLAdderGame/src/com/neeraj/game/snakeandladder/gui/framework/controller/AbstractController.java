/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: AbstractController.java
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
package com.neeraj.game.snakeandladder.gui.framework.controller;

/**
 * The Class AbstractController.
 * @param <E> the element type
 * @param <T> the generic type
 */
public abstract class AbstractController<E, T> {

    /** The model. */
    private T model;

    /** The view. */
    private E view;

    /**
     * Instantiates a new abstract controller.
     * @param view the view
     * @param model the model
     */
    public AbstractController(E view, T model) {
        this.model = model;
        this.view = view;
    }

    /**
     * Gets the model.
     * @return the model
     */
    public T getModel() {
        return model;
    }

    /**
     * Sets the model.
     * @param model the model to set
     */
    public void setModel(T model) {
        this.model = model;
    }

    /**
     * Gets the view.
     * @return the view
     */
    public E getView() {
        return view;
    }

    /**
     * Sets the view.
     * @param view the view to set
     */
    public void setView(E view) {
        this.view = view;
    }

}
