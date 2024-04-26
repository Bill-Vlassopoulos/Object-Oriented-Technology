package spaceships;

import Resources.*;
import mainPacket.MainClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SpaceShipALPHA extends SpaceShip {
    public static BufferedImage img;

    static {
        try {
            SpaceShipALPHA.img = ImageIO.read(MainClass.class.getResource("Resources/images/ALPHA.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public SpaceShipALPHA() {
        super(10);
        this.xCoord=0;
        this.yCoord=MainClass.cosmosHeight-MainClass.spaceShipHeight-MainClass.yOffSet;

    }
}
