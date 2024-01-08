package com.mower.domain;

/**
 * Represents the lawn where mowers move.
 *
 * @param width  Width of the lawn.
 * @param height Length of the lawn.
 */
public record Lawn(int width, int height) {

    /**
     * Constructor of the Lawn class.
     *
     * @throws IllegalArgumentException If the width or height is negative.
     */
    public Lawn {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
    }
}
