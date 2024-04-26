package GUI;

import javax.swing.*;
import java.awt.*;

public class SpaceFrame extends JFrame {
    static int width, height;
    static JPanel spaceFramePanel = new JPanel();
    static SelectSpaceshipScreen selectSpaceshipScreen = new SelectSpaceshipScreen();
    static CardLayout cardLayout = new CardLayout();
    static GamePlayScreen gamePlayScreen=new GamePlayScreen();

    public SpaceFrame(int width, int height) {
        SpaceFrame.width = width;
        SpaceFrame.height = height;
        this.setSize(width, height);
        this.setTitle("[ECE_Y325] astra game simulation");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setFocusable(true);
        setupMasterPanel();
        setResizable(false);
        this.setVisible(true);
    }

    void setupMasterPanel() {
        spaceFramePanel.setLayout(cardLayout);
        spaceFramePanel.add(selectSpaceshipScreen);

    }
}
