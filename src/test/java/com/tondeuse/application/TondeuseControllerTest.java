package com.tondeuse.application;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TondeuseControllerTest {

    @Test
    public void getPositionFinale_Success() {
        String result = TondeuseController.getPositionFinale();

        assertEquals("13N 51E ", result);
    }
}
