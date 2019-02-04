package com.mobiquityinc.packer.service;

import com.mobiquityinc.packer.domain.Thing;
import com.mobiquityinc.packer.exception.ParseException;
import com.mobiquityinc.packer.exception.ReadException;
import com.mobiquityinc.packer.parser.LineParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

import static com.mobiquityinc.packer.Packer.ZERO_FOUND;

/**
 * Reader for file based input.
 */
public class PackerFileReader implements PackerReader {

    private final File file;

    PackerFileReader(File file) {
        this.file = file;
    }

    @Override
    public String getResult(LineParser lineParser, Collector<CharSequence, ?, String> indexJoiner, Collector<CharSequence, ?, String> linesJoiner) throws ParseException, ReadException {

        List<String> results = new ArrayList<>();
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lineParser.setLine(line);
                    lineParser.parse();

                    List<Thing> s = PackerSolver.solve(lineParser.getThings(), lineParser.getOverallWeight());
                    results.add(s.size() == 0 ? ZERO_FOUND : s.stream().sorted(Comparator.comparingInt(Thing::getIndex))
                            .map(thing -> String.valueOf(thing.getIndex()))
                            .collect(indexJoiner));
                }
            }
        } catch (IOException e) {
            throw new ReadException("An error occurred during reading the file", e);
        }
        return results.stream().collect(linesJoiner);
    }
}
