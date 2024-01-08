package com.mower.application.factory;

import com.mower.domain.Instruction;
import com.mower.domain.Orientation;
import com.mower.domain.Position;
import com.mower.domain.Mower;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MowerFactoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMowersFromLinesWithEmptyLines() {
        MowerFactory mowerCreator = new MowerFactory();
        List<String> lines = Arrays.asList("", "");

        mowerCreator.createMowersFromLines(lines);
    }

    @Test
    public void testCreateMowersFromLinesWithNonEmptyLines() {
        MowerFactory mowerCreator = new MowerFactory();
        List<String> lines = Arrays.asList("12N", "AADG", "34E", "DDAA");

        List<Mower> mowers = mowerCreator.createMowersFromLines(lines);

        assertEquals(2, mowers.size());

        Mower mower1 = mowers.getFirst();
        assertEquals(new Position(1, 2, Orientation.N), mower1.position());
        assertEquals(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.G), mower1.instructions());

        Mower mower2 = mowers.get(1);
        assertEquals(new Position(3, 4, Orientation.E), mower2.position());
        assertEquals(Arrays.asList(Instruction.D, Instruction.D, Instruction.A, Instruction.A), mower2.instructions());
    }

    @Test
    public void testCreateMowerFromLinesWithEmptyPositionLine() {
        MowerFactory mowerCreator = new MowerFactory();
        assertThrows(IllegalArgumentException.class, () ->
                mowerCreator.createMowerFromLines("", "AADG"));
    }

    @Test
    public void testCreateMowerFromLinesWithNonEmptyPositionLine() {
        MowerFactory mowerCreator = new MowerFactory();
        Mower mower = mowerCreator.createMowerFromLines("12N", "AADG");

        assertEquals(new Position(1, 2, Orientation.N), mower.position());
        assertEquals(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.G), mower.instructions());
    }


    @Test
    public void testParseInstructions() {
        MowerFactory mowerCreator = new MowerFactory();
        List<Instruction> instructions = mowerCreator.parseInstructions("AADG");

        assertEquals(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.G), instructions);
    }
}
