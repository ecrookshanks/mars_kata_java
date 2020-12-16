package com.nokelservices.mars_rover;

public class Obstacle {

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    private Position position;

    public Obstacle(int x, int y){
        this.position = new Position(x, y);
    }
}
