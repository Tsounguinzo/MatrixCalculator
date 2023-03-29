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

/**
 * The Operations class provides methods for performing mathematical operations on matrices.
 * It implements the IOperation interface.
 */
public class Operations implements IOperation {
    private static String errorMessage;

    /**
     * Performs matrix addition on two matrices and returns the result as a new Matrix object.
     *
     * @param matrixOne The first matrix to add.
     * @param matrixTwo The second matrix to add.
     * @return A new Matrix object representing the result of the addition, or null if the matrices cannot be added.
     */
    public  Matrix addition(Matrix matrixOne, Matrix matrixTwo){

        // Check if the matrices have the same dimensions
        if (matrixOne.getNumberOFRows() != matrixTwo.getNumberOFRows()
                || matrixOne.getNumberOFColumns() != matrixTwo.getNumberOFColumns()){
            errorMessage = "ERROR";
            return null;
        }

        // Get the values of the matrices
        double[][] first = matrixOne.getMatrix();
        double[][] second = matrixTwo.getMatrix();

        // Create a new 2D array to hold the sum of the matrices
        double[][] sum = new double[matrixOne.getNumberOFRows()][matrixOne.getNumberOFColumns()];

        // Add the corresponding elements of the matrices and store the result in the sum array
        for (int i = 0; i<sum.length; i++){
            for (int j = 0; j<sum[i].length; j++){
                sum[i][j] = first[i][j] + second[i][j];
            }
        }
        // Return a new Matrix object representing the sum of the matrices
        return new Matrix(sum);
    }

    /**
     * Performs scalar multiplication on a matrix and returns the result as a new Matrix object.
     *
     * @param matrix The matrix to multiply.
     * @param constant The constant to multiply the matrix by.
     * @return A new Matrix object representing the result of the multiplication.
     */
    public  Matrix multiplicationWithConstant(Matrix matrix, double constant){

        // Get the values of the matrix
        double[][] matrixMatrix = matrix.getMatrix();

        // Create a new 2D array to hold the product of the matrix and the constant
        double[][] product = new double[matrix.getNumberOFRows()][matrix.getNumberOFColumns()];

        // Multiply each element of the matrix by the constant and store the result in the product array
        for (int i = 0; i<product.length; i++){
            for (int j = 0; j<product[i].length; j++){
                product[i][j] = matrixMatrix[i][j] * constant;
            }
        }
        // Return a new Matrix object representing the product of the matrix and the constant
        return new Matrix(product);
    }

