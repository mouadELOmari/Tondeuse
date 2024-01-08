package com.mower.application;

import com.mower.application.controller.IMowerController;
import com.mower.application.controller.MowerController;
import com.mower.application.io.FileReader;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class of the Mower application.
 * This class contains the main method "main" that launches the execution of the mower controller.
 */
public class MowerApplicationMain {
    private static final Logger LOGGER = Logger.getLogger(MowerApplicationMain.class.getName());

    /**
     * The main entry point for the Mower application.
     *
     * @param args Command line arguments. Expects the filename as the first argument.
     */
    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "Mower application started.");

        if (args.length < 1) {
            LOGGER.log(Level.SEVERE, "Invalid path. Please provide a valid file path.");
            LOGGER.log(Level.INFO, "Mower application terminated due to an invalid path.");
            return;        }

        // Get the filename from the command line arguments
        final String filename = args[0];

        LOGGER.log(Level.INFO, "Processing file: {0}", filename);
        // Create an instance of the MowerController with a FileReader implementation
        IMowerController mowerController = new MowerController(new FileReader());

        // Get the final position of the mowers
        String finalPosition = mowerController.getFinalPosition(filename);

        // Log the final position information
        LOGGER.log(Level.INFO, "The final position is {0}", finalPosition);
    }
}
