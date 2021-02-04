package model;

import exception.WrongMatrixDimensionsException;
import io.DataReader;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class OneMatriceOneVector {
    private int rowsOfMatrice;
    private int columnsOfMatrice;
    private int rowsOfVector;
    private double[][] matrice;
    private double[] vector;
    private DataReader dataReader = new DataReader();

    public void getMatrice() {
        boolean isOk = false;
        while (!isOk) {
            try {
                howManyRowsForMatrice();
                howManyColumns();
                howManyRowsForVector();
                isOk = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Podaj wartości dla 1 macierzy");
        matrice = new double[rowsOfMatrice][columnsOfMatrice];
        for (int i = 0; i < rowsOfMatrice; i++) {
            System.out.println("Podaj wartosc " + (i + 1) + " wiersza");
            for (int j = 0; j < columnsOfMatrice; j++) {
                System.out.println("Podaj wartosc " + (j + 1) + " kolumny");
                try {
                    matrice[i][j] = dataReader.getDouble();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        vector = new double[rowsOfVector];
        for (int i = 0; i < rowsOfVector; i++) {
            System.out.println("Podaj wartość wektora dla Wiersza " + (i + 1) + " wiersza");
            try{
                vector[i] = dataReader.getDouble();
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> multiplyMatriceByVector() {
        List<String> sum2Matrices = new ArrayList<>();
        getMatrice();
        double result = 0;
        if (columnsOfMatrice == rowsOfVector) {
            for (int i = 0; i < rowsOfMatrice; i++) {
                result = 0;
                for (int j = 0; j < rowsOfVector; j++) {
                    result += matrice[i][j] * vector[j];
                }
                sum2Matrices.add(String.format("%.2f", result));
            }
        } else {
            System.out.println("Macierz pierwsza musi mieć tyle kolumn co wiersze wektora");
            throw new WrongMatrixDimensionsException("Nie zgodne wymiary wektora lub macierzy");
        }
        System.out.println("Wynikiem mnożenia macierzy przez wektor jest: ");
        return sum2Matrices;
    }


    private void howManyRowsForMatrice() {
        boolean isOk = false;
        rowsOfMatrice = 0;
        System.out.println("Podaj ilość wierszy w macierzy 1");
        while (!isOk) {
            rowsOfMatrice = dataReader.getInt();
            if (rowsOfMatrice >= 2 && rowsOfMatrice <= 4) {
                isOk = true;
            } else {
                System.out.println("Macierz może mieć minimalnie 2 wiersze i maksymalnie 4, spróbuj jeszcze raz");
            }

        }
    }

    private void howManyRowsForVector() {
        boolean isOk = false;
        rowsOfVector = 0;
        int i = 0;
        System.out.println("Podaj ilość wierszy dla wectora");
        while (!isOk) {
            rowsOfVector = dataReader.getInt();
            if (rowsOfVector >= 2 && rowsOfVector <= 4) {
                isOk = true;
            } else {
                System.out.println("Wektor może mieć minimalnie 2 wiersze i maksymalnie 4, spróbuj jeszcze raz");
            }
        }
    }

    private void howManyColumns() {
        System.out.println("Podaj ile kolumn ma mieć macierz");
        boolean isOk = false;
        columnsOfMatrice = 0;
        while (!isOk) {
            columnsOfMatrice = dataReader.getInt();
            if (columnsOfMatrice >= 2 && columnsOfMatrice <= 4) {
                isOk = true;
            } else {
                System.out.println("Macierz może mieć minimalnie 2 kolumny i maksymalnie 4, spróbuj jeszcze raz");
            }
        }
    }
}


