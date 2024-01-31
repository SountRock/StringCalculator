package org.example.AnalizeTools;

import org.example.Models.Operation;

import java.util.*;

public class Analizerv2 {
    private List<Operation> operations;

    public Analizerv2(List<Operation> operations){
        this.operations = operations;
    }

    public List<String> analize(String expession){
        PrepareExpression prepare = new PrepareExpression(expession);
        List<String> exArr = prepare.decompose();

        for (int i = 0; i < operations.size(); i++){
            for (int j = 0; j < exArr.size(); j++){
                if(exArr.get(j).equals("(")){
                    String compare = "";
                    exArr.remove(j);

                    byte Continue = 0;
                    byte closeCount = 1;
                    while(Continue < closeCount){
                        if(exArr.get(j).equals("("))
                            closeCount++;

                        compare += exArr.remove(j);
                        Continue += exArr.get(j).equals(")") ? 1 : 0;
                    }

                    exArr.remove(j);
                    exArr.add(j, analize(compare).toString());
                } else if(operations.get(i).isThisOperation(exArr.get(j))){
                    operations.get(i).operation(exArr, j);
                    j--;
                }
            }
        }

        return exArr;
    }
}

