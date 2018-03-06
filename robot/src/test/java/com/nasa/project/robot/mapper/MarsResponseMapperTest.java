package com.nasa.project.robot.mapper;

import com.nasa.project.robot.constant.Constants;
import com.nasa.project.robot.data.position.EastPosition;
import com.nasa.project.robot.data.position.NorthPosition;
import com.nasa.project.robot.data.position.Position;
import com.nasa.project.robot.data.position.SouthPosition;
import com.nasa.project.robot.data.position.StartPosition;
import com.nasa.project.robot.data.position.WestPosition;
import com.nasa.project.robot.dto.MarsResponseDTO;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public class MarsResponseMapperTest {

    @Test
    public void mapFromPosition360Rotation() throws Exception {

        // ARRANGE
        MarsResponseDTO expectedDTO = new MarsResponseDTO();

        expectedDTO.setX(0);
        expectedDTO.setY(0);
        expectedDTO.setDirection(Constants.NORTH);

        Position position
                = new NorthPosition(
                        new WestPosition(
                                new SouthPosition(
                                        new EastPosition(
                                                new NorthPosition(
                                                        new StartPosition())))));

        // ACT         
        MarsResponseDTO returnedDTO = MarsResponseMapper.fromPosition(position);

        // ASSERT
        assertEquals(returnedDTO.toString(), expectedDTO.toString());
    }
}
