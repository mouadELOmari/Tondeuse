package com.mower.domain;

import java.util.List;

/**
 * Represents a mower in the system.
 *
 * @param position     The current position of the mower.
 * @param instructions The instructions to be followed by the mower.
 */
public record Mower(Position position, List<Instruction> instructions) {

    /**
     * Moves the mower on the lawn based on its instructions.
     *
     * @param lawn The lawn on which the mower is moving.
     * @return The new position of the mower after executing the instructions.
     */
    public Position move(Lawn lawn) {
        for (Instruction instruction : instructions) {
            switch (instruction) {
                case A -> moveForward(lawn);
                case G -> turnLeft();
                case D -> turnRight();
            }
        }
        return new Position(position.getX(), position.getY(), position.getOrientation());
    }

    /**
     * Moves the mower one step in the current direction.
     *
     * @param lawn The lawn on which the mower is moving.
     */
    private void moveForward(Lawn lawn) {
        position.move(lawn);
    }

    /**
     * Turns the mower to the right.
     */
    private void turnRight() {
        position.turnRight();
    }

    /**
     * Turns the mower to the left.
     */
    private void turnLeft() {
        position.turnLeft();
    }

}
