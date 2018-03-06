package com.nasa.project.robot.data;

import com.nasa.project.robot.data.position.Position;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class Terrain {
    
    private final static int LOWER_X = 0;
    private final static int LOWER_Y = 0;
    private final static int UPPER_X = 5;
    private final static int UPPER_Y = 5;
    
    public static boolean covers(Position position) {
        return (position.getX() >= LOWER_X && position.getX() <= UPPER_X) &&
               (position.getY() >= LOWER_Y && position.getY() <= UPPER_Y);
    }
}
