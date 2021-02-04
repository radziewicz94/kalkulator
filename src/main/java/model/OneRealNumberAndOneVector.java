package model;

import io.DataReader;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class OneRealNumberAndOneVector {
    private DataReader dataReader = new DataReader();
    private List<Double> elementsOfVector = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("0.00");
    private double realNumber;

    public double getRealNumber() {
        double number = 0;
        boolean isOk = false;
        while(!isOk) {
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

    public void multiByNumber() {
        System.out.println("Dostępna jest tylko jedna opcja operacji czyli mnożenie macierzy przez liczbę");
        int numberOfElements = 0;
        realNumber = getRealNumber();
        numberOfElements = getElements();
        for (int i = 0; i < numberOfElements; i++) {
            elementsOfVector.add(getNumberOfElements());
        }
        System.out.println(toTxt() + " = " + calculate());
    }

    private double getNumberOfElements() {
        boolean isOk = false;
        double number = 0;
        while (!isOk){
            System.out.println("Podaj element wektora");
            try {
                number = dataReader.getDouble();
                isOk = true;
            }catch (InputMismatchException e){
                System.out.println(e.getMessage());
            }
        }
        return number;
    }

    private List<String> calculate() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < elementsOfVector.size(); i++) {
            double getResult = elementsOfVector.get(i) * realNumber;
            result.add(String.format("%.2f", getResult));
        }
        return result;
    }


    private int getElements() {
        boolean isOk = false;
        int elements = 0;
        while (!isOk) {
            System.out.println("Ilu elementowa ma być wektor?");
            try {
                elements = dataReader.getInt();
                if(elements <= 4 && elements >= 2) {
                    isOk = true;
                }else{
                    System.out.println("Wektor może mieć minimalnie 2 elementy i maksymalnie 4");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return elements;
    }


    public String toTxt() {
        return realNumber + " * " + elementsOfVector;
    }

}
