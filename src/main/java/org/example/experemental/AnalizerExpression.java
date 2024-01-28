package org.example.experemental;

import org.example.Models.ModelOperation;

import java.util.List;

public class AnalizerExpression {

    List<ModelOperation> operations;
    List<String> expession;

    public AnalizerExpression(List<ModelOperation> operations, List<String> expession) {
        this.operations = operations;
        this.expession = expession;

        if (isOperand(expession.get(0))){
            expession.add(0, "0");
        }
    }

    public double analize(){



        /*
        for (int i = 0; i < expession.size(); i++) {
            if(isOperand(expession.get(i))){

            }
            for (ModelOperation elem : operations) {

            }

        }
         */

        return 0;
    }

    private boolean isOperand(String value){
        char[] valTemp = value.toCharArray();
        int val = Integer.valueOf(valTemp[0]);
        return val > 32 && val < 48;
    }
}
