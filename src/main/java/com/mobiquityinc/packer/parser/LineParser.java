package com.mobiquityinc.packer.parser;

import com.mobiquityinc.packer.domain.Thing;
import com.mobiquityinc.packer.exception.ParseException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for line parsers,
 * pattern Template is used
 */
@Getter
public abstract class LineParser {
    protected List<Thing> things = new ArrayList<>();
    protected Integer overallWeight;
    @Setter
    @NonNull
    protected String line;

    /**
     * Parse a line and fill list of things and overall weight.
     * @throws ParseException thrown when parsing is impossible or unsuccessful
     */
    public abstract void parse() throws ParseException;
}
