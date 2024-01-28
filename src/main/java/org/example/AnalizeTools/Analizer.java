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

        System.out.println(exArr);

        for (int i = 0; i < operations.size(); i++){

            System.out.println(exArr);

            boolean search = true;
            while(search){
                search = false;
                for (int j = 0; j < exArr.size(); j++){
                    if(operations.get(i).isThisOperation(exArr.get(j))){
                        search = true;
                        StringBuilder operation = new StringBuilder();
                        int left = j - 1;
                        operation.append(exArr.get(left));
                        operation.append(exArr.get(j));
                        int right = j + 1;
                        operation.append(exArr.get(right));

                        System.out.println(left + " " + right);

                        for (int k = left; k < left + 3; k++) {
                            exArr.remove(left);
                        }

                        String temp = operations.get(i).operation(operation.toString());

                        System.out.println("operation : " + operation + " = " + temp);

                        exArr.add(left, temp);
                        j--;
                    }
                }
            }
        }

        return exArr;
    }
}
