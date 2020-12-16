package com.nokelservices.mars_rover;

public class MoveResult {
    public boolean didMove;
    public Position obstaclePosition;

    public MoveResult(){
        this.didMove = true;
        obstaclePosition = null;
    }
}
