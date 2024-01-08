package com.mower.application;

import com.mower.application.utils.StringUtils;
import com.mower.domain.Instruction;
import com.mower.domain.Orientation;
import com.mower.domain.Position;
import com.mower.domain.Mower;

import java.util.ArrayList;
import java.util.List;

/**
 * The MowerCreator class is responsible for creating Mower objects
 * from position and instruction lines.
 */
public class MowerCreator {

    /**
     * Exception message for an empty or null position line.
     */
    private final static String EXCEPTION_MESSAGE_EMPTY_LINE = "The position line is empty or null.";

    /**
     * Creates a list of mowers from position and instruction lines.
     *
     * @param lines The lines containing positions and instructions.
     * @return A list of Mower objects.
     * @throws IllegalArgumentException If the position line is empty or null.
     */
    public List<Mower> createMowersFromLines(List<String> lines) {
        List<Mower> mowers = new ArrayList<>();
        for (int i = 0; i < lines.size(); i += 2) {
            String positionLine = lines.get(i);
            String instructionsLine = lines.get(i + 1);
            Mower mower = createMowerFromLines(positionLine, instructionsLine);
            mowers.add(mower);
        }
        return mowers;
    }

    /**
     * Creates a Mower object from position and instruction lines.
     *
     * @param positionLine     The position line.
     * @param instructionsLine The instruction line.
     * @return A Mower object.
     * @throws IllegalArgumentException If the position line is empty or null.
     */
    public Mower createMowerFromLines(String positionLine, String instructionsLine) {
        // Check if the positionLine is empty or null
        if (positionLine == null || positionLine.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_EMPTY_LINE);
        }
        positionLine = StringUtils.removeAllWhitespaces(positionLine);
        int horizontal = Character.getNumericValue(positionLine.charAt(0));
        int vertical = Character.getNumericValue(positionLine.charAt(1));
        Orientation orientation = Orientation.get(positionLine.charAt(2));

        Position position = new Position(horizontal, vertical, orientation);
        List<Instruction> instructions = parseInstructions(instructionsLine);

        return new Mower(position, instructions);
    }

    /**
     * Parses the instruction line and returns a list of Instruction objects.
     *
     * @param line The instruction line.
     * @return A list of Instruction objects.
     */
    public List<Instruction> parseInstructions(String line) {
        List<Instruction> instructions = new ArrayList<>();
        for (char instructionChar : line.toCharArray()) {
            Instruction enumInstruction = Instruction.get(instructionChar);
            instructions.add(enumInstruction);
        }
        return instructions;
    }
}
