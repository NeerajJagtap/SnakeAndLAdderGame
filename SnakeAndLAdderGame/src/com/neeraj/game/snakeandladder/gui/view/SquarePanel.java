/**
 * Project : SnakeAndLAdderGame Version: 1.0 File Name: SquarePanel.java
 * @developer: Niraj Jagtap Java Version: 1.6.0_xx date of draft: last update: Nov 23, 2015 Copyright � 2015, Pune/Main
 * All rights, including that of the extracts pressure, photomechanical reproduction (including microscopy), and the
 * evaluation of databases, or similar organizations, reserved.
 */
package com.neeraj.game.snakeandladder.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.neeraj.game.snakeandladder.common.exception.SnakeAndLadderException;
import com.neeraj.game.snakeandladder.common.to.LadderTO;
import com.neeraj.game.snakeandladder.common.to.SnakeOrLadderObject;
import com.neeraj.game.snakeandladder.common.to.SnakeTO;
import com.neeraj.game.snakeandladder.gui.util.GUIUtils;

/**
 * The Class SquarePanel.
 * @author niraj_jagtap
 */
public class SquarePanel extends JPanel {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The square number. */
    private String squareNumber;

    /** The is occupied. */
    private Boolean isSnakeHead = false, isLadderStart = false, isOccupied = false;

    /** The snake or ladder object. */
    private SnakeOrLadderObject snakeOrLadderObject;

    /** The label image player2. */
    private JLabel labelSquareNumber, labelImageIcon, labelImagePlayer1, labelImagePlayer2;

    /**
     * Instantiates a new square panel.
     * @param squareNumber the square number
     * @param snakeOrLadderObject the snake or ladder object
     */
    public SquarePanel(String squareNumber, SnakeOrLadderObject snakeOrLadderObject) {
        this.squareNumber = squareNumber;
        this.isOccupied = false;
        this.snakeOrLadderObject = snakeOrLadderObject;
        init();
    }

    /**
     * Inits the.
     */
    private void init() {
        this.setLayout(new GridBagLayout());
        GUIUtils.setPreferredSizeOfComp(this, 60, 50);
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setBackground(Color.CYAN);

        labelSquareNumber = new JLabel(squareNumber);
        labelSquareNumber.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(labelSquareNumber, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0));

        // Check if this is snake or ladder object
        if (this.snakeOrLadderObject instanceof SnakeTO) {
            this.isSnakeHead = true;
        } else if (this.snakeOrLadderObject instanceof LadderTO) {
            this.isLadderStart = true;
        }
        setImage();
    }

    /**
     * Sets the image.
     */
    private void setImage() {
        BufferedImage bufferedImage = null;
        if (isSnakeHead) {
            try {
                bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("SnakeHead.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            labelImageIcon = new JLabel(new ImageIcon(bufferedImage));
            this.add(labelImageIcon, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        } else if (isLadderStart) {
            try {
                bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Ladder.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            labelImageIcon = new JLabel(new ImageIcon(bufferedImage));
            this.add(labelImageIcon, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                    GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        }
        try {
            labelImagePlayer1 = new JLabel(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream(
                    "player1.png"))));
            labelImagePlayer2 = new JLabel(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream(
                    "player2.png"))));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.add(labelImagePlayer1, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        this.add(labelImagePlayer2, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

        // Show only initial Images
        if (null != labelImageIcon) {
            labelImageIcon.setVisible(true);
        }
        labelImagePlayer1.setVisible(false);
        labelImagePlayer2.setVisible(false);
    }

    /**
     * Gets the checks if is occupied.
     * @return the isOccupied
     */
    public Boolean getIsOccupied() {
        return isOccupied;
    }

    /**
     * Sets the checks if is occupied.
     * @param isOccupied the isOccupied to set
     */
    public void setIsOccupied(Boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    /**
     * Gets the square number.
     * @return the squareNumber
     */
    public String getSquareNumber() {
        return squareNumber;
    }

    /**
     * Gets the checks if is snake head.
     * @return the isSnakeHead
     */
    public Boolean getIsSnakeHead() {
        return isSnakeHead;
    }

    /**
     * Gets the checks if is ladder start.
     * @return the isLadderStart
     */
    public Boolean getIsLadderStart() {
        return isLadderStart;
    }

    /**
     * Load player1 image.
     * @return the snake or ladder object
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    public SnakeOrLadderObject loadPlayer1Image() throws SnakeAndLadderException {
        isOccupied = true;
        // Load Player Image
        if (null != labelImageIcon) {
            labelImageIcon.setVisible(false);
        }
        labelImagePlayer1.setVisible(true);
        labelImagePlayer2.setVisible(false);
        // Check if Snake or ladder present
        if (isSnakeHead || isLadderStart) {
            findBySnakeOrLadder();
            // Set original Icon
            labelImageIcon.setVisible(true);
            labelImagePlayer1.setVisible(false);
            labelImagePlayer2.setVisible(false);
            // Move player to new position
            return snakeOrLadderObject;
        }
        return null;
    }

    /**
     * Load player2 image.
     * @return the snake or ladder object
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    public SnakeOrLadderObject loadPlayer2Image() throws SnakeAndLadderException {
        isOccupied = true;
        // Load Player 2 Image
        if (null != labelImageIcon) {
            labelImageIcon.setVisible(false);
        }
        labelImagePlayer1.setVisible(false);
        labelImagePlayer2.setVisible(true);
        // Check if Snake or ladder present
        if (isSnakeHead || isLadderStart) {
            findBySnakeOrLadder();
            // Set original Icon
            labelImageIcon.setVisible(true);
            labelImagePlayer1.setVisible(false);
            labelImagePlayer2.setVisible(false);
            // Move player to new position
            return snakeOrLadderObject;
        }
        return null;
    }

    /**
     * Unload player image.
     */
    public void unloadPlayerImage() {
        isOccupied = false;
        if (null != labelImageIcon) {
            labelImageIcon.setVisible(true);
        }
        labelImagePlayer1.setVisible(false);
        labelImagePlayer2.setVisible(false);
    }

    /**
     * Find by snake or ladder.
     */
    private void findBySnakeOrLadder() {
        String messageHeader = null, message = null;
        Color color = null;
        if (isSnakeHead) {
            messageHeader = "OOps!!!";
            message = "You are eaten by Snake... :(";
            color = Color.RED;
        } else if (isLadderStart) {
            messageHeader = "Waw!!!";
            message = "Its A Ladder... :)";
            color = Color.GREEN;
        }
        final JDialog dialog = GUIUtils.getDialogAtMiddleWithModal(messageHeader, message, color,
                new Dimension(200, 50));

        Timer timer = new Timer(2000, new ActionListener() {

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
     * Clear panel.
     */
    public void clearPanel() {
        this.isOccupied = false;
        this.labelImagePlayer1.setVisible(false);
        this.labelImagePlayer2.setVisible(false);
    }
}
