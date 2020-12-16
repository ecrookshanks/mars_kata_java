package com.nokelservices.mars_rover;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction rotateClockwise(Direction d){
        switch (d){
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                return null;
        }
    }

    public static Direction rotateCounterClockwise(Direction d){
        switch (d){
            case NORTH:
                return WEST;
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            default:
                return null;
        }
    }
}
