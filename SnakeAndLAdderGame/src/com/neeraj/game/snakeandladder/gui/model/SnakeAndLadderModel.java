/**
 * Project : SnakeAndLAdderGame Version: 1.0 File Name: SnakeAndLadderModel.java
 * @developer: Niraj Jagtap Java Version: 1.6.0_xx date of draft: last update: Nov 23, 2015 Copyright � 2015, Pune/Main
 * All rights, including that of the extracts pressure, photomechanical reproduction (including microscopy), and the
 * evaluation of databases, or similar organizations, reserved.
 */
package com.neeraj.game.snakeandladder.gui.model;

import com.neeraj.game.snakeandladder.gui.framework.model.AbstractModel;

/**
 * The Class SnakeAndLadderModel.
 * @author niraj_jagtap
 */
public class SnakeAndLadderModel extends AbstractModel<SnakeAndLadderModel.property> {

    /** The player1 name. */
    private String player1Name;

    /** The player2 name. */
    private String player2Name;

    /** The player1 position. */
    private Integer player1Position = -1;

    /** The player2 position. */
    private Integer player2Position = -1;

    /** The is start game enabled. */
    private Boolean isStartGameEnabled;

    /** The dice number. */
    private Integer diceNumber;

    /** The chance player1. */
    private Boolean chancePlayer1 = false;

    /**
     * The Enum property.
     */
    public enum property {

        /** The set player names. */
        SET_PLAYER_NAMES,

        /** The start game. */
        START_GAME,

        /** The roll dice. */
        ROLL_DICE,

        /** The reset game. */
        RESET_GAME
    }

    /**
     * Gets the player1 name.
     * @return the player1Name
     */
    public String getPlayer1Name() {
        return player1Name;
    }

    /**
     * Sets the player1 name.
     * @param player1Name the player1Name to set
     */
    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    /**
     * Gets the player2 name.
     * @return the player2Name
     */
    public String getPlayer2Name() {
        return player2Name;
    }

    /**
     * Sets the player2 name.
     * @param player2Name the player2Name to set
     */
    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    /**
     * Sets the player names.
     */
    public void setPlayerNames() {
        fireModelChange(property.SET_PLAYER_NAMES);
    }

    /**
     * Gets the player1 position.
     * @return the player1Position
     */
    public Integer getPlayer1Position() {
        return player1Position;
    }

    /**
     * Sets the player1 position.
     * @param player1Position the player1Position to set
     */
    public void setPlayer1Position(Integer player1Position) {
        this.player1Position = player1Position;
    }

    /**
     * Gets the player2 position.
     * @return the player2Position
     */
    public Integer getPlayer2Position() {
        return player2Position;
    }

    /**
     * Sets the player2 position.
     * @param player2Position the player2Position to set
     */
    public void setPlayer2Position(Integer player2Position) {
        this.player2Position = player2Position;
    }

    /**
     * Gets the checks if is start game enabled.
     * @return the isStartGameEnabled
     */
    public Boolean getIsStartGameEnabled() {
        return isStartGameEnabled;
    }

    /**
     * Sets the checks if is start game enabled.
     * @param isStartGameEnabled the isStartGameEnabled to set
     */
    public void setIsStartGameEnabled(Boolean isStartGameEnabled) {
        this.isStartGameEnabled = isStartGameEnabled;
        fireModelChange(property.START_GAME);
    }

    /**
     * Gets the dice number.
     * @return the diceNumber
     */
    public Integer getDiceNumber() {
        return diceNumber;
    }

    /**
     * Sets the dice number.
     * @param diceNumber the diceNumber to set
     */
    public void setDiceNumber(Integer diceNumber) {
        this.diceNumber = diceNumber;
        // Set opposite players chance
        this.chancePlayer1 = !this.chancePlayer1;
        // Recalculate position
        if (chancePlayer1) {
            player1Position = player1Position + diceNumber;
        } else {
            player2Position = player2Position + diceNumber;
        }
        fireModelChange(property.ROLL_DICE);
    }

    /**
     * Gets the chance player1.
     * @return the chancePlayer1
     */
    public Boolean getChancePlayer1() {
        return chancePlayer1;
    }

    /**
     * Sets the chance player1.
     * @param chancePlayer1 the chancePlayer1 to set
     */
    public void setChancePlayer1(Boolean chancePlayer1) {
        this.chancePlayer1 = chancePlayer1;
    }

    /**
     * Reset game.
     */
    public void resetGame() {
        fireModelChange(property.RESET_GAME);
    }

}
