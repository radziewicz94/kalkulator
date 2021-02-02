package model;

import exception.DivisionByZeroException;
import exception.RageNumberException;
import io.DataReader;

import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class TwoRealNumbers {
    DataReader dataReader = new DataReader();
    private DecimalFormat df = new DecimalFormat("0.00");
    private double a;
    private double b;
    private double result;

    public String addNumber() {
        try {
            System.out.println("Podaj pierwszą liczbę");
            a = dataReader.getDouble();
            System.out.println("Podaj drugą liczbę");
            b = dataReader.getDouble();
            result = a + b;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        return df.format(result);
    }

    public String subtractNumber() {
        try {
            System.out.println("Podaj pierwszą liczbę");
            a = dataReader.getDouble();
            System.out.println("Podaj drugą liczbę");
            b = dataReader.getDouble();
            result = a - b;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        return df.format(result);
    }

    public String multiNumber() {
        try {
            System.out.println("Podaj pierwszą liczbę");
            double a = dataReader.getDouble();
            System.out.println("Podaj drugą liczbę");
            double b = dataReader.getDouble();
            double result = a * b;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        return df.format(result);
    }

    public String divNumber() {
        try {
            System.out.println("Podaj pierwszą liczbę");
            a = dataReader.getDouble();
            System.out.println("Podaj drugą liczbę");
            b = dataReader.getDouble();
            if (b == 0) {
                throw new DivisionByZeroException("Nie dzielimy przez zero");
            }
            result = a / b;
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        return df.format(result);
    }

    public String expNumber() {
        try {
            System.out.println("Podaj pierwszą liczbę");
            a = dataReader.getDouble();
            System.out.println("Podaj drugą liczbę");
            b = dataReader.getDouble();
            if (b >= 0 && b <= 128) {
                result = Math.pow(a, b);
                df.format(result);
            }
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        throw new RageNumberException("Wybierz zakres potęgowania od 0 do 128");
    }

    public String redicalNumber() {
        try {
            System.out.println("Podaj liczbę");
            a = dataReader.getDouble();
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        return df.format(Math.sqrt(a));
    }
}
