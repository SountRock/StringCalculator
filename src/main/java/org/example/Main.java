package org.example;

import org.example.AnalizeTools.Analizer;
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

        String expr = "5.2+3*1.5/0.5";
        long start = System.currentTimeMillis();
        Double.parseDouble(ib.analize(expr).get(0));
        long over = System.currentTimeMillis();
        System.out.println(over-start);

    }
}