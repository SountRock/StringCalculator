package org.example.Models;

import org.example.Models.ModelOperation;

public class ModelMultiply implements ModelOperation {
    String oprerationIndex = "*";
    @Override
    public String operation(String expression) {
        String[] elements = expression.toLowerCase().replaceAll(" ", "").
                replaceAll("\\(", "").
                replaceAll("\\)", "").
                replaceAll("\\]", "").
                replaceAll("\\[", "").
                replaceAll("\\{", "").
                replaceAll("\\}", "").
                split("\\*");

        double result = 1;
        for (String elem : elements) {
            result *= Double.parseDouble(elem);
        }
        return Double.toString(result);
    }

    @Override
    public boolean isThisOperation(String operation) {
        return operation.equals(oprerationIndex);
    }
}
