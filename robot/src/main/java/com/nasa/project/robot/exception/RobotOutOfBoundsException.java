/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nasa.project.robot.exception;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class RobotOutOfBoundsException 
    extends RuntimeException {  
    
    public RobotOutOfBoundsException() {
        super("Invalid position!");
    }
}
