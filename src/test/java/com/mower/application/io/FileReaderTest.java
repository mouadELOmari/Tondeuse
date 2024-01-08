package com.mower.application.io;

import com.mower.application.exception.FileNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileReaderTest {

    @Test
    public void readFile_ValidFile_ReturnsFileContent() throws IOException {
        // Arrange
        String filePath = "src/resources/input.txt";
        String firstLine = "5 5";
        String line1 = "1 2 N";
        String line2 = "GAGAGAGAA";
        String line3 = "3 3 E";
        String line4 = "AADAADADDA";
        List<String> expectedLines = Arrays.asList(line1, line2,line3,line4);

        // Instantiate the FileReader
        FileReader fileReader = new FileReader();

        // Act
        FileContent fileContent = fileReader.readFile(filePath);

        // Assert
        Assert.assertEquals(firstLine, fileContent.firstLine());
        Assert.assertEquals(expectedLines, fileContent.lines());
    }

    @Test
    public void readFile_FileNotFound_ThrowsFileNotFoundException() {
        // Arrange
        String filePath = "nonexistentFilePath";

        // Instantiate the FileReader
        FileReader fileReader = new FileReader();

        // Act & Assert
        Assert.assertThrows(FileNotFoundException.class, () -> fileReader.readFile(filePath));
    }

    @Test
    public void readFile_IOExceptionInReader_ThrowsIOException() {
        // Arrange
        String filePath = "validFilePath";

        // Create a custom FileReader for testing (may need to expose protected methods)
        FileReader fileReader = new FileReader() {
            protected BufferedReader createBufferedReader(String filePath) throws IOException {
                throw new IOException(); // Simulate an IOException
            }
        };

        // Act & Assert
        Assert.assertThrows(IOException.class, () -> fileReader.readFile(filePath));
    }

}