    /**
     * Performs matrix multiplication on two matrices and returns the result as a new Matrix object.
     *
     * @param matrixOne The first matrix to multiply.
     * @param matrixTwo The second matrix to multiply.
     * @return A new Matrix object representing the result of the multiplication, or null if the matrices cannot be multiplied.
     */
    public Matrix multiplicationWithMatrix(Matrix matrixOne, Matrix matrixTwo){

        // Check if the matrices have compatible dimensions
        if (matrixOne.getNumberOFColumns() !=  matrixTwo.getNumberOFRows()){
            errorMessage = "The operation cannot be performed.";
            return null;
        }
        // Get the values of the matrices
        double[][] first = matrixOne.getMatrix();
        double[][] second = matrixTwo.getMatrix();

        // Create a new 2D array to hold the product of the two matrix: note  m x a * a x n = m x n
        double[][] product = new double[matrixOne.getNumberOFRows()][matrixTwo.getNumberOFColumns()];

        // Multiply the matrices and store the result in the product array
        for (int i = 0; i < matrixOne.getNumberOFRows(); i++){
            for (int j = 0; j < matrixTwo.getNumberOFColumns(); j++){
                for (int k = 0; k < matrixOne.getNumberOFColumns(); k++){
                    product[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        // Return a new Matrix object representing the product of the matrices
        return new Matrix(product);
    }

    /**
     * Transposes a matrix along its main diagonal and returns the result as a new Matrix object.
     *
     * @param matrix The matrix to transpose.
     * @return A new Matrix object representing the transpose of the matrix.
     */
    public Matrix mainDiagonalTranspose(Matrix matrix){
        // Get the values of the matrix
        double[][] transpose = matrix.getMatrix();

        // Transpose the matrix along its main diagonal
        for (int i = 0; i < matrix.getNumberOFRows() - 1; i++){
            for(int j = i + 1;  j < matrix.getNumberOFColumns(); j++) {
                double temp = transpose[i][j];
                transpose[i][j] = transpose[j][i];
                transpose[j][i] = temp;
            }
        }
        return new Matrix(transpose);
    }

    /**
     * Transposes a matrix along its side diagonal and returns the result as a new Matrix object.
     *
     * @param matrix The matrix to transpose.
     * @return A new Matrix object representing the transpose of the matrix.
     */
    public Matrix sideDiagonalTranspose(Matrix matrix){
        // Get the values of the matrix
        double[][] transpose = matrix.getMatrix();

        // Transpose the matrix along its side diagonal
        for (int i = 0; i < matrix.getNumberOFRows() - 1; i++){
            for(int j = 0;  j < matrix.getNumberOFColumns() - 1 - i; j++) {
                double temp = transpose[i][j];
                transpose[i][j] = transpose[matrix.getNumberOFRows() - 1 - j][matrix.getNumberOFColumns() - 1 - i];
                transpose[matrix.getNumberOFRows() - 1 - j][matrix.getNumberOFColumns() - 1 - i] = temp;
            }
        }
        return new Matrix(transpose);
    }

    /**
     * Transposes a matrix along its vertical axis and returns the result as a new Matrix object.
     *
     * @param matrix The matrix to transpose.
     * @return A new Matrix object representing the transpose of the matrix.
     */
    public Matrix verticalLineTranspose(Matrix matrix){
        double[][] transpose = matrix.getMatrix();

        // Transpose the matrix along its vertical axis
        for (int i = 0; i < matrix.getNumberOFRows(); i++){
            for(int j = 0;  j < matrix.getNumberOFColumns() / 2; j++) {
                double temp = transpose[i][j];
                transpose[i][j] = transpose[i][matrix.getNumberOFColumns() - 1 - j];
                transpose[i][matrix.getNumberOFColumns() - 1 - j] = temp;
            }
        }
        return new Matrix(transpose);
    }

    /**
     * Transposes a matrix along its horizontal axis and returns the result as a new Matrix object.
     *
     * @param matrix The matrix to transpose.
     * @return A new Matrix object representing the transpose of the matrix.
     */
    public Matrix horizontalLineTranspose(Matrix matrix){
        double[][] transpose = matrix.getMatrix();

        // Transpose the matrix along its horizontal axis
        for (int i = 0; i < matrix.getNumberOFRows() / 2; i++){
            for(int j = 0;  j < matrix.getNumberOFColumns(); j++) {
                double temp = transpose[i][j];
                transpose[i][j] = transpose[matrix.getNumberOFColumns() - 1 - i][j];
                transpose[matrix.getNumberOFColumns() - 1 - i][j] = temp;
            }
        }
        return new Matrix(transpose);
    }

    /**
     * Calculates the determinant of a matrix and returns the result as a double.
     *
     * @param matrix The matrix to calculate the determinant of.
     * @return The determinant of the matrix as a double.
     */
    public double determinant(Matrix matrix) {
        // If the matrix is not square, return -1
        if(matrix.getNumberOFRows() != matrix.getNumberOFColumns()){
            return -1;
        }

        double sum = 0;
        // If the matrix is a 2x2 matrix, calculate the determinant using the formula
        if(matrix.getNumberOFRows() == 2 && matrix.getNumberOFColumns() == 2){
            return TwoByTwoDeterminant(matrix);
        }

        // Otherwise, expand the determinant along the first row note may be improved to accept any row or columns
        int j = 0;
        while (j < matrix.getNumberOFColumns()){
            sum += matrix.getMatrix()[1][j] * cofactor(1,j,matrix); //expansion along the first row
            j++;
        }

        return sum; // Return the determinant
    }

    /**
     * Calculates the determinant of a 2x2 matrix and returns the result as a double.
     *
     * @param matrix The 2x2 matrix to calculate the determinant of.
     * @return The determinant of the matrix as a double.
     */
    public double TwoByTwoDeterminant(Matrix matrix){
        return (matrix.getMatrix()[0][0] * matrix.getMatrix()[1][1]) -
                (matrix.getMatrix()[0][1] * matrix.getMatrix()[1][0]);
    }

    /**
     * Calculates the cofactor of a matrix element and returns the result as a double.
     *
     * @param ith    The row index of the element.
     * @param jth    The column index of the element.
     * @param matrix The matrix containing the element.
     * @return The cofactor of the element as a double.
     */
    public double cofactor(int ith, int jth, Matrix matrix){
        return Math.pow(-1,(ith + jth))  * determinant(minor(ith,jth,matrix));
    }

    /**
     * Calculates the minor of a matrix element and returns the result as a new Matrix object.
     *
     * @param ith    The row index of the element.
     * @param jth    The column index of the element.
     * @param M The matrix containing the element.
     * @return A new Matrix object representing the minor of the element.
     */
    public Matrix minor(int ith, int jth, Matrix M){
        // create a new matrix with one row and column less, because those will be removed
        Matrix m = new Matrix(M.getNumberOFRows() - 1, M.getNumberOFColumns() - 1);
        int i_value = 0, j_value;

        // Fill in the values of the new matrix by skipping the row and column of the element
        for (int i = 0; i < M.getNumberOFRows(); i++){
            j_value = 0;
            for(int j = 0;  j < M.getNumberOFColumns(); j++) {
                if(i == ith){
                    i_value--; //do not change the value of i for m of that row is skipped
                    break;
                } else if (j == jth) {
                    continue;
                } else {
                    m.getMatrix()[i_value][j_value] = M.getMatrix()[i][j];
                    j_value++;
                }
            }
            i_value++;
        }
        // Return a new Matrix object representing the minor of the element
        return m;
    }

    /**
     * Calculates the inverse of a matrix and returns the result as a new Matrix object.
     *
     * @param matrix The matrix to calculate the inverse of.
     * @return A new Matrix object representing the inverse of the matrix.
     */
    public Matrix inverse(Matrix matrix){
        // If the determinant of the matrix is 0, return null
        if(determinant(matrix) == 0){
            return null;
        }

        // Calculate the adjoint matrix
        Matrix adjoin = new Matrix(matrix.getNumberOFRows(),matrix.getNumberOFColumns());
        for (int i = 0; i < matrix.getNumberOFRows(); i++){
            for(int j = 0;  j < matrix.getNumberOFColumns(); j++) {
                adjoin.getMatrix()[i][j] = cofactor(i,j,matrix);
            }
        }
        // Calculate the inverse of the matrix and return the result as a new Matrix object
        return multiplicationWithConstant(mainDiagonalTranspose(adjoin),(1/determinant(matrix)));
    }

    /**
     * Prints the error message for the most recent operation, if any.
     */
    public static void getMessage() {
        System.err.println(errorMessage);
    }


}
