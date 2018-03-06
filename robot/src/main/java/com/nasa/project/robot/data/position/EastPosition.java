package com.nasa.project.robot.data.position;

import com.nasa.project.robot.constant.Constants;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class EastPosition 
    extends PositionDecorator {
    
    public EastPosition(Position newPosition) {
        super(newPosition);   
        step = (newPosition instanceof EastPosition) ? 1 : 0; 
    }
    
    @Override
    public Integer getX() {
        return position.getX() + step;
    }
    
    @Override
    public Integer getY() {
        return position.getY();
    }
    
    @Override
    public String getDirections() {
       return position.getDirections().concat(Constants.EAST);
    } 
}
