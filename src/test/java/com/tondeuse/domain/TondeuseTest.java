package com.tondeuse.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;


public class TondeuseTest {

    @Test
    public void testEgaliteAvecObjetsEgaux() {
        // Arrange
        Position position1 = new Position(1, 2, Orientation.N);
        Position position2 = new Position(1, 2, Orientation.N);
        List<Instruction> instructions1 = Arrays.asList(Instruction.A, Instruction.D);
        List<Instruction> instructions2 = Arrays.asList(Instruction.A, Instruction.D);

        Tondeuse tondeuse1 = new Tondeuse(position1, instructions1);
        Tondeuse tondeuse2 = new Tondeuse(position2, instructions2);

        // Act & Assert
        Assert.assertEquals(tondeuse1, tondeuse2);
        Assert.assertEquals(tondeuse2, tondeuse1);
        assertEquals(tondeuse1.hashCode(), tondeuse2.hashCode());
    }

    @Test
    public void testEgaliteAvecPositionsDifferentes() {
        // Arrange
        Position position1 = new Position(1, 2, Orientation.N);
        Position position2 = new Position(3, 4, Orientation.S);
        List<Instruction> instructions1 = Arrays.asList(Instruction.A, Instruction.D);
        List<Instruction> instructions2 = Arrays.asList(Instruction.A, Instruction.D);

        Tondeuse tondeuse1 = new Tondeuse(position1, instructions1);
        Tondeuse tondeuse2 = new Tondeuse(position2, instructions2);

        // Act & Assert
        assertNotEquals(tondeuse1, tondeuse2);
        assertNotEquals(tondeuse2, tondeuse1);
    }

    @Test
    public void testEgaliteAvecInstructionsDifferentes() {
        // Arrange
        Position position1 = new Position(1, 2, Orientation.N);
        Position position2 = new Position(1, 2, Orientation.N);
        List<Instruction> instructions1 = Arrays.asList(Instruction.A, Instruction.D);
        List<Instruction> instructions2 = Arrays.asList(Instruction.G, Instruction.A);

        Tondeuse tondeuse1 = new Tondeuse(position1, instructions1);
        Tondeuse tondeuse2 = new Tondeuse(position2, instructions2);

        // Act & Assert
        assertNotEquals(tondeuse1, tondeuse2);
        assertNotEquals(tondeuse2, tondeuse1);
    }

    @Test
    public void testEgaliteAvecTypesObjetsDifferents() {
        // Arrange
        Tondeuse tondeuse = new Tondeuse(new Position(1, 2, Orientation.N), List.of(Instruction.A));

        // Act & Assert
        assertNotEquals("ce n'est pas une tondeuse", tondeuse);
        assertNotEquals(null, tondeuse);
    }

