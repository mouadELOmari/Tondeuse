package com.mower.application.io;

import com.mower.application.exception.FileNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader implements IFileReader  {

    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());

    private static final String FILE_NOT_FOUND_EXCEPTION = "File not found: ";
    private static final String LOG_BEGIN_EXTRACTION = "Start of data extraction";


    public FileContent readFile(final String filePath) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            LOGGER.log(Level.INFO, LOG_BEGIN_EXTRACTION);

            String firstLine = reader.readLine();

            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            return new FileContent(firstLine, lines);
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(FILE_NOT_FOUND_EXCEPTION + filePath, e);
        }
    }
}

