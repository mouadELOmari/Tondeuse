package com.tondeuse.application;

import com.tondeuse.domain.Instruction;
import com.tondeuse.domain.Orientation;
import com.tondeuse.domain.Position;
import com.tondeuse.domain.Tondeuse;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TondeuseCreateurTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreerTondeusesDepuisLignesAvecLignesVides() {
        TondeuseCreateur tondeuseCreateur = new TondeuseCreateur();
        List<String> lignes = Arrays.asList("", "");

        tondeuseCreateur.creerTondeusesDepuisLignes(lignes);

    }

    @Test
    public void testCreerTondeusesDepuisLignesAvecLignesNonVides() {
        TondeuseCreateur tondeuseCreateur = new TondeuseCreateur();
        List<String> lignes = Arrays.asList("12N", "AADG", "34E", "DDAA");

        List<Tondeuse> tondeuses = tondeuseCreateur.creerTondeusesDepuisLignes(lignes);

        assertEquals(2, tondeuses.size());

        Tondeuse tondeuse1 = tondeuses.getFirst();
        assertEquals(new Position(1, 2, Orientation.N), tondeuse1.getPosition());
        assertEquals(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.G), tondeuse1.getInstructions());

        Tondeuse tondeuse2 = tondeuses.get(1);
        assertEquals(new Position(3, 4, Orientation.E), tondeuse2.getPosition());
        assertEquals(Arrays.asList(Instruction.D, Instruction.D, Instruction.A, Instruction.A), tondeuse2.getInstructions());
    }

    @Test
    public void testCreerTondeuseDesLignesAvecLigneVide() {
        TondeuseCreateur tondeuseCreateur = new TondeuseCreateur();
        assertThrows(IllegalArgumentException.class, () ->
                tondeuseCreateur.creerTondeuseDesLignes("", "AADG"));
    }

    @Test
    public void testCreerTondeuseDesLignesAvecLigneNonVide() {
        TondeuseCreateur tondeuseCreateur = new TondeuseCreateur();
        Tondeuse tondeuse = tondeuseCreateur.creerTondeuseDesLignes("12N", "AADG");

        assertEquals(new Position(1, 2, Orientation.N), tondeuse.getPosition());
        assertEquals(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.G), tondeuse.getInstructions());
    }

    @Test
    public void testCreerTondeuseDesLignesAvecPositionVide() {
        TondeuseCreateur tondeuseCreateur = new TondeuseCreateur();
        assertThrows(IllegalArgumentException.class, () ->
                tondeuseCreateur.creerTondeuseDesLignes("", "AADG"));
    }

    @Test
    public void testParserInstructions() {
        TondeuseCreateur tondeuseCreateur = new TondeuseCreateur();
        List<Instruction> instructions = tondeuseCreateur.parserInstructions("AADG");

        assertEquals(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.G), instructions);
    }
}