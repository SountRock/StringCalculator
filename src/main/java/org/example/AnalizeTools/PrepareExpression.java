package org.example.AnalizeTools;

import java.util.ArrayList;
import java.util.List;

public class PrepareExpression {
    private String expression;

    public PrepareExpression(String expression) {
        this.expression = expression;
    }

    public List<String> decompose(){
        List<String> result = new ArrayList<>();

        char[] temp = expression.replaceAll("sqrt", "#").
                //replaceAll("", "").
                toCharArray();

        String compare = "";
        for (int i = 0; i < temp.length; i++) {
            if(!isOperand(temp[i])){
                compare += temp[i];
            } else {
                result.add(compare);
                result.add(temp[i]+"");
                compare = "";
            }
        }
        result.add(compare);

        CleanerList cl = new CleanerList<>(result);
        result = cl.clearList("");

        return result;
    }

    public boolean isOperand(char value){
        return (value > 32 && value < 48 && value != 46);
    }

    public boolean isChar(char value){
        return (value > 64 && value < 91) || (value > 96 && value < 123);
    }

    public boolean isNum(char value){
        return (value > 47 && value < 58);
    }
}
