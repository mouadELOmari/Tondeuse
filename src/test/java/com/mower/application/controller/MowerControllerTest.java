package com.mower.application.controller;

import com.mower.application.factory.ILawnFactory;
import com.mower.application.factory.IMowerFactory;
import com.mower.application.io.FileContent;
import com.mower.application.io.IFileReader;
import com.mower.domain.*;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MowerControllerTest {

    static class TestFileReader implements IFileReader {
        @Override
        public FileContent readFile(String filePath) throws IOException {
            return new FileContent("5 5", Arrays.asList("1 2 N", "LMLMLMLMM", "3 3 E", "MMRMMRMRRM"));
        }
    }

    static class TestLawnFactory implements ILawnFactory {
        @Override
        public Lawn createLawn(String inputLine) {
            return new Lawn(5, 5);
        }
    }

    static class TestMowerFactory implements IMowerFactory {
        @Override
        public List<Mower> createMowersFromLines(List<String> lines) {
            return Arrays.asList(
                    new Mower(new Position(1, 2, Orientation.N), Arrays.asList(Instruction.D,Instruction.A)),
                    new Mower(new Position(3, 3, Orientation.W), Arrays.asList(Instruction.G,Instruction.D))
            );
        }
    }

    @Test
    public void testGetFinalPosition() {
        // Create instances of mocked classes
        IFileReader fileReader = new TestFileReader();
        ILawnFactory lawnCreator = new TestLawnFactory();
        IMowerFactory mowerCreator = new TestMowerFactory();

        // Create an instance of MowerController
        MowerController mowerController = new MowerController(fileReader, lawnCreator, mowerCreator);

        // Test the getFinalPosition method
        String result = mowerController.getFinalPosition("testFilePath");

        // Assert the result
        String expectedResult = "22E 33W ";
        assertEquals(expectedResult, result);
    }
}
