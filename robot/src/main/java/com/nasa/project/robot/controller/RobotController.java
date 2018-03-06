package com.nasa.project.robot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.project.robot.service.RobotService;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
@RestController
public class RobotController
    extends MainController {
    
    @Autowired
    private RobotService robotService;

    /*
     * NOTE:
     * 
     *     In this case I think it would be more apropriated using a get request 
     *     instead of using a post one.
     *     
     *     Suggestion for walking all the borders : MMMMMRMMMMMRMMMMMRMMMMMR
     *
     */ 
    @RequestMapping(value = "/mars/{codes}")
    public ResponseEntity getMarsResponse(@PathVariable String codes) {        
        try {
            return new ResponseEntity(robotService.executeMovementCodes(codes).toString(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity(e.toString(), HttpStatus.BAD_REQUEST);
        }        
    }
}
