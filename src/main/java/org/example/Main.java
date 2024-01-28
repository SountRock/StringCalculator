package org.example;

import org.example.AnalizeTools.Analizer;
import org.example.AnalizeTools.Analizer1;
import org.example.AnalizeTools.PrepareExpression;
import org.example.Models.ModelDivite;
import org.example.Models.ModelMultiply;
import org.example.Models.ModelOperation;
import org.example.Models.ModelPlus;

import java.util.ArrayList;
import java.util.List;


//21 * 12 * 5 + 75 * 2

//Найти умножение


public class Main {
    public static void main(String[] args) {
        ////////////////////////////////////////////////////////////////////////////
        List<ModelOperation> operations = new ArrayList<>();
        operations.add(new ModelDivite());
        operations.add(new ModelMultiply());
        operations.add(new ModelPlus());

        Analizer ib = new Analizer(operations);
        ////////////////////////////////////////////////////////////////////////////

        String expr = "5.2*7/2+2/5";
        PrepareExpression prepareExpression = new PrepareExpression(expr, operations);
        System.out.println(prepareExpression.decompose());
        System.out.println(ib.analize(expr));
        double test = 5.2*7.0/2.0+2.0/5.0;
        System.out.println(test);

        System.out.println("////////////////////////////////////////////////////////////////////////////");

        Analizer1 ib1 = new Analizer1(operations);

        expr = "(5.2*7)*(2+2*5)";
        prepareExpression = new PrepareExpression(expr, operations);
        System.out.println(prepareExpression.decompose());

        test = (5.2*7)*(2+2*5);
        System.out.println("Right : " + test);

        System.out.println(ib1.analize(expr));

    }
}