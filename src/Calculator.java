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

import java.util.InputMismatchException;
import java.util.Scanner;
/**A simple calculator program for matrix operations*/
public class Calculator {
    public static Scanner sc = new Scanner(System.in);

    /**
     * Runs the calculator program
     */
    public void run() {

        boolean end = false;
        while (!end) {
            printMenu();

            System.out.print("Your choice: ");

            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine();

                if (choice < 0 || choice > 6) {
                    System.out.println("invalid input");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Your choice is not an integer.");
            }

            switch (choice) {
                case 0 -> {
                    System.out.println("Bye :)");
                    end = true;
                }
                case 1 -> {
                    Matrix sum = InputParser.addTwoMatrix();

                    if (sum == null) {
                        InputParser.getMessage();
                        continue;
                    }

                    System.out.println("\nThe result is:");
                    sum.printMatrix();
                }
                case 2 -> {
                    Matrix product = InputParser.matrixXconstatnt();

                    if (product == null) {
                        InputParser.getMessage();
                        continue;
                    }

                    System.out.println("\nThe result is:");
                    product.printMatrix();
                }
                case 3 -> {
                    Matrix product = InputParser.multiplyTwoMatrix();

                    if (product == null) {
                        InputParser.getMessage();
                        continue;
                    }

                    System.out.println("\nThe result is:");
                    product.printMatrix();
                }
                case 4 -> Transpose();
                case 5 -> {
                    double determinant = InputParser.matrixDeterminant();

                    if (determinant == -1) {
                        InputParser.getMessage();
                        continue;
                    }

                    System.out.println("\nThe result is:\n" + determinant);
                }
                case 6 -> {
                    Matrix inverse = InputParser.matrixInverse();

                    if (inverse == null) {
                        InputParser.getMessage();
                        continue;
                    }

                    System.out.println("\nThe result is:");
                    inverse.printMatrix();
                }
            }
        }
    }
    /**
     * Prints the menu for matrix operations
     */
    private static void printMenu(){
        System.out.println();
        System.out.println("""
                1. Add matrices
                2. Multiply matrix by a constant
                3. Multiply matrices
                4. Transpose matrix
                5. Calculate a determinant
                6. Inverse matrix
                0. Exit
                """);
    }

    /**
     * Handles the operation of transposing a matrix
     */
    private static void Transpose(){
        System.out.println();
        System.out.println("""
                1. Main diagonal
                2. Side diagonal
                3. Vertical line
                4. Horizontal line
                """);

        System.out.print("Your choice: ");

        int choice;
        while (true){
            try{
                choice = sc.nextInt();
                sc.nextLine();

                if (choice < 0 || choice > 4){
                    System.out.println("invalid input");
                } else break;
            }catch (InputMismatchException e){
                System.out.println("Your choice is not an integer.");
            }
        }


        switch (choice){

            case 1 -> {
                Matrix MDTranspose = InputParser.MDTranspose();

                if (MDTranspose == null){
                    InputParser.getMessage();
                    break;
                }

                System.out.println("\nThe result is:");
                MDTranspose.printMatrix();
            }
            case 2 -> {
                Matrix SDTranspose = InputParser.SDTranspose();

                if (SDTranspose == null){
                    InputParser.getMessage();
                    break;
                }

                System.out.println("\nThe result is:");
                SDTranspose.printMatrix();
            }
            case 3 -> {
                Matrix VLTranspose = InputParser.VLTranspose();

                if (VLTranspose == null){
                    InputParser.getMessage();
                    break;
                }

                System.out.println("\nThe result is:");
                VLTranspose.printMatrix();
            }
            case 4 -> {
                Matrix HLTranspose = InputParser.HLTranspose();

                if (HLTranspose == null){
                    InputParser.getMessage();
                    break;
                }

                System.out.println("\nThe result is:");
                HLTranspose.printMatrix();
            }
        }
    }

}
