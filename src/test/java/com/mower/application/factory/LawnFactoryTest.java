package com.mower.application.factory;

import com.mower.domain.Lawn;
import org.junit.Assert;
import org.junit.Test;


/**
 * Test class for LawnFactory.
 */
public class LawnFactoryTest {

    private final ILawnFactory lawnFactory = new LawnFactory();

    @Test
    public void testCreateLawnValidInput() {
        String inputLine = "34";

        Lawn lawn = lawnFactory.createLawn(inputLine);

        Assert.assertEquals(3, lawn.width());
        Assert.assertEquals(4, lawn.height());
    }

    @Test
    public void testCreateLawnInvalidDigit() {
        String inputLine = "3A";

        Assert.assertThrows(IllegalArgumentException.class, () -> lawnFactory.createLawn(inputLine));
    }

    @Test
    public void testCreateLawnInvalidInput() {
        String inputLine = " ";

        Assert.assertThrows(StringIndexOutOfBoundsException.class, () -> lawnFactory.createLawn(inputLine));
    }
}
