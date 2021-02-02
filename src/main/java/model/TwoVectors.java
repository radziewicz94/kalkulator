package model;

import io.DataReader;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class TwoVectors {
    DataReader dataReader = new DataReader();
    private DecimalFormat df = new DecimalFormat("0.00");
    private double[] vector1;
    private double[] vector2;


    private double getNumberOfElements() {
        boolean isOk = false;
        double number = 0;
        while (!isOk) {
            System.out.println("Podaj wartosc dla wektora");
            try {
                number = dataReader.getDouble();
                isOk = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return number;
    }

    public void valueOfVectors() {
        int elements = howManyElementsInVectors();
        vector1 = new double[elements];
        vector2 = new double[elements];

        System.out.println("Podaj wartość dla 1 wektora");
        for (int i = 0; i < vector1.length; i++) {
            vector1[i] = getNumberOfElements();
        }
        System.out.println("Podaj wartość dla 2 wektora");
        for (int i = 0; i < vector2.length; i++) {
            vector2[i] = getNumberOfElements();
        }

        System.out.println("wartości dla wektora 1");
        printElements(vector1);
        System.out.println("Wartość dla wektora 2");
        printElements(vector2);
    }

    private void printElements(double[] elements) {
        for (int i = 0; i < elements.length; i++) {
            if (i == 0) {
                System.out.print("(" + elements[i] + ", ");
            } else if (i + 1 == elements.length) {
                System.out.print(elements[i] + ")");
            } else {
                System.out.print(elements[i] + ", ");
            }
        }
        System.out.println();
    }

    public List<String> addNumber() {
        List<String> sum2Vectors = new ArrayList<>();
        valueOfVectors();
        double result = 0;
        for (int i = 0; i < vector1.length; i++) {
            result = vector1[i] + vector2[i];
            sum2Vectors.add(String.format("%.2f", result));
        }
        System.out.println("Wynikiem dodawania 2 wektorów jest: ");
        return sum2Vectors;
    }

    public List<String> subtractNumber() {
        List<String> sum2Vectors = new ArrayList<>();
        valueOfVectors();
        double result = 0;
        for (int i = 0; i < vector1.length; i++) {
            result = vector1[i] - vector2[i];
            sum2Vectors.add(String.format("%.2f", result));
        }
        System.out.println("Wynikiem odejmowania 2 wektorów jest: ");
        return sum2Vectors;
    }


    private int howManyElementsInVectors() {
        int value = 0;
        boolean isOk = false;
        while (!isOk) {
            System.out.println("Podaj ilu elementowe mają być wektory");
            try {
                value = dataReader.getInt();
                if (value >= 2 && value <= 4) {
                    isOk = true;
                } else {
                    System.out.println("minimalna ilość elementów w wektorze to 2 a maksymalna to 4");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return value;
    }
}
