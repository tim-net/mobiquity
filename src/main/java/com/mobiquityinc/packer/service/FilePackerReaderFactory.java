package com.mobiquityinc.packer.service;

import java.io.File;

/**
 * Implementation of a factory for reading from file input.
 */
public class FilePackerReaderFactory extends PackerReaderFactory<File> {
    FilePackerReaderFactory(File input) {
        super(input);
    }

    @Override
    public PackerReader getReader() {
        return new PackerFileReader(input);
    }
}
