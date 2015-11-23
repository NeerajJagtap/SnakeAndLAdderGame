/**
 * Project : SnakeAndLAdderGame Version: 1.0 File Name: SnakeAndLadderException.java
 * @developer: Niraj Jagtap Java Version: 1.6.0_xx date of draft: last update: Nov 23, 2015 Copyright � 2015, Pune/Main
 * All rights, including that of the extracts pressure, photomechanical reproduction (including microscopy), and the
 * evaluation of databases, or similar organizations, reserved.
 */
package com.neeraj.game.snakeandladder.common.exception;

/**
 * The Class SnakeAndLadderException.
 * @author Niraj Jagtap
 */
public class SnakeAndLadderException extends Exception {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The message id. */
    private String messageId;

    /**
     * Instantiates a new snake and ladder exception.
     */
    public SnakeAndLadderException() {
        super();
    }

    /**
     * Instantiates a new snake and ladder exception.
     * @param messageId the message id
     * @param message the message
     */
    public SnakeAndLadderException(String messageId, String message) {
        super(message);
        this.messageId = messageId;
    }

    /**
     * Gets the message id.
     *
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }

}
