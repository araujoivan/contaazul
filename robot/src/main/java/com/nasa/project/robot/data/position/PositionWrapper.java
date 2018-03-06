package com.nasa.project.robot.data.position;

import com.nasa.project.robot.constant.Constants;
import java.util.Arrays;

/**
 * @author Eder Crespo
 * @email  araujo.ivan@hotmail.com
 */
public enum PositionWrapper {
    
    WEST(Constants.WEST) {
        @Override
        public Position wrap(Position position) {
            return new WestPosition(position);
        }
    },
    
    NORTH(Constants.NORTH) {
        @Override
        public Position wrap(Position position) {
            return new NorthPosition(position);
        }
    },
    
    EAST(Constants.EAST) {
        @Override
        public Position wrap(Position position) {
            return new EastPosition(position);
        }
    },
    
    SOUTH(Constants.SOUTH) {
        @Override
        public Position wrap(Position position) {
            return new SouthPosition(position);
        }
    };
    
    private PositionWrapper(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    private String code;

    public abstract Position wrap(Position position);
    
    public static PositionWrapper getByCode(String value) {
        
        return Arrays.stream(PositionWrapper.values())
                .filter(p -> p.getCode().equalsIgnoreCase(value))
                .findFirst().get();
    }
      
    /*
     * NOTE:
     *      
     *      This method is responsible for simulating a circular line where is    
     *      possible to recover the next position based on the current position
     *      and the desirable direction <-left | right->
     */
    public static PositionWrapper getNextPositionWrapperBasedOnDirection(String currentPositionCode, String direction) {
        
        PositionWrapper positionWrapper = null;
        
        int index = 0;
        
        for(PositionWrapper p : PositionWrapper.values()) {
                        
            if(p.getCode().equalsIgnoreCase(currentPositionCode)) {
               
                if(direction.equalsIgnoreCase(Constants.TURN_LEFT)) {
                    index--;
                    index = (index < 0) ? PositionWrapper.values().length - 1 : index;
                    positionWrapper = PositionWrapper.values()[index];
                } else if(direction.equalsIgnoreCase(Constants.TURN_RIGHT)){
                    index++;
                    index = (index >= PositionWrapper.values().length) ? 0 : index;
                    positionWrapper = PositionWrapper.values()[index];
                }
                break;
            } 
            index++;
        } 
        
        return positionWrapper;
    }
}