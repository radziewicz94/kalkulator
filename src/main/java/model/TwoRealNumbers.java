package model;

import exception.DivisionByZeroException;
import exception.RageNumberException;
import io.DataReader;

import java.text.DecimalFormat;

public class TwoRealNumbers {
    DataReader dataReader;
    private DecimalFormat df = new DecimalFormat("0.00");

    public TwoRealNumbers() {
        this.dataReader = new DataReader();
    }

    public String addNumber() {
        System.out.println("Podaj pierwszą liczbę");
        double a = dataReader.getDouble();
        System.out.println("Podaj drugą liczbę");
        double b = dataReader.getDouble();
        double result = a + b;
        return df.format(result);
    }

    public String subtractNumber() {
        System.out.println("Podaj pierwszą liczbę");
        double a = dataReader.getDouble();
        System.out.println("Podaj drugą liczbę");
        double b = dataReader.getDouble();
        double result = a - b;
        return df.format(result);
    }

    public String multiNumber() {
        System.out.println("Podaj pierwszą liczbę");
        double a = dataReader.getDouble();
        System.out.println("Podaj drugą liczbę");
        double b = dataReader.getDouble();
        double result = a * b;
        return df.format(result);
    }

    public String divNumber() {
        System.out.println("Podaj pierwszą liczbę");
        double a = dataReader.getDouble();
        System.out.println("Podaj drugą liczbę");
        double b = dataReader.getDouble();
        if (b == 0) {
            throw new DivisionByZeroException("Nie dzielimy przez zero");
        }
        double result = a / b;
        return df.format(result);
    }

    public String expNumber() {
        System.out.println("Podaj pierwszą liczbę");
        double a = dataReader.getDouble();
        System.out.println("Podaj drugą liczbę");
        double b = dataReader.getDouble();
        if (b >= 0 && b <= 128) {
            double result = Math.pow(a, b);
            return df.format(result);
        }
        throw new RageNumberException("Wybierz zakres potęgowania od 0 do 128");
    }

    public String redicalNumber() {
        System.out.println("Podaj pierwszą liczbę");
        double a = dataReader.getDouble();
        System.out.println("Podaj drugą liczbę");
        double b = dataReader.getDouble();
        double result = a + b;
        return df.format(Math.sqrt(result));
    }
}
