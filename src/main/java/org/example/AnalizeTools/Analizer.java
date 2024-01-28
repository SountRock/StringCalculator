package org.example.AnalizeTools;

import org.example.Models.ModelOperation;
import java.util.*;

public class Analizer {
    private List<ModelOperation> operations;

    public Analizer(List<ModelOperation> operations){
        this.operations = operations;
    }

    public List<String> analize(String expession){
        PrepareExpression prepare = new PrepareExpression(expession, operations);
        List<String> exArr = prepare.decompose();

        for (int i = 0; i < operations.size(); i++){
            boolean search = true;
            while(search){
                search = false;
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
                        search = true;
                        StringBuilder operation = new StringBuilder();
                        int left = j - 1;
                        operation.append(exArr.get(left));
                        operation.append(exArr.get(j));
                        int right = j + 1;
                        operation.append(exArr.get(right));

                        for (int k = left; k < left + 3; k++) {
                            exArr.remove(left);
                        }

                        String temp = operations.get(i).operation(operation.toString());
                        exArr.add(left, temp);
                        j--;
                    }
                }
            }
        }

        return exArr;
    }
}
