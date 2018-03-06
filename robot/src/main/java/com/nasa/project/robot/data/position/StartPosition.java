package com.nasa.project.robot.data.position;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class StartPosition
    implements Position {

    @Override
    public Integer getX() {
        return 0;
    }

    @Override
    public Integer getY() {
        return 0;
    }
    
    @Override
    public String getDirections() {
       return "";
    }

    @Override
    public String getLastDirection() {
        return "";    
    } 
}
