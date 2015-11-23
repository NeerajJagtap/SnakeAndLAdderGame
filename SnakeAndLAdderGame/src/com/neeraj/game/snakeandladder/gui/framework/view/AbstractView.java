/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: AbstractView.java
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

import com.neeraj.game.snakeandladder.gui.framework.common.ModelChangeListener;

/**
 * The Class AbstractView.
 * @param <E> the element type
 * @param <C> the generic type
 */
public abstract class AbstractView<E, C> implements InterfaceView<E>, ModelChangeListener<E> {

    /** The model. */
    private E model;

    /** The controller. */
    private C controller;

    /**
     * Instantiates a new abstract view.
     */
    public AbstractView() {
        preBuild();
        build();
        postBuild();
    }

    /**
     * Instantiates a new abstract view.
     * @param model the model
     */
    public AbstractView(E model) {
        this.model = model;
        preBuild();
        build();
        postBuild();
    }

    /**
     * returning model.
     * @return the model
     */
    public E getModel() {
        return model;
    }

    /**
     * Sets the model.
     * @param model the model to set
     */
    public void setModel(E model) {
        this.model = model;
    }

    /**
     * Gets the controller.
     * @return the controller
     */
    public C getController() {
        return controller;
    }

    /**
     * Sets the controller.
     * @param controller the controller to set
     */
    public void setController(C controller) {
        this.controller = controller;
    }

}
