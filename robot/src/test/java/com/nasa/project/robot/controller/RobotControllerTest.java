package com.nasa.project.robot.controller;

import com.nasa.project.robot.dto.MarsResponseDTO;
import com.nasa.project.robot.service.RobotService;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import org.springframework.http.ResponseEntity;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class RobotControllerTest {
    
    RobotService robotService;
    
    @Autowired
    private RobotController robotController;

    @Before
    public void setUp() {
        robotService = mock(RobotService.class);
        setField(robotController, "robotService", robotService);
    }
    
    @Test
    public void getMarsResponse() {
        
//        String codes = "MMMRM";
//        
//        MarsResponseDTO dto = new MarsResponseDTO();
//        
//        dto.setX(1);
//        dto.setY(3);
//        dto.setDirection("E");
//         
//        when(robotService.executeMovementCodes(codes)).thenReturn(dto);
//        
//        ResponseEntity<String> response = (ResponseEntity<String>) get("localhost:8080/rest/mars", String.class);
//        
//        verify(robotService, times(1)).executeMovementCodes(codes);
//        assertTrue(response.getStatusCode().is2xxSuccessful());
//        assertFalse(response.getBody().isEmpty());
        
    }
}
