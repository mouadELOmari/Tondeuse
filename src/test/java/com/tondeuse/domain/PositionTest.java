package com.tondeuse.domain;
import org.junit.Test;

import static org.junit.Assert.*;


public class PositionTest {

    @Test
    public void testAvancer_Nord() {
        Pelouse pelouse = new Pelouse(5, 5);
        Position position = new Position(2, 2, Orientation.N);

        position.avancer(pelouse);

        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
        assertEquals(Orientation.N, position.getOrientation());
    }

    @Test
    public void testAvancer_Est() {
        Pelouse pelouse = new Pelouse(5, 5);
        Position position = new Position(2, 2, Orientation.E);

        position.avancer(pelouse);

        assertEquals(3, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Orientation.E, position.getOrientation());
    }

    @Test
    public void testAvancer_Sud() {
        Pelouse pelouse = new Pelouse(5, 5);
        Position position = new Position(2, 2, Orientation.S);

        position.avancer(pelouse);

        assertEquals(2, position.getX());
        assertEquals(1, position.getY());
        assertEquals(Orientation.S, position.getOrientation());
    }

    @Test
    public void testAvancer_Ouest() {
        Pelouse pelouse = new Pelouse(5, 5);
        Position position = new Position(2, 2, Orientation.O);

        position.avancer(pelouse);

        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Orientation.O, position.getOrientation());
    }

    @Test
    public void testTournerADroite() {
        Position position = new Position(2, 2, Orientation.N);
        position.tournerADroite();

        assertEquals(Orientation.E, position.getOrientation());
    }

    @Test
    public void testTournerAGauche() {
        Position position = new Position(2, 2, Orientation.N);
        position.tournerAGauche();

        assertEquals(Orientation.O, position.getOrientation());
    }

    @Test
    public void testEgalite() {
        Position position1 = new Position(1, 2, Orientation.N);
        Position position2 = new Position(1, 2, Orientation.N);
        Position position3 = new Position(3, 4, Orientation.S);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

}
