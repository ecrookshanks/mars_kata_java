package com.nokelservices.mars_rover;

public class Position {

    private int xPos;
    private int yPos;

    public Position(){
        this.xPos = 0;
        this.yPos = 0;
    }

    public Position(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }
    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }


    @Override
    public boolean equals(Object obj) {
        Position toCompare = (Position)obj;
        return (toCompare.getxPos() == this.getxPos()) &&
                (toCompare.getyPos() == this.getyPos());
    }
}
