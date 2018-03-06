package com.nasa.project.robot.service;

import com.nasa.project.robot.constant.Constants;
import com.nasa.project.robot.dto.MarsResponseDTO;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */


public class RobotServiceTest {
    
    private RobotService service;
    
    @Before
    public void setUp() throws IOException {
        service = mock(RobotService.class);	
    }

    @Test
    public void executeMovementCodes() {
        
        // ARRANGE
        String codes = "MMM";
                
        MarsResponseDTO expectedDTO = new MarsResponseDTO();
        
        expectedDTO.setX(0);
        expectedDTO.setY(3);
        expectedDTO.setDirection(Constants.NORTH);
        
        doReturn(expectedDTO).when(service).executeMovementCodes(codes);
        
        // ACT & ASSERT
        assertEquals(expectedDTO, service.executeMovementCodes(codes));
  
    }
    
}
