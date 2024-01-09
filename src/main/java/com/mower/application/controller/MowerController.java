package com.mower.application.controller;

import com.mower.application.factory.ILawnFactory;
import com.mower.application.factory.IMowerFactory;
import com.mower.application.io.FileContent;
import com.mower.application.io.IFileReader;
import com.mower.domain.Lawn;
import com.mower.domain.Position;
import com.mower.domain.Mower;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The MowerController class is responsible for managing mowers,
 * reading data, and retrieving the final positions.
 */
public class MowerController implements IMowerController {
    private static final Logger LOGGER = Logger.getLogger(MowerController.class.getName());
    private static final String READ_FILE_ERROR_EXCEPTION = "An error occurred while reading the file.";

    private final IFileReader fileReader;
    private final ILawnFactory lawnCreator;
    private final IMowerFactory mowerCreator;

    /**
     * Constructor for MowerController.
     *
     * @param fileReader  The file reader implementation to be used.
     * @param lawnCreator The lawn creator implementation to be used.
     * @param mowerCreator The mower creator implementation to be used.
     */
    public MowerController(IFileReader fileReader, ILawnFactory lawnCreator, IMowerFactory mowerCreator) {
        this.fileReader = fileReader;
        this.lawnCreator = lawnCreator;
        this.mowerCreator = mowerCreator;
    }

    @Override
    public String getFinalPosition(String filePath) {
        try {
            LOGGER.log(Level.INFO, "Initializing MowerController...");

            LOGGER.log(Level.INFO, "Reading file: {0}", filePath);
            FileContent fileContent = fileReader.readFile(filePath);

            // Read the first line to set the lawn boundaries
            String lawnLimits = fileContent.firstLine();
            LOGGER.log(Level.INFO, "Creating Lawn with dimensions: {0}", lawnLimits);
            Lawn myLawn = lawnCreator.createLawn(lawnLimits);

            // Read lines for each mower
            List<String> mowerLines = fileContent.lines();
            LOGGER.log(Level.INFO, "Creating Mowers from lines...");
            List<Mower> mowers = mowerCreator.createMowersFromLines(mowerLines);

            // Move each mower and retrieve the final positions
            StringBuilder result = new StringBuilder();
            LOGGER.log(Level.INFO, "Moving mowers and retrieving final positions...");
            List<Position> finalPositions = mowers.stream()
                    .map(mower -> mower.move(myLawn))
                    .toList();

            finalPositions.forEach(result::append);

            LOGGER.log(Level.INFO, "MowerController execution complete.");
            return result.toString();

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, READ_FILE_ERROR_EXCEPTION, e);
            throw new RuntimeException(READ_FILE_ERROR_EXCEPTION, e);
        }
    }
}
