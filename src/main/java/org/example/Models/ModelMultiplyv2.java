package org.example.Models;

import org.example.Models.Search.TwoSidesSearchModel;

import java.util.List;

/**
 * Модель деления
 */
public class ModelMultiplyv2 extends TwoSidesSearchModel {

    public ModelMultiplyv2() {
        super("*");
    }

    @Override
    public void operation(List<String> expression, int positionIndex) {
        List<Double> arguments= searchArgumenent(expression, positionIndex);

        for (int k = positionIndex - 1; k < positionIndex + 2; k++) {
            expression.remove(positionIndex - 1);
        }

        String temp = Double.toString(arguments.get(0) * arguments.get(1));
        expression.add(positionIndex - 1, temp);
    }
}
