package org.example.Models.Search;

import org.example.Models.Operation;

import java.util.ArrayList;
import java.util.List;

public class RigthSideSearchModel implements Operation {
    String operationIndex;

    public RigthSideSearchModel(String operationIndex) {
        this.operationIndex = operationIndex;
    }

    @Override
    public void operation(List<String> expression, int positionIndex) {}

    @Override
    public boolean isThisOperation(String operation) {
        return operation.equals(operationIndex);
    }

    public String searchArgumenent(List<String> expr, int positionIndex) {
        return expr.get(positionIndex + 1);
    }
}
