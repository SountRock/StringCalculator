package org.example.Models;

import org.example.Models.Search.RightSideSearchModel;

import java.util.List;

/**
 * Модель вычисления квабратного корня
 */
public class ModelSquare extends RightSideSearchModel {
    public ModelSquare() {
        super("sqrt");
    }

    @Override
    public void operation(List<String> expression, int positionIndex) {
        double argument = Double.parseDouble(searchArgumenent(expression, positionIndex));

        for (int k = positionIndex; k < positionIndex + 2; k++) {
            expression.remove(positionIndex);
        }

        expression.add(positionIndex, Double.toString(Math.sqrt(argument)));
    }
}
