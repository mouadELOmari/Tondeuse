package com.mower.application.factory;

import com.mower.domain.Mower;

import java.util.List;

/**
 * Interface for creating Mower objects from position and instruction lines.
 */
public interface IMowerFactory {

    /**
     * Creates a list of mowers from a list of lines representing mower positions and instructions.
     *
     * @param lines The list of lines containing mower positions and instructions.
     * @return A list of Mower objects created from the provided lines.
     * @throws IllegalArgumentException If the input lines are null or empty.
     */
    List<Mower> createMowersFromLines(List<String> lines);

}
