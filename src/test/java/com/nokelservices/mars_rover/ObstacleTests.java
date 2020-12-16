package com.nokelservices.mars_rover;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ObstacleTests {

    @Test
    public void obstacleIsCreatable(){
        Obstacle obj = new Obstacle(4, 3);
        Position dest = new Position(4,3);

        assertEquals(dest, obj.getPosition());
    }

    @Test
    public void obstaclePreventsRoverFromMoving(){
        Obstacle obst = new Obstacle(0, 2);
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(obst);

        Rover rover = new Rover(new Position(0,1), Direction.NORTH);
        rover.setObstacleList(obstacles);

        MoveResult res = rover.processSingleCommand('F');

        assertFalse(res.didMove);

    }

    @Test
    public void obstaclePositionIsReturnedWhenEncountered(){
        Obstacle obst = new Obstacle(0, 2);
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(obst);

        Rover rover = new Rover(new Position(0,1), Direction.NORTH);
        rover.setObstacleList(obstacles);

        MoveResult res = rover.processSingleCommand('F');

        assertFalse(res.didMove);
        assertEquals(obst.getPosition(), res.obstaclePosition);
    }
}
