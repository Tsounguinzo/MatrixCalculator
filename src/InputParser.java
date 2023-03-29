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

import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**This class provides methods for parsing user input to perform various matrix operations.*/
public class InputParser {
    private static final IOperation operation = new Operations();
    private static String errorMessage;
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to enter the dimensions and values of two matrices, then performs matrix multiplication
     * @return the product of the two matrices or null if the operation is not possible
     */
    public static Matrix multiplyTwoMatrix() {
        Matrix first = getMatrixDimensions("first");

        if (first == null){
            return null;
        }
        System.out.println("Enter first matrix");
        first.matrixValues();

        Matrix second = getMatrixDimensions("second");

        if (second == null){
            return null;
        }
        System.out.println("Enter second matrix");
        second.matrixValues();

        Matrix product = operation.multiplicationWithMatrix(first,second);

        if (product == null){
            errorMessage = "The Two matrix must have the same dimensions to be added.";
            return null;
        }

        return product;
    }

    /**
     * Prompts the user to enter the dimensions and values of a matrix, and a constant to multiply the matrix by
     * @return the product of the matrix and the constant
     */
    public static Matrix matrixXconstatnt() {
        Matrix matrix = getMatrixDimensions("the");

        if (matrix == null){
            return null;
        }
        System.out.println("Enter matrix: ");
        matrix.matrixValues();

        String Constant = "";
        double constant = 0.0;
        try{
            System.out.println("Enter constant: ");
            Constant = sc.nextLine();
            constant = Double.parseDouble(Constant);
        } catch (IllegalFormatException e){
            System.out.println("Your constant  " + Constant + "is not a number");
        }

        return operation.multiplicationWithConstant(matrix,constant);
    }

    /**
     * Prompts the user to enter the dimensions and values of two matrices, then performs matrix addition
     * @return the sum of the two matrices or null if the operation is not possible
     */
    public static Matrix addTwoMatrix(){
        Matrix first = getMatrixDimensions("first");

        if (first == null){
            return null;
        }
        System.out.println("Enter first matrix");
        first.matrixValues();

        Matrix second = getMatrixDimensions("second");

        if (second == null){
            return null;
        }
        System.out.println("Enter second matrix");
        second.matrixValues();

        Matrix sum = operation.addition(first,second);

        if (sum == null){
            errorMessage = "The Two matrix must have the same dimensions to be added.";
            return null;
        }

        return sum;
    }

    /**
     * Prompts the user to enter the dimensions and values of a matrix, then performs a main diagonal transpose
     * @return the transposed matrix
     */
    public static Matrix MDTranspose(){
        Matrix matrix = getMatrixDimensions("the");

        if (matrix == null){
            return null;
        }
        System.out.println("Enter matrix: ");
        matrix.matrixValues();


        return operation.mainDiagonalTranspose(matrix);
    }

    /**
     * Prompts the user to enter the dimensions and values of a matrix, then performs a side diagonal transpose
     * @return the transposed matrix
     */
    public static Matrix SDTranspose(){
        Matrix matrix = getMatrixDimensions("the");

        if (matrix == null){
            return null;
        }
        System.out.println("Enter matrix: ");
        matrix.matrixValues();


        return operation.sideDiagonalTranspose(matrix);
    }

    /**
     * Prompts the user to enter the dimensions and values of a matrix, then performs a vertical line transpose
     * @return the transposed matrix
     */
    public static Matrix VLTranspose(){
        Matrix matrix = getMatrixDimensions("the");

        if (matrix == null){
            return null;
        }
        System.out.println("Enter matrix: ");
        matrix.matrixValues();


        return operation.verticalLineTranspose(matrix);
    }

    /**
     * Prompts the user to enter the dimensions and values of a matrix, then performs a horizontal line transpose
     * @return the transposed matrix
     */
    public static Matrix HLTranspose(){
        Matrix matrix = getMatrixDimensions("the");

        if (matrix == null){
            return null;
        }
        System.out.println("Enter matrix: ");
        matrix.matrixValues();


        return operation.horizontalLineTranspose(matrix);
    }

    /**
     * Prompts the user to enter the dimensions and values of a matrix, then calculates its determinant
     * @return the determinant of the matrix or -1 if the operation is not possible
     */
    public static double matrixDeterminant() {
        Matrix matrix = getMatrixDimensions("the");

        if (matrix == null){
            return -1;
        }

        System.out.println("Enter matrix: ");
        matrix.matrixValues();

        return operation.determinant(matrix);
    }

    /**
     * Prompts the user to enter the dimensions and values of a matrix, then calculates its inverse
     * @return the inverse of the matrix or null if the operation is not possible
     */
    public static Matrix matrixInverse() {
        Matrix matrix = getMatrixDimensions("the");

        if (matrix == null){
            return null;
        }

        System.out.println("Enter matrix: ");
        matrix.matrixValues();

        Matrix inverse = operation.inverse(matrix);

        if (inverse == null){
            errorMessage = "This matrix doesn't have an inverse.";
            return null;
        }

        return inverse;
    }

    /**
     * Prompts the user to enter the dimensions of a matrix and creates a new Matrix object with the specified dimensions.
     * If the user inputs an invalid size, they will be prompted to re-enter the dimensions until a valid input is given.
     * @param number a string indicating which matrix (e.g. "first", "second", "the") the user is inputting the dimensions for
     * @return a new Matrix object with the specified dimensions
     */
    private static Matrix getMatrixDimensions(String number){
        System.out.print("Enter size of " + number + " matrix (A B): ");

        int numRows = 0;
        boolean flag = false;
        while(!flag) {
            try {
                numRows = sc.nextInt();
                flag = true;
                if (numRows < 1) {
                    System.out.print("\nnumber of rows should be greater than one!\nRe-enter the size of the matrix (A B): ");
                    sc.nextLine();
                    flag = false;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid size! Re-enter the size of the matrix (A B): ");
                sc.nextLine();
            }
        }

        int numCols = 0;
        flag = false;
        while(!flag) {
            try {
                numCols = sc.nextInt();
                sc.nextLine();
                flag = true;
                if (numCols < 1) {
                    System.out.print("\nnumber of columns should be greater than one!\nRe-enter the size of the matrix (A B): ");
                    sc.nextLine();
                    flag = false;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid size! Re-enter the size of the matrix (A B): ");
                sc.nextLine();
            }
        }

        return new Matrix(numRows, numCols);
    }

    /**
     * Prints the error message to the console.
     */
    public static void getMessage() {
        System.out.println(errorMessage);
    }

}

