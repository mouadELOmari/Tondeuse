package com.tondeuse.application.utils;

public class StringUtils {
    private StringUtils() {
        throw new IllegalStateException("Util class");
    }

    public static String removeAllWhitespaces(String str) {
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (!Character.isWhitespace(aChar)) {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }
}
