/**
 * Project : SnakeAndLAdderGame
 * Version: 1.0
 *
 * File Name: PropertyFileLoader.java
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

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.neeraj.game.snakeandladder.common.exception.SnakeAndLadderException;
import com.neeraj.game.snakeandladder.common.to.LadderTO;
import com.neeraj.game.snakeandladder.common.to.SnakeOrLadderObject;
import com.neeraj.game.snakeandladder.common.to.SnakeTO;

/**
 * The Class PropertyFileLoader.
 * @author niraj_jagtap
 */
public class PropertyFileLoader {

    /** The Constant BOARD_DIMENSION. */
    private static final String BOARD_DIMENSION = "Board_Dimension";

    /** The Constant SNAKES. */
    private static final String SNAKES = "Snakes";

    /** The Constant LADDERS. */
    private static final String LADDERS = "Ladders";

    /** The properties. */
    private Properties properties = null;

    /**
     * Instantiates a new property file loader.
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    public PropertyFileLoader() throws SnakeAndLadderException {
        if (null == properties) {
            properties = new Properties();
            String path = "SnakeBoard.properties";

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            if (null != inputStream) {
                try {
                    properties.load(inputStream);
                } catch (IOException e) {
                    throw new SnakeAndLadderException("E1002", e.getMessage());
                }
            } else {
                throw new SnakeAndLadderException("E1001", "Null in loading file");
            }
        }
    }

    /**
     * Gets the properties file.
     * @return the properties file
     */
    public Properties getPropertiesFile() {
        return properties;
    }

    /**
     * Load snakes and ladders.
     * @return the map
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    public Map<Integer, SnakeOrLadderObject> loadSnakesAndLadders() throws SnakeAndLadderException {
        Map<Integer, SnakeOrLadderObject> map = new HashMap<Integer, SnakeOrLadderObject>();
        // Load Snakes
        loadSnakes(map);
        // Load Ladders
        loadLadders(map);
        return map;
    }

    /**
     * Load snakes.
     * @param map the map
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    private void loadSnakes(Map<Integer, SnakeOrLadderObject> map) throws SnakeAndLadderException {
        // Load Snakes
        String objectString = (String) properties.get(SNAKES);
        String stringTrim = objectString.substring(1, objectString.length() - 1);
        // calculate list of snakes
        String[] objects = stringTrim.split("\\},\\{");
        SnakeTO snakeTO = null;
        for (int index = 0; index < objects.length; index++) {
            String[] splitString = objects[index].split(",");
            Integer start = Integer.parseInt(splitString[0]) - 1;
            snakeTO = new SnakeTO(start, Integer.parseInt(splitString[1]));
            map.put(start, snakeTO);
        }
    }

    /**
     * Load ladders.
     * @param map the map
     * @throws SnakeAndLadderException the snake and ladder exception
     */
    private void loadLadders(Map<Integer, SnakeOrLadderObject> map) throws SnakeAndLadderException {
        // Load Snakes
        String objectString = (String) properties.get(LADDERS);
        String stringTrim = objectString.substring(1, objectString.length() - 1);
        // calculate list of snakes
        String[] objects = stringTrim.split("\\},\\{");
        LadderTO ladderTO = null;
        for (int index = 0; index < objects.length; index++) {
            String[] splitString = objects[index].split(",");
            Integer start = Integer.parseInt(splitString[0]) - 1;
            ladderTO = new LadderTO(start, Integer.parseInt(splitString[1]));
            map.put(start, ladderTO);
        }
    }

    /**
     * Load board dimension.
     * @return the integer[]
     */
    public Integer[] loadBoardDimension() {
        String[] boardDimensionSplit = properties.get(BOARD_DIMENSION).toString().split("X");
        return new Integer[]{Integer.parseInt(boardDimensionSplit[0]), Integer.parseInt(boardDimensionSplit[1])};
    }

}
