package model;

import exception.WrongMatrixDimensionsException;
import io.DataReader;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class TwoMatrices {
    private DataReader dataReader = new DataReader();
    private int rows[];
    private int columns[];
    double[][] matrice1;
    double[][] matrice2;

    public List<String> addMatrices() {
        List<String> sum2Matrices = new ArrayList<>();
        getMatrice();
        double result = 0;
        if (rows[0] == rows[1] && columns[0] == columns[1]) {
            for (int i = 0; i < rows[0]; i++) {
                for (int j = 0; j < columns[0]; j++) {
                    result = matrice1[i][j] + matrice2[i][j];
                    sum2Matrices.add(String.format("%.2f", result));
                }
            }
        } else {
            System.out.println("Nie można dodać dwóch macierzy, mają różne wymiary");
            throw new WrongMatrixDimensionsException("Nie zgodne wymiary macierzy");
        }
        System.out.println("Wynikiem dodawania 2 wektorów jest: ");
        return sum2Matrices;
    }

    public List<String> subtractMatrices() {
        List<String> sum2Matrices = new ArrayList<>();
        getMatrice();
        double result = 0;
        if (rows[0] == rows[1] && columns[0] == columns[1]) {
            for (int i = 0; i < rows[0]; i++) {
                for (int j = 0; j < columns[0]; j++) {
                    result = matrice1[i][j] - matrice2[i][j];
                    sum2Matrices.add(String.format("%.2f", result));
                }
            }
        } else {
            System.out.println("Nie można dodać dwóch macierzy, mają różne wymiary");
            throw new WrongMatrixDimensionsException("Nie zgodne wymiary macierzy");
        }
        System.out.println("Wynikiem dodawania 2 wektorów jest: ");
        return sum2Matrices;
    }

    public List<String> multiplyMatrices() {
        List<String> sum2Matrices = new ArrayList<>();
        getMatrice();
        double result;
        if (columns[0] == rows[1] ) {
            for(int i = 0; i < rows[0]; i++)
            {
                for(int j = 0; j < rows[0]; j++)
                {
                    result = 0;
                    for(int l = 0; l < columns[0] ; l++)
                        result += matrice1[i][l] * matrice2[l][j];
                    sum2Matrices.add(String.format("%.2f", result));

                }
            }
        } else {
            System.out.println("Macierz pierwsza musi mieć tyle wierszy co kolumn drugiej macierzy");
            throw new WrongMatrixDimensionsException("Nie zgodne wymiary macierzy");
        }
        System.out.println("Wynikiem mnożenia 2 macierzy jest: ");
        return sum2Matrices;
    }

    public void getMatrice() {
        boolean isOk = false;
        while (!isOk) {
            try {
                howManyRows();
                howManyColumns();
                isOk = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Podaj wartości dla 1 macierzy");
        matrice1 = new double[rows[0]][columns[0]];
        for (int i = 0; i < rows[0]; i++) {
            System.out.println("Podaj wartosc " + (i + 1 ) + " wiersza");
            for (int j = 0; j < columns[0]; j++) {
                System.out.println("Podaj wartosc " + (j + 1) + " kolumny");
                try {
                    matrice1[i][j] = dataReader.getDouble();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Podaj wartości dla 2 macierzy");
        matrice2 = new double[rows[1]][columns[1]];
        for (int i = 0; i < rows[1]; i++) {
            System.out.println("Podaj wartosc " + (i + 1) + " wiersza");
            for (int j = 0; j < columns[1]; j++) {
                System.out.println("Podaj wartosc " + (j + 1) + " kolumny");
                try {
                    matrice2[i][j] = dataReader.getDouble();
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void howManyRows() {
        boolean isOk = false;
        rows = new int[2];
        int i = 0;
        System.out.println("Podaj ilość wierszy w macierzy 1");
        while (!isOk) {
            rows[i] = dataReader.getInt();
            if (rows[i] >= 2 && rows[i] <= 4) {
                i++;
            } else {
                System.out.println("Macierz może mieć minimalnie 2 wiersze i maksymalnie 4, spróbuj jeszcze raz");
            }
            if (i == 1) {
                System.out.println("Podaj wartość wierszy dla macierzy 2");
            } else if (i == 2)
                isOk = true;
        }
    }

    public void howManyColumns() {
        System.out.println("Podaj ile kolumn ma mieć macierz");
        boolean isOk = false;
        columns = new int[2];
        int i = 0;
        while (!isOk) {
            columns[i] = dataReader.getInt();
            if (columns[i] >= 2 && columns[i] <= 4) {
                i++;
            } else {
                System.out.println("Macierz może mieć minimalnie 2 kolumny i maksymalnie 4, spróbuj jeszcze raz");
            }
            if (i == 1) {
                System.out.println("Podaj ilość kolumn dla macierzy 2");
            } else if (i == 2)
                isOk = true;
        }
    }
}
