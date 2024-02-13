package org.example.AnalizeTools;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс подготовки строки к анализу
 */
public class PrepareExpression {
    private String expression;

    /**
     * Введите стоку с выражением для его разбиения
     * @param expression
     */
    public PrepareExpression(String expression) {
        this.expression = expression.replaceAll(" ", "");
    }

    /**
     * Разбивает выражение на части
     * @return expression list
     */
    public List<String> decompose(){
        List<String> result = new ArrayList<>();

        char[] temp = expression.toLowerCase().toCharArray();

        for (int i = 0; i < temp.length; i++) {
            if(isNum(temp[i])){
                String compare = "";
                int j = i;
                for (; j < temp.length && isNum(temp[j]); j++) {
                    compare += temp[j];
                }
                result.add(compare);
                i = j - 1;
            } else if(isLetter(temp[i])){
                String compare = "";
                int j = i;
                for (; j < temp.length && isLetter(temp[j]); j++) {
                    compare += temp[j];
                }
                result.add(compare);
                i = j - 1;
            } else {
                result.add(temp[i]+"");
            }
        }

        return result;
    }

    /**
     * Проверяет является ли символ буквой
     * @param value
     * @return is letter
     */
    private boolean isLetter(char value){
        return (value > 96 && value < 123);
    }

    /**
     * Проверяет является ли символ числом
     * @param value
     * @return is number
     */
    private boolean isNum(char value){
        return (value > 47 && value < 58) || value == 46;
    }
}
