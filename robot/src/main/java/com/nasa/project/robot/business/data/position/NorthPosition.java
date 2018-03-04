package com.nasa.project.robot.business.data.position;

import com.nasa.project.robot.constant.Constants;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class NorthPosition 
    extends PositionDecorator {

    public NorthPosition(Position newPosition) {
        super(newPosition);    
        step = (newPosition instanceof NorthPosition) ? 1 : 0; 
    }
    
    @Override
    public Integer getX() {
        return position.getX();
    }
    
    @Override
    public Integer getY() {
        return position.getY() + step;
    }

    @Override
    public String getDirections() {
       return position.getDirections().concat(Constants.NORTH);
    }
}
