package com.yurchinho;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static void KeyboardArr(int[][] arr) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(i + " рядок " + j + " стовпчик");

                arr[i][j] = in.nextInt();
                System.out.println("Невірне введення даних. Введіть ще раз!\n");
                System.out.println(i + " рядок " + j + " стовпчик");
                arr[i][j] = in.nextInt();

            }
        }
    }

    static double[][] KeyboardArr2(double[][] arr) {
        Scanner in = new Scanner(System.in);

        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.println(i + " рядок " + j + " стовпчик");
                    arr[i][j] = in.nextFloat();
                }
            }
        }catch (InputMismatchException ex)
        {
            System.out.println("Невірне введення даних. Введіть ще раз!\n");
            KeyboardArr2(arr);
        }
        return arr;

    }




    static void RandomArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 200 - 100);
                ;
            }
        }
    }

    static void RandomArr2(double[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (float)Math.random() * 20 - 10;
                ;
            }
        }
    }

    static void OutputArr(int[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t\t");
            }
            System.out.println();
        }
    }

    static void OutputArr2(double[][] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                double num = Math.round(arr[i][j] * 100);
                num = num / 100;
                System.out.print( num + "\t\t");
            }
            System.out.println();
        }
    }

    static void Task1(int[][] arr) {
        int k = 0;
        int p = 2;
        int[] tmp = new int[arr.length];
        int[] tmp2 = new int[arr.length];
// Запам'ятовуємо перший стовбець
        for (int i = 0; i < arr.length; i++) {
            for (; k < arr[i].length; ) {
                tmp[i] = arr[i][k];
                break;
            }

        }
//  Запам'ятовуємо третій стовбець
        for (int i = 0; i < arr.length; i++) {
            for (; p < arr[i].length; ) {
                tmp2[i] = arr[i][p];
                break;
            }

        }
//Вставляємо в 1 стовпчик і 3 стовпчик
        for (int i = 0; i < arr.length; i++) {
            arr[i][k] = tmp2[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][p] = tmp[i];

        }
    }

    static void Task2(double[][] arr, int width) {
        double[] array = new double[width];
        for (int i = 0; i < arr[0].length; i++) {
            double max = arr[0][i];
            for (int j = 1; j < arr.length; j++) {
                if (max < arr[j][i]) {
                    max = arr[j][i];

                }
                array[i] = max;
            }
        }
        System.out.println("Одновимірний масив:");
        for (int g = 0; g < array.length; g++) {
            double num = Math.round(array[g] * 100);
            num = num / 100;
            System.out.print("\t\t" + num);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] arr = new int[3][4];
        boolean bool = true;
        int choice = 0;

        while (bool) {
            System.out.println("Головне меню.\n\t1 - Завдання №1.\n\t2 - Завдання №2");
            System.out.print("Введіть цифру від 1 до 2: ");
            choice = in.nextInt();
            switch (choice) {
                case 1: {

                    System.out.println("\tВведіть якик чином заповнити масив: \n1 - Заготовлений масив;\n2 - Рандомний масив;");
                    int choice5 = in.nextInt();
                    if(choice5 == 1) {
                        arr[0][0] = 3;
                        arr[0][1] = -2;
                        arr[0][2] = 4;
                        arr[0][3] = 9;

                        arr[1][0] = 0;
                        arr[1][1] = 3;
                        arr[1][2] = 10;
                        arr[1][3] = 3;

                        arr[2][0] = 5;
                        arr[2][1] = -4;
                        arr[2][2] = -6;
                        arr[2][3] = 0;


                    }else if (choice5 == 2) RandomArr(arr);
                    else
                    {
                        System.out.println("Невірно введені дані!");
                        return;
                    }
                    System.out.println("Дано цілочислову матрицю arr розмірності nxm, та цілі числа k = 0 та p 2 – номери стовпців матриці. Поміняти місцями вказані стовпці.");
                    System.out.println("Дано матрицю: ");
                    OutputArr(arr);
                    System.out.println("Результат роботи: ");
                    Task1(arr);
                    OutputArr(arr);
                    break;
                }
                case 2: {
                    System.out.println("Введіть кількість рядків двовимірного масива: ");
                    int height = in.nextInt();
                    System.out.println("Введіть кількість стовпців двовимірного масива: ");
                    int width = in.nextInt();
                    if(height < 0 || width < 0|| height == 0 || width == 0)
                    {
                        System.out.println("Невірно введені дані!");
                        return;
                    }
                    double[][] arr2 = new double[height][width];


                    System.out.println("Знайти максимальні елементи в кожному стовчику прямокутної матрицi дiйсних чисел  i записати їх в окремий одновимiрний масив.");
                    System.out.println("Дано матрицю: ");
                    OutputArr2(arr2);
                    System.out.println("Результат роботи: ");
                    Task2(arr2, width);
                    break;
                }
                default: {
                    System.out.println("Введено помилкове значення!");
                }

            }
            System.out.println("Якщо хочете прожовжити або закінчити програму натисніть:\n\t1 - Якщо хочете продовжити.\n\t2 - Якщо хочете закінчити.");
            int choice2 = in.nextInt();
            if (choice2 == 1) {
                bool = true;
            } else {
                bool = false;
            }


        }
    }
}


