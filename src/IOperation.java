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

public interface IOperation {
    Matrix addition(Matrix matrixOne, Matrix matrixTwo);
    Matrix multiplicationWithConstant(Matrix matrix, double constant);
    Matrix multiplicationWithMatrix(Matrix matrixOne, Matrix matrixTwo);
    Matrix mainDiagonalTranspose(Matrix matrix);
    Matrix sideDiagonalTranspose(Matrix matrix);
    Matrix verticalLineTranspose(Matrix matrix);
    Matrix horizontalLineTranspose(Matrix matrix);
    double determinant(Matrix matrix);
    double TwoByTwoDeterminant(Matrix matrix);
    double cofactor(int ith, int jth, Matrix matrix);
    Matrix minor(int ith, int jth, Matrix M);
    Matrix inverse(Matrix matrix);
}
