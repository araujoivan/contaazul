package com.nasa.project.robot.service;

import com.nasa.project.robot.dto.MarsResponseDTO;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public interface RobotService {
    public MarsResponseDTO executeMovementCodes(String codes);
}
