package com.nokelservices.mars_rover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rover {

    public Position getCurrentPosition() {
        return currentPosition;
    }

    private Position currentPosition;
    private Direction direction;
    private List<Obstacle> obstacleList;

    public List<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public void setObstacleList(List<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    // CTOR
    public Rover(){
        this.setDirection(Direction.NORTH);
        this.currentPosition = new Position();
        this.obstacleList = new ArrayList<>();
    }

    public Rover(Position pos, Direction direction){
        this.currentPosition = pos;
        this.direction = direction;
    }


    public MoveResult processSingleCommand(char command) throws IllegalArgumentException {
        MoveResult didMove = new MoveResult();
        char c = Character.toUpperCase(command);
        // TODO: Guard clause - check value and return if wrong
        char[] validCommands = {'F', 'B', 'R', 'L'};
        boolean contains = false;
        for (char v : validCommands) {
            if (v == c) {
                contains = true;
                break;
            }
        }
        if (!contains) {
            throw new IllegalArgumentException("Invalid input to processSingleCommand");
        }

        if ( c == 'F' || c == 'B'){
            didMove = MoveRover(c);
        }
        else if (c == 'L' || c == 'R'){
            TurnRover(c);
        }

        return didMove;
    }

    private void TurnRover(char c) {
        if (c=='R'){
            this.setDirection( Direction.rotateClockwise(this.getDirection()));
        }
        else{
            this.setDirection(Direction.rotateCounterClockwise(this.getDirection()));
        }
    }

    private MoveResult MoveRover(char c) {
        MoveResult mr = canMove(c);
        if (mr.didMove) {
            Position next = this.getNextPosition(this.currentPosition, c);
            this.currentPosition = next;
        }
        return mr;
    }

    private MoveResult canMove(char c){
        MoveResult mr = new MoveResult();
        Position current = this.currentPosition;
        Position next = this.getNextPosition(current, c);
        // check if next position is same as an obstacle
        for (Obstacle o : obstacleList) {
            if (o.getPosition().equals(next)) {
                mr.didMove = false;
                mr.obstaclePosition = o.getPosition();
                return mr;
            }
        }

        return mr;
    }

    private Position getNextPosition(Position current, char cmd){
        Position next = null;
        switch (this.getDirection()){
            case EAST:
                if ( cmd == 'F') {
                    next = this.moveEast(current);
                }
                else{
                    next = this.moveWest(current);
                }
                break;
            case WEST:
                if ( cmd == 'F'){
                    next = this.moveWest(current);
                }
                else {
                    next = this.moveEast(current);
                }
                break;
            case NORTH:
                if ( cmd == 'F'){
                    next = this.moveNorth(current);
                }
                else{
                    next = this.moveSouth(current);
                }
                break;
            case SOUTH:
                if (cmd == 'F'){
                    next = this.moveSouth(current);
                }
                else{
                    next = this.moveNorth(current);
                }
                break;

            default:
                break;
        }
        return next;
    }

    public Position moveNorth(Position pos) {
        Position newPos = new Position(pos.getxPos(), pos.getyPos());
        newPos.setyPos(newPos.getyPos() + 1);
        return newPos;
    }

    public Position moveEast(Position pos) {
        Position newPos = new Position(pos.getxPos(), pos.getyPos());
        newPos.setxPos(newPos.getxPos() + 1);
        return newPos;
    }

    public Position moveWest(Position pos) {
        Position newPos = new Position(pos.getxPos(), pos.getyPos());
        newPos.setxPos(newPos.getxPos() -1);
        return newPos;
    }

    public Position moveSouth(Position pos) {
        Position newPos = new Position(pos.getxPos(), pos.getyPos());
        newPos.setyPos(newPos.getyPos() - 1);
        return newPos;
    }

    public void processCommands(char[] route) {
        for (char c : route) {
            this.processSingleCommand(c);
        }
    }
}
