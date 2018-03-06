package com.nasa.project.robot.mapper;

import com.nasa.project.robot.data.position.Position;
import com.nasa.project.robot.dto.MarsResponseDTO;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class MarsResponseMapper {
    
    public static MarsResponseDTO fromPosition(Position position) { 
        
        MarsResponseDTO dto = new MarsResponseDTO();
        
        dto.setX(position.getX());
        dto.setY(position.getY());
        dto.setDirection(position.getLastDirection());
        
        return dto;
    }
}
