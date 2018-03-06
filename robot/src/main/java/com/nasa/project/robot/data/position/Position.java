package com.nasa.project.robot.data.position;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public interface Position {
    
    public Integer getX();
    public Integer getY();
    public String getDirections();
    
    public default String getLastDirection() {
        
        return this.getDirections().substring(
               this.getDirections().length() - 1, 
               this.getDirections().length());
    }
}
