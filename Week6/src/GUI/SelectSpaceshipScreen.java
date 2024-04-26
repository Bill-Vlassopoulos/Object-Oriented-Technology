package GUI;

import spaceships.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectSpaceshipScreen extends JPanel {
    SelectSpaceshipScreen() {
        this.setLayout(new BorderLayout(30, 30));
        this.add(createNorthPanel(), BorderLayout.NORTH);
        this.add(createCenterPanel(), BorderLayout.CENTER);
        this.add(createSouthPanel(), BorderLayout.SOUTH);
    }

    class SpaceShipSelectionBtnHandler implements ActionListener {
        String name;

        public SpaceShipSelectionBtnHandler(String x) {
            name = x;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            SpaceFrame.cardLayout.next(SpaceFrame.spaceFramePanel);
            SpaceFrame.gamePlayScreen.setFocusable(true);
            SpaceFrame.gamePlayScreen.requestFocus();

            if (name.equalsIgnoreCase("SZERO")) SpaceFrame.gamePlayScreen.setUserSpaceship(new SpaceShipZERO());
            if (name.equalsIgnoreCase("SALPHA")) SpaceFrame.gamePlayScreen.setUserSpaceship(new SpaceShipALPHA());
            if (name.equalsIgnoreCase("SBETA")) SpaceFrame.gamePlayScreen.setUserSpaceship(new SpaceShipBETA());
            if (name.equalsIgnoreCase("SGAMA")) SpaceFrame.gamePlayScreen.setUserSpaceship(new SpaceShipGAMA());
            if (name.equalsIgnoreCase("SDELTA")) SpaceFrame.gamePlayScreen.setUserSpaceship(new SpaceShipDELTA());

        }
    }

    public void makeBtnsTransparent(JButton btn) {
        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
    }

    private JPanel createNorthPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        JLabel label = new JLabel("Please choose your Spaceship ");
        label.setFont(new Font("Arcade Classic", Font.PLAIN, 25));
        label.setForeground(Color.WHITE);
        panel.setBackground(Color.BLACK);
        panel.add(label);
        return panel;
    }


    private JPanel createCenterPanel() {
        JButton btnspaceShipZero = new JButton();
        JButton btnspaceShipAlpha = new JButton();
        JButton btnspaceShipBeta = new JButton();
        JButton btnspaceShipGama = new JButton();
        JButton btnspaceShipDelta = new JButton();
        btnspaceShipZero.addActionListener(new SpaceShipSelectionBtnHandler("SZERO"));
        btnspaceShipZero.addActionListener(new SpaceShipSelectionBtnHandler("SALPHA"));
        btnspaceShipZero.addActionListener(new SpaceShipSelectionBtnHandler("SBETA"));
        btnspaceShipZero.addActionListener(new SpaceShipSelectionBtnHandler("SGAMA"));
        btnspaceShipZero.addActionListener(new SpaceShipSelectionBtnHandler("SDELTA"));

        btnspaceShipZero.setIcon(new ImageIcon(SpaceShipZERO.img));
        btnspaceShipAlpha.setIcon(new ImageIcon(SpaceShipALPHA.img));
        btnspaceShipAlpha.setIcon(new ImageIcon(SpaceShipBETA.img));
        btnspaceShipAlpha.setIcon(new ImageIcon(SpaceShipGAMA.img));
        btnspaceShipAlpha.setIcon(new ImageIcon(SpaceShipDELTA.img));
        btnspaceShipAlpha.setIcon(new ImageIcon(SpaceShipENEMY.img));


        makeBtnsTransparent(btnspaceShipZero);
        makeBtnsTransparent(btnspaceShipAlpha);
        makeBtnsTransparent(btnspaceShipBeta);
        makeBtnsTransparent(btnspaceShipGama);
        makeBtnsTransparent(btnspaceShipDelta);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBackground(Color.BLACK);
        panel.add(btnspaceShipZero);
        panel.add(btnspaceShipAlpha);
        panel.add(btnspaceShipBeta);
        panel.add(btnspaceShipGama);
        panel.add(btnspaceShipDelta);
        return panel;
    }

    private JPanel createSouthPanel() {

    }
}
