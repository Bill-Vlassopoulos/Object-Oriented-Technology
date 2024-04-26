package spaceships;

import mainPacket.MainClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SpaceShipGAMA extends SpaceShip {
    public static BufferedImage img;

    static {
        try {
            SpaceShipGAMA.img = ImageIO.read(MainClass.class.getResource("Resources/images/GAMA.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public SpaceShipGAMA(){
        super(30);
    }
}
