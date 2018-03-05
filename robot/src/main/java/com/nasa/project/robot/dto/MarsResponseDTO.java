package com.nasa.project.robot.dto;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class MarsResponseDTO {
    
    private int x;
    private int y;
    private String direction;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
 
    @Override
    public String toString() {
        return "("
                .concat(String.valueOf(getX()))
                .concat(",")
                .concat(String.valueOf(getY()))
                .concat(",")
                .concat(getDirection())
                .concat(")");
    }
    
}
