package org.example.Models.Search;

import org.example.AnalizeTools.Analizerv2;
import org.example.Models.Operation;

import java.util.ArrayList;
import java.util.List;

public class LeftSideSearchModel implements Operation {
    String operationIndex;
    Analizerv2 anaizer;

    public LeftSideSearchModel(String operationIndex) {
        this.operationIndex = operationIndex;
    }

    @Override
    public void operation(List<String> expression, int positionIndex) {}

    @Override
    public boolean isThisOperation(String operation) {
        return operation.equals(operationIndex);
    }

    public String searchArgumenent(List<String> expr, int positionIndex) {
        if(!expr.get(positionIndex - 1).equals("(")){
            return expr.get(positionIndex - 1);
        }

        List<String> temp = anaizer.compare(expr, positionIndex - 1, "(", ")");

        return anaizer.analize(temp).toString();
    }
}
