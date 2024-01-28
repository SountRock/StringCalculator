package org.example.Models;

public class ModelDivite implements ModelOperation{
    String oprerationIndex = "/";
    @Override
    public String operation(String expression) {
        String[] elements = expression.toLowerCase().replaceAll(" ", "").
                replaceAll("\\(", "").
                replaceAll("\\)", "").
                replaceAll("\\]", "").
                replaceAll("\\[", "").
                replaceAll("\\{", "").
                replaceAll("\\}", "").
                split("/");

        double result = Double.parseDouble(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            result = result / Double.parseDouble(elements[i]);
        }

        return Double.toString(result);
    }

    @Override
    public boolean isThisOperation(String operation) {
        return operation.equals(oprerationIndex);
    }
}
