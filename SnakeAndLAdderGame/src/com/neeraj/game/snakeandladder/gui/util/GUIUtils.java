/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: GUIUtils.java
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
package com.neeraj.game.snakeandladder.gui.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The Class GUIUtils.
 *
 * @author niraj_jagtap
 */
public class GUIUtils {

    /**
     * Sets the preferred size of comp.
     *
     * @param component the component
     * @param width the width
     * @param height the height
     */
    public static final void setPreferredSizeOfComp(Component component, int width, int height) {
        Dimension dimension = new Dimension(width, height);
        component.setPreferredSize(dimension);
        component.setMaximumSize(dimension);
        component.setMinimumSize(dimension);
    }

    /**
     * Gets the dialog at middle with modal.
     *
     * @param messageHeader the message header
     * @param message the message
     * @param color the color
     * @param dimension the dimension
     * @return the dialog at middle with modal
     */
    public static final JDialog getDialogAtMiddleWithModal(String messageHeader, String message, Color color,
            Dimension dimension) {
        JFrame f = new JFrame();
        JLabel labelMessage = new JLabel();
        final JDialog dialog = new JDialog(f, messageHeader, true);
        labelMessage.setForeground(color);
        labelMessage.setFont(new Font("Arial", Font.ITALIC, 15));
        labelMessage.setText(message);
        dialog.add(labelMessage);
        dialog.setSize(dimension);
        dialog.setLocationRelativeTo(null);
        return dialog;
    }
}
