package com.nasa.project.robot.data;

import com.nasa.project.robot.data.position.NorthPosition;
import com.nasa.project.robot.data.position.Position;
import com.nasa.project.robot.data.position.StartPosition;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */

public class Robot {
        
    private Position position;
    
   /*
    * NOTE:
    *
    *     Initializing the robot pointing to North with 0,0 for x and y coordinates.
    */
    public Robot() {
        this.position = new NorthPosition(new StartPosition()); 
    }
    
    public Position getPosition() {
        return position;
    } 
    
    public void setPosition(Position newCoordinate) {
        this.position = newCoordinate;
    } 
}