package com.nasa.project.robot.exception;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class InvalidMovementCodeException 
    extends RuntimeException {
    
    public InvalidMovementCodeException() {
        super("Invalid movement code!");
    }
}
