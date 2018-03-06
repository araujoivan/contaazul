package com.nasa.project.robot.data.position;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 * 
 * NOTE: 
 * 
 *      The Decorator Design Pattern was chosen to track
 *      all positions that were assigned to the robot and as a
 *      way to calculate the final coordinates x and y, easier
 *      and faster.
 * 
 */
public abstract class PositionDecorator 
    implements Position {
    
    protected Position position;
    
    protected int step = 0;
    
    public PositionDecorator(Position position) {
        this.position = position;
    }
    
    @Override
    public Integer getX() {
        return this.position.getX();
    }
    
    @Override
    public Integer getY() {
        return this.position.getX();
    }
    
    @Override
    public String getDirections() {
        return this.position.getDirections();
    }
}
