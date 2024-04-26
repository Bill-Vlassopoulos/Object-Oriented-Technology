package spaceships;

import mainPacket.MainClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SpaceShipZERO extends SpaceShip {

    public static BufferedImage img;

    static {
        try {
            SpaceShipZERO.img = ImageIO.read(MainClass.class.getResource("Resources/images/ZERO.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public SpaceShipZERO(){
        super(5);
    }
}
