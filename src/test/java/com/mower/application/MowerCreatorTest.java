package com.mower.application;

import com.mower.domain.Instruction;
import com.mower.domain.Orientation;
import com.mower.domain.Position;
import com.mower.domain.Mower;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MowerCreatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMowersFromLinesWithEmptyLines() {
        MowerCreator mowerCreator = new MowerCreator();
        List<String> lines = Arrays.asList("", "");

        mowerCreator.createMowersFromLines(lines);
    }

    @Test
    public void testCreateMowersFromLinesWithNonEmptyLines() {
        MowerCreator mowerCreator = new MowerCreator();
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
        MowerCreator mowerCreator = new MowerCreator();
        assertThrows(IllegalArgumentException.class, () ->
                mowerCreator.createMowerFromLines("", "AADG"));
    }

    @Test
    public void testCreateMowerFromLinesWithNonEmptyPositionLine() {
        MowerCreator mowerCreator = new MowerCreator();
        Mower mower = mowerCreator.createMowerFromLines("12N", "AADG");

        assertEquals(new Position(1, 2, Orientation.N), mower.position());
        assertEquals(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.G), mower.instructions());
    }


    @Test
    public void testParseInstructions() {
        MowerCreator mowerCreator = new MowerCreator();
        List<Instruction> instructions = mowerCreator.parseInstructions("AADG");

        assertEquals(Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.G), instructions);
    }
}
