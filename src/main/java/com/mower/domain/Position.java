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
        int deltaX = 0;
        int deltaY = 0;

        switch (this.getOrientation()) {
            case N -> deltaY = 1;
            case E -> deltaX = 1;
            case W -> deltaX = -1;
            case S -> deltaY = -1;
        }
        // The position cannot exceed the limits of the lawn
        int newX = Math.max(0, Math.min(this.x + deltaX, lawn.width()));
        int newY = Math.max(0, Math.min(this.y + deltaY, lawn.height()));

        this.x = newX;
        this.y = newY;
    }

    /**
     * Turns the mower to the right.
     */
    void turnRight() {
        switch (this.orientation) {
            case N -> orientation = Orientation.E;
            case E -> orientation = Orientation.S;
            case W -> orientation = Orientation.N;
            case S -> orientation = Orientation.W;
        }
    }

    /**
     * Turns the mower to the left.
     */
    void turnLeft() {
        switch (this.orientation) {
            case N -> orientation = Orientation.W;
            case E -> orientation = Orientation.N;
            case W -> orientation = Orientation.S;
            case S -> orientation = Orientation.E;
        }
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
