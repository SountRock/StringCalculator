package org.example.AnalizeTools;

import java.util.ArrayList;
import java.util.List;

public class PrepareExpression {
    private String expression;

    public PrepareExpression(String expression) {
        this.expression = expression.replaceAll(" ", "");
    }

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
            } else if(isChar(temp[i])){
                String compare = "";
                int j = i;
                for (; j < temp.length && isChar(temp[j]); j++) {
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

    public boolean isChar(char value){
        return (value > 96 && value < 123);
    }

    public boolean isNum(char value){
        return (value > 47 && value < 58) || value == 46;
    }
}
