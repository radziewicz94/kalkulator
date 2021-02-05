package model;

import io.DataReader;

import java.util.Arrays;
import java.util.InputMismatchException;

public class OneRealNumberAndMatrices {
    private double realNumber;
    private DataReader dataReader = new DataReader();
    private int rows;
    private int columns;

    public double getRealNumber() {
        double number = 0;
        boolean isOk = false;
        while (!isOk) {
            System.out.println("Podaj liczbę przez którą będzie mnożony wektor");
            try {
                number = dataReader.getDouble();
                isOk = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return number;
    }

    public void multiplyByRealNumber() {
        realNumber = getRealNumber();
        double[][] macierz = getMatrice();
        printMatrices(macierz);
        for (int i = 0; i < macierz.length; i++) {
            for (int j = 0; j < macierz[i].length; j++) {
                macierz[i][j] = macierz[i][j] * 5;
            }
        }
        printResult(macierz);
    }

    public void printResult(double[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (j - 1 == tab[i].length)
                    System.out.print(tab[i][j]);
                else
                    System.out.print(tab[i][j] + ", ");

            }
            System.out.println();
        }
        System.out.println();
    }
    public void printMatrices(double[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (j - 1 == tab[i].length)
                    System.out.print(realNumber + " * " + tab[i][j]);
                else
                    System.out.print(realNumber + " * " + tab[i][j] + ", ");

            }
            System.out.println();
        }
        System.out.println();
    }

    public double[][] getMatrice() {
        boolean isOk = false;
        while (!isOk) {
            try {
                rows = howManyRows();
                columns = howManyColumns();
                isOk = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        double[][] macierz = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Podaj wartosc");
                try {
                    macierz[i][j] = dataReader.getDouble();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return macierz;
    }

    public int howManyRows() {
        System.out.println("Podaj ile wierszy ma mieć macierz");
        boolean isOk = false;
        int rows = 0;
        while (!isOk) {
            rows = dataReader.getInt();
            if (rows >= 2 && rows <= 4) {
                isOk = true;
            } else {
                System.out.println("Macierz może mieć minimalnie 2 wiersze i maksymalnie 4, spróbuj jeszcze raz");
            }
        }
        return rows;
    }

    public int howManyColumns() {
        System.out.println("Podaj ile kolumn ma mieć macierz");
        boolean isOk = false;
        int columns = 0;
        while (!isOk) {
            columns = dataReader.getInt();
            if (columns >= 2 && columns <= 4) {
                isOk = true;
            } else {
                System.out.println("Macierz może mieć minimalnie 2 kolumny i maksymalnie 4, spróbuj jeszcze raz");
            }
        }
        return columns;
    }
}
