package com.mower.application.io;

public class FakeFileReader implements IFileReader {
    private final FileContent fileContent;

    public FakeFileReader(FileContent fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public FileContent readFile(String filePath) {
        return fileContent;
    }
}
