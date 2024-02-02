package org.example.Models;

import org.example.Models.Search.LeftSideSearchModel;
import org.example.Models.Search.RigthSideSearchModel;

import java.util.List;

public class ModelSquare extends RigthSideSearchModel {
    public ModelSquare() {
        super("#");
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
