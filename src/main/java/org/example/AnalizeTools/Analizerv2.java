package org.example.AnalizeTools;

import org.example.Models.Operation;

import java.util.*;

public class Analizerv2 {
    private List<Operation> operations;

    public Analizerv2(List<Operation> operations){
        this.operations = operations;
    }

    public List<String> analize(List<String> exArr){
        for (int i = 0; i < operations.size(); i++){
            for (int j = 0; j < exArr.size(); j++){
                if(exArr.get(j).equals("(")){
                    List<String> temp = compare(exArr, j, "(", ")");
                    exArr.add(j, analize(temp).toString().replaceAll("\\[", "").replaceAll("\\]", ""));
                } else if(operations.get(i).isThisOperation(exArr.get(j))){
                    operations.get(i).operation(exArr, j);
                    j--;
                }
            }
        }

        return exArr;
    }

    public List<String> compare(List<String> exArr, int indexStart, String paramContinue, String paramClose){
        List<String> temp = new ArrayList<>();
        exArr.remove(indexStart);

        byte Continue = 0;
        byte closeCount = 1;
        while(Continue < closeCount){
            if(exArr.get(indexStart).equals(paramContinue))
                closeCount++;

            temp.add(exArr.remove(indexStart));
            Continue += exArr.get(indexStart).equals(paramClose) ? 1 : 0;
        }

        exArr.remove(indexStart);

        return temp;
    }
}

