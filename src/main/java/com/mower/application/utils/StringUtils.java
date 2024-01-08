package com.mower.application.utils;

import java.util.stream.Collectors;

public class StringUtils {
    private StringUtils() {
        throw new IllegalStateException("Util class");
    }

    public static String removeAllWhitespaces(String str) {
        if (str == null) {
            return null;
        }

        return str.chars()
                .filter(c -> !Character.isWhitespace(c))
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
