package com.nasa.project.robot.controller;

import com.nasa.project.robot.constant.Constants;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.mockito.Mockito.when;

import com.nasa.project.robot.dto.MarsResponseDTO;
import com.nasa.project.robot.exception.InvalidMovementCodeException;
import com.nasa.project.robot.exception.RobotOutOfBoundsException;
import com.nasa.project.robot.service.RobotService;

import java.io.IOException;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


/**
 * @author Eder Crespo
 * @email araujo.ivan@hotmail.com
 */
public class RobotControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private RobotController controller;

    @Mock
    private RobotService service;

    @Before
    public void setUp() throws IOException {

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getMarsSuccesResponse() throws Exception {

        // ARRANGE
        MarsResponseDTO expectedResponse = new MarsResponseDTO();

        expectedResponse.setDirection(Constants.NORTH);
        expectedResponse.setX(0);
        expectedResponse.setY(0);

        String movementCodes = "MMML";

        when(service.executeMovementCodes(movementCodes))
                .thenReturn(expectedResponse);

        // ACT & ASSERT
        mockMvc.perform(post("/rest/mars/".concat(movementCodes)))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse.toString()));
    }

    @Test
    public void getMarsBadRequestResponseWithOutOfBoundsException() throws Exception {
        
        // ARRANGE
        String movementCodes = "MMMMMMMMMMMMMMMM";

        when(service.executeMovementCodes(movementCodes))
                .thenThrow(new RobotOutOfBoundsException());

        // ACT & ASSERT
        mockMvc.perform(post("/rest/mars/".concat(movementCodes)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getMarsBadRequestResponseWithInvalidMovementCodesException() throws Exception {

        // ARRANGE
        String movementCodes = "XXINVALIDCODESXX";

        when(service.executeMovementCodes(movementCodes))
                .thenThrow(new InvalidMovementCodeException());

        // ACT & ASSERT
        mockMvc.perform(post("/rest/mars/".concat(movementCodes)))
                .andExpect(status().isBadRequest());
    }
}
