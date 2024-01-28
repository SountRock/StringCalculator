package org.example.AnalizeTools;

import org.example.Models.ModelOperation;
import java.util.*;

public class Analizer1 {
    private List<ModelOperation> operations;

    public Analizer1(List<ModelOperation> operations){
        this.operations = operations;
    }

    /*
    public String analize2(String expession){
        PrepareExpression prepare = new PrepareExpression(expession, operations);
        List<String> exArr = prepare.decompose();

        for (int j = 0; j < exArr.size(); j++){
            if(exArr.get(j).equals("(")){
                String compare = "";
                int index = j + 1;
                while (!exArr.get(index).equals(")")){
                    compare += exArr.get(index);
                }


            }
        }
    }
     */

    public List<String> analize(String expession){
        PrepareExpression prepare = new PrepareExpression(expession, operations);
        List<String> exArr = prepare.decompose();

        System.out.println("In :" + exArr);

        for (int i = 0; i < operations.size(); i++){
            boolean search = true;
            while(search){
                search = false;
                for (int j = 0; j < exArr.size(); j++){
                    if(exArr.get(j).equals("(")){
                        String compare = "";
                        exArr.remove(j); ////
                        //int index = j + 1;

                        System.out.println("Now :" + exArr);

                        while (!exArr.get(j).equals(")")) {
                            compare += exArr.remove(j);
                        }
                        exArr.remove(j);

                        /*
                        while (!exArr.get(index).equals(")")) {
                            compare += exArr.get(index++);
                        }
                         */

                        /*
                        System.out.println("Now :" + exArr);
                        int length = j + compare.length();
                        for (int k = j; k < length; k++) {
                            exArr.remove(k);
                        }
                         */
                        System.out.println("Before :" + exArr);

                        System.out.println("in reqursia");

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

                        System.out.println("operation " + operation);
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
