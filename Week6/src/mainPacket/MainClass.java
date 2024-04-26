package mainPacket;

import spaceships.*;

import java.util.LinkedList;
import java.util.Scanner;

public class MainClass {
    public static int cosmosWidth = 800;
    public static int cosmosHeight = 600;
    public static int spaceShipWidth = 100;
    public static int spaceShipHeight = 100;
    public static int yOffSet = 30;

    public static void main(String[] args) {
        LinkedList<SpaceShip> spaceshipLinkedList = new LinkedList<SpaceShip>();
        SpaceShip z = new SpaceShipZERO();
        SpaceShip a = new SpaceShipALPHA();
        SpaceShip b = new SpaceShipBETA();
        SpaceShip g = new SpaceShipGAMA();
        SpaceShip d = new SpaceShipDELTA();
        SpaceShip e = new SpaceShipENEMY();

        spaceshipLinkedList.add(z);
        spaceshipLinkedList.add(a);
        spaceshipLinkedList.add(b);
        spaceshipLinkedList.add(g);
        spaceshipLinkedList.add(d);
        spaceshipLinkedList.add(e);

        System.out.println("Enter command to test spaceships movements:");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            System.out.println(s1);
            int i = 0;
            while (i < spaceshipLinkedList.size()) {
                if (s1.equals("u")) spaceshipLinkedList.get(i).moveUP();
                if (s1.equals("d")) spaceshipLinkedList.get(i).moveDOWN();
                if (s1.equals("l")) spaceshipLinkedList.get(i).moveLEFT();
                if (s1.equals("r")) spaceshipLinkedList.get(i).moveRIGHT();
                spaceshipLinkedList.get(i).printCoords();
                i++;
            }
        }
        sc.close();
    }
}
