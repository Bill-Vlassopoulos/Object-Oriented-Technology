package spaceships;

import mainPacket.MainClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SpaceShipBETA extends SpaceShip {
    public static BufferedImage img;

    static {
        try {
            SpaceShipBETA.img = ImageIO.read(MainClass.class.getResource("Resources/images/BETA.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public SpaceShipBETA() {
        super(20);
    }
}
