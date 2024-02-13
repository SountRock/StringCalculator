package org.example;

import org.example.AnalizeTools.Analizerv2;
import org.example.AnalizeTools.PrepareExpression;
import org.example.Models.*;
import org.example.Models.MathMethod.GammaFunc;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Operation> operations = new ArrayList<>();
        operations.add(new ModelFactorial());
        operations.add(new ModelSquare());
        operations.add(new ModelDivitev2());
        operations.add(new ModelMultiplyv2());
        operations.add(new ModelPlusv2());
        operations.add(new ModelMinusv2());
        Analizerv2 analizer = new Analizerv2(operations);

        PrepareExpression pe = new PrepareExpression("11 * (sqrt(24.6 + 0.4) + 12.0001!)");
        List<String> prepare = pe.decompose();
        System.out.println(prepare);
        System.out.println(analizer.analize(prepare));
        System.out.println(11 * (Math.sqrt(24.6 + 0.4) + GammaFunc.gamma(12.0001 + 1)));
    }
}