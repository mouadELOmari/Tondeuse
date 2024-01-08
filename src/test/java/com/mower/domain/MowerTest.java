package com.mower.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MowerTest {

    @Test
    public void moveForwardInNorthOrientation() {
        Lawn myLawn = new Lawn(5, 5);
        Position position = new Position(1, 2, Orientation.N);
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.A);
        Mower mower = new Mower(position, instructions);
        Position positionTest = mower.move(myLawn);
        Position expectedPosition = new Position(1, 3, Orientation.N);
        assertEquals(expectedPosition, positionTest);
    }

    @Test
    public void turnLeftInNorthOrientation() {
        Lawn myLawn = new Lawn(5, 5);
        Position position = new Position(1, 2, Orientation.N);
        List<Instruction> instructions2 = new ArrayList<>();
        instructions2.add(Instruction.G);
        Mower mower2 = new Mower(position, instructions2);
        Position positionTest2 = mower2.move(myLawn);
        Position expectedPosition2 = new Position(1, 2, Orientation.W);
        assertEquals(expectedPosition2, positionTest2);
    }

    @Test
    public void turnRightInNorthOrientation() {
        Lawn myLawn = new Lawn(5, 5);
        Position position = new Position(1, 2, Orientation.N);
        List<Instruction> instructions3 = new ArrayList<>();
        instructions3.add(Instruction.D);
        Mower mower3 = new Mower(position, instructions3);
        Position positionTest3 = mower3.move(myLawn);
        Position expectedPosition3 = new Position(1, 2, Orientation.E);
        assertEquals(expectedPosition3, positionTest3);
    }

    @Test
    public void moveForwardOutsideLawnInNorthOrientation() {
        Lawn myLawn = new Lawn(5, 5);
        Position position = new Position(1, 5, Orientation.N);
        List<Instruction> instructions4 = new ArrayList<>();
        instructions4.add(Instruction.A);
        Mower mower4 = new Mower(position, instructions4);
        Position positionTest4 = mower4.move(myLawn);
        Position expectedPosition4 = new Position(1, 5, Orientation.N);
        assertEquals(expectedPosition4, positionTest4);
    }

}
