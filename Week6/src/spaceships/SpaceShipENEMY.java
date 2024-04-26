package spaceships;

import mainPacket.MainClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class SpaceShipENEMY extends SpaceShip {
    public static BufferedImage img;

    static {
        try {
            SpaceShipENEMY.img = ImageIO.read(MainClass.class.getResource("Resources/images/ENEMY.png"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public SpaceShipENEMY(){
        super(15);
    }
}
