/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: SnakeAndLadderStarter.java
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
package com.neeraj.game.snakeandladder;

import java.awt.EventQueue;

import com.neeraj.game.snakeandladder.gui.model.SnakeAndLadderModel;
import com.neeraj.game.snakeandladder.gui.view.SnakeAndLadderView;

/**
 * The Class SnakeAndLadderStarter.
 *
 * @author Niraj Jagtap
 */
public class SnakeAndLadderStarter {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new SnakeAndLadderView(new SnakeAndLadderModel());
            }
        });
    }

}
