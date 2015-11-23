/**
 * Project : SnakeAndLAdderGame Version: 1.0 File Name: SnakeAndLadderView.java
 * @developer: Niraj Jagtap Java Version: 1.6.0_xx date of draft: last update: Nov 23, 2015 Copyright � 2015, Pune/Main
 * All rights, including that of the extracts pressure, photomechanical reproduction (including microscopy), and the
 * evaluation of databases, or similar organizations, reserved.
 */
package com.neeraj.game.snakeandladder.gui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.neeraj.game.snakeandladder.common.exception.SnakeAndLadderException;
import com.neeraj.game.snakeandladder.common.exception.SnakeAndLadderExceptionConstants;
import com.neeraj.game.snakeandladder.gui.controller.SnakeAndLadderController;
import com.neeraj.game.snakeandladder.gui.framework.view.AbstractView;
import com.neeraj.game.snakeandladder.gui.model.SnakeAndLadderModel;
import com.neeraj.game.snakeandladder.gui.util.GUIUtils;

/**
 * The Class SnakeAndLadderView.
 * @author Niraj Jagtap
 */
public class SnakeAndLadderView extends AbstractView<SnakeAndLadderModel, SnakeAndLadderController> {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    // Constants
    /** The Constant MAIN_HEADER. */
    private static final String MAIN_HEADER = "Snake and Ladder Game";

    /** The Constant SNAKE_PANEL. */
    private static final String SNAKE_PANEL = "Panel Snake Board";

    /** The Constant PLAYERS_PANEL. */
    private static final String PLAYERS_PANEL = "Panel Players";

    /** The Constant ROLL_DICE_PANEL. */
    private static final String ROLL_DICE_PANEL = "Panel Roll Dice";

    /** The Constant PLAYER1_NAME. */
    private static final String PLAYER1_NAME = "Player1 Name";

    /** The Constant PLAYER2_NAME. */
    private static final String PLAYER2_NAME = "Player2 Name";

    /** The Constant START_GAME. */
    private static final String START_GAME = "Start Game";

    /** The Constant ROLL_DICE. */
    private static final String ROLL_DICE = "Roll Dice";

    /** The Constant RESET_GAME. */
    private static final String RESET_GAME = "Reset Game";

    /** The Constant ONE. */
    private static final String ONE = "1. ";

    /** The Constant TWO. */
    private static final String TWO = "2. ";

    /** The panel start. */
    private JPanel panelSnake, panelPlayers, panelRollDice, panelStart;

    /** The board panel. */
    BoardPanel boardPanel;

    /** The button start game. */
    private JButton buttonRollDice, buttonStartGame, buttonResetGame;

    /** The text field player2. */
    private JTextField textFieldPlayer1, textFieldPlayer2;

    /** The label dice image6. */
    private JLabel labelPlayer1, labelPlayer2, labelRollDicePlayer1, labelRollDicePlayer2, labelImageIcon1,
            labelImageIcon2, labelPlayer1Object, labelPlayer2Object, labelDiceImage1, labelDiceImage2, labelDiceImage3,
            labelDiceImage4, labelDiceImage5, labelDiceImage6;

    /** The frame main screen. */
    private JFrame frameMainScreen;

    /**
     * Instantiates a new snake and ladder view.
     * @param model the model
     */
    public SnakeAndLadderView(SnakeAndLadderModel model) {
        super(model);
    }

