package GUI;

import spaceships.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlayScreen extends JPanel implements KeyListener {
    private SpaceShip userSpaceship;

    GamePlayScreen() {
        spaceFramePanel.addKeyListener(this);
        this.setVisible(true);
        this.setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        userSpaceship.getSpaceShipImageIcon().paintIcon(this, g, userSpaceship.getX(), userSpaceship.getY());

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) userSpaceship.moveUP();
        if (e.getKeyCode() == KeyEvent.VK_DOWN) userSpaceship.moveDOWN();
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) userSpaceship.moveRIGHT();
        if (e.getKeyCode() == KeyEvent.VK_LEFT) userSpaceship.moveLEFT();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        void setUserSpaceship (SpaceShip use1){
            userSpaceship =;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
