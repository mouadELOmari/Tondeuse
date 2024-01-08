package com.mower.application.factory;

import com.mower.domain.Lawn;

/**
 * Interface for creating an instance of Lawn from an input line.
 */
public interface ILawnFactory {

    /**
     * Creates a lawn from an input line.
     *
     * @param inputLine The input line representing the dimensions of the lawn.
     * @return An instance of Lawn with the specified dimensions.
     */
    Lawn createLawn(String inputLine);
}
