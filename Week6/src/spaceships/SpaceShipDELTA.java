package spaceships;

import mainPacket.MainClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SpaceShipDELTA extends SpaceShip {
    public static BufferedImage img;

    static {
        try {
            SpaceShipDELTA.img = ImageIO.read(MainClass.class.getResource("Resources/images/DELTA.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public SpaceShipDELTA(){
        super(40);
    }
}
