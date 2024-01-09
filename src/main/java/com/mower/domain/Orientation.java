package com.mower.domain;

/**
 * The Orientation enumeration represents the different possible orientations of a mower.
 * Each orientation is associated with a letter: N (North), E (East), O (West), S (South).
 */
public enum Orientation {
    N("N"),
    E("E"),
    W("W"),
    S("S");

    final String name;

    Orientation(String name) {
        this.name = name;
    }

    /**
     * Returns the orientation associated with the specified letter.
     *
     * @param orientation The letter representing the orientation (N, E, O, S).
     * @return The corresponding orientation.
     */
    public static Orientation get(char orientation) {
        char upperCaseOrientation = Character.toUpperCase(orientation);
        return switch (upperCaseOrientation) {
            case 'N' -> N;
            case 'E' -> E;
            case 'W' -> W;
            case 'S' -> S;
            default -> throw new IllegalArgumentException("Unexpected value: " + upperCaseOrientation);
        };
    }
    /**
     * Turns the orientation to the right.
     *
     * @return The new orientation after turning right.
     */
    public Orientation turnRight() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case W -> N;
            case S -> W;
        };
    }

    /**
     * Turns the orientation to the left.
     *
     * @return The new orientation after turning left.
     */
    public Orientation turnLeft() {
        return switch (this) {
            case N -> W;
            case E -> N;
            case W -> S;
            case S -> E;
        };
    }


    @Override
    public String toString() {
        return name;
    }
}
