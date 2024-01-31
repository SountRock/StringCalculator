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

        char[] temp = expression.toCharArray();

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

    private boolean isOperand(char value){
        return (value > 32 && value < 48 && value != 46);
    }
}
