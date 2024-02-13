package org.example.Models.Search;

import org.example.Models.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Политика простого поиска аргументов с двух сторон от индификатора
 */
public class TwoSidesSearchModel implements Operation {
    String operationIndex;

    /**
     * Введите индефикатор операции
     * @param operationIndex
     */
    public TwoSidesSearchModel(String operationIndex) {
        this.operationIndex = operationIndex;
    }

    @Override
    public void operation(List<String> expression, int positionIndex) {}

    @Override
    public boolean isThisOperation(String operation) {
        return operation.equals(operationIndex);
    }

    /**
     * Метод поиска аргументов
     * @param expr
     * @param positionIndex
     * @return argument list
     */
    public List<Double> searchArgumenent(List<String> expr, int positionIndex) {
        int startPosition = positionIndex - 1;

        List<Double> arguments = new ArrayList<>();
        String argument = expr.get(startPosition).replaceAll("\\[", "").replaceAll("\\]", "");
        arguments.add(Double.parseDouble(argument));
        argument = expr.get(startPosition + 2).replaceAll("\\[", "").replaceAll("\\]", "");
        arguments.add(Double.parseDouble(argument));

        return arguments;
    }
}
