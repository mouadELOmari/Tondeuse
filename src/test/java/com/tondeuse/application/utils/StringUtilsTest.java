package com.tondeuse.application.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StringUtilsTest {
    private final static String EMPTY_STRING ="";

    @Test
    public void testRemoveAllWhitespacesWithWhitespace() {
        String input = "done done";

        String result = StringUtils.removeAllWhitespaces(input);

        assertEquals("donedone", result);
    }

    @Test
    public void testRemoveAllWhitespacesWithoutWhitespace() {
        String input = "SANSESPACE";

        String result = StringUtils.removeAllWhitespaces(input);

        assertEquals("SANSESPACE", result);
    }

    @Test
    public void testRemoveAllWhitespacesWithMixedCharacters() {
        String input = "TONDEUSE123TONDEUSE";

        String result = StringUtils.removeAllWhitespaces(input);

        assertEquals("TONDEUSE123TONDEUSE", result);
    }

    @Test
    public void testRemoveAllWhitespacesWithEmptyString() {

        String result = StringUtils.removeAllWhitespaces(EMPTY_STRING);

        assertEquals(EMPTY_STRING, result);
    }

    @Test
    public void testRemoveAllWhitespacesWithNullString() {
        String input = null;

        StringUtils.removeAllWhitespaces(input);

        assertNull(null);
    }
}
