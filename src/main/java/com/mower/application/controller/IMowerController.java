package com.mower.application.controller;

/**
 * Interface for managing mowers, reading data, and retrieving final positions.
 */
public interface IMowerController {

    /**
     * Retrieves the final positions of the mowers after reading the data.
     *
     * @param filePath The path of the file containing mower data.
     * @return A string representing the final positions of the mowers.
     */
    String getFinalPosition(String filePath);
}
