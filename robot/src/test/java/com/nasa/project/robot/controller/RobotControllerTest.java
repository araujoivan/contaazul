package com.nasa.project.robot.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.nasa.project.robot.dto.MarsResponseDTO;
import com.nasa.project.robot.service.RobotService;


/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */

@RunWith(SpringRunner.class)
@WebMvcTest(RobotControllerTest.class)
public class RobotControllerTest {
    
    @MockBean
    RobotService robotService;
    
    @Autowired
    private MockMvc mockMvc;
  
    @Test
    public void getMarsResponse() throws Exception {
        
        MarsResponseDTO dtoResponse = new MarsResponseDTO();
        
        dtoResponse.setDirection("N");
        dtoResponse.setX(0);
        dtoResponse.setY(0);
        
        String movementCodes = "MMML";
        
        given(robotService.executeMovementCodes(movementCodes)).willReturn(dtoResponse);
        
        mockMvc.perform(post("/rest/mars")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(1)))
            .andExpect(jsonPath("$[0].name", is("MMLL")));
    }
}
