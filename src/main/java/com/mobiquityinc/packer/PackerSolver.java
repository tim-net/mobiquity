package com.mobiquityinc.packer;

import com.mobiquityinc.packer.domain.Thing;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class PackerSolver {

    static List<Thing> solve(final List<Thing> things, final Integer maximumWeight) {

        things.sort(Comparator.comparingDouble(Thing::getWeight));

        int numberOfThings = things.size();

        // we use a matrix to store the max value at each n-th item
        int[][] matrix = new int[numberOfThings + 1][maximumWeight * 100 + 1];


        int minWeight = (int) things.stream().min(Comparator.comparingDouble(Thing::getWeight)).get().getWeight().doubleValue()*100;

        // first line is initialized to 0
        for (int i = minWeight; i <= maximumWeight * 100; i++) {
            matrix[0][i] = 0;

        }

        // we iterate on things
        for (int i = 1; i <= numberOfThings; i++) {
            // we iterate on each maximumWeight
            for (int j = minWeight; j <= maximumWeight * 100; j++) {
                if (things.get(i - 1).getWeight() * 100 > j)
                    matrix[i][j] = matrix[i - 1][j];
                else
                    // we maximize value at this rank in the matrix
                    matrix[i][j] = Math.max(matrix[i - 1][j], (int) Math.floor(matrix[i - 1][j - (int) Math.ceil(things.get(i - 1).getWeight() * 100)]
                            + things.get(i - 1).getCost()));
            }
        }

        int res = matrix[numberOfThings][maximumWeight * 100];
        int w = maximumWeight * 100;
        List<Thing> thingsSolution = new ArrayList<>();

        for (int i = numberOfThings; i > 0 && res > 0; i--) {
            if (res != matrix[i - 1][w]) {
                thingsSolution.add(things.get(i - 1));
                // we remove things value and weight
                res -= Math.floor(things.get(i - 1).getCost());
                w -= Math.floor(things.get(i - 1).getWeight() * 100);
            }
        }

        return thingsSolution;

    }

}
