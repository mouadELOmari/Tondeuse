package com.mower.application.controller;

import com.mower.application.io.FakeFileReader;
import com.mower.application.io.FileContent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MowerControllerTest {

    private IMowerController mowerController;

    @Before
    public void setUp() {
        mowerController = new MowerController(new FakeFileReader(new FileContent("55", Arrays.asList("12N", "AAG"))));
    }

    @Test
    public void testGetFinalPosition() {
        String finalPosition = mowerController.getFinalPosition("fake/path");

        // Add assertions based on the expected behavior of your application
        Assert.assertEquals("14W ", finalPosition);
    }
}