package com.nasa.project.robot.service;

import com.nasa.project.robot.dto.MarsResponseDTO;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */


public class RobotServiceTest {
    
    @Mock
    private RobotService robotService;
    
    @Before
    public void setUp() throws IOException {
        robotService = mock(RobotService.class);	
    }

    @Test
    public void executeMovementCodes() {
        
        String codes = "MMM";
                
        MarsResponseDTO DTOReturned = new MarsResponseDTO();
        
        DTOReturned.setX(0);
        DTOReturned.setY(3);
        DTOReturned.setDirection("N");
        
        doReturn(DTOReturned).when(robotService).executeMovementCodes(codes);
        
        assertEquals(DTOReturned, robotService.executeMovementCodes(codes));
  
    }
    
}
