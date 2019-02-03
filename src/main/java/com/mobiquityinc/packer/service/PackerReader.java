package com.mobiquityinc.packer.service;

import com.mobiquityinc.packer.exception.ParseException;
import com.mobiquityinc.packer.exception.ReadException;
import com.mobiquityinc.packer.parser.LineParser;

import java.util.stream.Collector;

/**
 * Interface for readers. Part of the abstract factory.
 */
public interface PackerReader {

    /**
     * Returns the resulting string.
     * @param lineParser Instance of LineParser {@link LineParser} that will be used to parse a line
     * @param indexJoiner {@link Collector} instance to join found indexes
     * @param linesJoiner {@link Collector} instance to join lines in the result
     * @return result as a string
     * @throws ParseException is thrown when parsing is impossible or unsuccessful
     * @throws ReadException is thrown when reading from input is impossible or unsuccessful
     */
    String getResult(LineParser lineParser, Collector<CharSequence, ?, String> indexJoiner, Collector<CharSequence, ?, String> linesJoiner) throws ParseException, ReadException;
}
