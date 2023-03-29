/*
 * Copyright (c) 2023 Beaudelaire Tsoungui Nzodoumkouo. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under My consent.
 *
 * This code is shared on GitHub in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Please contact Me at +1 438 509 3906
 * or LinkedIn: https://www.linkedin.com/in/beaudelaire-tsoungui-nzodoumkouo-809744231
 * if you need additional information or have any questions.
 */

import java.util.Scanner;

/**
 * The Matrix class represents a mathematical matrix and provides methods for getting and setting its values
 * as well as printing the matrix to the console.
 */
public class Matrix {
    private final int numberOFRows;
    private final int numberOFColumns;

    private final double[][] matrix; // A 2D array to hold the matrix values

    /**
     * Constructs a Matrix object with the given number of rows and columns.
     *
     * @param numberOFRows The number of rows in the matrix.
     * @param numberOFColumns The number of columns in the matrix.
     */
    public Matrix (int numberOFRows, int numberOFColumns) {
        this.numberOFRows = numberOFRows;
        this.numberOFColumns = numberOFColumns;
        matrix = new double[numberOFRows][numberOFColumns];
    }

    /**
     * Constructs a Matrix object with the given 2D array of values.
     *
     * @param matrix A 2D array representing the values of the matrix.
     */
    public Matrix (double[][] matrix){
        this.matrix = matrix;
        this.numberOFRows = matrix.length;
        this.numberOFColumns = matrix[0].length;
    }
    /** @return A 2D array representing the values of the matrix.*/
    public double[][] getMatrix() {
        return matrix;
    }

    /** @return The number of rows in the matrix.*/
    public int getNumberOFRows() {
        return numberOFRows;
    }

    /** @return The number of columns in the matrix.*/
    public int getNumberOFColumns() {
        return numberOFColumns;
    }

    /**
     * Prints the matrix values to the console.
     */
    public void printMatrix(){
        for (double[] dbls : matrix) {
            for (double dbl : dbls){
                System.out.print(dbl + " ");
            }
            System.out.println();
        }
    }

    /**
     * Reads input from the console and sets the values of the matrix.
     */
    public void matrixValues(){
        String[][] rows = new String[numberOFRows][1];
        for(int i = 0; i < rows.length; i++){
            rows[i] = new Scanner(System.in).nextLine().split(" ");
        }
        for(int i = 0, j = 0; i < rows.length; i++, j++){
            matrix[i] = toDoubleArray(rows[i]);
        }

    }

    /**
     * Converts a string array to a double array.
     *
     * @param input A string array representing a row of the matrix.
     * @return A double array representing a row of the matrix.
     */
    private double[] toDoubleArray(String[] input){
        double[] converted = new double[input.length];
        for(int i = 0; i < converted.length; i++){
            converted[i] = Double.parseDouble(input[i]);
        }
        return converted;
    }
}
