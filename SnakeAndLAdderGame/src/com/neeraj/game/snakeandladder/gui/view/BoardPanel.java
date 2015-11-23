/**
 * Project : SnakeAndLAdderGame Version: 1.0 File Name: BoardPanel.java
 * @developer: Niraj Jagtap Java Version: 1.6.0_xx date of draft: last update: Nov 23, 2015 Copyright � 2015, Pune/Main
 * All rights, including that of the extracts pressure, photomechanical reproduction (including microscopy), and the
 * evaluation of databases, or similar organizations, reserved.
 */
package com.neeraj.game.snakeandladder.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.neeraj.game.snakeandladder.common.exception.SnakeAndLadderException;
import com.neeraj.game.snakeandladder.common.exception.SnakeAndLadderExceptionConstants;
import com.neeraj.game.snakeandladder.common.to.SnakeOrLadderObject;
import com.neeraj.game.snakeandladder.gui.model.SnakeAndLadderModel;
import com.neeraj.game.snakeandladder.gui.util.GUIUtils;
import com.neeraj.game.snakeandladder.gui.util.PropertyFileLoader;

/**
 * The Class BoardPanel.
 * @author niraj_jagtap
 */
public class BoardPanel extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The Constant CONGRAT_HEADER. */
    private static final String CONGRAT_HEADER = "Congratulations You WON!";

    /** The Constant WON_THE_GAME. */
    private static final String WON_THE_GAME = " you Won the Game!!!";

    /** The Constant STARS. */
    private static final String STARS = "***";

    /** The player2 alerted about finish. */
    private Boolean player1AlertedAboutFinish = false, player2AlertedAboutFinish = false;

    /** The square panel. */
    private SquarePanel squarePanel;

    /**
     * Instantiates a new board panel.
     * @param layout the layout
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    public BoardPanel(GridBagLayout layout) throws SnakeAndLadderException {
        super(layout);
        createBoard();
    }

    /**
     * Creates the board.
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    private void createBoard() throws SnakeAndLadderException {
        // Read Property file
        // Load board dimensions
        PropertyFileLoader propertyFileLoader = new PropertyFileLoader();
        Integer[] boardDimension = propertyFileLoader.loadBoardDimension();
        // Load Snakes and Ladders
        Map<Integer, SnakeOrLadderObject> map = propertyFileLoader.loadSnakesAndLadders();
        // Initial y max and x max
        int ymax = boardDimension[1], xmax = boardDimension[0];
        // initialize xmin
        int xmin = 0;
        // Boolean for changing traverse
        boolean isXchanged = false;
        int x = 0, y = 0;
        for (int index = 0; index < xmax * ymax; index++) {
            if (x == xmax - 1) {
                isXchanged = true;
            } else if (x == xmin) {
                isXchanged = false;
            }
            squarePanel = new SquarePanel(String.valueOf(index + 1), map.get(index));
            if (isXchanged) {
                x = (xmax - 1) - (index % xmax);
            } else {
                x = index % xmax;
            }
            y = index / xmax;
            this.add(squarePanel, new GridBagConstraints(x, ymax - y, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
                    GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        }
    }

    /**
     * Move player1 coin.
     * @param diceNumber the dice number
     * @param model the model
     * @return true, if successful
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    public boolean movePlayer1Coin(Integer diceNumber, SnakeAndLadderModel model) throws SnakeAndLadderException {
        Integer newPosition = 0, olderPosition = 0;

        // Check new position
        newPosition = model.getPlayer1Position();
        // Check if it is last
        if (newPosition < 120) {
            if (!((SquarePanel) this.getComponent(newPosition)).getIsOccupied()) {
                SnakeOrLadderObject snakeOrLadderObject = null;
                olderPosition = newPosition - diceNumber;
                // Remove older Image Position
                // Check if this is not first chance
                if (olderPosition >= 0) {
                    ((SquarePanel) this.getComponent(olderPosition)).unloadPlayerImage();
                }
                // Add new Image position
                SquarePanel squarePanelNewPosition = ((SquarePanel) this.getComponent(newPosition));
                snakeOrLadderObject = squarePanelNewPosition.loadPlayer1Image();

                // If SOLO object is not null means the position is having ladder or snake
                if (null != snakeOrLadderObject) {
                    squarePanelNewPosition.unloadPlayerImage();
                    // If not null then move to new position
                    newPosition = snakeOrLadderObject.getEndPoint();
                    model.setPlayer1Position(newPosition);
                    snakeOrLadderObject = ((SquarePanel) this.getComponent(newPosition)).loadPlayer1Image();
                }
                if (newPosition == 119) {
                    wonTheGameMessage(model.getPlayer1Name());
                    throw new SnakeAndLadderException(SnakeAndLadderExceptionConstants.GAME_FINISHED,
                            "Game finished and loading again!");
                }
            } else {
                // Set Player1 position to original
                model.setPlayer1Position(newPosition - diceNumber);
                cantMoveMessage(model.getPlayer1Name());
                return false;
            }
        } else {
            model.setPlayer1Position(newPosition - diceNumber);
            if (!player1AlertedAboutFinish) {
                pleaseTryAgainMessage(model.getPlayer1Name(), true);
            }
        }
        return true;
    }

    /**
     * Move player2 coin.
     * @param diceNumber the dice number
     * @param model the model
     * @return true, if successful
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    public boolean movePlayer2Coin(Integer diceNumber, SnakeAndLadderModel model) throws SnakeAndLadderException {
        Integer newPosition = 0, olderPosition = 0;
        // Check new position
        newPosition = model.getPlayer2Position();
        if (newPosition < 120) {
            if (!((SquarePanel) this.getComponent(newPosition)).getIsOccupied()) {
                SnakeOrLadderObject snakeOrLadderObject = null;
                olderPosition = newPosition - diceNumber;
                // Remove older Image Position
                // Check if this is not first chance
                if (olderPosition >= 0) {
                    ((SquarePanel) this.getComponent(olderPosition)).unloadPlayerImage();
                }
                // Add new Image position
                SquarePanel squarePanelNewPosition = ((SquarePanel) this.getComponent(newPosition));
                snakeOrLadderObject = squarePanelNewPosition.loadPlayer2Image();
                // If SOLO object is not null means the position is having ladder or snake
                if (null != snakeOrLadderObject) {
                    squarePanelNewPosition.unloadPlayerImage();
                    // If not null then move to new position
                    newPosition = snakeOrLadderObject.getEndPoint();
                    model.setPlayer2Position(newPosition);
                    snakeOrLadderObject = ((SquarePanel) this.getComponent(newPosition)).loadPlayer2Image();
                }
                if (newPosition == 119) {
                    wonTheGameMessage(model.getPlayer2Name());
                    throw new SnakeAndLadderException(SnakeAndLadderExceptionConstants.GAME_FINISHED,
                            "Game finished and loading again!");
                }
            } else {
                // Set Player1 position to original
                model.setPlayer2Position(newPosition - diceNumber);
                cantMoveMessage(model.getPlayer2Name());
                return false;
            }
        } else {
            model.setPlayer2Position(newPosition - diceNumber);
            if (!player2AlertedAboutFinish) {
                pleaseTryAgainMessage(model.getPlayer2Name(), false);
            }
        }
        return true;
    }

    /**
     * Cant move message.
     * @param playerNmae the playerNmae
     */
    private void cantMoveMessage(String playerNmae) {
        // Alert that you can't move as position is occupied
        final JDialog dialog = GUIUtils.getDialogAtMiddleWithModal("You can't Move!", playerNmae
                + " You can't move as position is occupied", Color.BLACK, new Dimension(300, 70));
        Timer timer = new Timer(3000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }

    /**
     * Won the game message.
     * @param playerName the player name
     */
    private void wonTheGameMessage(String playerName) {
        // Alert that he won the game
        final JDialog dialog = GUIUtils.getDialogAtMiddleWithModal(CONGRAT_HEADER, STARS + playerName + WON_THE_GAME,
                Color.BLACK, new Dimension(300, 70));
        Timer timer = new Timer(4000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }

    /**
     * Please try again message.
     * @param playerName the player name
     * @param player1 the player1
     */
    private void pleaseTryAgainMessage(String playerName, Boolean player1) {
        if (player1) {
            player1AlertedAboutFinish = true;
        } else {
            player2AlertedAboutFinish = true;
        }
        // Alert that player need exact number to finish the game
        final JDialog dialog = GUIUtils.getDialogAtMiddleWithModal("Warning!", playerName
                + " You need exact number to finish thos game.", Color.BLACK, new Dimension(300, 70));
        Timer timer = new Timer(3000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }

    /**
     * Reset board.
     */
    public void resetBoard() {
        for (int index = 0; index < this.getComponentCount(); index++) {
            SquarePanel squarePanel = (SquarePanel) this.getComponent(index);
            squarePanel.clearPanel();
        }
    }

}
