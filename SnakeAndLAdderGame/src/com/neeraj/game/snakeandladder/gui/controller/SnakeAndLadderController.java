/**
 * Project : SnakeAndLAdderGame Version: 1.0 File Name: SnakeAndLadderController.java
 * @developer: Niraj Jagtap Java Version: 1.6.0_xx date of draft: last update: Nov 23, 2015 Copyright � 2015, Pune/Main
 * All rights, including that of the extracts pressure, photomechanical reproduction (including microscopy), and the
 * evaluation of databases, or similar organizations, reserved.
 */
package com.neeraj.game.snakeandladder.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ThreadLocalRandom;

import com.neeraj.game.snakeandladder.common.CommonConstants;
import com.neeraj.game.snakeandladder.gui.framework.controller.AbstractController;
import com.neeraj.game.snakeandladder.gui.model.SnakeAndLadderModel;
import com.neeraj.game.snakeandladder.gui.view.SnakeAndLadderView;

/**
 * The Class SnakeAndLadderController.
 * @author niraj_jagtap
 */
public class SnakeAndLadderController extends AbstractController<SnakeAndLadderView, SnakeAndLadderModel> {

    /**
     * Instantiates a new snake and ladder controller.
     * @param view the view
     * @param model the model
     */
    public SnakeAndLadderController(SnakeAndLadderView view, SnakeAndLadderModel model) {
        super(view, model);
        model.setView(view);
        initialize();
    }

    /**
     * Initialize.
     */
    public void initialize() {
        createActionListeners();
    }

    /**
     * Creates the action listeners.
     */
    private void createActionListeners() {

        getView().getButtonStartGame().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SnakeAndLadderModel modelState = getView().modelState();
                getModel().setPlayer1Name(modelState.getPlayer1Name());
                getModel().setPlayer2Name(modelState.getPlayer2Name());
                getModel().setPlayerNames();
            }
        });

        getView().getButtonRollDice().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Roll dice with random number generator
                Integer randomNumber = ThreadLocalRandom.current().nextInt(1, 7);
                // set random number
                getModel().setDiceNumber(randomNumber);
            }
        });

        getView().getButtonResetGame().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getModel().resetGame();
            }
        });

        getView().getTextFieldPlayer1().addKeyListener(keyListener);
        getView().getTextFieldPlayer2().addKeyListener(keyListener);
    }

    // Create Key Listener for both text boxes
    /** The key listener. */
    private KeyListener keyListener = new KeyListener() {

        @Override
        public void keyTyped(KeyEvent e) {
            // Do nothing
        }

        @Override
        public void keyReleased(KeyEvent e) {
            SnakeAndLadderModel model = getView().modelState();
            // Button Start Game Enabled or disabled
            getModel().setIsStartGameEnabled(
                    (null != model.getPlayer1Name() && !CommonConstants.EMPTY_STRING.equals(model.getPlayer1Name()
                            .trim()))
                            && (null != model.getPlayer2Name() && !CommonConstants.EMPTY_STRING.equals(model
                                    .getPlayer2Name().trim())));
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // Do Nothing
        }
    };

}
