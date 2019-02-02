package com.mobiquityinc.packer;

import com.mobiquityinc.packer.domain.Thing;
import com.mobiquityinc.packer.exception.APIException;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
class LineParser {
    private static Pattern pattern = Pattern.compile("(?:\\((\\d+),([0-9]+\\.[0-9]+),€(\\d+)\\)\\s*)");
    private List<Thing> things = new ArrayList<>();
    private Integer overallWeight;
    @NonNull
    private final String line;

    LineParser(String line) {
        this.line = line;
    }

    void parse() throws APIException {

        String[] split = line.split(":");
        if (split.length != 2) {
            throw new APIException("Line " + line + " does not correspond to the format");
        }
        try {
            overallWeight = Integer.parseInt(split[0].trim());
        } catch (NumberFormatException e) {
            throw new APIException("Overall weight value is in incorrect format " + split[0]);
        }

        Matcher matcher = pattern.matcher(split[1].trim());

        if (!matcher.find()) {
            throw new APIException("Things' details are in wrong format in line " + line);
        }

        do {

            try {
                Integer index = Integer.parseInt(matcher.group(1));
                Double weight = Double.parseDouble(matcher.group(2));
                Double cost = Double.parseDouble(matcher.group(3));
                things.add(new Thing(index, weight, cost));
            } catch (NumberFormatException e) {
                throw new APIException("Thing's details are in wrong format in line " + line);
            }

        } while (matcher.find());


    }

}
