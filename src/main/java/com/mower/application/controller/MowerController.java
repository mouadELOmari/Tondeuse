package com.mower.application.controller;

import com.mower.application.LawnCreator;
import com.mower.application.MowerCreator;
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

    /**
     * Constructor for MowerController.
     *
     * @param fileReader The file reader implementation to be used.
     */
    public MowerController(IFileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public String getFinalPosition(String filePath) {
        try {
            // Initialization of file readers and creators
            LawnCreator lawnCreator = new LawnCreator();
            MowerCreator mowerCreator = new MowerCreator();

            FileContent fileContent = fileReader.readFile(filePath);

            // Read the first line to set the lawn boundaries
            String lawnLimits = fileContent.firstLine();
            Lawn myLawn = lawnCreator.createLawn(lawnLimits);

            // Read lines for each mower
            List<String> mowerLines = fileContent.lines();
            List<Mower> mowers = mowerCreator.createMowersFromLines(mowerLines);

            // Move each mower and retrieve the final positions
            Position finalPosition;
            StringBuilder result = new StringBuilder();
            for (Mower mower : mowers) {
                finalPosition = mower.move(myLawn);
                result.append(finalPosition);
            }
            return result.toString();

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, READ_FILE_ERROR_EXCEPTION, e);
            throw new RuntimeException(READ_FILE_ERROR_EXCEPTION, e);
        }
    }
}
