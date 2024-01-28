package org.example.Models;

public class ModelPlus implements ModelOperation {
    String oprerationIndex = "+";
    @Override
    public String operation(String expression) {
        String[] elements = expression.toLowerCase().replaceAll(" ", "").
                replaceAll("\\(", "").
                replaceAll("\\)", "").
                replaceAll("\\]", "").
                replaceAll("\\[", "").
                replaceAll("\\{", "").
                replaceAll("\\}", "").
                split("\\+");

        double result = 0;
        for (String elem : elements) {
            result += Double.parseDouble(elem);
        }

        return Double.toString(result);
    }

    @Override
    public boolean isThisOperation(String operation) {
        return operation.equals(oprerationIndex);
    }
}
