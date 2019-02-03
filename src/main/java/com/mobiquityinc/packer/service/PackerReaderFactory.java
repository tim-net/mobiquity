package com.mobiquityinc.packer.service;

/**
 * Abstract factory for readers
 * @param <T> input object
 */
public abstract class PackerReaderFactory<T> {
    T input;

    PackerReaderFactory(T input) {
        this.input = input;
    }

    /**
     * Method should return correspondent reader object.
     * @return reader.
     */
    public abstract PackerReader getReader();
}
