package com.mobiquityinc.packer.parser;

import com.mobiquityinc.packer.domain.Thing;
import com.mobiquityinc.packer.exception.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parser for a common format,
 * one that is only known.
 */
public class CommonFormatParser extends LineParser {
    private static Pattern formatCheckPattern = Pattern.compile("^(?:\\((\\d+),([0-9]+\\.[0-9]+),€(\\d+)\\)\\s*)+$");
    private static Pattern groupsPattern = Pattern.compile("(?:\\((\\d+),([0-9]+\\.[0-9]+),€(\\d+)\\)\\s*)");


    public void parse() throws ParseException {

        String[] split = line.split(":");
        if (split.length != 2) {
            throw new ParseException("Line " + line + " does not correspond to the format");
        }
        try {
            overallWeight = Integer.parseInt(split[0].trim());
        } catch (NumberFormatException e) {
            throw new ParseException("Overall weight value is in incorrect format " + split[0]);
        }

        String groups = split[1].trim();
        Matcher formatMatcher = formatCheckPattern.matcher(groups);

        if (!formatMatcher.find()) {
            throw new ParseException("Things' details are in wrong format in line " + line);
        }

        Matcher matcher = groupsPattern.matcher(groups);

        things.clear();
        while (matcher.find()) {

            try {
                Integer index = Integer.parseInt(matcher.group(1));
                Float weight = Float.parseFloat(matcher.group(2));
                Float cost = Float.parseFloat(matcher.group(3));
                things.add(new Thing(index, weight, cost));
            } catch (NumberFormatException e) {
                throw new ParseException("Thing's details are in wrong format in line " + line);
            }

        }

        if (things.size() == 0) {
            throw new ParseException("Number of things has to be more that 0");
        }

    }

}
