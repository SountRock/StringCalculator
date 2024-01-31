package org.example.Models;

import java.util.Arrays;

public class ModelPower implements ModelOperation {
    String oprerationIndex = "pow";
    @Override
    public String operation(String expression) {
        String[] elements = expression.toLowerCase().replaceAll(" ", "").
                replaceAll("\\(", "").
                replaceAll("\\)", "").
                replaceAll("\\]", "").
                replaceAll("\\[", "").
                replaceAll("\\{", "").
                replaceAll("\\}", "").
                split("pow");

        double result = Double.parseDouble(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            float powerIndex = Float.parseFloat(elements[i]);
            result = Math.pow(result, powerIndex);
        }

        return Double.toString(result);
    }


    @Override
    public boolean isThisOperation(String operation) {
        return operation.equals(oprerationIndex);
    }
}


