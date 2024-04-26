package spaceships;

import mainPacket.*;

import javax.swing.*;


public  class SpaceShip implements Navigation {
    protected ImageIcon SpaceShipImageIcon;
    int xCoord, yCoord;
    int speed;
    int shipWidth, shipHeight;


    SpaceShip(int speed) {
        this.xCoord = -MainClass.cosmosWidth / 2;
        this.yCoord = -MainClass.cosmosHeight / 2;
        this.shipWidth = MainClass.spaceShipWidth;
        this.shipHeight = MainClass.spaceShipHeight;
        this.speed = speed;
    }

    public static void not_permissable() {
        System.out.print("Not permissable action.Out of borders error.-> ");
    }

    public ImageIcon getSpaceShipImageIcon() {
        return SpaceShipImageIcon;
    }

    public int getX(){
        return xCoord;
    }

    public int getY(){
        return yCoord;
    }

    @Override
    public int moveUP() {
        if (this.yCoord + speed < 0) {
            this.yCoord += speed;
        } else {
            not_permissable();
        }
        return this.yCoord;
    }

    @Override
    public int moveDOWN() {
        if (this.yCoord - MainClass.spaceShipHeight - speed > -MainClass.cosmosHeight) {
            this.yCoord -= speed;
        } else {
            not_permissable();
        }
        return this.yCoord;
    }

    @Override
    public int moveLEFT() {
        if (this.xCoord + speed < 0) {
            this.xCoord += speed;
        } else {
            not_permissable();
        }
        return this.xCoord;
    }

    @Override
    public int moveRIGHT() {
        if (this.xCoord - MainClass.spaceShipHeight - speed > -MainClass.cosmosWidth) {
            this.xCoord -= speed;
        } else {
            not_permissable();
        }
        return this.xCoord;
    }

    public void printCoords() {
        System.out.println("xCoord=" + this.xCoord + " yCoord=" + this.yCoord);
    }
}
