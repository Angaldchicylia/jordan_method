package com.examples.Angald;

import java.util.Arrays;

public class program {
    public static void main( String[] args )
    {
        double[][] matrix = {
                {4, -7, 8},
                {2, -4, 5},
                {-3, 11, 1}
        };
        double[] b = {-23, -13, 16};
        printVector(b);
        JordanElimination solver = new JordanElimination();
        solver.solve(matrix,b);
        printVector(b);
    }

    public static void printVector(double[] matrix) {
        for (double el : matrix) {
            System.out.printf(el + " ");
        }
        System.out.println();
    }
}
