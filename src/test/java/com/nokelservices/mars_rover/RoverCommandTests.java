package com.nokelservices.mars_rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoverCommandTests {

    @Test
    public void simpleTestReturnsTrue(){
        assertTrue(true);
    }

    @Test
    public void roverInitIsNorthAtZeroZero(){
        Rover rover = new Rover();
        Position dest = new Position(0,0);

        assertEquals(dest, rover.getCurrentPosition());
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    public void roverInitAndReceivesSingleForwardCommandAndMovesOnce(){
        Rover rover = new Rover();
        char command = 'F';
        Position dest = new Position(0,1);

        rover.processSingleCommand(command);

        assertEquals(dest, rover.getCurrentPosition());
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    public void roverRotatesAllTheWayAndBack(){
        Rover rover = new Rover();
        char commandR = 'R';
        char commandL = 'L';

        Position dest = new Position(0,0);

        rover.processSingleCommand(commandR);
        assertEquals(Direction.EAST, rover.getDirection());
        rover.processSingleCommand(commandR);
        assertEquals(Direction.SOUTH, rover.getDirection());
        rover.processSingleCommand(commandR);
        assertEquals(Direction.WEST, rover.getDirection());
        rover.processSingleCommand(commandR);

        assertEquals(dest, rover.getCurrentPosition());
        assertEquals(Direction.NORTH, rover.getDirection());

        rover.processSingleCommand(commandL);
        assertEquals(Direction.WEST, rover.getDirection());
        rover.processSingleCommand(commandL);
        assertEquals(Direction.SOUTH, rover.getDirection());
        rover.processSingleCommand(commandL);
        assertEquals(Direction.EAST, rover.getDirection());
        rover.processSingleCommand(commandL);

        assertEquals(dest, rover.getCurrentPosition());
        assertEquals(Direction.NORTH, rover.getDirection());

    }

    @Test
    public void roverMoveForwardAndBackward(){
        Rover rover = new Rover();
        char commandF = 'F';
        char commandB = 'B';
        Position dest = new Position(0,0);

        rover.processSingleCommand(commandF);
        rover.processSingleCommand(commandF);
        rover.processSingleCommand(commandB);
        rover.processSingleCommand(commandB);

        assertEquals(dest, rover.getCurrentPosition());
        assertEquals(Direction.NORTH, rover.getDirection());

    }

    @Test
    public void roverInitInvalidCommandThrowsCommandException(){
        Rover rover = new Rover();
        char command = 'Z';

        assertThrows(IllegalArgumentException.class,
                () -> rover.processSingleCommand(command));
    }

    @Test
    public void roverProcessesMultipleCommandsInCircleRoute(){
        Rover rover = new Rover();
        Position dest = new Position(0,0);
        char[] circleRoute = {'F', 'F', 'R', 'F', 'R', 'F', 'F', 'R', 'F'};

        rover.processCommands(circleRoute);

        assertEquals(dest, rover.getCurrentPosition());

    }

}