    /*
     * (non-Javadoc)
     * @see com.neeraj.game.snakeandladder.gui.view.AtomicView#preBuild()
     */
    @Override
    public void preBuild() {
        // Initialize main frame parameters
        frameMainScreen = new JFrame(MAIN_HEADER);
        frameMainScreen.setResizable(false);
        frameMainScreen.setSize(1100, 600);
        frameMainScreen.setLocationRelativeTo(null);
        frameMainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMainScreen.setLayout(new GridBagLayout());
        frameMainScreen.setResizable(false);

        // Initialize all Panels
        panelSnake = new JPanel(new GridBagLayout());
        panelPlayers = new JPanel(new GridBagLayout());
        panelRollDice = new JPanel(new GridBagLayout());
        try {
            boardPanel = new BoardPanel(new GridBagLayout());
        } catch (SnakeAndLadderException e) {
            JOptionPane.showMessageDialog(new JFrame("Alert"), e.getMessage(), "Board Panel Error",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        panelStart = new JPanel(new GridBagLayout());

        // Initialize Labels
        labelPlayer1 = new JLabel(PLAYER1_NAME);
        labelPlayer2 = new JLabel(PLAYER2_NAME);
        labelRollDicePlayer1 = new JLabel(PLAYER1_NAME);
        labelRollDicePlayer2 = new JLabel(PLAYER2_NAME);

        // Initialize Text Fields
        textFieldPlayer1 = new JTextField();
        textFieldPlayer2 = new JTextField();

        // Initialize Buttons
        buttonStartGame = new JButton(START_GAME);
        buttonRollDice = new JButton(ROLL_DICE);
        buttonResetGame = new JButton(RESET_GAME);

        // Image Icons
        initializeImages();
    }

    /**
     * Initialize images.
     */
    private void initializeImages() {
        try {
            BufferedImage bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Turn.png"));
            labelImageIcon1 = new JLabel(new ImageIcon(bufferedImage));
            GUIUtils.setPreferredSizeOfComp(labelImageIcon1, 50, 30);
            labelImageIcon2 = new JLabel(new ImageIcon(bufferedImage));
            GUIUtils.setPreferredSizeOfComp(labelImageIcon2, 50, 30);
            bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player1.png"));
            labelPlayer1Object = new JLabel(new ImageIcon(bufferedImage));
            GUIUtils.setPreferredSizeOfComp(labelPlayer1Object, 30, 50);
            bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player2.png"));
            labelPlayer2Object = new JLabel(new ImageIcon(bufferedImage));
            GUIUtils.setPreferredSizeOfComp(labelPlayer2Object, 30, 50);

            bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Dice_1.png"));
            labelDiceImage1 = new JLabel(new ImageIcon(bufferedImage));
            bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Dice_2.png"));
            labelDiceImage2 = new JLabel(new ImageIcon(bufferedImage));
            bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Dice_3.png"));
            labelDiceImage3 = new JLabel(new ImageIcon(bufferedImage));
            bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Dice_4.png"));
            labelDiceImage4 = new JLabel(new ImageIcon(bufferedImage));
            bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Dice_5.png"));
            labelDiceImage5 = new JLabel(new ImageIcon(bufferedImage));
            bufferedImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Dice_6.png"));
            labelDiceImage6 = new JLabel(new ImageIcon(bufferedImage));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * @see com.neeraj.game.snakeandladder.gui.framework.view.InterfaceView#build()
     */
    @Override
    public void build() {
        // Create Main Panel
        panelSnake.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), SNAKE_PANEL));
        GridBagConstraints gridBagConstraints = new GridBagConstraints(0, 0, 1, 2, 1.0, 1.0,
                GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 350, 0);
        frameMainScreen.add(panelSnake, gridBagConstraints);

        panelPlayers.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), PLAYERS_PANEL));
        gridBagConstraints = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
                GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 250, 0);
        frameMainScreen.add(panelPlayers, gridBagConstraints);

        panelRollDice.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), ROLL_DICE_PANEL));
        gridBagConstraints = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
                GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 250, 0);
        frameMainScreen.add(panelRollDice, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
                GridBagConstraints.BOTH, new Insets(10, 0, 10, 5), 0, 0);
        panelSnake.add(boardPanel, gridBagConstraints);

        createStartPanel();
        gridBagConstraints = new GridBagConstraints(0, 0, 1, 1, 0.1, 1.0, GridBagConstraints.SOUTHEAST,
                GridBagConstraints.NONE, new Insets(10, 0, 5, 0), 0, 0);
        panelSnake.add(panelStart, gridBagConstraints);
        // Creating player panel
        createPlayerPanel();
        // Create Roll Dice Panel
        createRollDicePanel();
    }

    /*
     * (non-Javadoc)
     * @see com.neeraj.game.snakeandladder.gui.view.AtomicView#postBuild()
     */
    @Override
    public void postBuild() {
        new SnakeAndLadderController(this, new SnakeAndLadderModel());
        resetAll();
    }

    /**
     * Reset all.
     */
    private void resetAll() {
        buttonRollDice.setEnabled(false);
        buttonStartGame.setEnabled(false);
        frameMainScreen.setVisible(true);
        labelImageIcon2.setVisible(false);
        labelImageIcon1.setVisible(false);
        labelDiceImage1.setVisible(false);
        labelDiceImage2.setVisible(false);
        labelDiceImage3.setVisible(false);
        labelDiceImage4.setVisible(false);
        labelDiceImage5.setVisible(false);
        labelDiceImage6.setVisible(false);
    }

    /**
     * Creates the start panel.
     */
    private void createStartPanel() {
        panelStart.add(labelPlayer1Object, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTHEAST,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        panelStart.add(labelPlayer2Object, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTHEAST,
                GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    }

    /**
     * Creates the player panel.
     */
    private void createPlayerPanel() {
        panelPlayers.add(labelPlayer1, new GridBagConstraints(0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
                GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
        panelPlayers.add(textFieldPlayer1, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 10), 0, 0));
        panelPlayers.add(labelPlayer2, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
        panelPlayers.add(textFieldPlayer2, new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
                GridBagConstraints.HORIZONTAL, new Insets(0, 10, 10, 10), 0, 0));
        panelPlayers.add(buttonStartGame, new GridBagConstraints(0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
        panelPlayers.add(buttonResetGame, new GridBagConstraints(1, 4, 1, 1, 1.0, 1.0, GridBagConstraints.EAST,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
    }

    /**
     * Creates the roll dice panel.
     */
    private void createRollDicePanel() {
        panelRollDice.add(labelRollDicePlayer1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(10, 10, 10, 5), 0, 0));
        panelRollDice.add(labelImageIcon1, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(10, 0, 10, 10), 0, 0));
        panelRollDice.add(labelRollDicePlayer2, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 5), 0, 0));
        panelRollDice.add(labelImageIcon2, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                GridBagConstraints.NONE, new Insets(0, 0, 10, 10), 0, 0));
        panelRollDice.add(buttonRollDice, new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
        panelRollDice.add(labelDiceImage1, new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
        panelRollDice.add(labelDiceImage2, new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
        panelRollDice.add(labelDiceImage3, new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
        panelRollDice.add(labelDiceImage4, new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
        panelRollDice.add(labelDiceImage5, new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
        panelRollDice.add(labelDiceImage6, new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                GridBagConstraints.NONE, new Insets(0, 10, 10, 10), 0, 0));
    }

    /**
     * Gets the button roll dice.
     * @return the buttonRollDice
     */
    public JButton getButtonRollDice() {
        return buttonRollDice;
    }

    /**
     * Gets the button start game.
     * @return the buttonStartGame
     */
    public JButton getButtonStartGame() {
        return buttonStartGame;
    }

    /**
     * Gets the text field player1.
     * @return the textFieldPlayer1
     */
    public JTextField getTextFieldPlayer1() {
        return textFieldPlayer1;
    }

    /**
     * Gets the text field player2.
     * @return the textFieldPlayer2
     */
    public JTextField getTextFieldPlayer2() {
        return textFieldPlayer2;
    }

    /**
     * Gets the button reset game.
     * @return the buttonResetGame
     */
    public JButton getButtonResetGame() {
        return buttonResetGame;
    }

    /**
     * Sets the player names.
     * @param player1 the player1
     * @param player2 the player2
     */
    public void setPlayerNames(String player1, String player2) {
        if (null != player1 && null != player2) {
            labelRollDicePlayer1.setText(ONE + player1);
            labelRollDicePlayer2.setText(TWO + player2);
            buttonRollDice.setEnabled(true);
        } else {
            labelRollDicePlayer1.setText(PLAYER1_NAME);
            labelRollDicePlayer2.setText(PLAYER2_NAME);
            buttonRollDice.setEnabled(false);
        }
    }

    /*
     * (non-Javadoc)
     * @see com.neeraj.game.snakeandladder.gui.framework.view.InterfaceView#closeAction()
     */
    @Override
    public void closeAction() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see com.neeraj.game.snakeandladder.gui.framework.view.InterfaceView#modelChange(java.lang.Object)
     */
    @Override
    public void modelChange(SnakeAndLadderModel model) {
        switch (model.getPropertyChange()) {
            case SET_PLAYER_NAMES:
                setPlayerNames(model.getPlayer1Name(), model.getPlayer2Name());
                labelImageIcon1.setVisible(true);
                break;

            case START_GAME:
                buttonStartGame.setEnabled(model.getIsStartGameEnabled());
                break;

            case ROLL_DICE:
                Integer diceNumber = model.getDiceNumber();
                // Load Dice Images
                loadAppropriateDiceImage(diceNumber);
                // Move Players coins
                movePlayerCoins(diceNumber, model);
                break;

            case RESET_GAME:
                resetGame(model);
                break;

            default:
                break;
        }

    }

    /**
     * Move player coins.
     * @param diceNumber the dice number
     * @param model the model
     */
    private void movePlayerCoins(Integer diceNumber, SnakeAndLadderModel model) {
        try {
            if (model.getChancePlayer1()) {
                // Remove starting icon of player 1
                labelPlayer1Object.setVisible(false);
                if (boardPanel.movePlayer1Coin(diceNumber, model)) {
                    labelImageIcon1.setVisible(false);
                    labelImageIcon2.setVisible(true);
                }
            } else {
                // Remove starting icon of player 2
                labelPlayer2Object.setVisible(false);
                if (boardPanel.movePlayer2Coin(diceNumber, model)) {
                    labelImageIcon1.setVisible(true);
                    labelImageIcon2.setVisible(false);
                }
            }
        } catch (SnakeAndLadderException e) {
            if (SnakeAndLadderExceptionConstants.GAME_FINISHED.equalsIgnoreCase(e.getMessageId())) {
                resetGame(model);
            } else {
                JOptionPane.showMessageDialog(new JFrame("Alert"), e.getMessage(), "Board Panel Error",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    /**
     * Reset game.
     * @param model the model
     */
    private void resetGame(SnakeAndLadderModel model) {
        resetAll();
        labelPlayer1Object.setVisible(true);
        labelPlayer2Object.setVisible(true);
        labelPlayer1.setText(PLAYER1_NAME);
        labelPlayer2.setText(PLAYER2_NAME);
        textFieldPlayer1.setText(null);
        textFieldPlayer2.setText(null);
        this.boardPanel.resetBoard();
        // Reset Model info
        getModel().setChancePlayer1(false);
        model.setPlayer1Position(-1);
        model.setPlayer2Position(-1);
    }

    /**
     * Load appropriate dice image.
     * @param diceNumber the dice number
     */
    private void loadAppropriateDiceImage(Integer diceNumber) {
        labelDiceImage1.setVisible(false);
        labelDiceImage2.setVisible(false);
        labelDiceImage3.setVisible(false);
        labelDiceImage4.setVisible(false);
        labelDiceImage5.setVisible(false);
        labelDiceImage6.setVisible(false);
        switch (diceNumber) {
            case 1:
                labelDiceImage1.setVisible(true);
                break;
            case 2:
                labelDiceImage2.setVisible(true);
                break;
            case 3:
                labelDiceImage3.setVisible(true);
                break;
            case 4:
                labelDiceImage4.setVisible(true);
                break;
            case 5:
                labelDiceImage5.setVisible(true);
                break;
            case 6:
                labelDiceImage6.setVisible(true);
                break;
            default:
                break;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.neeraj.game.snakeandladder.gui.framework.view.InterfaceView#modelState()
     */
    @Override
    public SnakeAndLadderModel modelState() {
        SnakeAndLadderModel model = new SnakeAndLadderModel();
        model.setPlayer1Name(textFieldPlayer1.getText().trim());
        model.setPlayer2Name(textFieldPlayer2.getText().trim());
        return model;
    }

}
