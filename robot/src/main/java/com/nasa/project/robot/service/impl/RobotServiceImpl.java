package com.nasa.project.robot.service.impl;

import com.nasa.project.robot.data.Robot;
import com.nasa.project.robot.data.Terrain;
import com.nasa.project.robot.data.position.Position;
import com.nasa.project.robot.data.position.PositionWrapper;
import com.nasa.project.robot.constant.Constants;
import com.nasa.project.robot.dto.MarsResponseDTO;
import com.nasa.project.robot.exception.InvalidMovementCodeException;
import com.nasa.project.robot.exception.RobotOutOfBoundsException;
import com.nasa.project.robot.mapper.MarsResponseMapper;
import com.nasa.project.robot.service.RobotService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */

@Service
public class RobotServiceImpl
    implements RobotService {

    @Override
    public MarsResponseDTO executeMovementCodes(String codes) {
        
        List<String> movementCodes = new ArrayList(Arrays.asList(codes.split("")));
        
        validateMovementCodes(movementCodes);
        
        Robot robot = new Robot();
            
        robot.setPosition(move(movementCodes, robot.getPosition()));
        
        return MarsResponseMapper.fromPosition(robot.getPosition());
    }
    
    private Position move(List<String> movingCodes, Position position) {
        
        while(!movingCodes.isEmpty()) {
            
            position = defineNewMovement(movingCodes.remove(0), position);
            position = move(movingCodes, position);
            
            if (!Terrain.covers(position)) {
                throw new RobotOutOfBoundsException();
            }
        }
        
       return position;
    }

    private Position defineNewMovement(String code, Position position) {
       
        if(code.equalsIgnoreCase(Constants.GO_AHEAD)) {
            return PositionWrapper.getByCode(position.getLastDirection()).wrap(position);
        } else {
           return PositionWrapper.getNextPositionWrapperBasedOnDirection(position.getLastDirection(), code).wrap(position);
        }
    } 
    
    private void validateMovementCodes(List<String> movementCodes) {
        
        movementCodes.forEach(code -> {
            switch(code.toUpperCase()) {
                case Constants.TURN_LEFT:
                case Constants.TURN_RIGHT:
                case Constants.GO_AHEAD:
                break;
                default: throw new InvalidMovementCodeException();
            }
        });
    }
}