    @Test
    public void deplacerEnAvantOrientationNord() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.N);
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.A);
        Tondeuse tondeuse = new Tondeuse(position, instructions);
        Position positionTest = tondeuse.deplacer(myPelouse);
        Position expectedPosition = new Position(1, 3, Orientation.N);
        assertEquals(expectedPosition, positionTest);
    }

    @Test
    public void deplacerAGaucheOrientationNord() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.N);
        List<Instruction> instructions2 = new ArrayList<>();
        instructions2.add(Instruction.G);
        Tondeuse tondeuse2 = new Tondeuse(position, instructions2);
        Position positionTest2 = tondeuse2.deplacer(myPelouse);
        Position expectedPosition2 = new Position(1, 2, Orientation.O);
        assertEquals(expectedPosition2, positionTest2);
    }

    @Test
    public void deplacerADroiteOrientationNord() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.N);
        List<Instruction> instructions3 = new ArrayList<>();
        instructions3.add(Instruction.D);
        Tondeuse tondeuse3 = new Tondeuse(position, instructions3);
        Position positionTest3 = tondeuse3.deplacer(myPelouse);
        Position expectedPosition3 = new Position(1, 2, Orientation.E);
        assertEquals(expectedPosition3, positionTest3);
    }

    @Test
    public void deplacerEnAvantHorsPelouseOrientationNord() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 5, Orientation.N);
        List<Instruction> instructions4 = new ArrayList<>();
        instructions4.add(Instruction.A);
        Tondeuse tondeuse4 = new Tondeuse(position, instructions4);
        Position positionTest4 = tondeuse4.deplacer(myPelouse);
        Position expectedPosition4 = new Position(1, 5, Orientation.N);
        assertEquals(expectedPosition4, positionTest4);
    }

    @Test
    public void deplacerEnAvantOrientationEst() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.E);
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.A);
        Tondeuse tondeuse = new Tondeuse(position, instructions);
        Position positionTest = tondeuse.deplacer(myPelouse);
        Position expectedPosition = new Position(2, 2, Orientation.E);
        assertEquals(expectedPosition, positionTest);
    }

    @Test
    public void deplacerAGaucheOrientationEst() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.E);
        List<Instruction> instructions2 = new ArrayList<>();
        instructions2.add(Instruction.G);
        Tondeuse tondeuse2 = new Tondeuse(position, instructions2);
        Position positionTest2 = tondeuse2.deplacer(myPelouse);
        Position expectedPosition2 = new Position(1, 2, Orientation.N);
        assertEquals(expectedPosition2, positionTest2);
    }

    @Test
    public void deplacerADroiteOrientationEst() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.E);
        List<Instruction> instructions3 = new ArrayList<>();
        instructions3.add(Instruction.D);
        Tondeuse tondeuse3 = new Tondeuse(position, instructions3);
        Position positionTest3 = tondeuse3.deplacer(myPelouse);
        Position expectedPosition3 = new Position(1, 2, Orientation.S);
        assertEquals(expectedPosition3, positionTest3);
    }

    @Test
    public void deplacerEnAvantHorsPelouseOrientationEst() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(5, 5, Orientation.E);
        List<Instruction> instructions4 = new ArrayList<>();
        instructions4.add(Instruction.A);
        Tondeuse tondeuse4 = new Tondeuse(position, instructions4);
        Position positionTest4 = tondeuse4.deplacer(myPelouse);
        Position expectedPosition4 = new Position(5, 5, Orientation.E);
        assertEquals(expectedPosition4, positionTest4);
    }

    @Test
    public void deplacerEnAvantOrientationSud() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.S);
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.A);
        Tondeuse tondeuse = new Tondeuse(position, instructions);
        Position positionTest = tondeuse.deplacer(myPelouse);
        Position expectedPosition = new Position(1, 1, Orientation.S);
        assertEquals(expectedPosition, positionTest);
    }

    @Test
    public void deplacerAGaucheOrientationSud() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.S);
        List<Instruction> instructions2 = new ArrayList<>();
        instructions2.add(Instruction.G);
        Tondeuse tondeuse2 = new Tondeuse(position, instructions2);
        Position positionTest2 = tondeuse2.deplacer(myPelouse);
        Position expectedPosition2 = new Position(1, 2, Orientation.E);
        assertEquals(expectedPosition2, positionTest2);
    }

    @Test
    public void deplacerADroiteOrientationSud() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.S);
        List<Instruction> instructions3 = new ArrayList<>();
        instructions3.add(Instruction.D);
        Tondeuse tondeuse3 = new Tondeuse(position, instructions3);
        Position positionTest3 = tondeuse3.deplacer(myPelouse);
        Position expectedPosition3 = new Position(1, 2, Orientation.O);
        assertEquals(expectedPosition3, positionTest3);
    }

    @Test
    public void deplacerEnAvantHorsPelouseOrientationSud() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(5, 0, Orientation.S);
        List<Instruction> instructions4 = new ArrayList<>();
        instructions4.add(Instruction.A);
        Tondeuse tondeuse4 = new Tondeuse(position, instructions4);
        Position positionTest4 = tondeuse4.deplacer(myPelouse);
        Position expectedPosition4 = new Position(5, 0, Orientation.S);
        assertEquals(expectedPosition4, positionTest4);
    }

    @Test
    public void deplacerEnAvantOrientationOuest() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.O);
        List<Instruction> instructions = new ArrayList<>();
        instructions.add(Instruction.A);
        Tondeuse tondeuse = new Tondeuse(position, instructions);
        Position positionTest = tondeuse.deplacer(myPelouse);
        Position expectedPosition = new Position(0, 2, Orientation.O);
        assertEquals(expectedPosition, positionTest);
    }

    @Test
    public void deplacerAGaucheOrientationOuest() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.O);
        List<Instruction> instructions2 = new ArrayList<>();
        instructions2.add(Instruction.G);
        Tondeuse tondeuse2 = new Tondeuse(position, instructions2);
        Position positionTest2 = tondeuse2.deplacer(myPelouse);
        Position expectedPosition2 = new Position(1, 2, Orientation.S);
        assertEquals(expectedPosition2, positionTest2);
    }

    @Test
    public void deplacerADroiteOrientationOuest() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(1, 2, Orientation.O);
        List<Instruction> instructions3 = new ArrayList<>();
        instructions3.add(Instruction.D);
        Tondeuse tondeuse3 = new Tondeuse(position, instructions3);
        Position positionTest3 = tondeuse3.deplacer(myPelouse);
        Position expectedPosition3 = new Position(1, 2, Orientation.N);
        assertEquals(expectedPosition3, positionTest3);
    }

    @Test
    public void deplacerEnAvantHorsPelouseOrientationOuest() {
        Pelouse myPelouse = new Pelouse(5, 5);
        Position position = new Position(0, 2, Orientation.O);
        List<Instruction> instructions4 = new ArrayList<>();
        instructions4.add(Instruction.A);
        Tondeuse tondeuse4 = new Tondeuse(position, instructions4);
        Position positionTest4 = tondeuse4.deplacer(myPelouse);
        Position expectedPosition4 = new Position(0, 2, Orientation.O);
        assertEquals(expectedPosition4, positionTest4);
    }


}