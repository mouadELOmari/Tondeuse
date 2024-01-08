package com.mower.domain;

/**
 * The Instruction enumeration represents the different possible instructions for a mower.
 * Each instruction is associated with a letter: G (Left), D (Right), A (Advance).
 */
public enum Instruction {
    G("G"),
    D("D"),
    A("A");

    final String name;

    Instruction(String name) {
        this.name = name;
    }

    /**
     * Returns the instruction associated with the specified letter.
     *
     * @param instruction The letter representing the instruction (G, D, A).
     * @return The corresponding instruction.
     */
    public static Instruction get(char instruction) {
        return switch (instruction) {
            case 'G' -> G;
            case 'D' -> D;
            case 'A' -> A;
            default -> throw new IllegalArgumentException("Unexpected value: " + instruction);
        };
    }

    @Override
    public String toString() {
        return name;
    }
}
