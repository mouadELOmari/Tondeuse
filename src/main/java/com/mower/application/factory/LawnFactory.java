package com.mower.application.factory;

import com.mower.application.utils.StringUtils;
import com.mower.domain.Lawn;

import java.util.Optional;

/**
 * The LawnFactory class is responsible for creating an instance of Lawn from an input line.
 */
public class LawnFactory implements ILawnFactory{

    /**
     * Creates a lawn from an input line.
     *
     * @param inputLine The input line representing the dimensions of the lawn.
     * @return An instance of Lawn with the specified dimensions.
     */
    public Lawn createLawn(String inputLine) {
        String cleanedInputLine = StringUtils.removeAllWhitespaces(inputLine);

        int width = parseDigit(cleanedInputLine.charAt(0));
        int height = parseDigit(cleanedInputLine.charAt(1));

        return new Lawn(width, height);
    }

    private int parseDigit(char digit) {
        return Optional.of(Character.getNumericValue(digit))
                .orElseThrow(() -> new IllegalArgumentException("Invalid digit: " + digit));
    }
}
