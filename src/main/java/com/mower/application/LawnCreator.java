package com.mower.application;

import com.mower.application.utils.StringUtils;
import com.mower.domain.Lawn;

import java.util.Optional;

/**
 * The LawnCreator class is responsible for creating an instance of Lawn from an input line.
 */
public class LawnCreator {

    /**
     * Creates a lawn from an input line.
     *
     * @param inputLine The input line representing the dimensions of the lawn.
     * @return An instance of Lawn with the specified dimensions.
     */
    public Lawn createLawn(String inputLine) {
        String cleanedInputLine = StringUtils.removeAllWhitespaces(inputLine);

        int width = parseDigit(cleanedInputLine.charAt(0));
        int length = parseDigit(cleanedInputLine.charAt(1));

        return new Lawn(width, length);
    }

    private int parseDigit(char digit) {
        return Optional.of(Character.getNumericValue(digit))
                .filter(val -> val >= 0 && val <= 9)
                .orElseThrow(() -> new IllegalArgumentException("Invalid digit: " + digit));
    }
}
