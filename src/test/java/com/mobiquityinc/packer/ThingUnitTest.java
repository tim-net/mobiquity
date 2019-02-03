package com.mobiquityinc.packer;


import com.mobiquityinc.packer.domain.Thing;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThingUnitTest {

    @Test
    public void testCreate() {
        Integer index = 1;
        Float weight = 2.0f;
        Float cost = 3.0f;
        Thing thing = new Thing(index, weight, cost);
        assertNotNull(thing.getIndex());
        assertNotNull(thing.getWeight());
        assertNotNull(thing.getCost());
        assertEquals(1, (int) thing.getIndex());
        assertEquals(2.0f, thing.getWeight(), 0.0);
        assertEquals(3.0f, thing.getCost(), 0.0);
    }

}
