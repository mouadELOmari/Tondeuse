package com.mower.application.io;

import java.io.IOException;

public interface IFileReader {
    FileContent readFile(String filePath) throws IOException;

}
