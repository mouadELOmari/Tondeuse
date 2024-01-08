package com.mower.domain;
import org.junit.Test;

import static org.junit.Assert.*;


public class PositionTest {

    @Test
    public void testMove_North() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(2, 2, Orientation.N);

        position.move(lawn);

        assertEquals(2, position.getX());
        assertEquals(3, position.getY());
        assertEquals(Orientation.N, position.getOrientation());
    }

    @Test
    public void testMove_East() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(2, 2, Orientation.E);

        position.move(lawn);

        assertEquals(3, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Orientation.E, position.getOrientation());
    }

    @Test
    public void testMove_South() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(2, 2, Orientation.S);

        position.move(lawn);

        assertEquals(2, position.getX());
        assertEquals(1, position.getY());
        assertEquals(Orientation.S, position.getOrientation());
    }

    @Test
    public void testMove_West() {
        Lawn lawn = new Lawn(5, 5);
        Position position = new Position(2, 2, Orientation.W);

        position.move(lawn);

        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
        assertEquals(Orientation.W, position.getOrientation());
    }

    @Test
    public void testTurnRight() {
        Position position = new Position(2, 2, Orientation.N);
        position.turnRight();

        assertEquals(Orientation.E, position.getOrientation());
    }

    @Test
    public void testTurnLeft() {
        Position position = new Position(2, 2, Orientation.N);
        position.turnLeft();

        assertEquals(Orientation.W, position.getOrientation());
    }

    @Test
    public void testEquality() {
        Position position1 = new Position(1, 2, Orientation.N);
        Position position2 = new Position(1, 2, Orientation.N);
        Position position3 = new Position(3, 4, Orientation.S);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

}
