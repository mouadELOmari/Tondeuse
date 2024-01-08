package com.mower.application.factory;

import com.mower.application.controller.IMowerController;
import com.mower.application.controller.MowerController;
import com.mower.application.io.FileReader;
import com.mower.application.io.IFileReader;

/**
 * Factory class for creating instances of Mower-related components.
 */
public class MowerControllerFactory {

    /**
     * Creates an instance of IMowerController with default dependencies.
     *æ
     * @return An instance of IMowerController.
     */
    public static IMowerController createMowerController() {
        IFileReader fileReader = new FileReader();
        ILawnFactory lawnFactory = new LawnFactory();
        IMowerFactory mowerFactory = new MowerFactory();
        return new MowerController(fileReader, lawnFactory, mowerFactory);
    }
}
