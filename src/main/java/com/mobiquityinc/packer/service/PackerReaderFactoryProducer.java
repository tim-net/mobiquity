package com.mobiquityinc.packer.service;

import java.io.File;

/**
 * Class to create reader factory based on input.
 * used pattern AbstractFactory
 */
public class PackerReaderFactoryProducer {
    public static <T extends File> PackerReaderFactory getFactory(T input) {
        return getFactoryImpl(input);
    }

    private static FilePackerReaderFactory getFactoryImpl(File file) {
        return new FilePackerReaderFactory(file);
    }

}
