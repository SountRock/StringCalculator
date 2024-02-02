package org.example.Models;

import org.example.Models.MathMethod.GammaFunc;
import org.example.Models.Search.LeftSideSearchModel;

import java.util.List;

public class ModelFactorial extends LeftSideSearchModel {
    public ModelFactorial() {
        super("!");
    }

    @Override
    public void operation(List<String> expression, int positionIndex) {
        double argument = Double.parseDouble(searchArgumenent(expression, positionIndex));

        for (int k = positionIndex - 1; k < positionIndex + 1; k++) {
            expression.remove(positionIndex - 1);
        }

        String temp = Double.toString(GammaFunc.gamma(argument + 1.0));
        expression.add(positionIndex - 1, temp);
    }
}
