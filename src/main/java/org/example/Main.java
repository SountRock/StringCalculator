package org.example;

import org.example.AnalizeTools.PrepareExpression;

public class Main {
    public static void main(String[] args) {
        PrepareExpression pe = new PrepareExpression("sqrt12+2!*(22+abs(-5)");
        System.out.println(pe.decompose());
    }
}