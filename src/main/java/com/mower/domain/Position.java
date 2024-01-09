package com.mower.domain;

/**
 * Represents the position of a mower on a lawn.
 */
public class Position {

    /**
     * X-coordinate of the position.
     */
    private int x;

    /**
     * Y-coordinate of the position.
     */
    private int y;

    /**
     * Orientation of the mower.
     */
    private Orientation orientation;

    /**
     * Constructor of the Position class.
     *
     * @param x           The X-coordinate of the position.
     * @param y           The Y-coordinate of the position.
     * @param orientation The orientation of the mower.
     */
    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    /**
     * Moves the mower one step in the current direction.
     *
     * @param lawn The lawn on which the mower is moving.
     */
    void move(Lawn lawn) {
        int deltaX = switch (this.getOrientation()) {
            case N -> 0;
            case E -> 1;
            case W -> -1;
            case S -> 0;
        };

        int deltaY = switch (this.getOrientation()) {
            case N -> 1;
            case E -> 0;
            case W -> 0;
            case S -> -1;
        };
// The position cannot exceed the limits of the lawn
        this.x = Math.max(0, Math.min(this.x + deltaX, lawn.width()));
        this.y = Math.max(0, Math.min(this.y + deltaY, lawn.height()));
    }

    /**
     * Turns the mower to the right.
     */
    void turnRight() {
        orientation = orientation.turnRight();
    }

    /**
     * Turns the mower to the left.
     */
    void turnLeft() {
        orientation = orientation.turnLeft();
    }

    /**
     * Gets the X-coordinate of the position.
     *
     * @return The X-coordinate of the position.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the Y-coordinate of the position.
     *
     * @return The Y-coordinate of the position.
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the orientation of the mower.
     *
     * @return The orientation of the mower.
     */
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "" + x + y + orientation + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;
        return orientation == position.orientation;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + orientation.hashCode();
        return result;
    }
}
